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
    
        for(int i=0;i<p.getPartySize();i++){
            PartyMember c = p.getCharacter(i);
            String delim = ",";
            bw.write(c.getName()+delim);
            //write class
            if(c.getCharacterClass()==CharacterClass.BARD){
                bw.write("bard"+delim);
            }
            else if(c.getCharacterClass()==CharacterClass.BARBARIAN){
                bw.write("barbarian"+delim);
            }
            else if(c.getCharacterClass()==CharacterClass.FIGHTER){
                bw.write("fighter"+delim);
            }
            else if(c.getCharacterClass()==CharacterClass.ROGUE){
                bw.write("rogue"+delim);
            }
            else if(c.getCharacterClass()==CharacterClass.SORCERER){
                bw.write("sorcerer"+delim);
            }
            else if(c.getCharacterClass()==CharacterClass.WARLOCK){
                bw.write("warlock"+delim);
            }
            else if(c.getCharacterClass()==CharacterClass.WIZARD){
                bw.write("wizard"+delim);
            }
            else if(c.getCharacterClass()==CharacterClass.CLERIC){
                bw.write("cleric"+delim);
            }
            else if(c.getCharacterClass()==CharacterClass.MONK){
                bw.write("monk"+delim);
            }
            else if(c.getCharacterClass()==CharacterClass.RANGER){
                bw.write("ranger"+delim);
            }
            else if(c.getCharacterClass()==CharacterClass.PALADIN){
                bw.write("paladin"+delim);
            }
            else{
                bw.write("druid"+delim);
            }
            //write race
            if(c.getCharacterRace()==CharacterRace.DRAGONBORNE){
                bw.write("dragonborne"+delim);
            }
            else if(c.getCharacterRace()==CharacterRace.HALFELF){
                bw.write("half-elf"+delim);
            }
            else if(c.getCharacterRace()==CharacterRace.HALFLING){
                bw.write("halfling"+delim);
            }
            else if(c.getCharacterRace()==CharacterRace.HALFORC){
                bw.write("half-orc"+delim);
            }
            else if(c.getCharacterRace()==CharacterRace.GNOME){
                bw.write("gnome"+delim);
            }
            else if(c.getCharacterRace()==CharacterRace.DWARF){
                bw.write("dwarf"+delim);
            }
            else if(c.getCharacterRace()==CharacterRace.ELF){
                bw.write("elf"+delim);
            }
            else if(c.getCharacterRace()==CharacterRace.TIEFLING){
                bw.write("tiefling"+delim);
            }
            else{
                bw.write("human"+delim);
            }
        }
        bw.close();

    }

    public static void main(String[] args){
        String username = properUsernameLogin();
        DungeonMaster dm = new DungeonMaster(username);

    }
    
}
