package edu.ithaca;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.*;
// import org.apache.spark.sql.Dataset;
// import org.apache.spark.sql.Row;
// import org.apache.spark.sql.SparkSession;
// import org.apache.spark.sql.types.StructType;
public class EnemyDataBaseList {
    private List<Enemy> enemyDBList;
    // public static Dataset<Row> loadInDb(String filename) throws FileNotFoundException{
    //     SparkSession spark = SparkSession.builder().appName("Java Spark SQL basic example")
    //     .config("spark.master", "local").getOrCreate();
    //     StructType schema = new StructType()
    //     .add("Name","string")
    //     .add("Size","string")
    //     .add("isHumanoid","boolean")
    //     .add("Align","string")
    //     .add("AC","int")
    //     .add("HP","int")
    //     .add("Ground Speed","int")
    //     .add("Fly Speed","int")
    //     .add("Swim Speed","int")
    //     .add("STR","int")
    //     .add("DEX","int")
    //     .add("CON","int")
    //     .add("INT","int")
    //     .add("WIS","int")
    //     .add("CHA","int")
    //     .add("Sav Throws","string")
    //     .add("Skills","string")
    //     .add("Languages","string")
    //     .add("CR","int")
    //     .add("Additional","string");

    //     //Dataset<Row> == DataFrame
    //     Dataset<Row> df = spark.read().option("mode", "DROPMALFORMED").schema(schema).csv(filename);
    //     df.printSchema();
    //     df.show(10,true);
    //     return df;
    // }

    public EnemyDataBaseList(String fileName) throws FileNotFoundException{
        Scanner scan = new Scanner(new File(fileName));
        scan.nextLine(); // removes header
        enemyDBList = new ArrayList<>();
        while(scan.hasNextLine()){
            enemyDBList.add(csvLineToEnemy(scan.nextLine()));
        }
    }

    public EnemyDataBaseList(){
        enemyDBList=new ArrayList<>();
    }

    private String convertToSemiColonSeparated(String line){
        boolean inString =false;
        char[] chLine = line.toCharArray();
        int quoteCount=0;
        for(int i=0;i<chLine.length;i++){
            char ch = chLine[i];
            if(ch=='"'){
                quoteCount++;
                if(!inString){
                    inString=true;
                }
            }
            if(inString){
                if(ch=='"'&&quoteCount%2==0){
                    inString=false;
                }
            }
            else{
                if(ch==','){
                    chLine[i]=';';
                }
            }
        }
        return new String(chLine);
    }
    private String removeQuotesFromStartOrEnd(String field){
        if(field.charAt(0)=='"'){
            field = field.substring(1);
        }
        if(field.charAt(field.length()-1)=='"'){
            field = field.substring(0,field.length()-1);
        }
        return field;
    }
    public Enemy csvLineToEnemy(String line){
        String semiColonSeparatedLine = convertToSemiColonSeparated(line);
        String[] enemyFields = semiColonSeparatedLine.split(";");
        //DB Columns
        //Name,Size,isHumanoid,Align.,AC,HP,Ground Speed,Fly Speed,Swim Speed,
        //STR,DEX,CON,INT,WIS,CHA,Sav. Throws,Skills,Languages,CR,Additional
        try{
            String name = removeQuotesFromStartOrEnd(enemyFields[0]);
            Size size = Size.valueOf(enemyFields[1].toUpperCase());
            boolean isHumanoid= Boolean.parseBoolean(enemyFields[2].toLowerCase());
            Alignment align = Alignment.valueOf(enemyFields[3].toUpperCase());
            int ac = Integer.parseInt(enemyFields[4]);
            int hp = Integer.parseInt(enemyFields[5]);
            int gs = Integer.parseInt(enemyFields[6]);
            int fs = Integer.parseInt(enemyFields[7]);
            int sws = Integer.parseInt(enemyFields[8]);
            int str = Integer.parseInt(enemyFields[9]);
            int dex = Integer.parseInt(enemyFields[10]);
            int con = Integer.parseInt(enemyFields[11]);
            int intel = Integer.parseInt(enemyFields[12]);
            int wis = Integer.parseInt(enemyFields[13]);
            int cha = Integer.parseInt(enemyFields[14]);
            String savThrows = removeQuotesFromStartOrEnd(enemyFields[15]);
            String skills = removeQuotesFromStartOrEnd(enemyFields[16]);
            String languages = removeQuotesFromStartOrEnd(enemyFields[17]);
            double cr = Double.parseDouble(enemyFields[18]);
            String additional = removeQuotesFromStartOrEnd(enemyFields[19]);
            QualatativeStats qls = new QualatativeStats(align, size, languages,',');
            EnemyQuantStats eqns = new EnemyQuantStats(cr, sws, gs, fs, ac, hp, con, str, wis,intel, dex, cha);
            return new Enemy(name,isHumanoid,qls,eqns,savThrows,skills,additional);
        }catch(Exception e){
            System.out.println("csv parsing error");
            throw e;
        }
    }

    public Enemy get(int index){
        return enemyDBList.get(index);
    }

    public ArrayList<Enemy> head(int size){
        if(enemyDBList!=null||!enemyDBList.isEmpty()){
            ArrayList<Enemy> enemies=new ArrayList<>();
            for(int i=0;i<size;i++){
                enemies.add(enemyDBList.get(i));
            }
            return enemies;
        }
        else{
            throw new RuntimeException("enemy database list has not been created yet");
        }
    }
    /**
     * Searches db for enemies with matching combat ratings and returns them as a list 
     * 
     * @param crToFind - Cr value to search for in database
     * @return - List of appropriate enemy objects
     */

    public ArrayList<Enemy> crFind(double crToFind) {
        ArrayList<Enemy> enemiesWithCR = new ArrayList<>();
        for(int i=0;i<enemyDBList.size();i++){
            Enemy e = enemyDBList.get(i);
            if(e.getCr()==crToFind){
                enemiesWithCR.add(e);
            }
        }
        return enemiesWithCR;
    }

    /**
     * Searches db for enemies with matching preferences and returns them as a list 
     * 
     * @param preferences
     * @return - List of appropriate enemy objects
     */
    public ArrayList<Enemy> prefFind(Preferences preferences) {
        ArrayList<Enemy> enemiesWithPreference = new ArrayList<>();
        for(int i=0;i<enemyDBList.size();i++){
            Enemy e = enemyDBList.get(i);
            ArrayList<MovementType> emt = e.getMovementTypes();
            if(e.getAlignment()==preferences.getAlignment()){
                enemiesWithPreference.add(e);
            }
            else if(e.getIsHumanoid()==preferences.getIsHumanoid()){
                enemiesWithPreference.add(e);
            }
            else if(emt.contains(preferences.getMovementType())){
                enemiesWithPreference.add(e);
            }
        }
        return enemiesWithPreference;
    }
}
