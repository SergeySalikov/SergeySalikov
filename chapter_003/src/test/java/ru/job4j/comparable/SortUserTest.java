package ru.job4j.comparable;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Test.
 *
 * @author Sergey Salikov (mailto:sseerrgey@gmail.com).
 * @version 1
 */
public class SortUserTest {
    /**
     * Test compareTo
     */
    @Test
    public void whenThisUserGreatUser() {
        SortUser sUser = new SortUser();
        User user1 = new User("Ivan", 56);
        User user2 = new User("Dima", 52);
        assertThat(user1.compareTo(user2), is(1));
    }
}
