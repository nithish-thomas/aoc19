package executionEngine.impl;

import executionEngine.impl.error.WaitingForInputException;

import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Input {
    private Queue<Integer> startInputs = new LinkedList<>();
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

    public Input(int[] startInputs, BlockingQueue<Integer> inputQueue) {
        for (int startInput: startInputs) {
            this.startInputs.add(startInput);
        }
        this.inputQueue = inputQueue;
    }

    public int getInputsWithException() {
        if(!startInputs.isEmpty()){
            return startInputs.remove();
        }
        try {
            return inputQueue.remove();
        } catch (NullPointerException | NoSuchElementException e) {
            throw new WaitingForInputException();
        }
    }
}