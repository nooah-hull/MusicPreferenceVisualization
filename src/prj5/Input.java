package prj5;
// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Brock Morgan (brockmorgan)

import java.io.FileNotFoundException;

/**
 * Runs the project
 *
 * @author <Brock Morgan> <brockmorgan>
 * @version <4/9/2019>
 */
public class Input {

    /**
     * If two arguments have been provided, we will use those as our input
     * filenames. Otherwise, instantiate a MusicReader object and provide the
     * default "SongList2018.csv" and "MusicSurveyData2018.csv" filenames as
     * inputs. The main method should not catch the exceptions, just let them be
     * thrown.
     * 
     * @param args
     *            String array of file names, should only be length 2
     * @throws FileNotFoundException
     *             if no file is found
     * @throws MPVDataException
     *             if data in files is incorrect
     */
    public static void main(String[] args) throws FileNotFoundException {
        if (args.length != 2) {
            new MusicReader("MusicSurveyData.csv", "SongList.csv");
        }
        else {
            new MusicReader(args[0], args[1]);
        }
    }
}
