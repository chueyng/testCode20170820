import java.util.*;
import java.io.*;
import java.io.IOException;

public class Q2Comparation 
{
    public static void main(String []args)
    {
        List<Student> studentList = new ArrayList<Student>();
        
        // Add all student records into studentList
        studentList.add(new Student(33, "Tina", 3.68));
        studentList.add(new Student(85, "Louis", 3.85));
        studentList.add(new Student(56, "Samil", 3.75));
        studentList.add(new Student(19, "Samar", 3.75));
        studentList.add(new Student(22, "Lorry", 3.76));

        // Get list of descending order by GPA score
        Collections.sort(studentList, new Comparator<Student>() 
        {
            @Override
            public int compare(Student s1, Student s2) 
            {
                return Double.compare(s2.getGPA(), s1.getGPA());
            }
        });
        
        // Sort again by name and ID after descending order list
        Collections.sort(studentList, new Comparator<Student>() 
        {
            @Override
            public int compare(Student s1, Student s2) 
            {
                if (s1.getName().equalsIgnoreCase(s2.getName()))
                {
                    return s1.getID() - s2.getID();
                }
                else
                {
                    return s1.getName().compareTo(s2.getName());
                }
            }
        });
        
        // Loop through studentList
        for(Student student : studentList)
        {
            System.out.println(student.getName());
        }
    }
}