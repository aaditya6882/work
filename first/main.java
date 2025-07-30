public class main{
    public static void main(String[] args){
        System.out.print("Hello World");
        int age=18;
            if(age==18){
        System.out.println("adult");
        }
        for(int i=0; i<5; i++){
            System.out.println("i is: " + i);
        }
    String s1="Hello";
    String s2="World";
    System.out.println(s1 + " " + s2);
    System.out.println(s1.charAt(2));
    System.out.println(s1.length());
    System.out.println(s1.substring(1, 4));
    System.out.println(s1.replace('l', 'p'));
    String s3=s1.concat( " , ").concat(s2);
    System.out.println(s3);
    String[] words=s3.split(" ,");
    for(String word : words){
        System.out.println(word);
        }
    StringConcatDemo.printConcat();
    stringBufferBuilderDemo sbDemo = new stringBufferBuilderDemo();
    ArrayDemo.array();
    AutoBoxingDemo.demo();
}
}
class StringConcatDemo {
    public static void printConcat() {
        String s = "Hello";
        s.concat(" World");
        System.out.println(s);
        // String is immutable, so the original string remains unchanged 
        }
}
class stringBufferBuilderDemo{
    public stringBufferBuilderDemo()
{
    StringBuffer sb=new StringBuffer("Hii");
    sb.append(" How aree you");
    System.out.println(sb);
    sb.delete(8, 9);
    System.out.println(sb);
    System.out.println(sb.capacity());
    sb.delete(10, 11);
    System.out.println(sb);
    sb.insert(8, "a");
    System.out.println(sb);
    sb.append("HelloHelloHelloHelloHello");
    System.out.println(sb.capacity());
    sb.delete(15, 41);
    System.out.println(sb);
    System.out.println(sb.capacity());
}}

class ArrayDemo {
    public static void array() {
        int[] arr = {1, 2, 3, 4, 5};
        for (int i = 0; i < arr.length; i++) {
            System.out.println("Element at index " + i + ": " + arr[i]);
             }
    }
}
class AutoBoxingDemo {
    public static void demo() {
        int num = 100;
        Integer boxedNum = num; 
        System.out.println( boxedNum);

        int unboxedNum = boxedNum; 
        System.out.println( unboxedNum);
    }
}