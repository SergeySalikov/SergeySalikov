package ru.job4j.list;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class LoopTest {
    @Test
    public void whenIsLoopTrue() {
        Loop<Integer> loopInt = new Loop<>();
        Node<Integer> first = new Node<>(1);
        Node<Integer> two = new Node<>(2);
        Node<Integer> third = new Node<>(3);
        Node<Integer> four = new Node<>(4);
        first.next = two;
        two.next = third;
        third.next = four;
        four.next = two;
        boolean result = loopInt.hasLoop(first);
        assertThat(result, is(true));
    }

    @Test
    public void whenIsLoopFalse() {
        Loop<Integer> loopInt = new Loop<>();
        Node<Integer> first = new Node<>(1);
        Node<Integer> two = new Node<>(2);
        Node<Integer> third = new Node<>(3);
        Node<Integer> four = new Node<>(4);
        first.next = two;
        two.next = third;
        third.next = four;
        four.next = null;
        boolean result = loopInt.hasLoop(first);
        assertThat(result, is(false));
    }
}
