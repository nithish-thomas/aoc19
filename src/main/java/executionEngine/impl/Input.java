package executionEngine.impl;

import executionEngine.impl.error.InputInterrupted;
import executionEngine.impl.error.WaitingForInputException;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Input {
    private final BlockingQueue<Integer> inputQueue;

    public Input(int... inputs) {
        inputQueue = new ArrayBlockingQueue<>(inputs.length > 4 ? inputs.length : 4);

        for (int i = 0; i < inputs.length; i++) {
            inputQueue.add(inputs[i]);
        }

    }

    public Input(BlockingQueue<Integer> inputQueue) {
        this.inputQueue = inputQueue;
    }

    public int getInputs() {
        try {
            return inputQueue.take();
        } catch (InterruptedException e) {
            throw new InputInterrupted();
        }
    }

    public int getInputsWithException() {
        try {
            return inputQueue.remove();
        } catch (NullPointerException e) {
            throw new WaitingForInputException();
        }
    }
}
