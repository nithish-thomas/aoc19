package fft;

import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.assertEquals;

public class BasePatternIteratorTest {

    @Test
    public void shouldReturnForLevel1() {
        final Iterator<Integer> iteratorForLevel1 = new BasePatternIterator(1);
        assertEquals(Integer.valueOf(0), iteratorForLevel1.next());
        assertEquals(Integer.valueOf(1), iteratorForLevel1.next());
        assertEquals(Integer.valueOf(0), iteratorForLevel1.next());
        assertEquals(Integer.valueOf(-1), iteratorForLevel1.next());
        assertEquals(Integer.valueOf(0), iteratorForLevel1.next());
        assertEquals(Integer.valueOf(1), iteratorForLevel1.next());
        assertEquals(Integer.valueOf(0), iteratorForLevel1.next());
    }
    @Test
    public void shouldReturnForLevel2() {
        final Iterator<Integer> iteratorForLevel1 = new BasePatternIterator(2);
        assertEquals(Integer.valueOf(0), iteratorForLevel1.next());
        assertEquals(Integer.valueOf(0), iteratorForLevel1.next());
        assertEquals(Integer.valueOf(1), iteratorForLevel1.next());
        assertEquals(Integer.valueOf(1), iteratorForLevel1.next());
        assertEquals(Integer.valueOf(0), iteratorForLevel1.next());
        assertEquals(Integer.valueOf(0), iteratorForLevel1.next());
        assertEquals(Integer.valueOf(-1), iteratorForLevel1.next());
        assertEquals(Integer.valueOf(-1), iteratorForLevel1.next());
        assertEquals(Integer.valueOf(0), iteratorForLevel1.next());
        assertEquals(Integer.valueOf(0), iteratorForLevel1.next());
        assertEquals(Integer.valueOf(1), iteratorForLevel1.next());
        assertEquals(Integer.valueOf(1), iteratorForLevel1.next());
        assertEquals(Integer.valueOf(0), iteratorForLevel1.next());
        assertEquals(Integer.valueOf(0), iteratorForLevel1.next());
    }

}