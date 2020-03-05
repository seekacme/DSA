/**
 * 斐波那契数
 */
public class Main2 {

    /**
     * 第一种实现方式
     * @param n 第n个数
     * @return 第n个数的数值
     * 0 1 1 2 3 5 8 13
     */
    public static int fib1(int n){
        if(n<=1) return n;

        return fib1(-2) + fib1(n-1);
    }

    /**
     * 第二种实现方式
     * @param n 第n个数
     * @return 第n个数的数值
     */
    public static int fib2(int n){
        if(n<=1) return n;
        int first = 0 ;
        int second = 1;

        for (int i = 0; i < n - 1; i++) {
            int sum = first + second;
            first = second;
            second = sum;
        }
        return second;
    }

    public static void main(String[] args) {
        final int n = 50;
        Times.test("fib1", new Times.Task() {
            public void execute() {
                fib1(n);
            }
        });

        Times.test("fib2", new Times.Task() {
            public void execute() {
                fib2(n);
            }
        });
    }
}
