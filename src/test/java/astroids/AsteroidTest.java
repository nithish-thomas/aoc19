package astroids;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AsteroidTest {
    @Test
    public void expectSlopeToBe45() {
        final Asteroid a1 = new Asteroid(1, 1);
        final Asteroid a2 = new Asteroid(2, 2);

        assertEquals(45, a1.slope(a2),0.0001);
    }
}