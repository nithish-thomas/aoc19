package executionEngine.impl;

import executionEngine.impl.error.WaitingForInputException;

import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class Input {
    private Queue<Long> startInputs = new LinkedList<>();
    private final Queue<Long> inputQueue;

    public Input(long... inputs) {
        inputQueue = new ArrayBlockingQueue<>(inputs.length > 4 ? inputs.length : 4);

        for (int i = 0; i < inputs.length; i++) {
            inputQueue.add(inputs[i]);
        }

    }

    public Input(Queue<Long> inputQueue) {
        this.inputQueue = inputQueue;
    }

    public Input(long[] startInputs, Queue<Long> inputQueue) {
        for (long startInput: startInputs) {
            this.startInputs.add(startInput);
        }
        this.inputQueue = inputQueue;
    }

    public long getInputsWithException() {
        if(!startInputs.isEmpty()){
            return startInputs.remove();
        }
        if(inputQueue.isEmpty()){
            throw new WaitingForInputException();
        }
        try {
            return inputQueue.remove();
        } catch (NullPointerException | NoSuchElementException e) {
            throw new WaitingForInputException();
        }
    }
}
