/*
 * Virginia Tech Honor Code Pledge:
 *
 * As a Hokie, I will conduct myself with honor
 * and integrity at all times.
 * I will not lie, cheat, or steal, nor will I
 * accept the actions of those who do.
 * -- Noah Hull (noahhull)
 */
package prj5;

import java.awt.Color;
import CS2114.Button;
import CS2114.Shape;
import CS2114.TextShape;
import CS2114.Window;
import CS2114.WindowSide;
import prj5.DList.Node;

/**
 * Creates the graphical window for music preference visualization
 *
 * @author Noah Hull (noahhull)
 * @version 04/15/19
 */
public class GUI {
    private Window window;
    private Button prev, sortArtist, sortTitle, sortYear, sortGenre, next,
        hobby, major, region, quit;
    private int barX, songY, barW, barH, elementGap, legendW, legendH, legendT,
        legendLeftX, legendTopY, glyphTracker, wierdXOffset, wierdYOffset;
    private Color[] colors;
    private String[] colorNames;
    private Node<Song> currNode;
    private String curRep;
    private MusicCalculator musCalc;


    /**
     * Constructs a new graphical window for the music preference data
     * 
     * @param calcIn
     *            - the MusicCalculator that works with the window
     */
    public GUI(MusicCalculator calcIn) {
        musCalc = calcIn;

        // Creates the window
        window = new Window();
        window.setTitle("Music Preference Visualization");
        window.setSize(1300, 850);

        // makes the buttons
        prev = new Button("Previous");
        sortArtist = new Button("Sort by Artist Name");
        sortTitle = new Button("Sort by Song Title");
        sortYear = new Button("Sort by Release Year");
        sortGenre = new Button("Sort by Genre");
        next = new Button("Next");
        hobby = new Button("Represent Hobby");
        major = new Button("Represent Major");
        region = new Button("Represent Region");
        quit = new Button("Quit");

        // adds the buttons to the right locations
        window.addButton(prev, WindowSide.NORTH);
        window.addButton(sortArtist, WindowSide.NORTH);
        window.addButton(sortTitle, WindowSide.NORTH);
        window.addButton(sortYear, WindowSide.NORTH);
        window.addButton(sortGenre, WindowSide.NORTH);
        window.addButton(next, WindowSide.NORTH);

        window.addButton(hobby, WindowSide.SOUTH);
        window.addButton(major, WindowSide.SOUTH);
        window.addButton(region, WindowSide.SOUTH);
        window.addButton(quit, WindowSide.SOUTH);

        // Adds the button detection methods
        prev.onClick(this, "clickedPrev");
        sortArtist.onClick(this, "clickedSortArtist");
        sortTitle.onClick(this, "clickedSortTitle");
        sortYear.onClick(this, "clickedSortYear");
        sortGenre.onClick(this, "clickedSortGenre");
        next.onClick(this, "clickedNext");
        hobby.onClick(this, "clickedHobby");
        major.onClick(this, "clickedMajor");
        region.onClick(this, "clickedRegion");
        quit.onClick(this, "clickedQuit");

        // Creates constants for use in the graphical shapes
        barX = 150;
        songY = 20;
        barW = 8;
        barH = 64;
        elementGap = 5;
        legendW = 150;
        legendH = 225;
        legendT = 4;
        wierdXOffset = 38;
        wierdYOffset = 180;
        legendLeftX = window.getWidth() - elementGap - legendW - wierdXOffset;
        legendTopY = window.getHeight() - elementGap - legendH - wierdYOffset;

        // assigns color array for use in the visualization bars
        colors = new Color[4];
        colors[0] = Color.RED;
        colors[1] = Color.BLUE;
        colors[2] = Color.YELLOW;
        colors[3] = Color.GREEN;

        // Assigns color names to be used in the legend
        colorNames = new String[12];
        colorNames[0] = "Read";
        colorNames[1] = "Art";
        colorNames[2] = "Sports";
        colorNames[3] = "Music";
        colorNames[4] = "Computer Science";
        colorNames[5] = "Other Engineering";
        colorNames[6] = "Math";
        colorNames[7] = "Other";
        colorNames[8] = "Northeastern US";
        colorNames[9] = "Southeastern US";
        colorNames[10] = "Other US";
        colorNames[11] = "Other";

        // Runs update methods
        currNode = musCalc.getSongs().getNodeAtIndex(0);
        curRep = "Hobby";
        glyphTracker = 0;
        checkButtons();
    }


