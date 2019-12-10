package executionEngine.impl;

import java.util.*;
import java.util.stream.Collectors;

public class Memory {
    private Map<Long, Long> memory = new HashMap<>();

    public static Memory create(long[] program) {
        final Memory memory = new Memory();
        for (int i = 0; i < program.length; i++) {
            memory.setValueAt(i, program[i]);
        }
        return memory;
    }

    public long getValueAt(long i) {
        return memory.getOrDefault(i,0L);
    }

    public void setValueAt(long i, long value) {
        memory.put(i, value);
    }

    public long[] getAsArray(){
        final OptionalLong maxValue = memory.keySet()
          .stream()
          .mapToLong(Long::longValue)
          .max();

        final long asLong = maxValue.getAsLong()+1;
        long res[] = new long[(int) asLong];

        for (Map.Entry<Long, Long> entry: memory.entrySet()) {
            res[Math.toIntExact(entry.getKey())] = entry.getValue();
        }
        return res;
    }

    @Override
    public String toString() {
        final List<Map.Entry<Long, Long>> sortedList = memory.entrySet().stream()
          .sorted(Comparator.comparingLong(Map.Entry::getKey))
          .collect(Collectors.toList());
        return "Memory{" +
          "memory=" + sortedList +
          '}';
    }
}
