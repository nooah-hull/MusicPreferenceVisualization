package prj5;

// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Matthew Hunderup - hmatthew1

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class creates the musicReader object to read in the text files of the
 * survey data and songs to use in the MusicCalculator and GUI.
 * 
 * @author Matthew Hunderup hmatthew1
 * @version 4/10/2019
 * 
 */
public class MusicReader {

    private ArrayList<Student> students;
    private DList<Song> songs;


    /**
     * Creates the MusicReader object where the file names are run into the
     * private methods to find the ArrayList of students and Doubly Linked List
     * of songs
     * 
     * @param studentFileName
     *            The name of the file with the survey results
     * @param songFileName
     *            The name of the text with the song information
     * @throws FileNotFoundException
     *             Throws exception if the file doesn't exist
     */
    public MusicReader(String studentFileName, String songFileName)
        throws FileNotFoundException {
        songs = this.readSongFile(songFileName);
        students = this.readStudentFile(studentFileName);
        MusicCalculator calc = new MusicCalculator(students, songs);
        @SuppressWarnings("unused")
        GUI graphics = new GUI(calc);
    }


    /**
     * Reads in the name of the student file and returns an ArrayList of Student
     * objects
     * 
     * @param fileName
     *            Name of the file
     * @return Returns the ArrayList of Students
     * @throws FileNotFoundException
     *             Throws exception if the file doesn't exist
     * 
     */
    private ArrayList<Student> readStudentFile(String fileName)
        throws FileNotFoundException {
        File text = new File(fileName);
        Scanner input = new Scanner(text);
        input.nextLine();
        ArrayList<Student> tempStudents = new ArrayList<Student>();

        while (input.hasNextLine()) {
            String line = input.nextLine();
            String[] info = line.split(", *", -1);

            if (info.length >= 5) {
                String[] lessInfo = new String[info.length - 5];
                for (int j = 0; j < lessInfo.length; ++j) {
                    lessInfo[j] = info[j + 5];
                }
                tempStudents.add(new Student(info[2], info[3], info[4],
                    lessInfo));
            }
        }
        input.close();
        return tempStudents;
    }


    /**
     * Reads in the name of the song file and returns a Doubly Linked List of
     * song objects
     * 
     * @param fileName
     *            Name of the file
     * @return Returns the list of songs as a DList
     * @throws FileNotFoundException
     *             Throws exception if the file doesn't exist
     * 
     */
    private DList<Song> readSongFile(String fileName)
        throws FileNotFoundException {
        File text = new File(fileName);
        Scanner input = new Scanner(text);
        int i = 0;
        input.nextLine();
        DList<Song> tempSongs = new DList<Song>();
        while (input.hasNextLine()) {
            String line = input.nextLine();
            String[] info = line.split(", *", -1);
            if (info.length == 4) {
                tempSongs.add(new Song(info[0], info[1], Integer.parseInt(
                    info[2]), info[3], i));
            }
            ++i;
        }
        input.close();
        return tempSongs;
    }


    public DList<Song> getSongs() {
        return songs;
    }


    public ArrayList<Student> getStudents() {
        return students;
    }
}
