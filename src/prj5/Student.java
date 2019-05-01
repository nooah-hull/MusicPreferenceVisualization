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

/**
 * Creates a Student object with preferences and attributes
 *
 * @author Jacob Drimer PID:Jackman99
 * @version 04/15/2019
 */

public class Student {

    private MajorEnum major;
    private StateEnum region;
    private HobbyEnum hobby;
    private String[] preferences;


    /**
     * This is the Student constructor that will take in student's major,
     * region, hobby, and preferences
     *
     * @param majorIN
     *            this is the student's major
     * @param regionIN
     *            this is the student's region
     * @param hobbyIN
     *            this is the student's hobby
     * @param preferencesIN
     *            this is the student's preferences
     */
    public Student(
        String majorIN,
        String regionIN,
        String hobbyIN,
        String[] preferencesIN) {
        setMajor(majorIN);
        setRegion(regionIN);
        setHobby(hobbyIN);
        preferences = preferencesIN;

    }


    /**
     * Returns the major
     *
     * @return student's major
     */
    public MajorEnum getMajor() {
        return major;
    }


    /**
     * assigns the enum for a major
     * 
     * @param m
     *            - the major of a student
     */
    private void setMajor(String m) {
        if (m.equals("Computer Science")) {
            major = MajorEnum.COMPUTERSCIENCE;
        }
        else if (m.equals("Other Engineering")) {
            major = MajorEnum.OTHERENGINEERING;
        }
        else if (m.equals("Math or CMDA")) {
            major = MajorEnum.MATH;
        }
        else {
            major = MajorEnum.OTHER;
        }
    }


    /**
     * Returns the region
     *
     * @return student's region
     */
    public StateEnum getRegion() {
        return region;
    }


    /**
     * assigns the enum for a region
     * 
     * @param regionIN
     *            - the region of a student
     */
    private void setRegion(String regionIN) {
        if (regionIN.equals("Northeast")) {
            region = StateEnum.NORTHEASTUS;
        }
        else if (regionIN.equals("Southeast")) {
            region = StateEnum.SOUTHEASTUS;
        }
        else if (regionIN.equals(
            "United States (other than Southeast or Northwest)")) {
            region = StateEnum.RESTOFUS;
        }
        else {
            region = StateEnum.OTHER;
        }
    }


    /**
     * Returns the hobby
     *
     * @return the student's hobby
     */
    public HobbyEnum getHobby() {
        return hobby;
    }


    /**
     * assigns the enum for a hobby
     * 
     * @param hobbyIN
     *            - the hobby of a student
     */
    private void setHobby(String hobbyIN) {
        if (hobbyIN.equals("reading")) {
            hobby = HobbyEnum.READ;
        }
        else if (hobbyIN.equals("art")) {
            hobby = HobbyEnum.ART;
        }
        else if (hobbyIN.equals("sports")) {
            hobby = HobbyEnum.SPORTS;
        }
        else if (hobbyIN.equals("music")) {
            hobby = HobbyEnum.MUSIC;
        }
    }


    /**
     * Returns the song's genre
     *
     * @return the genre
     */
    public String[] getPreferences() {
        return preferences;
    }


    /**
     * compares the specific aspects of each students
     * 
     * @param obj
     *            this is the student to be compared
     * @return true if all the aspects of the student are the same
     */
    public boolean equals(Object obj) {

        if (obj == this) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (this.getClass() == obj.getClass()) {
            Student doggie = (Student)obj;
            return (this.getMajor() == doggie.getMajor() && this
                .getRegion() == doggie.getRegion() && this.getHobby() == doggie
                    .getHobby() && this.getPreferences().equals(doggie
                        .getPreferences()));
        }
        else {
            return false;
        }
    }

}
