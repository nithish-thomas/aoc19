package orbital;

import org.junit.Test;

import static org.junit.Assert.*;

public class OrbitalMapTest {
    @Test
    public void shoulParseMap() {
        final Planet COM = OrbitalMap.parse("COM)B\n" +
          "B)C\n" +
          "C)D\n" +
          "D)E\n" +
          "E)F\n" +
          "B)G\n" +
          "G)H\n" +
          "D)I\n" +
          "E)J\n" +
          "J)K\n" +
          "K)L");


    }
}