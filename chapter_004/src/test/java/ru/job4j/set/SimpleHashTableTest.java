package ru.job4j.set;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class SimpleHashTableTest {
    private SimpleHashTable<Integer> hashInt;

    @Before
    public void setUp() {
        hashInt = new SimpleHashTable<>();
        for (int i = 0; i < 20; i++) {
            hashInt.add(i);
        }
    }
    @Test
    public void thenContains() {
       assertThat(hashInt.contains(0), is(true));
       assertThat(hashInt.contains(5), is(true));
       assertThat(hashInt.contains(8), is(true));
       assertThat(hashInt.contains(19), is(true));
       assertThat(hashInt.contains(21), is(false));
       assertThat(hashInt.contains(1123), is(false));
    }

    @Test
    public void thenRemove() {
        assertThat(hashInt.contains(10), is(true));
        assertThat(hashInt.remove(10), is(true));
        assertThat(hashInt.contains(10), is(false));
    }
}
