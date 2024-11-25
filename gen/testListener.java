// Generated from /Users/janpelkowski/Documents/Test2/src/test.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link testParser}.
 */
public interface testListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link testParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(testParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link testParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(testParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link testParser#conditionalExpr}.
	 * @param ctx the parse tree
	 */
	void enterConditionalExpr(testParser.ConditionalExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link testParser#conditionalExpr}.
	 * @param ctx the parse tree
	 */
	void exitConditionalExpr(testParser.ConditionalExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link testParser#nullCoalescingExpr}.
	 * @param ctx the parse tree
	 */
	void enterNullCoalescingExpr(testParser.NullCoalescingExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link testParser#nullCoalescingExpr}.
	 * @param ctx the parse tree
	 */
	void exitNullCoalescingExpr(testParser.NullCoalescingExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link testParser#ownedExprRef}.
	 * @param ctx the parse tree
	 */
	void enterOwnedExprRef(testParser.OwnedExprRefContext ctx);
	/**
	 * Exit a parse tree produced by {@link testParser#ownedExprRef}.
	 * @param ctx the parse tree
	 */
	void exitOwnedExprRef(testParser.OwnedExprRefContext ctx);
	/**
	 * Enter a parse tree produced by {@link testParser#impliesExpr}.
	 * @param ctx the parse tree
	 */
	void enterImpliesExpr(testParser.ImpliesExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link testParser#impliesExpr}.
	 * @param ctx the parse tree
	 */
	void exitImpliesExpr(testParser.ImpliesExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link testParser#orExpr}.
	 * @param ctx the parse tree
	 */
	void enterOrExpr(testParser.OrExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link testParser#orExpr}.
	 * @param ctx the parse tree
	 */
	void exitOrExpr(testParser.OrExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link testParser#xorExpr}.
	 * @param ctx the parse tree
	 */
	void enterXorExpr(testParser.XorExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link testParser#xorExpr}.
	 * @param ctx the parse tree
	 */
	void exitXorExpr(testParser.XorExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link testParser#andExpr}.
	 * @param ctx the parse tree
	 */
	void enterAndExpr(testParser.AndExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link testParser#andExpr}.
	 * @param ctx the parse tree
	 */
	void exitAndExpr(testParser.AndExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link testParser#equalityExpr}.
	 * @param ctx the parse tree
	 */
	void enterEqualityExpr(testParser.EqualityExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link testParser#equalityExpr}.
	 * @param ctx the parse tree
	 */
	void exitEqualityExpr(testParser.EqualityExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link testParser#relationalExpr}.
	 * @param ctx the parse tree
	 */
	void enterRelationalExpr(testParser.RelationalExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link testParser#relationalExpr}.
	 * @param ctx the parse tree
	 */
	void exitRelationalExpr(testParser.RelationalExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link testParser#additiveExpr}.
	 * @param ctx the parse tree
	 */
	void enterAdditiveExpr(testParser.AdditiveExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link testParser#additiveExpr}.
	 * @param ctx the parse tree
	 */
	void exitAdditiveExpr(testParser.AdditiveExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link testParser#multiplicativeExpr}.
	 * @param ctx the parse tree
	 */
	void enterMultiplicativeExpr(testParser.MultiplicativeExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link testParser#multiplicativeExpr}.
	 * @param ctx the parse tree
	 */
	void exitMultiplicativeExpr(testParser.MultiplicativeExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link testParser#primaryExpr}.
	 * @param ctx the parse tree
	 */
	void enterPrimaryExpr(testParser.PrimaryExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link testParser#primaryExpr}.
	 * @param ctx the parse tree
	 */
	void exitPrimaryExpr(testParser.PrimaryExprContext ctx);
}