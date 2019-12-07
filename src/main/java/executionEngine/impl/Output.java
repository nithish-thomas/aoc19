package executionEngine.impl;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Output {
    private BlockingQueue<Integer> outputs = new ArrayBlockingQueue<>(10);

    public Output() {
    }

    public BlockingQueue<Integer> getOutputs() {
        return outputs;
    }

    public void add(Integer output) {
        outputs.add(output);
    }
}