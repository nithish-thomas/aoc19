package executionEngine.impl;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Output {
    private BlockingQueue<Long> outputs = new ArrayBlockingQueue<>(200);

    public Output() {
    }

    public Output(BlockingQueue<Long> outputs) {
        this.outputs = outputs;
    }

    public BlockingQueue<Long> getOutputQueue() {
        return outputs;
    }

    public void add(Long output) {
        outputs.add(output);
    }
}