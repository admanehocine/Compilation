package java_antlr;



import antlr.CompileBaseListener;
import antlr.CompileParser;
import org.antlr.v4.runtime.ParserRuleContext;

import java.util.HashMap;
import java.util.LinkedList;


public class Semantique extends CompileBaseListener {
    public String t = "",lp="", k="";
    private boolean premierAfficheTypeNoErruer = false;
    private static final int DECLARED = 1,D=2;
    private static final int UNDECLARED = -1;
    private static final int FLOAT = 2;
    private static final int INT = 1;
    private static final int STRING = 3;

    private TableSymbole table = new TableSymbole();

    LinkedList<String> errors = new LinkedList<>();
    private LinkedList<String> varnondeclarer = new LinkedList<>();//utilisé pour afficher touts les vars qui ne sont pas dans cette liste
    private HashMap<ParserRuleContext, Integer> compatibilite = new HashMap<>();//parserrulecontext generer depuis la grammaire par antlr
    private static int typesC[] = {0, INT | FLOAT, INT | FLOAT, INT | FLOAT | STRING}; // types compatibility operations 0,int,float,String
    private static int typesA[] = {0, INT, INT | FLOAT, INT | FLOAT| STRING}; // types compatibilité affectation 0,int,float,String

    @Override public void enterPrg(CompileParser.PrgContext ctx) {
            table.add();
        if (table.containsNomVariable(ctx.ID().getText())) {

            errors.add(TextColors.WHITE_BRIGHT + "erreur : le nom de programme " +
                    TextColors.RED + ctx.ID().getText() + TextColors.WHITE_BRIGHT +
                    " est un mot clé  " + TextColors.RED +
                    "la ligne " + ctx.ID().getSymbol().getLine() + TextColors.WHITE_BOLD);
        } else
            table.addElement(new TableSymbole.Element(ctx.ID().getText(),D, 4, "vide","mot réservé"));
    }
    @Override
    public void exitPrg(CompileParser.PrgContext ctx) {
        if (errors.size() == 0) { // Pas d'errueur
            System.out.println(TextColors.GREEN + "programme a été compilé sans erreur ! Voici la table de symbole" + TextColors.WHITE_BOLD);
        } else {
            System.out.println(TextColors.RED + "\nle programme a été compilé avec les errors suivantes :" + TextColors.WHITE_BOLD);
            for (int i = 0; i < errors.size(); i++) {
                System.out.println("\t" + TextColors.WHITE_BRIGHT + (i + 1) + ": => " + errors.get(i));
            }
        }

        System.out.println(TextColors.PURPLE_BOLD +"\n-----------------------------------------------------Table des Symboles-----------------------------------------------------------"+ TextColors.WHITE_BOLD);
        for (int i = 0; i < table.getSize(); i++) {
            System.out.println(TextColors.WHITE_BOLD + table.getNomVariable(i).toString() + TextColors.WHITE_BOLD);
        }
        System.out.println(TextColors.PURPLE_BOLD +"----------------------------------------------------\\Table des Symboles-----------------------------------------------------------\n"+ TextColors.WHITE_BOLD);
    }


    @Override
    public void exitDec(CompileParser.DecContext ctx) { // apres declaration des variables
        int type = UNDECLARED;
        if (ctx.type().getText().equals("intCompil")) type = INT;
        else {  if (ctx.type().getText().equals("floatCompil")) type = FLOAT;
        else {  if (ctx.type().getText().equals("stringCompil")) type = STRING;
        }
        }

        CompileParser.List_variableContext i = ctx.list_variable(); // i parcours list des declarations
        for (; ; i = i.list_variable())
        {
            String NomVariable = i.getChild(0).getText();
            if (table.containsNomVariable(NomVariable)) {
                errors.add("Erreur: "+TextColors.RED_UNDERLINED + "Double declaration" +
                        TextColors.WHITE_BRIGHT + " de la variable: " +
                        TextColors.RED + "\""+NomVariable+"\""+ TextColors.WHITE_BRIGHT
                );
            } else // pas de double declaration
                table.addElement(new TableSymbole.Element(NomVariable, DECLARED, type, null,null));
            if (i.list_variable() == null)
                return; // stopper la boucle et la methode
        }

    }


