package prj5;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import student.TestCase;

// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Brock Morgan (brockmorgan)
/**
 * Tests the methods of the MusicCalculator class
 * 
 * @author <Brock Morgan> <brockmorgan>
 * @version <4/16/2019>
 */
public class MusicCalculatorTest extends TestCase {
    private MusicCalculator mc;


    /**
     * Sets up each test method.
     */
    public void setUp() {
        String[] preferences1;

        DList<Song> songs = new DList<Song>();
        ArrayList<Student> students = new ArrayList<Student>();
        songs.add(new Song("Enter Sandman", "Metallica", 1991, "rock", 0));
        songs.add(new Song("Sandstorm", "Darude", 2000, "EDM", 1));
        songs.add(new Song("Gangsta's Paradise", "Coolio", 1995, "R&B", 2));
        songs.add(new Song("Boot Scootin' Boogie", "Brooks and Dunn", 1991,
            "country", 3));
        songs.add(new Song("Firework", "Katy Perry", 2011, "pop", 4));
        songs.add(new Song("a", "Katy Perry", 2011, "pop", 4));
        songs.add(new Song("a", "Katy Perry", 2011, "pop", 4));
        songs.add(new Song("a", "Katy Perry", 2011, "pop", 4));
        songs.add(new Song("a", "Katy Perry", 2011, "pop", 4));
        songs.add(new Song("a", "Katy Perry", 2011, "pop", 4));

        preferences1 = new String[10];

        preferences1[0] = "none";
        preferences1[1] = "good";
        preferences1[2] = "yes";
        preferences1[3] = "no";
        preferences1[4] = "";
        preferences1[5] = "yes";
        preferences1[6] = "no";
        preferences1[7] = "";
        preferences1[8] = "no";
        preferences1[9] = "yes";

        students.add(new Student("Engineering", "SouthWestUS", "music",
            preferences1));
        students.add(new Student("Engineering", "SouthWestUS", "music",
            preferences1));
        students.add(new Student("CMDA", "SouthWestUS", "Music", preferences1));
        students.add(new Student("Engineering", "NorthWestUS", "music",
            preferences1));
        students.add(new Student("Engineering", "SouthWestUS", "reading",
            preferences1));
        students.add(new Student("Engineering", "SouthWestUS", "art",
            preferences1));
        students.add(new Student("Engineering", "SouthWestUS", "reading",
            preferences1));
        students.add(new Student("Engineering", "SouthWestUS", "sports",
            preferences1));
        students.add(new Student("Engineering", "SouthWestUS", "music",
            preferences1));
        students.add(new Student("Engineering", "SouthWestUS", "sports",
            preferences1));
        students.add(new Student("Engineering", "SouthWestUS", "reading",
            preferences1));
        students.add(new Student("Engineering", "SouthWestUS", "art",
            preferences1));
        students.add(new Student("Engineering", "SouthWestUS", "other",
            preferences1));
        students.add(new Student("Engineering", "SouthWestUS", "other",
            preferences1));

        mc = new MusicCalculator(students, songs);

    }


    /**
     * tests the songHobbies() method
     */
    public void testSongHobbies() {

        Exception e = null;
        try {
            new MusicCalculator(null, null);
        }
        catch (Exception exception) {
            e = exception;
        }
        assertTrue(e instanceof IllegalArgumentException);
    }


    /**
     * tests sorting by year
     */
    public void testSortByYear() {
        mc.sort("year");

        DList<Song> s2 = mc.getSongs();

        assertEquals(s2.get(0), new Song("Enter Sandman", "Metallica", 1991,
            "rock", 0));
        assertEquals(s2.get(1), new Song("Boot Scootin' Boogie",
            "Brooks and Dunn", 1991, "country", 3));
        assertEquals(s2.get(2), new Song("Gangsta's Paradise", "Coolio", 1995,
            "R&B", 2));
        assertEquals(s2.get(3), new Song("Sandstorm", "Darude", 2000, "EDM",
            1));
        assertEquals(s2.get(4), new Song("Firework", "Katy Perry", 2011, "pop",
            4));
    }


    /**
     * tests sorting by genre
     */
    public void testSortByGenre() {
        mc.sort("genre");

        DList<Song> s2 = mc.getSongs();
        assertEquals(s2.get(2), new Song("Boot Scootin' Boogie",
            "Brooks and Dunn", 1991, "country", 3));
        assertEquals(s2.get(3), new Song("Firework", "Katy Perry", 2011, "pop",
            4));

    }


    /**
     * tests sorting by genre
     */
    public void testSortByArtist() {
        mc.sort("artist");

        DList<Song> s2 = mc.getSongs();

        assertEquals(s2.get(0), new Song("Boot Scootin' Boogie",
            "Brooks and Dunn", 1991, "country", 3));
        assertEquals(s2.get(1), new Song("Gangsta's Paradise", "Coolio", 1995,
            "R&B", 2));
        assertEquals(s2.get(2), new Song("Sandstorm", "Darude", 2000, "EDM",
            1));
        assertEquals(s2.get(3), new Song("Firework", "Katy Perry", 2011, "pop",
            4));
    }


    /**
     * tests sorting by genre
     */
    public void testSortByTitle() {
        mc.sort("title");

        DList<Song> s2 = mc.getSongs();

        assertEquals(s2.get(0), new Song("Boot Scootin' Boogie",
            "Brooks and Dunn", 1991, "country", 3));
        assertEquals(s2.get(1), new Song("Enter Sandman", "Metallica", 1991,
            "rock", 0));
        assertEquals(s2.get(2), new Song("Firework", "Katy Perry", 2011, "pop",
            4));
        assertEquals(s2.get(3), new Song("Gangsta's Paradise", "Coolio", 1995,
            "R&B", 2));
        assertEquals(s2.get(4), new Song("Sandstorm", "Darude", 2000, "EDM",
            1));
    }


    /**
     * tests the music calculator with the music reader
     * 
     * @throws FileNotFoundException
     *             if the file is not found
     */
    public void testWithMusicReader() throws FileNotFoundException {
        new MusicReader("MusicSurveyDataTest2.csv", "SongListTest2.csv");

        Exception e = null;
        try {
            new MusicCalculator(null, null);
        }
        catch (Exception exception) {
            e = exception;
        }
        assertTrue(e instanceof IllegalArgumentException);
    }

    /**
     * 
     */
}
