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
 * Creates a Song with a title, artist, year, genre, and index
 *
 * @author Jacob Drimer PID:Jackman99
 * @version 04/15/2019
 */
public class Song {

    private String songTitle;
    private String artist;
    private int year;
    private String genre;
    private int index;


    /**
     * This is the song constructor that will take in song's title, artist,
     * year, genre, and index
     *
     * @param songTitleIN
     *            this is the song's title
     * @param artistIN
     *            this is the song's artist
     * @param yearIN
     *            this is the song's year
     * @param genreIN
     *            this is the song's genre
     * @param indexIN
     *            this is the song's index
     * 
     */
    public Song(
        String songTitleIN,
        String artistIN,
        int yearIN,
        String genreIN,
        int indexIN) {
        songTitle = songTitleIN;
        artist = artistIN;
        year = yearIN;
        genre = genreIN;
        index = indexIN;
    }


    /**
     * Returns the title
     *
     * @return song's title
     */
    public String getSong() {
        return songTitle;
    }


    /**
     * Returns the artist
     *
     * @return song's artist
     */
    public String getArtist() {
        return artist;
    }


    /**
     * Returns the song's year
     *
     * @return the year
     */
    public int getYear() {
        return year;
    }


    /**
     * Returns the song's genre
     *
     * @return the genre
     */
    public String getGenre() {
        return genre;
    }


    /**
     * Returns the song's index
     *
     * @return the index
     */
    public int getIndex() {
        return index;
    }


    /**
     * Converts all the skill rankings into a readable string
     *
     * @return a string of all the skills
     */
    public String toString() {
        StringBuilder helpful = new StringBuilder();
        helpful.append("Song Title: " + getSong() + "\n");
        helpful.append("Song Artist: " + getArtist() + "\n");
        helpful.append("Song Genre: " + getGenre() + "\n");
        helpful.append("Song Year: " + Integer.toString(getYear()));
        return helpful.toString();
    }


    /**
     * Compares the specific aspects of each song
     * 
     * @param obj
     *            this is the song to be compared
     * @return true if all the aspects of the songs are the same
     */
    public boolean equals(Object obj) {

        if (obj == this) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (this.getClass() == obj.getClass()) {
            Song doggie = (Song)obj;
            return (this.getSong().equals(doggie.getSong()) && this.getArtist()
                .equals(doggie.getArtist()) && this.getYear() == doggie
                    .getYear() && this.getGenre().equals(doggie.getGenre())
                && this.getIndex() == doggie.getIndex());
        }
        else {
            return false;
        }
    }


    /**
     * Compares two songs based on a provided parameter
     * 
     * @param other
     *            the other song
     * @param param
     *            the param to compare
     * @return an int value for how the comparison of the provided comparison
     */
    public int compareTo(Song other, String param) {
        int i = 0;
        if (param.equals("year")) {
            i = this.getYear() - other.getYear();
        }
        else {
            if (param.equals("genre")) {
                i = this.getGenre().compareTo(other.getGenre());
            }
            else if (param.equals("title")) {
                i = this.getSong().compareTo(other.getSong());
            }
            else {
                i = this.getArtist().compareToIgnoreCase(other.getArtist());
            }
        }
        return i;
    }

}
