package nanoFactory;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class EquationParserTest {
    @Test
    public void shouldParseAnEquation() {
        final Stoichiometry reactions = EquationParser.parse("10 ORE => 10 A");
        final ReactionEquation equation = reactions.getReactionsThatCreates(Chemical.getChemical("A"));
        assertNotNull(equation);
    }
}