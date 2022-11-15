

package java_antlr;

import antlr.CompileBaseListener;
import antlr.CompileParser;

import java.util.HashMap;
import java.util.LinkedList;

public class Createur_Quadruples extends CompileBaseListener
{
    LinkedList<genrateurobjet.Instruction> instructions;
    private LinkedList<String> pile = new LinkedList<>(); // pile(Pour stocker les temporaire et les operandes) dans une list fifo ->  on prend le dernier
    private listQuadruplet listQuadruplet = new listQuadruplet();
    int qc; // Le quad courant pour sauvgarder L'@  de mise a jours
    int qcDowhile; // Le quad courant pour sauvgarder L'@  de mise a jours pour la boucle
    private int cptTemps = 0;
    Semantique semantique;
    private static HashMap<String,String> branchement_If = new HashMap<>(); // Les branchement de instruction if
    private static HashMap<String,String> branchement_DoWhile = new HashMap<>();// Les branchement de instruction  dowhile



    public Createur_Quadruples(Semantique semantique) {
        branchement_If.put("<","BGE");  // les branchement de if sont inversés pour quitter la condition
        branchement_If.put(">","BLE");
        branchement_If.put("<=","BG");
        branchement_If.put(">=","BL");
        branchement_If.put("==","BNE");
        branchement_If.put("!=","BE");

        branchement_DoWhile.put(">=","BGE");
        branchement_DoWhile.put("<=","BLE");
        branchement_DoWhile.put(">","BG");
        branchement_DoWhile.put("<","BL");
        branchement_DoWhile.put("!=","BNE");
        branchement_DoWhile.put("==","BE");

        this.semantique = semantique;
    }


    @Override
    public void exitPrg(CompileParser.PrgContext ctx)
    {
        if(semantique.getErrors().size()>0) // S'il ya des erruer, on affiche pas les quads
            return;

        System.out.println(TextColors.GREEN_BOLD_BRIGHT+
                "------------------------------------Routine Fin_de_Programme------------------------------------"+
                TextColors.WHITE_BRIGHT);

        listQuadruplet.addQuad("END","","",""); // quad de fin
        System.out.println(TextColors.WHITE_BRIGHT+"-Quadruplet de fin a été généré : -> "+listQuadruplet.getQuad(listQuadruplet.size()-1));
        System.out.println(TextColors.WHITE_BRIGHT+"\n\n Les quadruplets generés : ");
        System.out.println(TextColors.WHITE_BRIGHT+"------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        for (int i = 0; i < listQuadruplet.size(); i++) {
            System.out.println(i + ": " + listQuadruplet.getQuad(i).toString());
        }
        genrateurobjet gOc = new genrateurobjet(listQuadruplet);
        instructions = gOc.generateCode();

    }

    @Override
    public void exitAffect(CompileParser.AffectContext ctx)
    {
        System.out.println(TextColors.GREEN_BOLD_BRIGHT+
                "------------------------------------Routine Exit_Affectation------------------------------------"+
                TextColors.WHITE_BRIGHT);

        String t1 = pile.removeLast();
        System.out.println(TextColors.WHITE_BRIGHT+"-L'opérande "+
                TextColors.BLUE_BOLD+"\""+t1+"\""+TextColors.WHITE_BRIGHT+
                " a été desempilé");

        System.out.print(TextColors.WHITE_BRIGHT+"-Quadruplet généré pour affecter " +
                TextColors.BLUE_BOLD+"\""+t1+"\""+TextColors.WHITE_BRIGHT+" à "+// affecter le dernier de la pile
                TextColors.BLUE_BOLD+"\""+ctx.id().getText()+"\""+TextColors.WHITE_BRIGHT+ // à la variable de l'affectation
                ": -> ");
        listQuadruplet.addQuad("=","",t1,ctx.id().getText());
        System.out.println(listQuadruplet.getQuad(listQuadruplet.size()-1));
    }

    @Override
    public void exitExp(CompileParser.ExpContext ctx)
    {
        if(ctx.exp() != null) {
            System.out.println(TextColors.GREEN_BOLD_BRIGHT+
                    "------------------------------------Routine exit_Expression------------------------------------"+
                    TextColors.WHITE_BRIGHT);

            String t1 = pile.removeLast(); // depiler deux fois
            System.out.println(TextColors.WHITE_BRIGHT+"-L'opérande "+
                    TextColors.BLUE_BOLD+"\""+t1+"\""+TextColors.WHITE_BRIGHT+
                    " a été desempilé");
            String t2 = pile.removeLast();
            System.out.println(TextColors.WHITE_BRIGHT+"-L'opérande "+
                    TextColors.BLUE_BOLD+"\""+t2+"\""+TextColors.WHITE_BRIGHT+
                    " a été desempilé");

            String temp = "T" + (++cptTemps); // reation d'un temporaire
            listQuadruplet.addQuad(ctx.plusmoin().getText(), t2, t1, temp); // Creation de quad
            System.out.println(TextColors.WHITE_BRIGHT+"-Quadruple generé et a été sauvgarder dans "+
                    TextColors.BLUE_BOLD+"\""+temp+"\""+TextColors.WHITE_BRIGHT+": -> "
                    + listQuadruplet.getQuad(listQuadruplet.size() - 1));

            pile.add(temp);
            System.out.println("-L'opérande "+TextColors.BLUE_BOLD+"\""+temp+"\""+TextColors.WHITE_BRIGHT+" a été empilé");
        }
    }

