/*
Factory is a design pattern in common usage. 
Please implement a ToyFactory which can generate proper toy based on the given type.

ToyFactory tf = new ToyFactory();
Toy toy = tf.getToy(Dog);
toy.talk(); 
>> Wow

ToyFactory tf = new ToyFactory();
Toy toy = tf.getToy(Cat);
toy.talk();
>> Meow
*/


/**
 * Your object will be instantiated and called as such:
 * ToyFactory tf = new ToyFactory();
 * Toy toy = tf.getToy(type);
 * toy.talk();
 */
interface Toy {
    void talk();
}

class Dog implements Toy {
    // Write your code here
    @Override
    public void talk(){
        System.out.println("Wow");
    }
    
}

class Cat implements Toy {
    // Write your code here
    @Override
    public void talk(){
        System.out.println("Meow");
    }
}

public class ToyFactory {
    /**
     * @param type a string
     * @return Get object of the type
     */
    public Toy getToy(String type) {
        // Write your code here
        if(type == null){
            return null;
        }
        if(type.equals("Dog")){               //String uses .equals as method to compare
            return new Dog();
        } else if(type.equals("Cat")){
            return new Cat();
        }
        return null;
    }
}
