/*
Implement a Rectangle class which include the following attributes and methods:

Two public attributes width and height.
A constructor which expects two parameters width and height of type int.
A method getArea which would calculate the size of the rectangle and return.
eg.
Rectangle rec = new Rectangle(3, 4);
rec.getArea(); // should get 12
*/
public class Rectangle {
    /*
     * Define two public attributes width and height of type int.
     */
     public int width, height;//two int
     
     
    //construction fuction, same name as class, don't need void/return
    public Rectangle(int width, int height)
    {
     this.width=width;
     this.height=height;
    }

    /*
     * Define a public method `getArea` which can calculate the area of the
     * rectangle and return.
     */
    public int getArea()
    {
        return this.width * this.height;
    }
    
}
