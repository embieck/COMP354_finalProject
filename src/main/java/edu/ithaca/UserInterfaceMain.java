package edu.ithaca;
import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.Map.Entry;

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

    public static Party readPartyFile(String filename) throws FileNotFoundException, RuntimeException{
        File f = new File(filename);
        Scanner scan = new Scanner(f);
        scan.useDelimiter(",");
        ArrayList<PartyMember> partyMembers = new ArrayList<>();
        while(scan.hasNext()){
            String charName = scan.next();
            CharacterClass cc = stringToClass(scan.next());
            CharacterRace cr = stringToRace(scan.next());
            partyMembers.add(new PartyMember(charName,cc,cr));
        }

        scan.close();

        if(partyMembers.size()<1){
            throw new RuntimeException("empty file");
        }
        return new Party(partyMembers);
    }

    public static void printFileInfo(String filename) throws FileNotFoundException{
        File f = new File(filename);
        Scanner scan = new Scanner(f);
        scan.useDelimiter(",");
        while(scan.hasNext()){
            System.out.println(scan.next());
        }
        scan.close();
    }

    private static EnumMap<CharacterClass,String> createStringToClassMapping(){
        EnumMap <CharacterClass, String> classesAndStrings = new EnumMap<>(CharacterClass.class);
        classesAndStrings.put(CharacterClass.BARBARIAN,"barbarian");
        classesAndStrings.put(CharacterClass.ROGUE,"rogue");
        classesAndStrings.put(CharacterClass.BARD,"bard");
        classesAndStrings.put(CharacterClass.PALADIN,"paladin");
        classesAndStrings.put(CharacterClass.SORCERER,"sorcerer");
        classesAndStrings.put(CharacterClass.WIZARD,"wizard");
        classesAndStrings.put(CharacterClass.FIGHTER,"fighter");
        classesAndStrings.put(CharacterClass.WARLOCK,"warlock");
        classesAndStrings.put(CharacterClass.CLERIC,"cleric");
        classesAndStrings.put(CharacterClass.MONK,"monk");
        classesAndStrings.put(CharacterClass.RANGER,"ranger");
        classesAndStrings.put(CharacterClass.DRUID,"druid");
        return classesAndStrings;

    }
    public static CharacterClass stringToClass(String className) throws IllegalArgumentException{
        EnumMap <CharacterClass, String> classesAndStrings = createStringToClassMapping();
        Set<Entry<CharacterClass,String>> entries = classesAndStrings.entrySet();
        Iterator<Entry<CharacterClass,String>> i = entries.iterator();
        while(i.hasNext()){
            Entry<CharacterClass,String> entry = i.next();
            if(entry.getValue().equalsIgnoreCase(className)){
                return entry.getKey();
            }
        }

        throw new IllegalArgumentException("invalid class name");
        
    }

    private static EnumMap<CharacterRace,String> createStringToRaceMapping(){
        EnumMap <CharacterRace, String> racesAndStrings = new EnumMap<>(CharacterRace.class);
        racesAndStrings.put(CharacterRace.DRAGONBORNE,"dragonborne");
        racesAndStrings.put(CharacterRace.DWARF,"dwarf");
        racesAndStrings.put(CharacterRace.ELF,"elf");
        racesAndStrings.put(CharacterRace.GNOME,"gnome");
        racesAndStrings.put(CharacterRace.HALFELF,"half-elf");
        racesAndStrings.put(CharacterRace.HALFLING,"halfling");
        racesAndStrings.put(CharacterRace.HALFORC,"half-orc");
        racesAndStrings.put(CharacterRace.HUMAN,"human");
        racesAndStrings.put(CharacterRace.TIEFLING,"tiefling");
        
        return racesAndStrings;

    }

    public static CharacterRace stringToRace(String race) throws IllegalArgumentException{
        EnumMap <CharacterRace, String> racesAndStrings = createStringToRaceMapping();
        Set<Entry<CharacterRace,String>> entries = racesAndStrings.entrySet();
        Iterator<Entry<CharacterRace,String>> i = entries.iterator();
        while(i.hasNext()){
            Entry<CharacterRace,String> entry = i.next();
            if(entry.getValue().equalsIgnoreCase(race)){
                return entry.getKey();
            }
        }

        throw new IllegalArgumentException("invalid class name");

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
