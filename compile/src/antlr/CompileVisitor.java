// Generated from C:/Users/lenovo/IdeaProjects/compile/src/antlr\Compile.g4 by ANTLR 4.9
package antlr;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link CompileParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface CompileVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link CompileParser#prg}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrg(CompileParser.PrgContext ctx);
	/**
	 * Visit a parse tree produced by {@link CompileParser#list_declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitList_declaration(CompileParser.List_declarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link CompileParser#dec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDec(CompileParser.DecContext ctx);
	/**
	 * Visit a parse tree produced by {@link CompileParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(CompileParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link CompileParser#list_variable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitList_variable(CompileParser.List_variableContext ctx);
	/**
	 * Visit a parse tree produced by {@link CompileParser#id}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitId(CompileParser.IdContext ctx);
	/**
	 * Visit a parse tree produced by {@link CompileParser#list_instruction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitList_instruction(CompileParser.List_instructionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CompileParser#inst}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInst(CompileParser.InstContext ctx);
	/**
	 * Visit a parse tree produced by {@link CompileParser#affect}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAffect(CompileParser.AffectContext ctx);
	/**
	 * Visit a parse tree produced by {@link CompileParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExp(CompileParser.ExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link CompileParser#exp_prio}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExp_prio(CompileParser.Exp_prioContext ctx);
	/**
	 * Visit a parse tree produced by {@link CompileParser#plusmoin}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPlusmoin(CompileParser.PlusmoinContext ctx);
	/**
	 * Visit a parse tree produced by {@link CompileParser#muldiv}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMuldiv(CompileParser.MuldivContext ctx);
	/**
	 * Visit a parse tree produced by {@link CompileParser#suit_exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSuit_exp(CompileParser.Suit_expContext ctx);
	/**
	 * Visit a parse tree produced by {@link CompileParser#val}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVal(CompileParser.ValContext ctx);
	/**
	 * Visit a parse tree produced by {@link CompileParser#instif}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInstif(CompileParser.InstifContext ctx);
	/**
	 * Visit a parse tree produced by {@link CompileParser#el}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEl(CompileParser.ElContext ctx);
	/**
	 * Visit a parse tree produced by {@link CompileParser#condition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondition(CompileParser.ConditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CompileParser#op_logique}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOp_logique(CompileParser.Op_logiqueContext ctx);
	/**
	 * Visit a parse tree produced by {@link CompileParser#dowhile}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDowhile(CompileParser.DowhileContext ctx);
	/**
	 * Visit a parse tree produced by {@link CompileParser#scan}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitScan(CompileParser.ScanContext ctx);
	/**
	 * Visit a parse tree produced by {@link CompileParser#print}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrint(CompileParser.PrintContext ctx);
	/**
	 * Visit a parse tree produced by {@link CompileParser#listID}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitListID(CompileParser.ListIDContext ctx);
}