package ru.job4j.map;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Before;

public class SimpleMapTest {
    private SimpleMap<String, String> map;

    @Before
    public void setUp() {
        map = new SimpleMap<>();
        String str1 = "aaa";
        String str2 = "bbb";
        String str3 = "ccc";
        String str4 = "ddd";
        map.insert("1sddd", str1);
        map.insert("2ad", str2);
        map.insert("3aad", str3);
        map.insert("4aas", str4);

    }

    @Test
    public void thenGet() {
        String result = map.get("2ad");
        assertThat(result, is("bbb"));
        result = map.get("4aas");
        assertThat(result, is("ddd"));
    }

    @Test
    public void thenDelete() {
        boolean result = map.delete("4aad");
        assertThat(result, is(true));
        result = map.delete("4aad");
        assertThat(result, is(false));
    }
}

