package number;

public class Sqrt {
    public int mySqrt(int x) {
        if (x <= 1) {
            return x;
        }

        long sqrt = x;

        while ( sqrt * sqrt > x) {
            sqrt = (sqrt + x / sqrt ) / 2;
        }

        return (int) sqrt;
    }
}
