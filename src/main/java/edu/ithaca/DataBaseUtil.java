package edu.ithaca;
import java.io.FileNotFoundException;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.types.StructType;
public class DataBaseUtil {
    public static Dataset<Row> loadInDb(String filename) throws FileNotFoundException{
        SparkSession spark = SparkSession.builder().appName("Java Spark SQL basic example")
        .config("spark.master", "local").getOrCreate();
        StructType schema = new StructType()
        .add("Name","string")
        .add("Size","string")
        .add("isHumanoid","boolean")
        .add("Align","string")
        .add("AC","int")
        .add("HP","int")
        .add("Ground Speed","int")
        .add("Fly Speed","int")
        .add("Swim Speed","int")
        .add("STR","int")
        .add("DEX","int")
        .add("CON","int")
        .add("INT","int")
        .add("WIS","int")
        .add("CHA","int")
        .add("Sav Throws","string")
        .add("Skills","string")
        .add("Languages","string")
        .add("CR","int")
        .add("Additional","string");

        //Dataset<Row> == DataFrame
        Dataset<Row> df = spark.read().option("mode", "DROPMALFORMED").schema(schema).csv(filename);
        df.printSchema();
        //df.show(10,true);
        return df;
    }
}
