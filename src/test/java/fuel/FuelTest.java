package fuel;

import org.junit.Test;

import static org.junit.Assert.*;

public class FuelTest {
    @Test
    public void expectActualFuelForFuelOf2ToBe2() {
        assertEquals(2, new Fuel(2).actualFuelRequirement());

    }

    @Test
    public void expectActualFuelForFuelOf654ToBe966() {
        assertEquals(966, new Fuel(654).actualFuelRequirement());
    }
}