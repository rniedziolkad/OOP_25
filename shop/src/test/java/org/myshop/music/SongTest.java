package org.myshop.music;

import org.example.database.DatabaseConnection;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.sql.SQLException;
import java.util.Optional;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class SongTest {
    @BeforeAll
    public static void connectToDatabase() {
        DatabaseConnection.connect("songs.db");
    }

    @Test
    public void testReadValidIndexReturnsSong() throws SQLException {
        Optional<Song> result = Song.Persistence.read(7);
        assertTrue(result.isPresent());

        Song song = result.get();
        assertEquals("The Doors", song.artist());
        assertEquals("Light My Fire", song.title());
        assertEquals(426, song.duration());
    }

    @Test
    public void testReadInvalidIndexReturnsEmpty() throws SQLException {
        Optional<Song> result = Song.Persistence.read(50);
        assertTrue(result.isEmpty());
    }

    @ParameterizedTest
    @MethodSource("provideTestSongs")
    public void testReadSongByIndex(int index, Song expected) throws SQLException {
        Optional<Song> result = Song.Persistence.read(index);
        assertTrue(result.isPresent());

        Song song = result.get();
        assertEquals(expected, song);
    }
    @ParameterizedTest
    @CsvFileSource(resources = "/songs.csv", numLinesToSkip = 1)
    public void testReadSongByIndex(int index, String artists, String title, int duration) throws SQLException {
        Optional<Song> result = Song.Persistence.read(index);
        assertTrue(result.isPresent());

        Song song = result.get();
        assertEquals(artists, song.artist());
        assertEquals(title, song.title());
        assertEquals(duration, song.duration());
    }

    private static Stream<Arguments> provideTestSongs() {
        return Stream.of(
                Arguments.of(1,
                        new Song("The Beatles", "Hey Jude", 431)),
                Arguments.of(46,
                        new Song("Marvin Gaye", "What's Going On", 233)),
                Arguments.of(47,
                        new Song("The Doors", "Riders on the Storm", 434))
        );
    }

    @AfterAll
    public static void disconnectFromDatabase() {
        DatabaseConnection.disconnect();
    }
}
