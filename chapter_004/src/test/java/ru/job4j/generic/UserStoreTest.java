package ru.job4j.generic;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;


public class UserStoreTest {
    UserStore userStore;

    @Before
    public void setUp() {
        userStore = new UserStore(3);
    }

    @Test
    public void whenFindByIdUser() {
        User user1 = new User("10");
        User user2 = new User("20");
        User user3 = new User("30");
        userStore.add(user1);
        userStore.add(user2);
        userStore.add(user3);
        assertThat(userStore.findById("10"), is(user1));
        assertThat(userStore.findById("20"), is(user2));
        assertThat(userStore.findById("30"), is(user3));
    }

    @Test
    public void whenDeleteUser() {
        User user1 = new User("10");
        User user2 = new User("20");
        User user3 = new User("30");
        userStore.add(user1);
        userStore.add(user2);
        userStore.add(user3);
        boolean resultTrue = userStore.delete("30");
        assertThat(resultTrue, is(true));
        boolean resultFalse = userStore.delete("11");
        assertThat(resultFalse, is(false));
    }

    @Test
    public void whenReplaceUser() {
        User user1 = new User("10");
        User user2 = new User("20");
        User user3 = new User("30");
        userStore.add(user1);
        userStore.add(user2);
        userStore.add(user3);
        boolean resultFalse = userStore.replace("31", new User("30"));
        assertThat(resultFalse, is(false));
        boolean resultTrue = userStore.replace("30", new User("31"));
        assertThat(resultTrue, is(true));

    }
}
