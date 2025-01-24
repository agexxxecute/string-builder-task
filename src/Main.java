public class Main {

    public static void main(String[] args) {
        MyStringBuilder myStringBuilder = new MyStringBuilder();
        myStringBuilder.append("Hello ");
        myStringBuilder.append("World");
        System.out.println(myStringBuilder); //Hello World
        myStringBuilder.delete(5,11);
        System.out.println(myStringBuilder); //Hello
        System.out.println(myStringBuilder.undo()); //Hello World
        System.out.println(myStringBuilder.undo()); //Hello
        System.out.println(myStringBuilder.undo()); //empty string
    }
}
