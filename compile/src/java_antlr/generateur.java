package java_antlr;

public class generateur
{
    public genrateurobjet.Instruction[] getInstruction(Quad quad)
    {
        return null;
    }
    genrateurobjet gen;

    public generateur(genrateurobjet gen) {
        this.gen = gen;
    }

    genrateurobjet.Instruction[] getInAcc(genrateurobjet.Ope op1, genrateurobjet.Ope op2, int arraySize)
    {
        genrateurobjet.Instruction[] insts = gen.getInAcc(op1,op2);

        genrateurobjet.Instruction[] tab = new genrateurobjet.Instruction[arraySize+((insts==null)?0:insts.length)];
        if(insts!=null)
            for (int i=0;i<insts.length;i++)
                tab[i] = insts[i];
        return tab;
    }

    //******************************** Instructions ***********************************

    static public class Mov extends generateur
    {
        public Mov(genrateurobjet gen) {
            super(gen);
        }

        public genrateurobjet.Instruction[] getInstruction(Quad quad)
        {
            genrateurobjet.Ope op1 = new genrateurobjet.Ope(quad.get(1)),op2 = new genrateurobjet.Ope("");
            genrateurobjet.Instruction[] tab = getInAcc(op1,op2,1);
            tab[tab.length-1] = new genrateurobjet.Instruction("MOV",quad.get(3),"AX");
            return tab;
        }
    }

    static public class Add extends generateur
    {
        public Add(genrateurobjet gen) {
            super(gen);
        }

        public genrateurobjet.Instruction[] getInstruction(Quad quad)
        {
            genrateurobjet.Ope op1 = new genrateurobjet.Ope(quad.get(1)),op2 = new genrateurobjet.Ope(quad.get(2));
            genrateurobjet.Instruction[] tab = getInAcc(op1,op2,1);
            tab[tab.length-1] = new genrateurobjet.Instruction("ADD","AX",op2.str);
            gen.setAcc(quad.get(3));
            return tab;
        }
    }

    static public class Sub extends generateur
    {
        public Sub(genrateurobjet gen) {
            super(gen);
        }

        public genrateurobjet.Instruction[] getInstruction(Quad quad)
        {
            genrateurobjet.Ope op1 = new genrateurobjet.Ope(quad.get(1)),op2 = new genrateurobjet.Ope("");
            genrateurobjet.Instruction[] tab = getInAcc(op1,op2,1);
            tab[tab.length-1] = new genrateurobjet.Instruction("SUB","AX",quad.get(2));
            gen.setAcc(quad.get(3));
            return tab;
        }
    }

    static public class Mul extends generateur
    {
        public Mul(genrateurobjet gen) {
            super(gen);
        }

        public genrateurobjet.Instruction[] getInstruction(Quad quad)
        {
            genrateurobjet.Ope op1 = new genrateurobjet.Ope(quad.get(1)),op2 = new genrateurobjet.Ope(quad.get(2));
            genrateurobjet.Instruction[] tab = getInAcc(op1,op2,1);
            tab[tab.length-1] = new genrateurobjet.Instruction("MUL","AX",op2.str);
            gen.setAcc(quad.get(3));
            return tab;
        }
    }

    static public class Div extends generateur
    {
        public Div(genrateurobjet gen) {
            super(gen);
        }

        public genrateurobjet.Instruction[] getInstruction(Quad quad)
        {
            genrateurobjet.Ope op1 = new genrateurobjet.Ope(quad.get(1)),op2 = new genrateurobjet.Ope("");
            genrateurobjet.Instruction[] tab = getInAcc(op1,op2,1);
            tab[tab.length-1] = new genrateurobjet.Instruction("DIV","AX",quad.get(2));
            gen.setAcc(quad.get(3));
            return tab;
        }
    }

    static public class Br extends generateur
    {
        public Br(genrateurobjet gen) {
            super(gen);
        }

        public genrateurobjet.Instruction[] getInstruction(Quad quad)
        {
            genrateurobjet.Instruction[] tab = new genrateurobjet.Instruction[1];
            tab[0] = new genrateurobjet.Instruction("JMP",quad.get(3));
            return tab;
        }
    }
    static public class Ble extends generateur
    {
        public Ble(genrateurobjet gen) {
            super(gen);
        }

