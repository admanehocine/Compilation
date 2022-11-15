




         package java_antlr;

 import antlr.CompileLexer;
 import antlr.CompileParser;
 import org.antlr.v4.runtime.CharStream;
 import org.antlr.v4.runtime.CharStreams;
 import org.antlr.v4.runtime.CommonTokenStream;
 import org.antlr.v4.runtime.tree.ParseTree;
 import org.antlr.v4.runtime.tree.ParseTreeWalker;
 import java.io.IOException;
 public class launch {
     public static void main(String[] args ){

         try{ String source="C:\\Users\\lenovo\\IdeaProjects\\compile\\src\\teste\\input.txt";
             CharStream fichier= CharStreams.fromFileName(source);
             CompileLexer lexeur= new CompileLexer(fichier);         // <- L'analyseur Lexical
             CommonTokenStream token= new CommonTokenStream(lexeur); // <- Les Token
             CompileParser parseur=new CompileParser(token);         // <- Le parseur
             ParseTree arbreAbstrait= parseur.prg();                 // <- Arbre Abstrait
             Semantique L=new Semantique();                          // <- Classe semantique
             ParseTreeWalker analyseur = new ParseTreeWalker();      // <- Fair une analyse semantique
             analyseur.walk(L, arbreAbstrait);                       // <-  Creation d'analyseur
             if(L.errors.size()==0) {                                //si il ya pas d erreurs semantique alors on genere les quads
                 Createur_Quadruples D = new Createur_Quadruples(L); // <- Createur des quadreuples (apres une analyse semantique)
                 analyseur.walk(D, arbreAbstrait);                        // <- Fair une creation des quads
             }


         }catch(IOException e){
             e.printStackTrace();
         }

     }
 }





























