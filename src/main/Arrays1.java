package main;
import java.util.Arrays;
import java.util.Scanner;

public class Arrays1 {
    private Student[] sectionG = new Student[10];
    private int bottom;
    public void insert(Student student)
    {
        if(bottom != sectionG.length-1){
            bottom++;
            sectionG[bottom] = student;
        }
    }
    public Arrays1(int numberOfStudents){
        sectionG = new Student[numberOfStudents];
        bottom = -1;
    }
    public void display()
    {
        for (Student student : sectionG)
        {
            if(student != null)
            {
                System.out.println(student);
            }
        }
    }
    public Student remove(int rollNo)
    {
        Student temp = null;
        if(bottom != -1)
        {
            for (int i = 0; i <= bottom ; i++) {
                if(sectionG[i].getRollno() == rollNo)
                {
                    temp = sectionG[i];
                    sectionG[i] = null;
                    for (int j = i; j < sectionG.length-1; j++) {
                        sectionG[j] = sectionG[j + 1];
                    }
                    sectionG[bottom] = null;
                    bottom--;
                }
            }
        }
        return temp;
    }
    public static void main(String[] args){
        /*Arrays1[] arrays1s = new Arrays1[5];
        System.out.println(Arrays.toString(arrays1s));
        int[] primitiveArray = new int[10];
        int x = 42;
        primitiveArray[0] = x;
        Arrays1 arrays1 = new Arrays1();
        arrays1s[0] = arrays1;
        System.out.println(Arrays.toString(arrays1s));*/
        //Student student1 = new Student();

       /* student1.setName("Guddu");
        student1.setRollno(5);
        insert(student1);*/
       Arrays1 list = new Arrays1(37);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Length");
        int length = scanner.nextInt();
        for (int i = 0; i < length ; i++) {
            Student student = new Student();
            student.setRollno(scanner.nextInt());
            student.setName(scanner.nextLine().trim());
            list.insert(student);
        }
        list.display();
        System.out.println(list.remove(1) + "was removed.");
    }
}
class Student{
    private int rollno;
    private String name;
    //getters and setters
    // accessor and mutator
    // observers and transformers


    public int getRollno() {
        return rollno;
    }

    public void setRollno(int rollno) {
        this.rollno = rollno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return ("(" + rollno + "," + name + ")");
    }
}