        public genrateurobjet.Instruction[] getInstruction(Quad quad)
        {
            genrateurobjet.Ope op1 = new genrateurobjet.Ope(quad.get(1)),op2 = new genrateurobjet.Ope("");
            genrateurobjet.Instruction[] tab = getInAcc(op1,op2,2);
            tab[tab.length-2] = new genrateurobjet.Instruction("CMP","AX",quad.get(2));
            tab[tab.length-1] = new genrateurobjet.Instruction("JLE",(quad.get(3)));
            return tab;
        }
    }

    static public class Bge extends generateur
    {
        public Bge(genrateurobjet gen) {
            super(gen);
        }

        public genrateurobjet.Instruction[] getInstruction(Quad quad)
        {
            genrateurobjet.Ope op1 = new genrateurobjet.Ope(quad.get(1)),op2 = new genrateurobjet.Ope("");
            genrateurobjet.Instruction[] tab = getInAcc(op1,op2,2);
            tab[tab.length-2] = new genrateurobjet.Instruction("CMP","AX",quad.get(2));
            tab[tab.length-1] = new genrateurobjet.Instruction("JGE",quad.get(3));
            return tab;
        }
    }

    static public class Bg extends generateur
    {
        public Bg(genrateurobjet gen) {
            super(gen);
        }

        public genrateurobjet.Instruction[] getInstruction(Quad quad)
        {
            genrateurobjet.Ope op1 = new genrateurobjet.Ope(quad.get(1)),op2 = new genrateurobjet.Ope("");
            genrateurobjet.Instruction[] tab = getInAcc(op1,op2,2);
            tab[tab.length-2] = new genrateurobjet.Instruction("CMP","AX",quad.get(2));
            tab[tab.length-1] = new genrateurobjet.Instruction("JG",quad.get(3));
            return tab;
        }
    }

    static public class Bl extends generateur
    {
        public Bl(genrateurobjet gen) {
            super(gen);
        }

        public genrateurobjet.Instruction[] getInstruction(Quad quad)
        {
            genrateurobjet.Ope op1 = new genrateurobjet.Ope(quad.get(1)),op2 = new genrateurobjet.Ope("");
            genrateurobjet.Instruction[] tab = getInAcc(op1,op2,2);
            tab[tab.length-2] = new genrateurobjet.Instruction("CMP","AX",quad.get(2));
            tab[tab.length-1] = new genrateurobjet.Instruction("JL",quad.get(3));
            return tab;
        }
    }

    static public class Be extends generateur
    {
        public Be(genrateurobjet gen) {
            super(gen);
        }

        public genrateurobjet.Instruction[] getInstruction(Quad quad)
        {
            genrateurobjet.Ope op1 = new genrateurobjet.Ope(quad.get(1)),op2 = new genrateurobjet.Ope("");
            genrateurobjet.Instruction[] tab = getInAcc(op1,op2,2);
            tab[tab.length-2] = new genrateurobjet.Instruction("CMP","AX",quad.get(2));
            tab[tab.length-1] = new genrateurobjet.Instruction("JE",quad.get(3));
            return tab;
        }
    }

    static public class Bne extends generateur
    {
        public Bne(genrateurobjet gen) {
            super(gen);
        }

        public genrateurobjet.Instruction[] getInstruction(Quad quad)
        {
            genrateurobjet.Ope op1 = new genrateurobjet.Ope(quad.get(1)),op2 = new genrateurobjet.Ope("");
            genrateurobjet.Instruction[] tab = getInAcc(op1,op2,2);
            tab[tab.length-2] = new genrateurobjet.Instruction("CMP","AX",quad.get(2));
            tab[tab.length-1] = new genrateurobjet.Instruction("JNE",quad.get(3));
            return tab;
        }
    }

    static public class End extends generateur
    {
        public End(genrateurobjet gen) {
            super(gen);
        }

        public genrateurobjet.Instruction[] getInstruction(Quad quad)
        {
            genrateurobjet.Instruction[] tab = new genrateurobjet.Instruction[2];
            tab[0] = new genrateurobjet.Instruction("MOV","AX","4C00H");
            tab[1] = new genrateurobjet.Instruction("INT","21H");
            return tab;
        }
    }
}