    @Override
    public void exitExp_prio(CompileParser.Exp_prioContext ctx)
    {
        if(ctx.exp_prio() != null)
        {
            System.out.println(TextColors.GREEN_BOLD_BRIGHT+
                    "-------------------------------------Routine exit_Expression_prioritaire------------------------------------"+
                    TextColors.WHITE_BRIGHT);

            String t1 = pile.removeLast(); // depiler deux fois
            System.out.println(TextColors.WHITE_BRIGHT+"-L'opérande "+
                    TextColors.BLUE_BOLD+"\""+t1+"\""+TextColors.WHITE_BRIGHT+
                    " a été desempilé");
            String t2 = pile.removeLast();
            System.out.println(TextColors.WHITE_BRIGHT+"-L'opérande "+
                    TextColors.BLUE_BOLD+"\""+t2+"\""+TextColors.WHITE_BRIGHT+
                    " a été desempilé");

            String temp = "T"+(++cptTemps);
            listQuadruplet.addQuad(ctx.muldiv().getText(),t2,t1,temp);
            System.out.println(TextColors.WHITE_BRIGHT+"-Quadruplet d'une expression prioritaire generé et a été sauvgarder dans "+
                    TextColors.BLUE_BOLD+"\""+temp+"\""+TextColors.WHITE_BRIGHT+
                    ": -> "+ listQuadruplet.getQuad(listQuadruplet.size()-1));
            pile.add(temp);
            System.out.println(TextColors.WHITE_BRIGHT+"-L'opérande "+
                    TextColors.BLUE_BOLD+"\""+temp+"\""+TextColors.WHITE_BRIGHT+
                    " a été empilé");

        }
        /*else
        {
            System.out.println("fin de quadruple ExpPrio : "
                    + pile.getLast());
        }*/
    }

    @Override
    public void exitSuit_exp(CompileParser.Suit_expContext ctx)
    {
        if(ctx.exp() == null) {
            System.out.println(TextColors.GREEN_BOLD_BRIGHT+
                    "------------------------------------Routine exit_Suite_Expression------------------------------------"+
                    TextColors.WHITE_BRIGHT);

            pile.add(ctx.getText());
            System.out.println(TextColors.WHITE_BRIGHT+"-L'operande "+
                    TextColors.BLUE_BOLD+ "\""+ctx.getText()+"\""+TextColors.WHITE_BRIGHT+
                    " a été empilé");
        }
    }

    @Override
    public void exitCondition(CompileParser.ConditionContext ctx)
    {
        System.out.println(TextColors.GREEN_BOLD_BRIGHT+
                "------------------------------------Routine exit_Condition------------------------------------"+
                TextColors.WHITE_BRIGHT);

        String t1 = pile.removeLast(); // depiler deux fois
        System.out.println(TextColors.WHITE_BRIGHT+"-L'opérande "+
                TextColors.BLUE_BOLD+"\""+t1+"\""+TextColors.WHITE_BRIGHT+
                " a été desempilé");
        String t2 = pile.removeLast();
        System.out.println(TextColors.WHITE_BRIGHT+"-L'opérande "+
                TextColors.BLUE_BOLD+"\""+t2+"\""+TextColors.WHITE_BRIGHT+
                " a été desempilé");


        if(ctx.getParent().children.get(0).getText().equals("if")){
            listQuadruplet.addQuad(getBR_If(ctx.op_logique().getText()),"",t2,t1);// t2-t1
        } else if (ctx.getParent().children.get(0).getText().equals("do")){
            listQuadruplet.addQuad(getBR_DoWhile(ctx.op_logique().getText()),"",t2,t1);// t2-t1
        }

        System.out.println(TextColors.WHITE_BRIGHT+"-Quadruplet de condition a été généré: -> "+listQuadruplet.getQuad(listQuadruplet.size()-1));

        qc = listQuadruplet.size()-1; // sauvgarder L'@ de quad <if Cond>
        System.out.println(TextColors.WHITE_BRIGHT+"-Sauvgarder l'@ de ce quad pour fair une mise a jour: -> "+
                TextColors.YELLOW+"QC = "+qc+TextColors.WHITE_BRIGHT);

    }

