package nanoFactory;

import java.util.HashMap;
import java.util.Map;

public class Stoichiometry {
    private final Map<Chemical, ReactionEquation> reactionsThatCanCreate = new HashMap<>();

    public void addReaction(ReactionEquation equation) {
        equation.getOutputs()
          .entrySet().forEach(reactionOutputsEntry -> reactionsThatCanCreate.put(reactionOutputsEntry.getKey(), equation));
    }

    public ReactionEquation getReactionsThatCreates(Chemical chemical){
        return reactionsThatCanCreate.get(chemical);
    }


}
