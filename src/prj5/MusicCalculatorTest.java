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
     * Tests the songHobbies() method
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
     * Tests sorting by year
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
     * Tests sorting by genre
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
     * Tests sorting by artist
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
     * Tests sorting by title
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
     * Tests the music calculators getPercents method with major
     * 
     * @throws FileNotFoundException
     *             if file not found
     */
    public void testGetPercentsMajor() throws FileNotFoundException {
        MusicReader mr = new MusicReader("MusicSurveyDataTest2.csv",
            "SongListTest2.csv");
        mc = new MusicCalculator(mr.getStudents(), mr.getSongs());
        int[] x = mc.getPercents(mc.getSongs().get(0), "Major");
        int[] testMajor = new int[8];
        testMajor[0] = 33;
        testMajor[1] = 0;
        testMajor[2] = 33;
        testMajor[3] = 0;
        testMajor[4] = 66;
        testMajor[5] = 0;
        testMajor[6] = 33;
        testMajor[7] = 0;
        for (int i = 0; i < 8; i++) {
            assertEquals(testMajor[i], x[i]);
        }
    }


    /**
     * Tests the music calculator getPercents method with region
     * 
     * @throws FileNotFoundException
     *             if file not found
     */
    public void testGetPercentsRegion() throws FileNotFoundException {
        MusicReader mr = new MusicReader("MusicSurveyDataTest2.csv",
            "SongListTest2.csv");
        mc = new MusicCalculator(mr.getStudents(), mr.getSongs());
        int[] x = mc.getPercents(mc.getSongs().get(0), "Region");
        int[] testRegion = new int[8];
        testRegion[1] = 33;
        testRegion[5] = 50;
        for (int i = 0; i < 8; i++) {
            assertEquals(testRegion[i], x[i]);
        }
    }


    /**
     * Tests the music calculator getPercents method with hobby
     * 
     * @throws FileNotFoundException
     *             if file not found
     */
    public void testGetPercentsHobby() throws FileNotFoundException {
        MusicReader mr = new MusicReader("MusicSurveyDataTest2.csv",
            "SongListTest2.csv");
        mc = new MusicCalculator(mr.getStudents(), mr.getSongs());
        int[] x = mc.getPercents(mc.getSongs().get(0), "Hobby");
        int[] testHobby = new int[8];
        testHobby[0] = 0;
        testHobby[2] = 50;
        testHobby[3] = 0;
        testHobby[4] = 0;
        testHobby[6] = 50;
        testHobby[7] = 100;
        for (int i = 0; i < 8; i++) {
            assertEquals(testHobby[i], x[i]);
        }
    }


    /**
     * Tests the getPercents when it should be whack
     */
    public void testGetPercentsWhack() {
        int[] x = mc.getPercents(mc.getSongs().get(0), "daddy barnette");
        for (int i = 0; i < 8; i++) {
            assertEquals(0, x[i]);
        }
    }


    /**
     * Tests the getPercents using created students and preferences
     * 
     * @throws FileNotFoundException
     *             if file not found
     */
    public void testGetPercentsMore() throws FileNotFoundException {
        String[] preferences1 = new String[2];
        String[] preferences2 = new String[2];
        String[] preferences3 = new String[3];
        String[] preferences4 = new String[4];
        String[] preferences5 = new String[5];

        preferences1[0] = "yes";
        preferences1[1] = "yes";

        preferences2[0] = "yes";
        preferences2[1] = "no";

        preferences3[0] = "no";
        preferences3[1] = "yes";

        preferences4[0] = "no";
        preferences4[1] = "no";

        preferences5[0] = "";
        preferences5[1] = "";

        Student one = new Student("Other Engineering", "Southwest", "art",
            preferences1);
        Student two = new Student("Other",
            "United States (other than Southeast or Northwest)", "sports",
            preferences2);
        Student three = new Student("Math or CMDA", "Outside of United States",
            "art", preferences3);
        Student four = new Student("Computer Science",
            "Outside of United States", "sports", preferences4);
        Student five = new Student("Math or CMDA", "Southwest", "music",
            preferences5);

        ArrayList<Student> testStudents = new ArrayList<Student>();
        testStudents.add(one);
        testStudents.add(two);
        testStudents.add(three);
        testStudents.add(four);
        testStudents.add(five);
        MusicReader mr = new MusicReader("MusicSurveyDataTest2.csv",
            "SongListTest2.csv");
        mc = new MusicCalculator(testStudents, mr.getSongs());

        int[] test1 = new int[8];
        int[] test2 = new int[8];
        int[] test3 = new int[8];

        test1[1] = 50;
        test2[1] = 100;

        test1[2] = 50;
        test3[2] = 100;

        test2[3] = 100;
        test3[3] = 33;

        test1[5] = 100;
        test2[5] = 100;

        test2[6] = 100;

        test3[7] = 66;

        int[] x = mc.getPercents(mc.getSongs().get(0), "Hobby");
        int[] y = mc.getPercents(mc.getSongs().get(0), "Major");
        int[] z = mc.getPercents(mc.getSongs().get(0), "Region");

        for (int i = 0; i < 8; i++) {
            assertEquals(x[i], test1[i]);
            assertEquals(y[i], test2[i]);
            assertEquals(z[i], test3[i]);
        }
    }


    /**
     * <<<<<<< HEAD
     * tests getPercents when there are blanks in the survey data
     * 
     * @throws FileNotFoundException
     *             if file not found
     */
    public void testGetPercentsBlanks() throws FileNotFoundException {
        MusicReader mr = new MusicReader("MusicSurveyDataTest1.csv",
            "SongListTest1.csv");
        mc = new MusicCalculator(mr.getStudents(), mr.getSongs());

        int[] test1 = new int[8];
        int[] test2 = new int[8];
        int[] test3 = new int[8];

        int[] x = mc.getPercents(mc.getSongs().get(3), "Hobby");
        int[] y = mc.getPercents(mc.getSongs().get(3), "Major");
        int[] z = mc.getPercents(mc.getSongs().get(3), "Region");

        test2[4] = 50;

        test3[5] = 20;

        test1[7] = 100;

        for (int i = 0; i < 8; i++) {
            System.out.println(i);
            System.out.println(x[i]);
            assertEquals(x[i], test1[i]);
            System.out.println(y[i]);
            assertEquals(y[i], test2[i]);
            System.out.println(z[i]);
            assertEquals(z[i], test3[i]);
        }
    }


    /**
     * tests casefinder 0
     * =======
     * Tests caseFinder 0
     * >>>>>>> branch 'master' of
     * https://github.com/nooah-hull/MusicPreferenceVisualization.git
     */
    public void testCaseFinder0() {
        assertEquals(0, mc.caseFinder("hello my dude"));
    }


    /**
     * Tests the music calculator with the music reader
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
     * Tests the caseFinder Method
     * 
     */
    public void testCaseFinder() {
        assertEquals(mc.caseFinder(HobbyEnum.READ), 1);
        assertEquals(mc.caseFinder(HobbyEnum.ART), 2);
        assertEquals(mc.caseFinder(HobbyEnum.SPORTS), 3);
        assertEquals(mc.caseFinder(HobbyEnum.MUSIC), 4);

        assertEquals(mc.caseFinder(MajorEnum.COMPUTERSCIENCE), 1);
        assertEquals(mc.caseFinder(MajorEnum.OTHERENGINEERING), 2);
        assertEquals(mc.caseFinder(MajorEnum.MATH), 3);
        assertEquals(mc.caseFinder(MajorEnum.OTHER), 4);

        assertEquals(mc.caseFinder(StateEnum.NORTHEASTUS), 1);
        assertEquals(mc.caseFinder(StateEnum.SOUTHEASTUS), 2);
        assertEquals(mc.caseFinder(StateEnum.RESTOFUS), 3);
        assertEquals(mc.caseFinder(StateEnum.OTHER), 4);

        assertEquals(mc.caseFinder(1), 0);
        assertEquals(mc.caseFinder("test1"), 0);
    }

}
