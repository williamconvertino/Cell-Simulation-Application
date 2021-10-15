package cellsociety.logic;

import cellsociety.errors.FileNotFoundError;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Properties;
import java.util.Scanner;

public class Logic {
    private Grid grid;
    HashMap<String, String> metadata;

    public Logic(int width, int height){
        grid = new Grid(width, height);
    }


    public void initializeWithCSVFile(String file){
        try{
            //parsing a CSV file into Scanner class constructor
            Scanner sc = new Scanner(new File(file));
            sc.useDelimiter(",");//sets the delimiter pattern
            //width and height are the first two values in the csv
            int width = sc.nextInt();
            int height = sc.nextInt();
            this.grid = new Grid(width, height);
            int i = 0, j = 0;
            while (sc.hasNext())  //returns a boolean value
            {
                grid.setCell(i% grid.getWidth(), j% grid.getHeight(), sc.nextInt());  //find and returns the next complete token from this scanner
                j++;
                if(j%grid.getHeight() == 0) i++;
            }
            sc.close();  //closes the scanner

            grid.updateGrid();
        } catch (FileNotFoundException e){
            //TODO do some error checking here
        }
    }

    public void initializeWithSimFile(String file){
        Properties prop = readPropertiesFile(file);
        for (final String name: prop.stringPropertyNames())
            metadata.put(name, prop.getProperty(name));
    }

    private Properties readPropertiesFile(String fileName){
        FileInputStream fis;
        Properties prop = null;
        try {
            fis = new FileInputStream(fileName);
            prop = new Properties();
            prop.load(fis);
            fis.close();
        } catch(FileNotFoundException fnfe) {
        } catch(IOException ioe) {
        }
        return prop;
    }

    public Grid getGrid(){
        return grid;
    }


}
