package executionEngine.prog.robo.repairBot;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DroidMapTest {
    @Test
    public void day15_1() {
        final DroidMap droidMap = new DroidMap(3, 1033, 1008, 1033, 1, 1032, 1005, 1032, 31, 1008, 1033, 2, 1032, 1005, 1032, 58, 1008, 1033, 3, 1032, 1005, 1032, 81, 1008, 1033, 4, 1032, 1005, 1032, 104, 99, 102, 1, 1034, 1039, 1002, 1036, 1, 1041, 1001, 1035, -1, 1040, 1008, 1038, 0, 1043, 102, -1, 1043, 1032, 1, 1037, 1032, 1042, 1105, 1, 124, 1001, 1034, 0, 1039, 101, 0, 1036, 1041, 1001, 1035, 1, 1040, 1008, 1038, 0, 1043, 1, 1037, 1038, 1042, 1106, 0, 124, 1001, 1034, -1, 1039, 1008, 1036, 0, 1041, 102, 1, 1035, 1040, 102, 1, 1038, 1043, 1002, 1037, 1, 1042, 1105, 1, 124, 1001, 1034, 1, 1039, 1008, 1036, 0, 1041, 102, 1, 1035, 1040, 1001, 1038, 0, 1043, 102, 1, 1037, 1042, 1006, 1039, 217, 1006, 1040, 217, 1008, 1039, 40, 1032, 1005, 1032, 217, 1008, 1040, 40, 1032, 1005, 1032, 217, 1008, 1039, 35, 1032, 1006, 1032, 165, 1008, 1040, 35, 1032, 1006, 1032, 165, 1102, 1, 2, 1044, 1105, 1, 224, 2, 1041, 1043, 1032, 1006, 1032, 179, 1101, 1, 0, 1044, 1105, 1, 224, 1, 1041, 1043, 1032, 1006, 1032, 217, 1, 1042, 1043, 1032, 1001, 1032, -1, 1032, 1002, 1032, 39, 1032, 1, 1032, 1039, 1032, 101, -1, 1032, 1032, 101, 252, 1032, 211, 1007, 0, 35, 1044, 1106, 0, 224, 1101, 0, 0, 1044, 1106, 0, 224, 1006, 1044, 247, 1002, 1039, 1, 1034, 102, 1, 1040, 1035, 101, 0, 1041, 1036, 1002, 1043, 1, 1038, 102, 1, 1042, 1037, 4, 1044, 1105, 1, 0, 34, 6, 31, 97, 12, 14, 91, 23, 87, 18, 20, 1, 13, 87, 28, 1, 58, 9, 38, 7, 70, 17, 30, 3, 32, 74, 76, 16, 2, 51, 30, 23, 8, 64, 24, 13, 52, 1, 13, 30, 55, 85, 89, 95, 16, 54, 7, 29, 81, 8, 81, 47, 99, 34, 92, 32, 48, 2, 10, 84, 5, 47, 85, 63, 21, 14, 87, 82, 23, 48, 64, 9, 29, 36, 4, 49, 72, 31, 12, 92, 27, 1, 23, 22, 59, 52, 9, 37, 65, 17, 18, 36, 99, 5, 14, 77, 75, 10, 65, 3, 42, 17, 10, 47, 73, 27, 57, 33, 5, 55, 46, 28, 21, 86, 3, 27, 74, 2, 88, 7, 87, 84, 34, 65, 29, 93, 66, 5, 20, 59, 3, 9, 48, 64, 34, 38, 13, 65, 16, 14, 86, 26, 55, 92, 4, 4, 43, 25, 48, 70, 18, 55, 66, 84, 2, 15, 29, 82, 9, 49, 11, 64, 20, 19, 41, 16, 85, 81, 24, 6, 68, 88, 73, 22, 32, 41, 32, 30, 68, 54, 95, 6, 12, 91, 6, 4, 41, 37, 3, 27, 87, 1, 7, 77, 31, 22, 45, 21, 84, 31, 84, 43, 23, 59, 6, 12, 69, 97, 17, 17, 17, 79, 5, 78, 61, 48, 20, 21, 87, 8, 64, 11, 99, 48, 9, 23, 99, 10, 50, 52, 18, 75, 9, 14, 17, 56, 43, 26, 15, 40, 63, 4, 23, 87, 81, 13, 30, 68, 76, 48, 34, 12, 4, 32, 98, 41, 16, 64, 34, 53, 8, 91, 57, 27, 25, 59, 93, 7, 5, 39, 9, 54, 21, 31, 5, 18, 78, 69, 29, 89, 3, 38, 15, 27, 98, 37, 12, 57, 1, 93, 44, 44, 9, 10, 6, 87, 29, 54, 67, 40, 20, 20, 98, 72, 3, 62, 23, 61, 76, 30, 58, 24, 21, 92, 47, 16, 34, 89, 27, 34, 83, 15, 85, 45, 1, 15, 52, 8, 52, 27, 20, 47, 78, 17, 41, 81, 29, 7, 50, 17, 81, 63, 36, 22, 18, 18, 1, 46, 34, 15, 58, 29, 83, 54, 34, 30, 84, 15, 21, 68, 55, 9, 17, 60, 48, 27, 16, 14, 81, 54, 12, 21, 52, 7, 33, 70, 85, 23, 10, 25, 70, 6, 13, 76, 39, 85, 59, 58, 22, 4, 33, 29, 17, 61, 80, 95, 29, 36, 33, 15, 76, 99, 32, 21, 47, 57, 18, 32, 70, 87, 89, 49, 81, 16, 86, 5, 61, 59, 16, 75, 15, 91, 22, 1, 14, 77, 7, 14, 90, 10, 45, 45, 10, 77, 34, 45, 39, 9, 92, 25, 63, 21, 16, 90, 51, 81, 9, 47, 5, 17, 13, 91, 25, 40, 32, 60, 32, 62, 71, 20, 22, 50, 69, 34, 44, 69, 23, 18, 81, 3, 29, 46, 30, 5, 10, 98, 31, 75, 25, 28, 49, 65, 32, 33, 20, 88, 18, 29, 74, 77, 14, 75, 17, 31, 25, 55, 29, 28, 49, 91, 27, 1, 14, 60, 12, 24, 88, 21, 16, 82, 74, 3, 59, 94, 44, 21, 66, 99, 5, 92, 42, 32, 71, 12, 43, 30, 77, 14, 2, 25, 68, 19, 74, 5, 47, 31, 79, 21, 33, 54, 68, 57, 68, 36, 11, 14, 42, 32, 32, 95, 55, 29, 10, 39, 64, 18, 26, 55, 10, 20, 58, 79, 44, 31, 41, 44, 52, 79, 15, 56, 14, 60, 2, 67, 24, 63, 46, 19, 52, 21, 48, 10, 22, 99, 4, 2, 58, 63, 21, 97, 14, 23, 94, 20, 47, 3, 38, 14, 56, 15, 3, 27, 53, 22, 31, 22, 91, 86, 28, 57, 44, 17, 82, 20, 93, 31, 3, 20, 92, 17, 1, 58, 99, 16, 8, 51, 26, 10, 12, 39, 59, 8, 7, 99, 5, 54, 34, 1, 85, 84, 74, 2, 53, 80, 89, 26, 77, 25, 23, 45, 7, 99, 10, 99, 30, 65, 13, 87, 94, 5, 21, 59, 32, 15, 93, 23, 99, 57, 9, 37, 9, 36, 94, 3, 93, 49, 95, 21, 26, 78, 13, 53, 20, 38, 21, 63, 22, 98, 65, 14, 73, 17, 82, 5, 69, 1, 95, 15, 40, 60, 18, 44, 33, 81, 6, 75, 73, 5, 34, 10, 19, 59, 64, 22, 20, 66, 4, 79, 28, 37, 28, 23, 26, 7, 95, 16, 98, 1, 93, 86, 8, 85, 4, 81, 19, 49, 63, 12, 78, 4, 26, 54, 21, 71, 14, 50, 29, 46, 38, 52, 22, 92, 94, 85, 22, 66, 75, 56, 21, 71, 70, 87, 6, 44, 9, 83, 20, 58, 29, 68, 26, 77, 36, 36, 13, 71, 15, 69, 5, 44, 0, 0, 21, 21, 1, 10, 1, 0, 0, 0, 0, 0, 0);
        final int steps = droidMap.nearestPathToOxygenSystem();
        System.out.println(steps);

        assertTrue(2147483647>steps);
        assertEquals(336, steps);
    }
}