// Generated from /Users/janpelkowski/Documents/Test2/src/test.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link testParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface testVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link testParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(testParser.ExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link testParser#conditionalExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditionalExpr(testParser.ConditionalExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link testParser#nullCoalescingExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNullCoalescingExpr(testParser.NullCoalescingExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link testParser#ownedExprRef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOwnedExprRef(testParser.OwnedExprRefContext ctx);
	/**
	 * Visit a parse tree produced by {@link testParser#impliesExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImpliesExpr(testParser.ImpliesExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link testParser#orExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrExpr(testParser.OrExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link testParser#xorExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXorExpr(testParser.XorExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link testParser#andExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAndExpr(testParser.AndExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link testParser#equalityExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqualityExpr(testParser.EqualityExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link testParser#relationalExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelationalExpr(testParser.RelationalExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link testParser#additiveExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdditiveExpr(testParser.AdditiveExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link testParser#multiplicativeExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiplicativeExpr(testParser.MultiplicativeExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link testParser#primaryExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryExpr(testParser.PrimaryExprContext ctx);
}