    @Override
    public void exitEl(CompileParser.ElContext ctx)
    {
        System.out.println(TextColors.GREEN_BOLD_BRIGHT+
                "------------------------------------Routine exit_Else------------------------------------"+
                TextColors.GREEN_BOLD_BRIGHT);

        Quad mise_a_jours = listQuadruplet.getQuad(qc); // MAJ de quad <if Cond>
        mise_a_jours.set(1,""+(listQuadruplet.size()+1)); // (+1 càd le quad  suivant ) donc branchement vers le quad suivant

        System.out.println(TextColors.WHITE_BRIGHT+"-Le Quad "+
                TextColors.YELLOW+"n° "+qc+TextColors.WHITE_BRIGHT+
                " son @ de branchement a été mis à jour vers "+
                TextColors.YELLOW+"@="+(listQuadruplet.size()+1)+TextColors.WHITE_BRIGHT);

        System.out.println(TextColors.WHITE_BRIGHT+"-Le Quad"+TextColors.YELLOW+" n° "+qc+" est maintenant: -> "+listQuadruplet.getQuad(qc));

        listQuadruplet.addQuad("BR","","",""); // générer le BR automaticment , pour que if cond saut jusqu'a la fin de else
        System.out.println(TextColors.WHITE_BRIGHT+"-Quadruplet BR a été généré: -> "+(listQuadruplet.getQuad(listQuadruplet.size()-1)));

        qc=listQuadruplet.size()-1; // savgarder l'@ quad <else>
        System.out.println(TextColors.WHITE_BRIGHT+"-L'adress de branchement a ce quad a été sauvgarder: -> "+
                TextColors.YELLOW+"QC = "+qc+TextColors.WHITE_BRIGHT);
    }

    @Override
    public void exitInstif(CompileParser.InstifContext ctx)
    {
        System.out.println(TextColors.GREEN_BOLD_BRIGHT+
                "------------------------------------Routine exit_Instruction_If-------------------------------------"+
                TextColors.WHITE_BRIGHT);

        Quad mise_a_jours = listQuadruplet.getQuad(qc); // MAJ de quad <else> ||  <if Cond> Si else n'existe pas
        mise_a_jours.set(1,""+ listQuadruplet.size()); // mise a jour de QC

        System.out.println(TextColors.WHITE_BRIGHT+"-Le Quad "+
                TextColors.WHITE_BRIGHT+"n° "+qc+TextColors.WHITE_BRIGHT+
                " son @ de branchement a été mis à jour vers "+
                TextColors.YELLOW+"@="+(listQuadruplet.size())+TextColors.WHITE_BRIGHT);

        System.out.println(TextColors.WHITE_BRIGHT+"-Le Quad "+
                TextColors.YELLOW+"n° "+qc+TextColors.WHITE_BRIGHT+" est maintenant: -> "+listQuadruplet.getQuad(qc));
    }


    @Override
    public void enterDowhile(CompileParser.DowhileContext ctx) {

        System.out.println(TextColors.GREEN_BOLD_BRIGHT+
                "------------------------------------Routine Enter_Do_While------------------------------------"+
                TextColors.WHITE_BRIGHT);
        qcDowhile=listQuadruplet.size(); // savguarder Qc
        System.out.println(TextColors.WHITE_BRIGHT+" L'adress de branchement a ce quad a été sauvgarder: -> "+
                TextColors.YELLOW+"QC = "+qcDowhile+TextColors.WHITE_BRIGHT);
    }


    @Override
    public void exitDowhile(CompileParser.DowhileContext ctx){
        System.out.println(TextColors.GREEN_BOLD_BRIGHT+
                "------------------------------------Routine exit_Do_While------------------------------------"+
                TextColors.WHITE_BRIGHT);
        Quad mise_a_jours;
        mise_a_jours= listQuadruplet.getQuad(listQuadruplet.size()-1);
        mise_a_jours.set(1,""+qcDowhile);

        System.out.println(TextColors.WHITE_BRIGHT+"-Le Quad "+
                TextColors.YELLOW+"n° "+(listQuadruplet.size()-1)+TextColors.WHITE_BRIGHT+
                " son @ de branchement a été mis à jour vers "+
                TextColors.YELLOW+"@="+qcDowhile+TextColors.WHITE_BRIGHT);

        System.out.println(TextColors.WHITE_BRIGHT+"-Le Quad "+
                TextColors.YELLOW+"n° "+(listQuadruplet.size()-1)+TextColors.WHITE_BRIGHT+
                " est maintenant: -> "+listQuadruplet.getQuad(qc));
    }






    private static String getBR_If(String s)
    {
        return branchement_If.get(s);
    }
    private static String getBR_DoWhile(String s)
    {
        return branchement_DoWhile.get(s);
    }
    public LinkedList<genrateurobjet.Instruction> getInstructions() {
        return instructions;
    }


}


