grammar Compile;

prg : COMPIL ID PARO PARF
      ACODO list_declaration
      START  list_instruction
      ACODF  EOF;

//listes déclaration
list_declaration : (dec list_declaration)|dec  ;
dec : type list_variable PV ;
type : INT | FLOAT | STRING;
list_variable : ((ID VER list_variable) | ID) ;
id : ID;

// listes  instructions
list_instruction : inst list_instruction | ;

inst : affect | instif  | print | scan  |dowhile ;

// affectation a=a+5  a=2+2;
affect : id AFF exp PV ;
exp : exp plusmoin exp_prio | exp_prio;
exp_prio : exp_prio muldiv suit_exp | suit_exp;
plusmoin : PLUS | MINUS ;
muldiv : MUL | DIV ;
suit_exp : id | PARO exp PARF |val ;
val : INTEGERVAL | FLOATVAL|STR ;



// instruction if
instif : IF PARO condition PARF
       THEN ACODO list_instruction ACODF (|el ACODO list_instruction ACODF)  ;
el : ELSE;
condition : exp op_logique exp ;
op_logique : SUP | INF | SUPE | INFE | DIF | EQ;

//instruction do while
dowhile : DO ACODO list_instruction ACODF
            WHILE PARO condition PARF  PV ;

// instruction scancompil/printcompil
scan :  SCAN PARO listID PARF PV;
print : PRINT PARO (STR|listID) PARF PV;
listID : id VER listID | id ;


//Mot cle
COMPIL : 'compil';
INT : 'intCompil';
FLOAT : 'floatCompil';
STRING : 'stringCompil';
SCAN : 'scancompil' ;
PRINT : 'printcompil' ;
START : 'start' ;
IF : 'if';
THEN : 'then';
ELSE : 'else';

DO: 'do';
WHILE: 'while';



// les operateurs

AFF : '=';
PLUS : '+';
MINUS : '-';
MUL : '*';
DIV : '/';
SUP : '>';
INF : '<';
SUPE : '>=';
INFE : '<=';
EQ : '==';
DIF : '!=';
PARO : '(';
PARF : ')';
ACODO: '{';
ACODF: '}';
PV : ';';
VER : ',';
// Expression reguliere
 ID : [a-zA-Z][a-zA-Z0-9_]*;
INTEGERVAL : '0'|[1-9][0-9]*;
FLOATVAL : INTEGERVAL('.' INTEGERVAL);//'0'|[+-]?[1-9][0-9]*('.'[0-9]*);
STR : '"' .*? '"';
// To Skip
WS : [ \n\t] -> skip;
COMMENTAIRE1 : '/''/'(~[\n])* -> skip;
COMMENTAIRE2 : '/*'(.)*?'*/' -> skip;

