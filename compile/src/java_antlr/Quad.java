package java_antlr;
public class Quad
{
    String indice[];

    public Quad(String[] vals) {
        this.indice = vals;
    }

    public Quad(String s1,String s2,String s3,String s4)
    {
        indice = new String[4];
        indice[0] = s1;
        indice[1] = s2;
        indice[2] = s3;
        indice[3] = s4;
    }

    public String get(int index)
    {
        return indice[index];
    }

    public void set(int index, String s)
    {
        indice[index] = s;
    }

    @Override
    public String toString()
    {
        return TextColors.WHITE_BRIGHT+"("+
                TextColors.YELLOW_BOLD+indice[0]+TextColors.WHITE_BRIGHT+","+
                TextColors.CYAN_BOLD+indice[1]+TextColors.WHITE_BRIGHT+","+
                TextColors.CYAN_BOLD+indice[2]+TextColors.WHITE_BRIGHT+","+
                TextColors.CYAN_BOLD+indice[3]+TextColors.WHITE_BRIGHT+")";
    }
}

