package edu.ithaca;
import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class UserInterfaceMain {

    public static String properUsernameLogin(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter username:\n");
        String username=scan.nextLine();
        while(username.length()==0){
            System.out.println("invalid username");
            System.out.println("Enter username:\n");
            username=scan.nextLine();
        }
        scan.close();
        return username;

    }

    public static void readPartyFile(String filename) throws FileNotFoundException{
        File f = new File(filename);
        Scanner scan = new Scanner(f);
        while(scan.hasNext()){
            //create party and characters from file info
        }

        scan.close();
    }

    public static void writePartyFile(String filename, Party p) throws FileNotFoundException,IOException{
        File f = new File(filename);
        BufferedWriter bw = new BufferedWriter(new FileWriter(f));
        bw.write("party info to be added");
        /*
        for(int i=0;i<p.getPartySize();i++){
            bw.write("info per party member to be added");
        }*/
        bw.close();

    }

    public static void main(String[] args){
        String username = properUsernameLogin();
        DungeonMaster dm = new DungeonMaster(username);

    }
    
}
