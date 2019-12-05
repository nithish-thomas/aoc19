package fuel;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ModuleTest {
    @Test
    public void expectFuel2ForMassOf12() {
        assertEquals(2, new Module(12).fuelRequirement());
    }

    @Test
    public void expectFuel2ForMassOf14() {
        assertEquals(2, new Module(12).fuelRequirement());
    }

    @Test
    public void expectFuel966ForMassOf1969() {
        assertEquals(966, new Module(1969).fuelRequirement());
    }

    @Test
    public void expectFuel50346ForMassOf100756() {
        assertEquals(50346, new Module(100756).fuelRequirement());
    }
}