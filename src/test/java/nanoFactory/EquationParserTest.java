package nanoFactory;

import org.junit.Test;

import java.util.Collection;

import static org.junit.Assert.assertEquals;

public class EquationParserTest {
    @Test
    public void shouldParseAnEquation() {
        final Stoichiometry reactions = EquationParser.parse("10 ORE => 10 A");
        final Collection<ReactionEquation> a = reactions.getReactionsThatCreates(Chemical.getChemical("A"));
        assertEquals(1, a.size());
    }
}