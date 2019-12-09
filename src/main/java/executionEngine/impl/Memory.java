//package executionEngine.impl;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.Map;
//
//public class Memory {
//    private Map<Integer, Integer> memory = new HashMap<>();
//
//    public static Memory create(int[] program) {
//        final Memory memory = new Memory();
//        for (int i = 0; i < program.length; i++) {
//            memory.setValueAt(i, program[i]);
//        }
//        return memory;
//    }
//
//    public long getValueAt(int i) {
//        return memory.get(Long.valueOf(i));
//    }
//
//    public void setValueAt(int i, int value) {
//        memory.put(Long.valueOf(i), Long.valueOf(value));
//    }
//
//    public int[] getAsArray(){
//        final ArrayList<Integer> integers = new ArrayList<>();
//        for (Map.Entry<Long,Long> entry: memory.entrySet()) {
//            integers.add(entry.getKey(), entry.getValue());
//        }
//        return
//    }
//}
