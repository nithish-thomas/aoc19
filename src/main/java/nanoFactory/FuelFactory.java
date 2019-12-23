package nanoFactory;

import java.util.HashMap;
import java.util.Map;

public class FuelFactory {
    private static final Chemical ORE = Chemical.getChemical("ORE");
    private final Stoichiometry stoichiometry;
    private final Map<Chemical, Long> extras = new HashMap<>();

    public FuelFactory(Stoichiometry stoichiometry) {
        this.stoichiometry = stoichiometry;
    }

    public long amountOfBaseChemicalRequire(Chemical chemical, long amountRequired) {
        if (ORE.equals(chemical)) {
            return amountRequired;
        }

        final long actualAmountRequired = amountToBeActuallyCreated(chemical, amountRequired);
        if (actualAmountRequired == 0) {
            return 0;
        } else if (actualAmountRequired != amountRequired) {
            return amountOfBaseChemicalRequire(chemical, actualAmountRequired);
        }

        final ReactionEquation reactionsThatCreates = stoichiometry.getReactionsThatCreates(chemical);
        final Map<Chemical, Integer> inputs = reactionsThatCreates.getInputs();
        final Map<Chemical, Integer> outputs = reactionsThatCreates.getOutputs();
        final Integer amountOfOutput = outputs.get(chemical);
        final long timesReactionNeedsToBeDone = (long) Math.ceil(amountRequired / (double) amountOfOutput);
        final long extraChemical = (timesReactionNeedsToBeDone * amountOfOutput) - amountRequired;

        addExtra(chemical, extraChemical);

        return inputs.entrySet().stream()
          .mapToLong(value -> amountOfBaseChemicalRequire(value.getKey(), value.getValue() * timesReactionNeedsToBeDone))
          .sum();
    }

    private void addExtra(Chemical chemical, long extraChemical) {
        if (extraChemical == 0) return;
        extras.put(chemical, extraChemical);
    }

    private long amountToBeActuallyCreated(Chemical chemical, long amountRequired) {
        final Long extraAmount = extras.get(chemical);
        if (extraAmount == null) {
            return amountRequired;
        }
        if (amountRequired >= extraAmount) {
            extras.remove(chemical);
            return amountRequired - extraAmount;
        } else {
            extras.put(chemical, extraAmount - amountRequired);
            return 0;
        }

    }
}
