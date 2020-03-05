package 链表;

public class Test {

    public static void main(String[] args) {
        String number = "(+0086)10086 ";
        number = number.replaceAll("[\\s()+-]", "");
        number = number.replaceFirst("^\\+?0{0,2}86", "");
        System.out.println(number);
    }
}
    