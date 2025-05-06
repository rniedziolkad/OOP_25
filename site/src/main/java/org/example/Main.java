package org.example;

import org.example.auth.AccountManager;
import org.example.database.DatabaseConnection;

public class Main {
    public static void main(String[] args) {
        DatabaseConnection db = new DatabaseConnection();
        db.connect("site.db");

        AccountManager am = new AccountManager(db);
        am.register("user1", "password123");
        am.register("user2", "qwerty");
        System.out.println("Uwierzytelnianie: " + am.authenticate("user2", "qwerty"));

        db.disconnect();
    }
}