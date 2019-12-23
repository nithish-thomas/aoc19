package nanoFactory;

import com.google.common.collect.HashMultimap;

import java.util.Collection;

public class Stoichiometry {
    private final HashMultimap<Chemical, ReactionEquation> reactionsThatCanCreate = HashMultimap.create();

    public void addReaction(ReactionEquation equation) {
        equation.getOutputs()
          .entrySet().forEach(reactionOutputsEntry -> reactionsThatCanCreate.put(reactionOutputsEntry.getKey(), equation));
    }

    public Collection<ReactionEquation> getReactionsThatCreates(Chemical chemical){
        return reactionsThatCanCreate.get(chemical);
    }
}
