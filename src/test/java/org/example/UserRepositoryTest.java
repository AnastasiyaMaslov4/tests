package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserRepositoryTest {

    private UserRepository repo;
    @BeforeEach
    void setUp() {
        this.repo = new UserRepository();
    }

    @AfterEach
    void tearDown() {
        repo = null;
    }

    @Test
    @DisplayName("Добавление пользователя")
    void addUser() {
        User user1 = new User("UsualUser", "123456", false);
        repo.addUser(user1);
        assertTrue(repo.findByName("UsualUser"));
    }

    @Test
    @DisplayName("Разлогинить обычного пользователя")
    void unloginUsersUsual() {
        User user2 = new User("UsualUser2", "00000", false);
        repo.addUser(user2);
        user2.isAuthenticate = true;
        repo.unloginUsers();
        assertFalse(user2.isAuthenticate);
    }

    @Test
    @DisplayName("Разлогинить админа")
    void unloginUsersAdmin() {
        User user3 = new User("UsualUser3", "00000", true);
        repo.addUser(user3);
        user3.isAuthenticate = true;
        repo.unloginUsers();
        assertTrue(user3.isAuthenticate);
    }
}