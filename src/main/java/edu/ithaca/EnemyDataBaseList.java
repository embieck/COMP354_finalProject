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


    private String convertToSemiColonSeparated(String line){
        boolean inString =false;
        char[] chLine = line.toCharArray();
        for(int i=0;i<chLine.length;i++){
            char ch = chLine[i];
            if(ch=='"'&&!inString){
                inString=true;
            }
            if(inString){
                if(ch=='"'){
                    inString=false;
                }
                else{
                    chLine[i]=';';
                }
            }
        }
        return new String(chLine);
    }
    public Enemy csvLineToEnemy(String line){
        String semiColonSeparatedLine = convertToSemiColonSeparated(line);
        String[] enemyFields = semiColonSeparatedLine.split(";");
        return new Enemy();
        
        

    }
}
