package org.example;

import org.example.database.DatabaseConnection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        DatabaseConnection db = new DatabaseConnection();
        db.connect("site.db");
        try (Statement stmt = db.getConnection().createStatement()) {
            stmt.executeUpdate("""
                    CREATE TABLE IF NOT EXISTS test (
                        id INTEGER PRIMARY KEY AUTOINCREMENT,
                        value TEXT NOT NULL
                    );
                    """);

            stmt.executeUpdate("""
                    DELETE FROM test;
                    """);
            stmt.executeUpdate("""
                    INSERT INTO test (value) VALUES
                    ('wartosc1'),
                    ('wartosc2')
                    """);

            ResultSet rs = stmt.executeQuery("""
                    SELECT * FROM test
                    """);
            while (rs.next()) {
                System.out.println(rs.getInt(1) + ": "+ rs.getString("value"));
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        db.disconnect();

    }
}