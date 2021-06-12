public class Main {

    public static void main(String[] args) {
        int[] A = {0};
        int[] res = SquareArray(A);
        System.out.println(res);
    }

    public static int[] SquareArray(int[] A) {
        // write your code here
        int[] res = new int[A.length];
        int leftIndex = 0, rightIndex = A.length - 1;
        int tmpIndex = A.length - 1;
        while (rightIndex >= leftIndex) {
            if (Math.abs(A[rightIndex]) >= Math.abs(A[leftIndex])) {
                res[tmpIndex] = A[rightIndex] * A[rightIndex];
                rightIndex--;
            } else {
                res[tmpIndex] = (A[leftIndex]) * A[leftIndex];
                leftIndex++;
            }
            tmpIndex--;
        }
        return res;

    }
}
