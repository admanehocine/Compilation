// Generated from C:/Users/lenovo/IdeaProjects/compile/src/antlr\Compile.g4 by ANTLR 4.9
package antlr;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link CompileParser}.
 */
public interface CompileListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link CompileParser#prg}.
	 * @param ctx the parse tree
	 */
	void enterPrg(CompileParser.PrgContext ctx);
	/**
	 * Exit a parse tree produced by {@link CompileParser#prg}.
	 * @param ctx the parse tree
	 */
	void exitPrg(CompileParser.PrgContext ctx);
	/**
	 * Enter a parse tree produced by {@link CompileParser#list_declaration}.
	 * @param ctx the parse tree
	 */
	void enterList_declaration(CompileParser.List_declarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link CompileParser#list_declaration}.
	 * @param ctx the parse tree
	 */
	void exitList_declaration(CompileParser.List_declarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link CompileParser#dec}.
	 * @param ctx the parse tree
	 */
	void enterDec(CompileParser.DecContext ctx);
	/**
	 * Exit a parse tree produced by {@link CompileParser#dec}.
	 * @param ctx the parse tree
	 */
	void exitDec(CompileParser.DecContext ctx);
	/**
	 * Enter a parse tree produced by {@link CompileParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(CompileParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link CompileParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(CompileParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link CompileParser#list_variable}.
	 * @param ctx the parse tree
	 */
	void enterList_variable(CompileParser.List_variableContext ctx);
	/**
	 * Exit a parse tree produced by {@link CompileParser#list_variable}.
	 * @param ctx the parse tree
	 */
	void exitList_variable(CompileParser.List_variableContext ctx);
	/**
	 * Enter a parse tree produced by {@link CompileParser#id}.
	 * @param ctx the parse tree
	 */
	void enterId(CompileParser.IdContext ctx);
	/**
	 * Exit a parse tree produced by {@link CompileParser#id}.
	 * @param ctx the parse tree
	 */
	void exitId(CompileParser.IdContext ctx);
	/**
	 * Enter a parse tree produced by {@link CompileParser#list_instruction}.
	 * @param ctx the parse tree
	 */
	void enterList_instruction(CompileParser.List_instructionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CompileParser#list_instruction}.
	 * @param ctx the parse tree
	 */
	void exitList_instruction(CompileParser.List_instructionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CompileParser#inst}.
	 * @param ctx the parse tree
	 */
	void enterInst(CompileParser.InstContext ctx);
	/**
	 * Exit a parse tree produced by {@link CompileParser#inst}.
	 * @param ctx the parse tree
	 */
	void exitInst(CompileParser.InstContext ctx);
	/**
	 * Enter a parse tree produced by {@link CompileParser#affect}.
	 * @param ctx the parse tree
	 */
	void enterAffect(CompileParser.AffectContext ctx);
	/**
	 * Exit a parse tree produced by {@link CompileParser#affect}.
	 * @param ctx the parse tree
	 */
	void exitAffect(CompileParser.AffectContext ctx);
	/**
	 * Enter a parse tree produced by {@link CompileParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterExp(CompileParser.ExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link CompileParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitExp(CompileParser.ExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link CompileParser#exp_prio}.
	 * @param ctx the parse tree
	 */
	void enterExp_prio(CompileParser.Exp_prioContext ctx);
	/**
	 * Exit a parse tree produced by {@link CompileParser#exp_prio}.
	 * @param ctx the parse tree
	 */
	void exitExp_prio(CompileParser.Exp_prioContext ctx);
	/**
	 * Enter a parse tree produced by {@link CompileParser#plusmoin}.
	 * @param ctx the parse tree
	 */
	void enterPlusmoin(CompileParser.PlusmoinContext ctx);
	/**
	 * Exit a parse tree produced by {@link CompileParser#plusmoin}.
	 * @param ctx the parse tree
	 */
	void exitPlusmoin(CompileParser.PlusmoinContext ctx);
	/**
	 * Enter a parse tree produced by {@link CompileParser#muldiv}.
	 * @param ctx the parse tree
	 */
	void enterMuldiv(CompileParser.MuldivContext ctx);
	/**
	 * Exit a parse tree produced by {@link CompileParser#muldiv}.
	 * @param ctx the parse tree
	 */
	void exitMuldiv(CompileParser.MuldivContext ctx);
	/**
	 * Enter a parse tree produced by {@link CompileParser#suit_exp}.
	 * @param ctx the parse tree
	 */
	void enterSuit_exp(CompileParser.Suit_expContext ctx);
	/**
	 * Exit a parse tree produced by {@link CompileParser#suit_exp}.
	 * @param ctx the parse tree
	 */
	void exitSuit_exp(CompileParser.Suit_expContext ctx);
	/**
	 * Enter a parse tree produced by {@link CompileParser#val}.
	 * @param ctx the parse tree
	 */
	void enterVal(CompileParser.ValContext ctx);
	/**
	 * Exit a parse tree produced by {@link CompileParser#val}.
	 * @param ctx the parse tree
	 */
	void exitVal(CompileParser.ValContext ctx);
	/**
	 * Enter a parse tree produced by {@link CompileParser#instif}.
	 * @param ctx the parse tree
	 */
	void enterInstif(CompileParser.InstifContext ctx);
	/**
	 * Exit a parse tree produced by {@link CompileParser#instif}.
	 * @param ctx the parse tree
	 */
	void exitInstif(CompileParser.InstifContext ctx);
	/**
	 * Enter a parse tree produced by {@link CompileParser#el}.
	 * @param ctx the parse tree
	 */
	void enterEl(CompileParser.ElContext ctx);
	/**
	 * Exit a parse tree produced by {@link CompileParser#el}.
	 * @param ctx the parse tree
	 */
	void exitEl(CompileParser.ElContext ctx);
	/**
	 * Enter a parse tree produced by {@link CompileParser#condition}.
	 * @param ctx the parse tree
	 */
	void enterCondition(CompileParser.ConditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CompileParser#condition}.
	 * @param ctx the parse tree
	 */
	void exitCondition(CompileParser.ConditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CompileParser#op_logique}.
	 * @param ctx the parse tree
	 */
	void enterOp_logique(CompileParser.Op_logiqueContext ctx);
	/**
	 * Exit a parse tree produced by {@link CompileParser#op_logique}.
	 * @param ctx the parse tree
	 */
	void exitOp_logique(CompileParser.Op_logiqueContext ctx);
	/**
	 * Enter a parse tree produced by {@link CompileParser#dowhile}.
	 * @param ctx the parse tree
	 */
	void enterDowhile(CompileParser.DowhileContext ctx);
	/**
	 * Exit a parse tree produced by {@link CompileParser#dowhile}.
	 * @param ctx the parse tree
	 */
	void exitDowhile(CompileParser.DowhileContext ctx);
	/**
	 * Enter a parse tree produced by {@link CompileParser#scan}.
	 * @param ctx the parse tree
	 */
	void enterScan(CompileParser.ScanContext ctx);
	/**
	 * Exit a parse tree produced by {@link CompileParser#scan}.
	 * @param ctx the parse tree
	 */
	void exitScan(CompileParser.ScanContext ctx);
	/**
	 * Enter a parse tree produced by {@link CompileParser#print}.
	 * @param ctx the parse tree
	 */
	void enterPrint(CompileParser.PrintContext ctx);
	/**
	 * Exit a parse tree produced by {@link CompileParser#print}.
	 * @param ctx the parse tree
	 */
	void exitPrint(CompileParser.PrintContext ctx);
	/**
	 * Enter a parse tree produced by {@link CompileParser#listID}.
	 * @param ctx the parse tree
	 */
	void enterListID(CompileParser.ListIDContext ctx);
	/**
	 * Exit a parse tree produced by {@link CompileParser#listID}.
	 * @param ctx the parse tree
	 */
	void exitListID(CompileParser.ListIDContext ctx);
}