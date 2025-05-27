package org.myshop.music;

import org.example.database.DatabaseConnection;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

public class ListenerAccountTest {
    @BeforeAll
    public static void connectToDatabase() throws SQLException {
        DatabaseConnection.connect("songs.db");
        ListenerAccount.Persistence.init();
    }

    @Test
    public void testRegister() throws SQLException {
        int register_id = ListenerAccount
                .Persistence.register("user1", "pass123");
        assertNotEquals(0, register_id);
    }
    @AfterAll
    public static void disconnectFromDatabase() {
        DatabaseConnection.disconnect();
    }
}

