/*
Implement a class School, including the following attributes and methods:

A private attribute name of type string.
A setter method setName which expect a parameter name of type string.
A getter method getName which expect no parameter and return the name of the school.
eg.
School school = new School();
school.setName("MIT");
school.getName(); // should return "MIT" as a result.
*/
public class School {

    private String name;
    public void setName(String name)
    {
        this.name=name;//refer to any member of the current object from within an instance method or a constructor by using this
    }  
    
public String getName()
     {
         return this.name;
     }
}
