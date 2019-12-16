package executionEngine.impl;

import java.util.LinkedList;

public class Output {
    private LinkedList<Long> outputs;

    public Output() {
        outputs = new LinkedList<>();
    }

    public Output(LinkedList<Long> outputs) {
        this.outputs = outputs;
    }

    public LinkedList<Long> getOutputQueue() {
        return outputs;
    }

    public void add(Long output) {
        outputs.add(output);
    }
}