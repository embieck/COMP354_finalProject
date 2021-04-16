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
            bw.write(c.getName());
            //write class
            if(c.getCharacterClass()==CharacterClass.BARD){
                bw.write("bard");
            }
            else if(c.getCharacterClass()==CharacterClass.BARBARIAN){
                bw.write("barbarian");
            }
            else if(c.getCharacterClass()==CharacterClass.FIGHTER){
                bw.write("fighter");
            }
            else if(c.getCharacterClass()==CharacterClass.ROGUE){
                bw.write("rogue");
            }
            else if(c.getCharacterClass()==CharacterClass.SORCERER){
                bw.write("sorcerer");
            }
            else if(c.getCharacterClass()==CharacterClass.WARLOCK){
                bw.write("warlock");
            }
            else if(c.getCharacterClass()==CharacterClass.WIZARD){
                bw.write("wizard");
            }
            else if(c.getCharacterClass()==CharacterClass.CLERIC){
                bw.write("cleric");
            }
            else if(c.getCharacterClass()==CharacterClass.MONK){
                bw.write("monk");
            }
            else if(c.getCharacterClass()==CharacterClass.RANGER){
                bw.write("ranger");
            }
            else if(c.getCharacterClass()==CharacterClass.PALADIN){
                bw.write("paladin");
            }
            else{
                bw.write("druid");
            }
            //write race
            if(c.getCharacterRace()==CharacterRace.DRAGONBORNE){
                bw.write("dragonborne");
            }
            else if(c.getCharacterRace()==CharacterRace.HALFELF){
                bw.write("half-elf");
            }
            else if(c.getCharacterRace()==CharacterRace.HALFLING){
                bw.write("halfling");
            }
            else if(c.getCharacterRace()==CharacterRace.HALFORC){
                bw.write("half-orc");
            }
            else if(c.getCharacterRace()==CharacterRace.GNOME){
                bw.write("gnome");
            }
            else if(c.getCharacterRace()==CharacterRace.DWARF){
                bw.write("dwarf");
            }
            else if(c.getCharacterRace()==CharacterRace.ELF){
                bw.write("elf");
            }
            else if(c.getCharacterRace()==CharacterRace.TIEFLING){
                bw.write("tiefling");
            }
            else{
                bw.write("human");
            }
        }
        bw.close();

    }

    public static void main(String[] args){
        String username = properUsernameLogin();
        DungeonMaster dm = new DungeonMaster(username);

    }
    
}
