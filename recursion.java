public class PowerFunction {
    public static double power(double x, int n) {
        if (n == 0) return 1;
        if (n < 0) return 1 / power(x, -n);
        if (n % 2 == 0) {
            double half = power(x, n / 2);
            return half * half;
        } else {
            return x * power(x, n - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(power(2, 10));  // 1024.0
        System.out.println(power(2, -3));  // 0.125
    }
}
