package executionEngine.prog;

import executionEngine.impl.IntCode;

public class FeedBackAmplifier {
    private static int NUM_OF_AMPLIFIERS = 5;

    private final IntCode amp[];

    public FeedBackAmplifier(int... program) {
        amp= new IntCode[NUM_OF_AMPLIFIERS];
        for (int i = 0; i < NUM_OF_AMPLIFIERS; i++) {
            amp[i]= new IntCode(program);
        }
    }


//    public long execute(int... phaseSettingForEachAmplifier){
//        final Input in0 = new Input(phaseSettingForEachAmplifier[0]);
//        final Output out0 = amp[0].execute(in0);
//        Input in1 = new Input(out0.getOutputQueue());
//        final Output out1 = amp[1].execute(in1);
//        Input in2 = new Input(out1.getOutputQueue());
//        final Output out2 = amp[2].execute(in2);
//        Input in3 = new Input(out2.getOutputQueue());
//        final Output out3 = amp[3].execute(in3);
//        Input in4 = new Input(out3.getOutputQueue());
//        final Output out4 = amp[4].execute(in4);
//        while (true) {
//            for (int i = 0; i < NUM_OF_AMPLIFIERS; i++) {
//                try {
//                    amp[i].execute(new Input(phaseSettingForEachAmplifier[i], outputSignalFromPrevAmplifier));
//                    outputSignalFromPrevAmplifier = getLast(amp[i].getOutputsAsList());
//                }catch (WaitingForInputException e){
//                    e.printStackTrace(System.err);
//                }
//            }
//            if(amp[NUM_OF_AMPLIFIERS-1].hasHalted()){
//                return getLast(amp[NUM_OF_AMPLIFIERS - 1].getOutputsAsList());
//            }
//        }
//    }


}
