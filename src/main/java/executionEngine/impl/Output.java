package executionEngine.impl;

import java.util.LinkedList;
import java.util.Queue;

public class Output {
    private Queue<Long> outputs;

    public Output() {
        outputs = new LinkedList<>();
    }

    public Output(Queue<Long> outputs) {
        this.outputs = outputs;
    }

    public Queue<Long> getOutputQueue() {
        return outputs;
    }

    public void add(Long output) {
        outputs.add(output);
    }
}