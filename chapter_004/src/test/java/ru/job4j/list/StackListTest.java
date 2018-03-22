package ru.job4j.list;

        import org.junit.Test;


        import static org.hamcrest.MatcherAssert.assertThat;
        import static org.hamcrest.Matchers.is;


public class StackListTest {
    @Test
    public void whenPushAndPoll() {
        StackList<Integer> stack = new StackList<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        assertThat(stack.poll(), is(3));
        assertThat(stack.poll(), is(2));
        assertThat(stack.poll(), is(1));
    }
}
