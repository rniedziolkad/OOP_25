package org.example.auth;

import org.example.database.DatabaseConnection;
import org.mindrot.jbcrypt.BCrypt;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AccountManager {
    private final DatabaseConnection db;

    public AccountManager(DatabaseConnection db) {
        this.db = db;
        prepareUserTable();
    }

    private void prepareUserTable() {
        try (Statement stmt = db.getConnection().createStatement()) {
            stmt.executeUpdate("""
                    CREATE TABLE IF NOT EXISTS users (
                        id INTEGER PRIMARY KEY AUTOINCREMENT,
                        username TEXT NOT NULL UNIQUE,
                        password TEXT NOT NULL
                    );
                    """);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void register(String username, String password) {
        String hashed = BCrypt.hashpw(password, BCrypt.gensalt());
        try {
            PreparedStatement stmt = db.getConnection().prepareStatement("""
                    INSERT INTO users (username, password) VALUES (?, ?)
                    """);
            stmt.setString(1, username);
            stmt.setString(2, hashed);
            stmt.executeUpdate();

            stmt.closeOnCompletion();
        } catch (SQLException e) {
            System.err.println("Nie udało się zarejestrować: "+e.getMessage());
        }
    }

    public boolean authenticate(String username, String password) {
        try {
            PreparedStatement stmt = db.getConnection().prepareStatement("""
                    SELECT password FROM users WHERE username = ?;
                    """);
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                String hashed = rs.getString("password");
                return BCrypt.checkpw(password, hashed);
            }
        } catch (SQLException e) {
            System.err.println("Błąd uwierzytelniania "+e.getMessage());
        }

        return false;
    }


}