    @Override
    public void exitAffect(CompileParser.AffectContext ctx) {
        //  if(errors.size() == 0) { // pas des erreur







        if(!premierAfficheTypeNoErruer){
            System.out.println(TextColors.CYAN + "Voici les Compatibilité entre les type de code donné" + TextColors.WHITE_BOLD);
            premierAfficheTypeNoErruer =true;
        }
        t = "";
        if (table.getNomVariable(ctx.id().getText()).type == 1) { t = "INT";
        } else {    if (table.getNomVariable(ctx.id().getText()).type == 2) { t = "FLOAT";
        } else {if (table.getNomVariable(ctx.id().getText()).type == 3) { t = "STRING";
        } else { t = "non declarer";
        }
        }
        }
        if (t.equals("non declarer") && getCtxTypeString(ctx.exp()).equals("non declarer"))
            System.out.println(
                    TextColors.WHITE_BRIGHT+"la variable \"" + TextColors.RED+ ctx.id().getText() +
                            TextColors.YELLOW+ "\" " + t + TextColors.WHITE_BRIGHT+
                            "  et le type de retour de l expression est une variable  "+
                            TextColors.YELLOW + getCtxTypeString(ctx.exp())+ TextColors.WHITE_BRIGHT+
                            " à la ligne "+TextColors.RED+ctx.id().ID().getSymbol().getLine()+TextColors.WHITE_BRIGHT+
                            "\n-----------------------------------------------------------------------------------------------------------");
        else {
            if (t.equals("non declarer"))
                System.out.println(
                        TextColors.WHITE_BRIGHT+
                                "la variable "+ TextColors.RED + "\""+ctx.id().getText()+ "\" : " + t + TextColors.WHITE_BRIGHT +
                                ", et le type de retour d affectation est "
                                + TextColors.YELLOW + getCtxTypeString(ctx.exp()) + TextColors.WHITE_BRIGHT+
                                ", à la ligne "+TextColors.RED+ctx.id().ID().getSymbol().getLine()+TextColors.WHITE_BRIGHT+
                                "\n-----------------------------------------------------------------------------------------------------------"
                );

            else
                System.out.println(
                        TextColors.WHITE_BRIGHT + "la variable \"" +
                                TextColors.BLUE + ctx.id().getText() + TextColors.WHITE_BRIGHT +
                                "\"  est du type " + TextColors.YELLOW + t +
                                TextColors.WHITE_BRIGHT +", et le type de retoure affectation  est  " +
                                TextColors.YELLOW + getCtxTypeString(ctx.exp()) + TextColors.WHITE_BRIGHT+
                                ", à la ligne "+ctx.id().ID().getSymbol().getLine()+
                                "\n-----------------------------------------------------------------------------------------------------------"
                );
        }
        if (!affectTypesCompatible(table.getNomVariable(ctx.id().getText()).type, getCtxType(ctx.exp()))) {
            if (!varnondeclarer.contains(ctx.id().getText())) {
                errors.add(TextColors.RED + "erreur:" + TextColors.WHITE_BRIGHT+
                        " incompatible  de type  d affectation  " + TextColors.RED + ctx.getText()
                        +TextColors.WHITE_BRIGHT+ "a la ligne "+ctx.id().ID().getSymbol().getLine()
                );
            }
        }
        //  }

        clearMap();
        //}
    }