    /**
     * 
     */
    public void checkButtons() {
        prev.enable();
        next.enable();
        Node<Song> temp = currNode;
        for (int i = 0; i < 9; i++) {
            if (temp.previous() == null) {
                prev.disable();
                break;
            }
            temp = temp.previous();
        }

        temp = currNode;
        for (int i = 0; i < 9; i++) {
            if (temp.next() == null) {
                next.disable();
                break;
            }
            temp = temp.next();
        }
    }


    /**
     * 
     * @param additional
     */
    private void currNodeBacktrack(int additional) {
        for (int i = 0; i < glyphTracker + additional; i++) {
            currNode = currNode.previous();
        }
    }


    /**
     * runs when previous is clicked
     * 
     * @param buttonIn
     *            - the button that is pressed
     */
    public void clickedPrev(Button buttonIn) {
        currNodeBacktrack(9);
        standardRefresh();
    }


    /**
     * runs when Sort Artist is pressed
     * 
     * @param buttonIn
     *            - the button that is pressed
     */
    public void clickedSortArtist(Button buttonIn) {
        musCalc.sort("artist");
        currNode = musCalc.getSongs().getNodeAtIndex(0);
        standardRefresh();
    }


    /**
     * runs when Sort Title is presssed
     * 
     * @param buttonIn
     *            - the button that is pressed
     */
    public void clickedSortTitle(Button buttonIn) {
        musCalc.sort("title");
        currNode = musCalc.getSongs().getNodeAtIndex(0);
        standardRefresh();
    }


    /**
     * runs when Sort Year is pressed
     * 
     * @param buttonIn
     *            - the button that is pressed
     */
    public void clickedSortYear(Button buttonIn) {
        musCalc.sort("year");
        currNode = musCalc.getSongs().getNodeAtIndex(0);
        standardRefresh();
    }


    /**
     * runs when sort genre is pressed
     * 
     * @param buttonIn
     *            - the button that is pressed
     */
    public void clickedSortGenre(Button buttonIn) {
        musCalc.sort("genre");
        currNode = musCalc.getSongs().getNodeAtIndex(0);
        standardRefresh();
    }


    /**
     * runs when next is pressed
     * 
     * @param buttonIn
     *            - the button that is pressed
     */
    public void clickedNext(Button buttonIn) {
        standardRefresh();
    }


    /**
     * runs when represent by hobby is pressed
     * 
     * @param buttonIn
     *            - the button that is pressed
     */
    public void clickedHobby(Button buttonIn) {
        curRep = "Hobby";
        currNodeBacktrack(0);
        standardRefresh();
    }


    /**
     * runs when represent by major is pressed
     * 
     * @param buttonIn
     *            - the button that is pressed
     */
    public void clickedMajor(Button buttonIn) {
        curRep = "Major";
        currNodeBacktrack(0);
        standardRefresh();
    }


    /**
     * runs when represent by region is pressed
     * 
     * @param buttonIn
     *            - the button that is pressed
     */
    public void clickedRegion(Button buttonIn) {
        currNodeBacktrack(0);
        curRep = "Region";
        standardRefresh();
    }


    /**
     * 
     */
    public void resetWindow() {
        window.removeAllShapes();
        barX = 150;
        songY = 20;
    }


    /**
     * 
     */
    public void standardRefresh() {
        resetWindow();
        createGlyphPage(curRep);
        updateLegend(curRep);
    }


    /**
     * runs when quit is pressed
     * 
     * @param buttonIn
     *            - the button that is pressed
     */
    public void clickedQuit(Button buttonIn) {
        System.exit(0);
    }


    /**
     * 
     * @param attribute
     */
    public void createGlyphPage(String attribute) {
        glyphTracker = 0;
        checkButtons();
        while (checkGlyph() && currNode.next() != null) {
            createGlyph(currNode.getData(), attribute);
            currNode = currNode.next();
        }
    }


    /**
     * 
     * @return
     */
    public boolean checkGlyph() {
        if (barX + 250 > window.getWidth() && songY + 250
            + wierdYOffset > window.getHeight()) {
            return false;
        }

        if (barX + 250 > window.getWidth()) {
            barX = 150;
            songY = songY + 250;
        }

        return true;
    }


