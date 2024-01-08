package practiceQuestions.OOPS;

class Employee{
    int id;
    String name;
    Employee(){
        this.id = 1;
        this.name = "No name";
    }
    Employee(int id, String name){
        this.id = id;
        this.name = name;
    }

    private void printSomething(){
        System.out.println("printed");
    }
    public void callPrintSomething(){
        printSomething();
    }
};
abstract class Animal {
    public abstract void makeSound();
    public abstract void move();
    public void newFunc(){
        System.out.println("new func");
    }
}

class Dog extends Animal {
    @Override
    public void makeSound() {
        System.out.println("The dog barks.");
    }

    @Override
    public void move() {
        System.out.println("The dog runs.");
    }
}

abstract class Cat extends Animal {}
class B{
    int a;
    B(int a){
        this.a = a;
    }
}
public class oops {
    static class A{
        int a;
        A(int a){
            this.a = a;
        }
    }
    public static void main(String[] args) {
//        practiceQuestions.OOPS.Employee emp = new practiceQuestions.OOPS.Employee(4, "Aman");
//        practiceQuestions.OOPS.Employee e = new practiceQuestions.OOPS.Employee();
//        System.out.println(emp);
//        System.out.println(emp.id);
//        System.out.println(emp.name);
//        System.out.println(e);
//        System.out.println(e.id);
//        System.out.println(e.name);
//        emp.callPrintSomething();
//
//        practiceQuestions.OOPS.Dog d = new practiceQuestions.OOPS.Dog();
//        d.makeSound();
//        d.move();
//
//        d.newFunc();


        A a =new A(1);
        A a1 =new A(2);
        B b = new B(3);
        B b1 = new B(4);
        System.out.println(a.a);
        System.out.println(a1.a);
        System.out.println(b.a);
        System.out.println(b1.a);
    }
}