    @Override public void exitMuldiv(CompileParser.MuldivContext ctx) {


        if(!ctx.getText().equals(null)){ lp="/";} // semantique , on vérifi la division sur 0

    }
    @Override
    public void exitExp(CompileParser.ExpContext ctx) {



        if(!premierAfficheTypeNoErruer){
            System.out.println(TextColors.GREEN + "Voici les Compatibilité entre les type de code donné"  + TextColors.WHITE_BOLD);
            premierAfficheTypeNoErruer =true;
        }

        if (ctx.exp() == null)
            addCtxType(ctx, getCtxType(ctx.exp_prio()));
        else {
            System.out.println(
                    TextColors.WHITE_BRIGHT + "\t->"+ TextColors.CYAN +"\""+ctx.exp_prio().getText()+"\"" +TextColors.WHITE_BRIGHT +
                            "  est de type: "+ TextColors.YELLOW+getCtxTypeString(ctx.exp_prio())+
                            TextColors.WHITE_BRIGHT + " et " + TextColors.CYAN+"\""+ctx.exp().getText()+"\""+TextColors.WHITE_BRIGHT +
                            " est de type: "+ TextColors.YELLOW + getCtxTypeString(ctx.exp())+ TextColors.WHITE_BRIGHT );
            if (typesCompatible(getCtxType(ctx.exp_prio()), getCtxType(ctx.exp())))
                addCtxType(ctx, getResultingType(getCtxType(ctx.exp_prio()), getCtxType(ctx.exp())));
            else {
                addCtxType(ctx, 0);

                if (!varnondeclarer.contains(ctx.exp().getText())) {
                    System.out.println(TextColors.WHITE_BRIGHT + "\t"+TextColors.WHITE_BRIGHT+"incompatible type entre "+
                            TextColors.RED_BOLD+  "\""+ctx.exp_prio().getText()+"\"" + TextColors.WHITE_BRIGHT+
                            " et " + TextColors.RED_BOLD +"\""+ctx.exp().getText()+"\""+ TextColors.WHITE_BRIGHT);
                }
                System.out.println(TextColors.WHITE_BRIGHT + "\t->"+ TextColors.CYAN +"\""+ctx.exp_prio().getText()+"\"" +TextColors.WHITE_BRIGHT +
                        " est de type: "+TextColors.YELLOW + getCtxTypeString(ctx.exp_prio()) +TextColors.WHITE_BRIGHT +
                        " et " + TextColors.CYAN+ "\""+ctx.exp().getText()+"\""+TextColors.WHITE_BRIGHT +
                        " est de type: " +TextColors.YELLOW+ getCtxTypeString(ctx.exp()) +TextColors.WHITE_BRIGHT );
            }

        }//}
    }

    @Override
    public void exitExp_prio(CompileParser.Exp_prioContext ctx) {
        if(!premierAfficheTypeNoErruer){
            System.out.println(TextColors.GREEN + "Voici les Compatibilité entre les type de code donné" + TextColors.WHITE_BOLD);
            premierAfficheTypeNoErruer =true;
        }
        if (ctx.exp_prio() == null)
            addCtxType(ctx, getCtxType(ctx.suit_exp()));
        else {
            System.out.println( TextColors.WHITE_BRIGHT +"\t->" +
                    TextColors.CYAN+"\""+ctx.exp_prio().getText()+"\""+ TextColors.WHITE_BRIGHT+
                    " est de type: " + TextColors.YELLOW+ getCtxTypeString(ctx.exp_prio()) + TextColors.WHITE_BRIGHT+" et " +
                    TextColors.CYAN+"\""+ctx.suit_exp().getText()+"\"" +
                    TextColors.WHITE_BRIGHT+" est de type: " + TextColors.YELLOW+ getCtxTypeString(ctx.suit_exp())+ TextColors.WHITE_BRIGHT
            );
            if (typesCompatible(getCtxType(ctx.suit_exp()), getCtxType(ctx.exp_prio())))
                addCtxType(ctx, getResultingType(getCtxType(ctx.exp_prio()), getCtxType(ctx.suit_exp())));
            else {
                addCtxType(ctx, 0);
                if (!varnondeclarer.contains(ctx.exp_prio().getText())) {
                    System.out.println(
                            TextColors.RED_BOLD+"incompatible type entre  " +
                                    ctx.exp_prio().getText() + " et " + ctx.suit_exp().getText()+ TextColors.WHITE_BRIGHT);
                }
                System.out.println((
                        TextColors.WHITE_BRIGHT+ctx.exp_prio().getText() + " type: " +TextColors.YELLOW+
                                getCtxTypeString(ctx.exp_prio()) +  TextColors.WHITE_BRIGHT+ " et  "
                                + ctx.suit_exp().getText() + " type: " +TextColors.YELLOW+
                                getCtxTypeString(ctx.suit_exp())+ TextColors.WHITE_BRIGHT));
            }
        }
    }
    //}


