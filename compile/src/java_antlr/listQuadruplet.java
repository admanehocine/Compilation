package java_antlr;
import java.util.LinkedList;

public class listQuadruplet
{
    LinkedList<Quad> list = new LinkedList<>();
    public int addQuad(String s1,String s2,String s3,String s4)
    {
        return addQuad(new Quad(s1,s2,s3,s4));
    }

    public int addQuad(Quad quad)
    {
        list.add(quad);
        return list.size()-1;
    }

    public Quad getQuad(int index)
    {
        return list.get(index);
    }


    public int size()
    {
        return list.size();
    }
}