    /**
     * generates a glyph of musical preferences for a song
     */
    public void createGlyph(Song songIn, String attribute) {

        // creates the song name and adds it to window
        TextShape songName = new TextShape(0, songY, songIn.getSong());
        window.addShape(songName);

        // adds the song artist centered below the name
        TextShape songArtist = new TextShape(0, songY + songName.getHeight()
            + elementGap, "By: " + songIn.getArtist());
        window.addShape(songArtist);

        // adds the separator bar centered below the artist line
        window.addShape(new Shape(barX, songArtist.getY() + songArtist
            .getHeight() + elementGap, barW, barH, Color.BLACK));

        songName.setX(barX + (barW / 2) - (songName.getWidth() / 2));
        songArtist.setX(barX + (barW / 2) - (songArtist.getWidth() / 2));

        // adds the four colored preference bars
        int[] nums = musCalc.getPercents(songIn, attribute);
        for (int i = 0; i < colors.length; i++) {
            window.addShape(new Shape(barX + barW / 2 - nums[i], songArtist
                .getY() + elementGap + (i + 1) * songArtist.getHeight(), nums[i]
                    + nums[i + 4], songArtist.getHeight(), colors[i]));
        }
        barX = barX + 350;
        glyphTracker++;
    }


    /**
     * updates the legend of the window
     */
    public void updateLegend(String attribute) {
        // adds the top bar of the legend and assigns it to a reference
        Shape referenceShape = new Shape(legendLeftX, legendTopY, legendW,
            legendT, Color.BLACK);
        window.addShape(referenceShape);

        // adds the left, right, and bottom legend bars
        window.addShape(new Shape(legendLeftX, legendTopY, legendT, legendH,
            Color.BLACK));
        window.addShape(new Shape(legendLeftX, window.getHeight() - elementGap
            - wierdYOffset, legendW, legendT, Color.BLACK));
        window.addShape(new Shape(window.getWidth() - elementGap - wierdXOffset
            - legendT, legendTopY, legendT, legendH, Color.BLACK));

        // adds the hobby legend text below the bars
        TextShape legend = new TextShape(0, referenceShape.getY()
            + referenceShape.getHeight() + elementGap, attribute + " Legend");
        legend.setX(referenceShape.getX() + (referenceShape.getWidth() / 2)
            - (legend.getWidth() / 2));
        window.addShape(legend);

        // adds the three colored words below the hobby legend
        int start = 0;
        if (attribute.equals("Hobby")) {
            start = 0;
        }
        else if (attribute.equals("Major")) {
            start = 4;
        }
        else {
            start = 8;
        }

        TextShape tempShape = null;
        for (int i = start; i < start + 4; i++) {
            tempShape = new TextShape(0, legend.getY() + elementGap + ((i % 4
                + 1) * legend.getHeight()) + (i % 4 + 1 * elementGap),
                colorNames[i], colors[i % 4]);
            tempShape.setX(referenceShape.getX() + (referenceShape.getWidth()
                / 2) - (tempShape.getWidth() / 2));
            window.addShape(tempShape);
        }

        // adds the song title example text centered
        TextShape songTitle = new TextShape(0, tempShape.getY() + tempShape
            .getHeight() + 4 * elementGap, "Song Title");
        songTitle.setX(referenceShape.getX() + (referenceShape.getWidth() / 2)
            - (songTitle.getWidth() / 2));
        window.addShape(songTitle);

        // adds the example bar centered below the song title example
        Shape exampleBar = new Shape(0, songTitle.getY() + songTitle.getHeight()
            + elementGap, barW, barH, Color.BLACK);
        exampleBar.setX(referenceShape.getX() + (referenceShape.getWidth() / 2)
            - (exampleBar.getWidth() / 2));
        window.addShape(exampleBar);

        // adds the text "heard" to the left of the example bar
        TextShape heard = new TextShape(0, 0, "Heard");
        heard.setX(exampleBar.getX() - elementGap - heard.getWidth());
        heard.setY(exampleBar.getY() + (exampleBar.getHeight() / 2) - (heard
            .getHeight() / 2));
        window.addShape(heard);

        // adds the text "likes" to the right of the example bar
        TextShape likes = new TextShape(0, 0, "Likes");
        likes.setX(exampleBar.getX() + exampleBar.getWidth() + elementGap);
        likes.setY(exampleBar.getY() + (exampleBar.getHeight() / 2) - (likes
            .getHeight() / 2));
        window.addShape(likes);
    }
}
