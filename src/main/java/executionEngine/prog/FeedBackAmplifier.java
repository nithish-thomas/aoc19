package executionEngine.prog;

import executionEngine.impl.Input;
import executionEngine.impl.IntCode;
import executionEngine.impl.Output;
import executionEngine.impl.error.WaitingForInputException;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import static executionEngine.IntCodeUtils.getLast;

public class FeedBackAmplifier {
    private static int NUM_OF_AMPLIFIERS = 5;

    private final IntCode amp[];

    public FeedBackAmplifier(int... program) {
        amp= new IntCode[NUM_OF_AMPLIFIERS];
        for (int i = 0; i < NUM_OF_AMPLIFIERS; i++) {
            amp[i]= new IntCode(program);
        }
    }

    public long execute(int... phaseSettingForEachAmplifier){
        final BlockingQueue<Integer> amp_A_B_Stream = new ArrayBlockingQueue<>(5);
        final BlockingQueue<Integer> amp_B_C_Stream = new ArrayBlockingQueue<>(5);
        final BlockingQueue<Integer> amp_C_D_Stream = new ArrayBlockingQueue<>(5);
        final BlockingQueue<Integer> amp_D_E_Stream = new ArrayBlockingQueue<>(5);
        final BlockingQueue<Integer> amp_E_A_Stream = new ArrayBlockingQueue<>(5);

        final Input inA = new Input(new int[]{phaseSettingForEachAmplifier[0],0}, amp_E_A_Stream);
        final Input inB = new Input(new int[]{phaseSettingForEachAmplifier[1]}, amp_A_B_Stream);
        final Input inC = new Input(new int[]{phaseSettingForEachAmplifier[2]}, amp_B_C_Stream);
        final Input inD = new Input(new int[]{phaseSettingForEachAmplifier[3]}, amp_C_D_Stream);
        final Input inE = new Input(new int[]{phaseSettingForEachAmplifier[4]}, amp_D_E_Stream);

        final Input[] inputs = {inA, inB, inC, inD, inE};

        final Output outA = new Output(amp_A_B_Stream);
        final Output outB = new Output(amp_B_C_Stream);
        final Output outC = new Output(amp_C_D_Stream);
        final Output outD = new Output(amp_D_E_Stream);
        final Output outE = new Output(amp_E_A_Stream);

        final Output[] outputs = {outA, outB,outC,outD,outE};

        while (true) {
            for (int i = 0; i < NUM_OF_AMPLIFIERS; i++) {
                try {
                    amp[i].execute(inputs[i],outputs[i]);
                }catch (WaitingForInputException e){
                    e.printStackTrace(System.err);
                }
            }
            if(amp[NUM_OF_AMPLIFIERS-1].hasHalted()){
                return getLast(amp[NUM_OF_AMPLIFIERS - 1].getOutputsAsList());
            }
        }
    }


}
