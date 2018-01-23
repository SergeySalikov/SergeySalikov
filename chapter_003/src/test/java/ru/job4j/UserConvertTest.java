package ru.job4j;


import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 *
 * @author Sergey Salikov (mailto:sseerrgey@gmail.com).
 * @version 1
 */
public class UserConvertTest {
    /**
     * Test process.
     */
    @Test
    public void whenListWithUserThenHashMap() {
        UserConvert userConv = new UserConvert();
        List<User> list = new ArrayList<>();
        User user1 = new User(1, "Ivan", "Saratov");
        User user2 = new User(2, "Bob", "NY");
        User user3 = new User(3, "Vova", "Ufa");
        list.add(user1);
        list.add(user2);
        list.add(user3);
        HashMap<Integer, User> mapUser = userConv.process(list);
        String result = mapUser.get(2).name;
        String expected = "Bob";
        assertThat(result, is(expected));
    }
}
