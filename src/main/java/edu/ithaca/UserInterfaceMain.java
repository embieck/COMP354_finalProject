package edu.ithaca;

import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.Map.Entry;

public class UserInterfaceMain {

    public static void main(String[] args) throws IOException {

        Scanner scan = new Scanner(System.in);
        Alignment alignChoice = null;
        boolean isHumanoidChoice = false;
        Difficulty difficultyChoice = null;
        MovementType movementChoice = null;

        System.out.println("Welcome to the DND Enemy Recommender!\n");
        System.out.println("First, we'll need some of your preferences to determine the best monster for your party.\n");
        //Preferences uiPref = new Preferences(alignment, isHumanoid, difficulty, movementType);

        System.out.println("Would you like your enemy to have a specific alignment?\n");
        System.out.println("For unaligned, press 0\n");
        System.out.println("For chaotic evil, press 1\n");
        System.out.println("For lawful evil, press 2\n");
        System.out.println("For neutral evil, press 3\n");
        System.out.println("For chaotic good, press 4\n");
        System.out.println("For lawful good, press 5\n");
        System.out.println("For neutral good, press 6\n");
        System.out.println("For chaotic neutral, press 7\n");
        System.out.println("For lawful neutral, press 8\n");
        System.out.println("For true neutral, press 9\n");
        //System.out.println("For random, press any other character\n");
        int choice1 = scan.nextInt();
        if(choice1 == 0){   
            alignChoice = Alignment.UNALIGNED;
        }
        else if(choice1 == 1){
            alignChoice = Alignment.CHAOTICEVIL;
        }
        else if(choice1 == 2){
            alignChoice = Alignment.LAWFULEVIL;
        }
        else if(choice1 == 3){
            alignChoice = Alignment.NEUTRALEVIL;
        }
        else if(choice1 == 4){
            alignChoice = Alignment.CHAOTICGOOD;
        }
        else if(choice1 == 5){
            alignChoice = Alignment.LAWFULGOOD;
        }
        else if(choice1 == 6){
            alignChoice = Alignment.NEUTRALGOOD;
        }
        else if(choice1 == 7){
            alignChoice = Alignment.CHAOTICNEUTRAL;
        }
        else if(choice1 == 8){
            alignChoice = Alignment.LAWFULNEUTRAL;
        }
        else if(choice1 == 9){
            alignChoice = Alignment.TRUENEUTRAL;
        }
        

        System.out.println("Would you like your enemy to be a humanoid?\n");
        System.out.println("For yes, press 1\n");
        System.out.println("For no, press 2\n");
        int choice2 = scan.nextInt();
        if(choice2 == 1){
            isHumanoidChoice = true;
        }


        System.out.println("Would you like your enemy to have a difficulty level?\n");
        System.out.println("For easy, press 1\n");
        System.out.println("For medium, press 2\n");
        System.out.println("For hard, press 3\n");
        System.out.println("For deadly, press 4\n");
        int choice3 = scan.nextInt();
        if(choice3 == 1){
            difficultyChoice = Difficulty.EASY;
        }
        else if(choice3 == 2){
            difficultyChoice = Difficulty.MEDIUM;
        }
        else if(choice3 == 3){
            difficultyChoice = Difficulty.HARD;
        }
        else if(choice3 == 4){
            difficultyChoice = Difficulty.DEADLY;
        }


        System.out.println("Would you like your enemy to have a movement type?\n");
        System.out.println("For ground, press 1\n");
        System.out.println("For flying, press 2\n");
        System.out.println("For swinning, press 3\n");
        int choice4 = scan.nextInt();
        if(choice4 == 1){
            movementChoice = MovementType.GROUND;
        }
        else if(choice4 == 2){
            movementChoice = MovementType.FLY;
        }
        else if(choice4 == 3){
            movementChoice = MovementType.SWIM;
        }

        Preferences pref = new Preferences(alignChoice, isHumanoidChoice, difficultyChoice, movementChoice);
    
        //Interface code for making a recommendation

    }

}
