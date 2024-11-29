package de.pelkowsk.bachelor;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import org.example.SysMLv2beispielLexer;
import org.example.SysMLv2beispielParser; // Import der generierten Klassen
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SysMLv2GrammarTest {

    @Test
    public void testValidExpression() {
        String input = "3 + 5 - 2";
        SysMLv2beispielLexer lexer = new SysMLv2beispielLexer(CharStreams.fromString(input));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        SysMLv2beispielParser parser = new SysMLv2beispielParser(tokens);

        ParseTree tree = parser.start();

        // Ensure the parse tree is not null
        assertNotNull(tree, "Parse tree should not be null for valid input");

        // Ensure no syntax errors
        assertEquals(0, parser.getNumberOfSyntaxErrors(), "There should be no syntax errors");

        // Print the parse tree for debugging (optional)
        System.out.println(tree.toStringTree(parser));
    }

    @Test
    public void testInvalidExpression() {
        String input = "3 + * 5";
        SysMLv2beispielLexer lexer = new SysMLv2beispielLexer(CharStreams.fromString(input));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        SysMLv2beispielParser parser = new SysMLv2beispielParser(tokens);

        parser.start();

        // Ensure there are syntax errors
        assertTrue(parser.getNumberOfSyntaxErrors() > 0, "There should be syntax errors for invalid input");
    }
}
