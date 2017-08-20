import java.util.*;
import java.io.*;
import java.io.IOException;

public class Student
{
    private int ID;
    private String name;
    private double score;

    public Student(int ID, String name, double score)
    {
        this.ID = ID;
        this.name = name;
        this.score = score;
    }

    //Getters
    public int getID()
    {
        return this.ID;
    }
    
    public String getName()
    {
        return this.name;
    }
    
    public double getGPA()
    {
        return this.score;
    }

    //Setters...
}