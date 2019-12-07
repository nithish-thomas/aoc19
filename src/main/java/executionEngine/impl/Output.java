package executionEngine.impl;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Output {
    private BlockingQueue<Integer> outputs = new ArrayBlockingQueue<>(10);

    public Output() {
    }

    public Output(BlockingQueue<Integer> outputs) {
        this.outputs = outputs;
    }

    public BlockingQueue<Integer> getOutputQueue() {
        return outputs;
    }

    public void add(Integer output) {
        outputs.add(output);
    }
}