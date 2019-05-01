package prj5;
/*
 * Virginia Tech Honor Code Pledge:
 *
 * As a Hokie, I will conduct myself with honor
 * and integrity at all times.
 * I will not lie, cheat, or steal, nor will I
 * accept the actions of those who do.
 * -- Jacob Drimer (Jackman99)
 */
import student.TestCase;

/**
 * Tests the methods of Student
 *
 * @author Jacob Drimer PID:Jackman99
 * @version 04/15/2019
 */
public class StudentTest extends TestCase {

    private Student student1;
    private Student student11;
    private Student student12;
    private Student student13;
    private Student student14;
    private Student student15;
    private Student student16;
    private Student student17;

    private String[] preferences1;
    private String[] preferences2;


    /**
     * Sets up each test method.
     */
    public void setUp() {
        preferences1 = new String[2];
        preferences2 = new String[2];

        preferences1[0] = "none";
        preferences1[1] = "good";

        preferences2[0] = "something";
        preferences2[1] = "bad";

        student1 = new Student("Other Engineering", "Northeast", "reading",
            preferences1);
        student11 = new Student("Math or CMDA", "Southeast", "art",
            preferences1);
        student12 = new Student("Computer Science",
            "United States (other than Southeast or Northwest)", "sports",
            preferences1);
        student13 = new Student("Physics", "China", "Music", preferences1);
        student14 = new Student("Computer Science", "Northeast", "reading",
            preferences1);
        student15 = new Student("Other Engineering", "Northeast9", "reading",
            preferences1);
        student16 = new Student("Other Engineering", "Northeast", "reading9",
            preferences1);
        student17 = new Student("Other Engineering", "Northeast", "reading",
            preferences2);
        new Student("Other engineering", "Northeast", "music", preferences1);

    }


    /**
     * Tests the getMajor method
     */

    public void testGetMajor() {
        assertEquals(student1.getMajor(), MajorEnum.OTHERENGINEERING);
        assertEquals(student11.getMajor(), MajorEnum.MATH);
        assertEquals(student12.getMajor(), MajorEnum.COMPUTERSCIENCE);
        assertEquals(student13.getMajor(), MajorEnum.OTHER);

    }


    /**
     * Tests the getRegion method
     */

    public void testGetRegion() {
        assertEquals(student1.getRegion(), StateEnum.NORTHEASTUS);
        assertEquals(student11.getRegion(), StateEnum.SOUTHEASTUS);
        assertEquals(student12.getRegion(), StateEnum.RESTOFUS);
        assertEquals(student13.getRegion(), StateEnum.OTHER);
    }


    /**
     * Tests the getHobby method
     */

    public void testGetHobby() {
        assertEquals(student1.getHobby(), HobbyEnum.READ);
        assertEquals(student11.getHobby(), HobbyEnum.ART);
        assertEquals(student12.getHobby(), HobbyEnum.SPORTS);
    }


    /**
     * Tests the getPreferences method
     */

    public void testGetPreferences() {
        assertEquals(student1.getPreferences(), preferences1);

    }


    /**
     * Tests the Equals method
     */

    public void testEquals() {
        Student nul = null;
        String doggie = "dog";
        int s = 5;

        assertTrue(student1.equals(student1));
        assertFalse(student1.equals(nul));

        assertFalse(student1.equals(s));
        assertFalse(student1.equals(doggie));

        assertFalse(student1.equals(student12));

        assertFalse(student1.equals(student13));
        assertFalse(student1.equals(student14));
        assertFalse(student1.equals(student15));

        assertFalse(student1.equals(student16));
        assertFalse(student1.equals(student17));

        Student stud1 = new Student("Computer Science", "same", "same",
            preferences1);
        Student stud2 = new Student("Math or CMDA", "same", "same",
            preferences1);
        Student stud3 = new Student("Math or CMDA", "same", "same",
            preferences2);
        Student stud1Copy = new Student("Computer Science", "same", "same",
            preferences1);

        assertFalse(stud1.equals(stud3));
        assertFalse(stud2.equals(stud3));
        assertTrue(stud1.equals(stud1Copy));
    }

}
