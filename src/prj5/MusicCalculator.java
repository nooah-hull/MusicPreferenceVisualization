package prj5;

import java.util.ArrayList;

// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// --

/**
 * Handles calculations for the project
 *
 * @author <Brock Morgan> <brockmorgan>
 * @version <4/16/2019>
 */
public class MusicCalculator {
    private DList<Song> songs;
    private ArrayList<Student> students;


    /**
     * makes a music calculator object from a DList of songs and an array of
     * students
     * 
     * @param arrayList
     *            the DList of songs
     * @param dList
     *            array of students
     */
    public MusicCalculator(ArrayList<Student> arrayList, DList<Song> dList) {
        if (arrayList == null) {
            throw new IllegalArgumentException();
        }
        this.songs = dList;
        this.students = arrayList;
    }


    /**
     * sorts the songs based on a given parameter such as year, genre, artist
     * 
     * @param cat
     *            the parameter to sort by
     */
    public void sort(String cat) {
        int n = songs.size();
        for (int i = 0; i < n - 1; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (songs.get(j).compareTo(songs.get(min), cat) < 0) {
                    min = j;
                }
            }
            Song temp = songs.getNodeAtIndex(min).getData();
            songs.getNodeAtIndex(min).setData(songs.getNodeAtIndex(i)
                .getData());
            songs.getNodeAtIndex(i).setData(temp);

        }

    }


    /**
     * returns an int array for percents for a given attribute
     * e.g. "major, hobby, region"
     * 
     * @param s
     *            the song being asked about
     * @return the attribute we are looking to search for
     */
    public int[] getPercents(Song s, String attribute) {
        int readHeard = 0;
        int readLiked = 0;
        int artHeard = 0;
        int artLiked = 0;
        int sportsHeard = 0;
        int sportsLiked = 0;
        int musicHeard = 0;
        int musicLiked = 0;
        int readCountLiked = 0;
        int readCountHeard = 0;
        int artCountLiked = 0;
        int artCountHeard = 0;
        int sportsCountLiked = 0;
        int sportsCountHeard = 0;
        int musicCountLiked = 0;
        int musicCountHeard = 0;

        int me = 0;
        for (Student student : students) {
            if (attribute.equals("Hobby")) {
                me = caseFinder(student.getHobby());
            }
            else if (attribute.equals("Major")) {
                me = caseFinder(student.getMajor());
            }
            else if (attribute.equals("Region")) {
                me = caseFinder(student.getRegion());
            }

            switch (me) {
                case 1: {
                    if (!(student.getPreferences()[s.getIndex() * 2]).equals(
                        "")) {
                        readCountHeard++;
                        if (student.getPreferences()[s.getIndex() * 2]
                            .equalsIgnoreCase("Yes")) {
                            readHeard++;
                        }
                    }
                    if (!(student.getPreferences()[s.getIndex() * 2 + 1])
                        .equals("")) {
                        readCountLiked++;
                        if (student.getPreferences()[s.getIndex() * 2 + 1]
                            .equalsIgnoreCase("Yes")) {
                            readLiked++;
                        }
                    }
                    break;
                }
                case 2: {

                    if (!(student.getPreferences()[s.getIndex() * 2]).equals(
                        "")) {
                        artCountHeard++;
                        if (student.getPreferences()[s.getIndex() * 2]
                            .equalsIgnoreCase("Yes")) {
                            artHeard++;
                        }
                    }
                    if (!(student.getPreferences()[s.getIndex() * 2 + 1])
                        .equals("")) {
                        artCountLiked++;
                        if (student.getPreferences()[s.getIndex() * 2 + 1]
                            .equalsIgnoreCase("Yes")) {
                            artLiked++;
                        }
                    }
                    break;
                }
                case 3: {
                    if (!(student.getPreferences()[s.getIndex() * 2]).equals(
                        "")) {
                        sportsCountHeard++;
                        if (student.getPreferences()[s.getIndex() * 2]
                            .equalsIgnoreCase("Yes")) {
                            sportsHeard++;
                        }
                    }
                    if (!(student.getPreferences()[s.getIndex() * 2 + 1])
                        .equals("")) {
                        sportsCountLiked++;
                        if (student.getPreferences()[s.getIndex() * 2 + 1]
                            .equalsIgnoreCase("Yes")) {
                            sportsLiked++;
                        }
                    }
                    break;
                }
                case 4: {
                    if (!(student.getPreferences()[s.getIndex() * 2]).equals(
                        "")) {
                        musicCountHeard++;
                        if (student.getPreferences()[s.getIndex() * 2]
                            .equalsIgnoreCase("Yes")) {
                            musicHeard++;
                        }
                    }
                    if (!(student.getPreferences()[s.getIndex() * 2 + 1])
                        .equals("")) {
                        musicCountLiked++;
                        if (student.getPreferences()[s.getIndex() * 2 + 1]
                            .equalsIgnoreCase("Yes")) {
                            musicLiked++;
                        }
                    }
                    break;
                }
                default: {
                    break;
                }
            }
        }
        int[] percents = new int[8];

        if (readCountHeard != 0) {
            percents[0] = (int)(readHeard * 100.0 / readCountHeard);
        }
        if (artCountHeard != 0) {
            percents[1] = (int)(artHeard * 100.0 / artCountHeard);
        }
        if (sportsCountHeard != 0) {
            percents[2] = (int)(sportsHeard * 100.0 / sportsCountHeard);
        }
        if (musicCountHeard != 0) {
            percents[3] = (int)(musicHeard * 100.0 / musicCountHeard);
        }
        if (readCountLiked != 0) {
            percents[4] = (int)(readLiked * 100.0 / readCountLiked);
        }
        if (artCountLiked != 0) {
            percents[5] = (int)(artLiked * 100.0 / artCountLiked);
        }
        if (sportsCountLiked != 0) {
            percents[6] = (int)(sportsLiked * 100.0 / sportsCountLiked);
        }
        if (musicCountLiked != 0) {
            percents[7] = (int)(musicLiked * 100.0 / musicCountLiked);
        }
        return percents;
    }


    /**
     * returns an int for the case based on the enum of the student's attribute
     * 
     * @param caseIn
     *            the attribute we want to fidn the case for
     * @return an int saying if it is the first, second, or third hobby, major,
     *         or region enum
     */
    public int caseFinder(Object caseIn) {
        if (caseIn == HobbyEnum.READ || caseIn == MajorEnum.COMPUTERSCIENCE
            || caseIn == StateEnum.NORTHEASTUS) {
            return 1;
        }

        if (caseIn == HobbyEnum.ART || caseIn == MajorEnum.OTHERENGINEERING
            || caseIn == StateEnum.SOUTHEASTUS) {
            return 2;
        }

        if (caseIn == HobbyEnum.SPORTS || caseIn == MajorEnum.MATH
            || caseIn == StateEnum.RESTOFUS) {
            return 3;
        }

        if (caseIn == HobbyEnum.MUSIC || caseIn == MajorEnum.OTHER
            || caseIn == StateEnum.OTHER) {
            return 4;
        }

        return 0;
    }


    /**
     * @return the DList of songs
     */
    public DList<Song> getSongs() {
        return songs;
    }

}
