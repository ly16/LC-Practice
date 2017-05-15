/*
Implement a class Student, including the following attributes and methods:

Two public attributes name(string) and score(int).
A constructor expect a name as a parameter.
A method getLevel to get the level(char) of the student.
score - level table:

A: score >= 90
B: score >= 80 and < 90
C: score >= 60 and < 80
D: score < 60
eg.
Student student = new Student("Zuck");
student.score = 10;
student.getLevel(); // should be 'D'
student.score = 60;
student.getLevel(); // should be 'C'
*/

public class Student {
    /**
     * Declare two public attributes name(string) and score(int).
     */
    public String name;
    public int score;
    
    /**
     * Declare a constructor expect a name as a parameter.
     */
    public Student(String name)
    {
        this.name=name;
    }
    /**
     * Declare a public method `getLevel` to get the level(char) of this studen.
     */
   public char getLevel()
   {
       if(score>=90)
       {
            return 'A';    
       }else if(score>=80)
       {
           return 'B';
       }else if(score>=60)
       {
           return 'C';
       }else return 'D';
   }
}
