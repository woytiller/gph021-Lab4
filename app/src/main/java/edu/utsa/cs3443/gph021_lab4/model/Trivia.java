package edu.utsa.cs3443.gph021_lab4.model;

import android.content.res.AssetManager;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.security.SecureRandom;
import java.util.Scanner;

public class Trivia {
    private String question;
    private String option1;
    private String option2;
    private String option3;

    //private string[] options = new string[3];
    private String descriptionAnswer;

    // Do we need to identify which is the correct one?
    private String correctAnswer;

    public Trivia(String question, String option1, String option2, String option3, String descriptionAnswer) {
        this.question = question;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.descriptionAnswer = descriptionAnswer;
    }

    public Trivia() {
        System.out.println("Explicit default constructor");
    }

    // TODO: write the setters and getters for all the instance variable
    /*
    @param: Activity activity
    @return Trivia object
     loadTrivia: this method takes  in an Activity (MainActivity) from input as an argument, it reads the file
     and stores from that file

     */

    public Trivia loadTrivia(Activity activity) {

        // Get an instance of AssetsManager
        //Read the file in the assets folder using inputStream
        //how many lines are in the file, the number of lines are equivalent to the number of trivia questions
        // randomly select a random number smaller or equal to the number of lines
        // return the object

        AssetManager manager = activity.getAssets();
        Scanner scanner;
        try {
            InputStream input = manager.open("trivia.csv");
            scanner = new Scanner(input);
            int i = 0;
            while(scanner.hasNextLine()){
                i++;
            }
            System.out.println("Number of lines:"+ i);
            //randomly select number 1 to i
            SecureRandom sRandom = new SecureRandom();
            //if i = 7 => A random number from 0 to 6
            int linenumber = sRandom.nextInt(i) + 1;
            int j = 1;
            String line = "";
            while(j<linenumber){
                line = scanner.nextLine();
            }
            //when this loop is over, i am standing right by the line that i want to return
            line = scanner.nextLine();
            String[] lineSplit = line.trim().split(",");
            this.question = lineSplit[0].trim();
            this.option1 = lineSplit[1].trim();
            this.option2 = lineSplit[2].trim();
            this.option3 = lineSplit[3].trim();
            this.descriptionAnswer = lineSplit[4];
            //From index 4 forward, we have the description
            for(int k = 5; k<lineSplit.length; k++){
                this.descriptionAnswer = this.descriptionAnswer +"," + lineSplit[k];
            }

            return (this);
        } catch (FileNotFoundException e) {
            System.err.println("File not found");
        } catch (IOException e) {
            System.err.println("IO exception, which is a super class of FileNotFoundException");
        }

        return (this);
    }

    private void identifyCorrectAnswer(){
        //takes all the options and checks if the description contains any of the options, if so that
        // option becomes the correctAnswer

    }
}