package nanoFactory;

import java.util.Collections;
import java.util.Map;
import java.util.Objects;

public class ReactionEquation {
    private final Map<Chemical, Integer> inputs;
    private final Map<Chemical, Integer> outputs;

    public ReactionEquation(Map<Chemical, Integer> inputs, Map<Chemical, Integer> outputs) {
        this.inputs = Collections.unmodifiableMap(inputs);
        this.outputs = Collections.unmodifiableMap(outputs);
    }

    public Map<Chemical, Integer> getInputs() {
        return inputs;
    }

    public Map<Chemical, Integer> getOutputs() {
        return outputs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReactionEquation that = (ReactionEquation) o;
        return Objects.equals(inputs, that.inputs) &&
          Objects.equals(outputs, that.outputs);
    }

    @Override
    public int hashCode() {
        return Objects.hash(inputs, outputs);
    }
}
