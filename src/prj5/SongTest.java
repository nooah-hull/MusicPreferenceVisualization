package prj5;

import student.TestCase;

// * // Virginia Tech Honor Code Pledge:
// * //
// * // As a Hokie, I will conduct myself with honor and integrity at all times.
// * // I will not lie, cheat, or steal, nor will I accept the actions of those
// * who
// * // do.
// * // -- Brock Morgan (brockmorgan)

/**
 * Tests the methods of the Song class
 *
 * @author <Brock Morgan> <brockmorgan>
 * 
 * @version <4/9/2019>
 */
public class SongTest extends TestCase {
    private Song song;
    private Song song2;
    private Song song3;
    private Song song4;
    private Song song5;
    private Song song6;
    private Song song7;


    /**
     * sets up the tests
     */
    public void setUp() {
        song = new Song("Enter Sandman", "Metallica", 1991, "Rock", 0);
        song2 = new Song("Sandstorm", "Darude", 2005, "EDM", 1);
        song3 = new Song("Sandstormdif", "Darude", 2005, "EDM", 1);
        song4 = new Song("Sandstorm", "Darude1", 2005, "EDM", 1);
        song5 = new Song("Sandstorm", "Darude", 2002, "EDM", 1);
        song6 = new Song("Sandstorm", "Darude", 2005, "Rock", 1);
        song7 = new Song("Sandstorm", "Darude", 2005, "EDM", 0);

    }


    /**
     * tests the getters
     */
    public void testGetters() {
        assertEquals("Enter Sandman", song.getSong());
        assertEquals("Metallica", song.getArtist());
        assertEquals(1991, song.getYear());
        assertEquals("Rock", song.getGenre());
        assertEquals(0, song.getIndex());
    }


    /**
     * tests the toString method
     */
    public void testToString() {
        assertEquals("Song Title: Enter Sandman\r\n"
            + "Song Artist: Metallica\r\n" + "Song Genre: Rock\r\n"
            + "Song Year: 1991", song.toString());
    }


    /**
     * tests the equals method
     */
    public void testEquals() {
        assertEquals(song, song);
        Object nullObject = null;
        assertFalse(song.equals(nullObject));
        assertFalse(song.equals(new Song("Sandstorm", "Darude", 2005, "EDM",
            1)));
        assertEquals(song, new Song("Enter Sandman", "Metallica", 1991, "Rock",
            0));
        assertFalse(song2.equals(song3));
        assertFalse(song2.equals(song4));

        assertFalse(song2.equals(song5));

        assertFalse(song2.equals(song6));

        assertFalse(song2.equals(song7));

        String doggie = "dog";

        assertFalse(song2.equals(doggie));

        Song tempSong1 = new Song("one", "two", 1, "three", 2);
        Song tempSong2 = new Song("one", "two", 2, "three", 2);

        assertFalse(tempSong1.equals(tempSong2));
    }


    /**
     * tests the compareTo method
     */
    public void testCompareTo() {

        assertEquals(-14, song.compareTo(song2, "year"));
        assertEquals(14, song2.compareTo(song, "year"));
        assertEquals(0, song.compareTo(song, "year"));

        assertEquals(13, song.compareTo(song2, "genre"));
        assertEquals(9, song.compareTo(song2, "artist"));
        assertEquals(-14, song.compareTo(song2, "title"));
    }
}