    @Override
    public void exitSuit_exp(CompileParser.Suit_expContext ctx) {

        if (ctx.id() != null)
            addCtxType(ctx, table.getNomVariable(ctx.id().getText()).type);
        if (ctx.exp() != null)
            addCtxType(ctx, getCtxType(ctx.exp()));
        if (ctx.val() != null)
            addCtxType(ctx, getCtxType(ctx.val()));

        if (ctx.id() == null && ctx.PARO()==null && ctx.PARF()==null  )
        {
            if(ctx.val().getText().equals("0") )
            {  //k =ctx.val().getText();  && k.equals("0")
                if (lp.equals("/"))
                {
                    errors.add(TextColors.RED + "erreur :division sur zero a la ligne   "+
                            ctx.val().INTEGERVAL().getSymbol().getLine()+TextColors.WHITE_BRIGHT
                    );
                }

            }               }



    }

    @Override
    public void exitVal(CompileParser.ValContext ctx) {
        if(ctx.INTEGERVAL() != null)  addCtxType(ctx,INT) ; else
        {    if(ctx.FLOATVAL() != null)  addCtxType(ctx, FLOAT);
        else addCtxType(ctx,STRING);}
    }

    @Override
    public void exitId(CompileParser.IdContext ctx) {
        //
        if (!table.containsNomVariable(ctx.ID().getText())) {
            varnondeclarer.add(ctx.ID().getText());
            errors.add("variable " + TextColors.RED + ctx.ID().getText() + TextColors.WHITE_BRIGHT +
                    " variable non declarer a " + TextColors.RED +
                    "la ligne " + ctx.ID().getSymbol().getLine() + TextColors.WHITE_BOLD);
            table.addElement(new TableSymbole.Element(ctx.ID().getText(), UNDECLARED, 0, null,null));
            // adding non declared variable in order to not generate same error again
        }
    }


    @Override
    public void exitCondition(CompileParser.ConditionContext ctx) {
        clearMap();
    }




    public LinkedList<String> getErrors() {
        return errors;
    }

    private void addCtxType(ParserRuleContext ctx, int type) {
        compatibilite.put(ctx, type);
    }

    private String getCtxTypeString(ParserRuleContext ctx) {
        if (compatibilite.get(ctx) == 1) return "INT";
        else {
            if (compatibilite.get(ctx) == 2) return "FLOAT";
            else {
                if (compatibilite.get(ctx) == 3) return "STRING";
                else return "non declarer";
            }
        }

    }

    private void clearMap() {
        compatibilite.clear();
    }

    private static boolean typesCompatible(int t1, int t2) {
        if ((typesC[t1] & t2) != 0) return true;
        else return false;
    }

    private static boolean affectTypesCompatible(int t1, int t2) {
        if ((typesA[t1] & t2) != 0) return true;
        else return false;
    }

    private static int getResultingType(int t1, int t2) {

        if ((t1 & t2 & INT) != 0) return INT;
        else {
            if ((t1 & t2 & FLOAT) != 0) return FLOAT;
            else if ((t1 & t2 & STRING) != 0) return STRING;
        }
        return -1;
    }

    private int getDeclared (CompileParser.AffectContext ctx){
        return table.getNomVariable(ctx.id().getText()).declare;
    }

    private int getCtxType(ParserRuleContext ctx) {
        return compatibilite.get(ctx);
    }

}