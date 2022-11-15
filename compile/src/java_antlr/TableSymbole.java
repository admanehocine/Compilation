package java_antlr;
import java.util.ArrayList;

public class TableSymbole
{
    static public class Element { // Element est une ligne de table de symbole

        String name;
        int declare; //1:declared, 2:Non declared
        int type; // 1:int 2:float 3:String 4:vide
        String init; //valeur initiale null
       String  unite;


        public Element(String name, int declare, int type, String init,String unite) {
            this.name = name;
            this.declare = declare;
            this.type = type;
            this.init = init;
            this.unite=unite;
        }

        @Override
        public String toString() {
            String t="", dec;
            int taille=0;
            switch (type){
                case 1 : t = "intCompil"; taille=4; break; // taille de int est 4Octet
                case 2 : t = "floatCompil"; taille=4; break;// taille de float est 4Octet
                case 3 : t = "stringCompil"; taille=name.toString().length(); break; // taille de String est nbr lettres dans le String *1ctet
                case 4 : t= "vide";break; //pour les mot cle;
                default: t = "non declarer"; taille=-1;break; // taille -1, cad Non declaré
            }

            if(declare ==1) {
                dec = TextColors.GREEN + "declaré" + TextColors.WHITE_BRIGHT;
            }else {if(declare==-1)
                dec = TextColors.RED + "non declaré" + TextColors.WHITE_BRIGHT;
            else dec=TextColors.RED + "vide" + TextColors.WHITE_BRIGHT;
            }
            String  pm= TextColors.WHITE_BRIGHT+"variable: "+ TextColors.BLUE+"\""+name+"\""+ TextColors.WHITE_BRIGHT +
                    ", est de type: " + TextColors.YELLOW+t+ TextColors.WHITE_BRIGHT+
                    ", L'état de variable : " +dec+
                    ", Valeur initial: "+TextColors.CYAN+init+ TextColors.WHITE_BRIGHT+
                    ", Taille de variable: "+TextColors.YELLOW+taille+" octet."+TextColors.WHITE_BRIGHT;
            if(type==4){
                pm=TextColors.WHITE_BRIGHT+"nom: "+ TextColors.BLUE+"\""+name+"\""+ TextColors.WHITE_BRIGHT +
                        ",Unité : " + TextColors.YELLOW+this.unite+ TextColors.WHITE_BRIGHT+
                        ", type: " +t+TextColors.WHITE_BRIGHT;
            }

            return pm;
        }
    }

    public ArrayList<Element> L = new ArrayList<Element>(); // table de symbole est une liste des element
    public void add()
    {
        int D=2;
        this.addElement(new TableSymbole.Element("compil",D, 4, "vide","mot réservé"));
        this.addElement(new TableSymbole.Element("intCompil",D, 4, "vide","mot réservé"));
        this.addElement(new TableSymbole.Element("floatCompil",D, 4, "vide","mot réservé"));
        this.addElement(new TableSymbole.Element("stringCompil",D, 4, "vide","mot réservé"));
        this.addElement(new TableSymbole.Element("scancompil",D, 4, "vide","mot réservé"));
        this.addElement(new TableSymbole.Element("printcompil",D, 4, "vide","mot réservé"));
        this.addElement(new TableSymbole.Element("start",D, 4, "vide","mot réservé"));
        this.addElement(new TableSymbole.Element("if",D, 4, "vide","mot réservé"));
        this.addElement(new TableSymbole.Element("then",D, 4, "vide","mot réservé"));
        this.addElement(new TableSymbole.Element("else",D, 4, "vide","mot réservé"));
        this.addElement(new TableSymbole.Element("do",D, 4, "vide","mot réservé"));
        this.addElement(new TableSymbole.Element("while",D, 4, "vide","mot réservé"));
        this.addElement(new TableSymbole.Element("=",D, 4, "vide","operateur"));
        this.addElement(new TableSymbole.Element("+",D, 4, "vide","operateur"));
        this.addElement(new TableSymbole.Element("-",D, 4, "vide","operateur"));
        this.addElement(new TableSymbole.Element("*",D, 4, "vide","operateur"));
        this.addElement(new TableSymbole.Element("/",D, 4, "vide","operateur"));
        this.addElement(new TableSymbole.Element(">",D, 4, "vide","operateur"));
        this.addElement(new TableSymbole.Element("<",D, 4, "vide","operateur"));
        this.addElement(new TableSymbole.Element("<=",D, 4, "vide","operateur"));
        this.addElement(new TableSymbole.Element(">=",D, 4, "vide","operateur"));
        this.addElement(new TableSymbole.Element("==",D, 4, "vide","operateur"));
        this.addElement(new TableSymbole.Element("!=",D, 4, "vide","operateur"));
        this.addElement(new TableSymbole.Element("(",D, 4, "vide","separateur"));
        this.addElement(new TableSymbole.Element(")",D, 4, "vide","separateur"));
        this.addElement(new TableSymbole.Element("{",D, 4, "vide","separateur"));
        this.addElement(new TableSymbole.Element("}",D, 4, "vide","separateur"));
        this.addElement(new TableSymbole.Element(";",D, 4, "vide","separateur"));
        this.addElement(new TableSymbole.Element(",",D, 4, "vide","separateur"));
    }
    public Element getNomVariable(String name) { //recherche une variable dans TS
        for (int i = 0; i < L.size(); i++) {
            if(L.get(i).name.compareTo(name)==0)
                return L.get(i);
        }
        return null;
    }


    public boolean containsNomVariable(String name) {
        if(getNomVariable(name) != null) {
            return true;
        }
        return false;
    }
    public void addElement(Element e)
    {
        L.add(e);
    }

    public int getSize()
    {
        return L.size();
    }

    public Element getNomVariable(int i)
    {
        return L.get(i);
    }

}
