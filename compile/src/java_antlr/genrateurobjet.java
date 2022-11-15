package java_antlr;
import java.util.HashMap;
import java.util.LinkedList;

public class genrateurobjet
{
    static public class Ope
    {
        public String str;

        public Ope(String str) {
            this.str = str;
        }
    }
    static public class Instruction
    {
        String inst;
        String op1;
        String op2;

        public Instruction(String inst, String op1, String op2) {
            this.inst = inst;
            this.op1 = op1;
            this.op2 = op2;
        }

        public Instruction(String inst, String op1) {
            this.inst = inst;
            this.op1 = op1;
            this.op2 = null;
        }

        @Override
        public String toString()
        {
            return inst + " " + op1 + " " + ((op2 == null)?"":op2);
        }
    }
    listQuadruplet quadruples;
    LinkedList<Instruction> listinstructions = new LinkedList<>();
    HashMap<String, generateur> generatequadruple = new HashMap<>();

    HashMap<Integer,Integer> nombre_quadruple = new HashMap<>(); //pour quand puisse jumpe pour les routines
    Ope acc = new Ope("");

    public genrateurobjet(listQuadruplet quadruples) {
        generatequadruple.put("=",new generateur.Mov(this));
        generatequadruple.put("*",new generateur.Mul(this));
        generatequadruple.put("/",new generateur.Div(this));
        generatequadruple.put("+",new generateur.Add(this));
        generatequadruple.put("-",new generateur.Sub(this));
        generatequadruple.put("BR",new generateur.Br(this));
        generatequadruple.put("BLE",new generateur.Ble(this));
        generatequadruple.put("BGE",new generateur.Bge(this));
        generatequadruple.put("BG",new generateur.Bg(this));
        generatequadruple.put("BL",new generateur.Bl(this));
        generatequadruple.put("BE",new generateur.Be(this));
        generatequadruple.put("BNE",new generateur.Bne(this));
        generatequadruple.put("END",new generateur.End(this));
        this.quadruples = quadruples;
    }

    public LinkedList<Instruction> generateCode()
    {
        LinkedList<Instruction> insts_to_jumps = new LinkedList<>();

        for(int i = 0; i< quadruples.size(); i++)
        {
            Instruction[] inst = getInstruction(quadruples.getQuad(i));

            nombre_quadruple.put(i, listinstructions.size());

            for (int j=0;j<inst.length;j++) {
                listinstructions.add(inst[j]);


                if(isJumpInst(inst[j].inst))
                    insts_to_jumps.add(inst[j]);
            }
        }


        for (int i=0;i<insts_to_jumps.size();i++)
            insts_to_jumps.get(i).op1 = ""+ nombre_quadruple.get(Integer.parseInt(insts_to_jumps.get(i).op1));

        System.out.println("******************************************************");
        for (int i = 0; i< listinstructions.size(); i++)
        {
            System.out.println(i + "- "+ listinstructions.get(i));


        }
        System.out.println("******************************************************");

        return listinstructions;
    }

    Instruction[] getInstruction(Quad quad)
    {
        return generatequadruple.get(quad.get(0)).getInstruction(quad);
    }

    private boolean isJumpInst(String inst)
    {
        String[] jmps = {"JMP","JLE","JGE","JG","JL","JE","JNE"};
        for (int i=0;i<jmps.length;i++)
            if(inst.compareTo(jmps[i]) == 0)
                return true;
        return false;
    }




    public void setAcc(String acc) {
        this.acc.str = acc;
    }

    public Instruction[] getInAcc(Ope op1,Ope op2)
    {
        Instruction[] insts = null;
        if(op1.str.equals(acc.str)) op1.str = "AX";
        else if(!op2.str.equals("") && op2.str.equals(acc.str))
        {
            op2.str = op1.str;
        }
        else if(!acc.str.equals("") && !isNumber(acc.str))
        {
            insts = new Instruction[2];
            insts[0] = new Instruction("MOV",acc.str,"AX");
            insts[1] = new Instruction("MOV","AX",op1.str);
            acc.str = op1.str;
        }
        else
        {
            insts = new Instruction[1];
            insts[0] = new Instruction("MOV","AX",op1.str);
            acc.str = op1.str;
        }
        op1.str = "AX";
        return insts;
    }

    private boolean isNumber(String s)
    {
        for (int i=0;i<s.length();i++)
            if(s.charAt(i) > '9' || s.charAt(i) < '0')
                return false;
        return true;
    }
}

