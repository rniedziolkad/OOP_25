package org.myshop.music;

import java.util.ArrayList;

public class Playlist extends ArrayList<Song> {
    public Song atSecond(int seconds) {
        if (seconds < 0) {
            throw new IndexOutOfBoundsException("Czas nie może być ujemny: "+seconds);
        }

        int timeLeft = seconds;
        for(Song s: this) {
            if (s.duration() > timeLeft) {
                return s;
            } else {
                timeLeft -= s.duration();
            }
        }

        throw new IndexOutOfBoundsException("Playlista jest krótsza niż "+seconds+ " sekund");
    }
}
