package nanoFactory;


import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class EquationParser {

    public static Stoichiometry parse(String reactionsString){
        final Stoichiometry stoichiometry = new Stoichiometry();
        final String[] reactions = reactionsString.split("\n");

        for (String aReactionString: reactions) {
            final String[] inputsAndOutput = aReactionString.split("=>");
            Map<Chemical, Integer> inputs = parseEachSideOfEquation(inputsAndOutput[0]);
            Map<Chemical, Integer> output = parseEachSideOfEquation(inputsAndOutput[1]);
            stoichiometry.addReaction(new ReactionEquation(inputs, output));
        }
        return stoichiometry;
    }

    private static Map<Chemical, Integer> parseEachSideOfEquation(String eachSideOfEquation) {
        final String[] molecules = eachSideOfEquation.split(",");
        return Arrays.stream(molecules)
          .map(EquationParser::parseMolecule)
          .collect(Collectors.toMap(strings -> Chemical.getChemical(strings[1]), strings -> Integer.parseInt(strings[0])));
    }

    private static String[] parseMolecule(String molecule) {
        return molecule.trim().split(" ");
    }

}
