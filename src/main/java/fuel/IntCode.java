package fuel;

public class IntCode {
    private final int[] intCodes;

    public IntCode(int... intCodes) {
        this.intCodes = intCodes;
    }

    public int[] execute() {
        executeFrom();
        return intCodes;
    }

    private void executeFrom() {
        int opCodeExecutionLocation = 0;
        while (true) {
            switch (intCodes[opCodeExecutionLocation]) {
                case 99:
                    return;
                case 1:
                    add(opCodeExecutionLocation);
                    break;
                case 2:
                    multiply(opCodeExecutionLocation);
                    break;

                default:
                    throw new RuntimeException("Int code exception");
            }
            opCodeExecutionLocation += 4;
        }

    }

    private void add(int opCodeExecutionLocation) {
        final int firstLocation = intCodes[opCodeExecutionLocation + 1];
        final int secondLocation = intCodes[opCodeExecutionLocation + 2];
        final int resultLocation = intCodes[opCodeExecutionLocation + 3];

        intCodes[resultLocation] = intCodes[firstLocation] + intCodes[secondLocation];
    }

    private void multiply(int opCodeExecutionLocation) {
        final int firstLocation = intCodes[opCodeExecutionLocation + 1];
        final int secondLocation = intCodes[opCodeExecutionLocation + 2];
        final int resultLocation = intCodes[opCodeExecutionLocation + 3];

        intCodes[resultLocation] = intCodes[firstLocation] * intCodes[secondLocation];
    }
}
