package h2;

public class H2_main {
    private static long[] cache = new long[1000];

    public static void main(String[] args) {
        benchmark(40);
    }

    public static void benchmark(int n) {
        long start, end, res;

        start = System.nanoTime();
        res = fibonacci(n);
        end = System.nanoTime();
        System.out.println("Result: " + res + " Elapsed nanoseconds (fibonacci): " + (end - start));

        start = System.nanoTime();
        res = fibonacciCached(n);
        end = System.nanoTime();
        System.out.println("Result: " + res + " Elapsed nanoseconds (fibonacciCached): " + (end - start));

        start = System.nanoTime();
        res = fibonacciIterative(n);
        end = System.nanoTime();
        System.out.println("Result: " + res + " Elapsed nanoseconds (fibonacciIterative): " + (end - start));
    }

    public static long fibonacci(int n) {
        if (n <= 2) return 1;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static long fibonacciCached(int n) {
        if (n <= 2) return 1;
        if (n < cache.length && cache[n] != 0) return cache[n];
        
        long res = fibonacciCached(n - 1) + fibonacciCached(n - 2);
        if (n < cache.length) cache[n] = res;
        return res;
    }

    public static long fibonacciIterative(int n) {
        if (n <= 2) return 1;
        long a = 1, b = 1, res = 0;
        for (int i = 3; i <= n; i++) {
            res = a + b;
            a = b;
            b = res;
        }
        return res;
    }
}