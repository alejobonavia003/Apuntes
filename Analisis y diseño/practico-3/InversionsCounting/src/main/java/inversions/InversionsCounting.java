package inversions;

import java.util.Arrays;

class InversionsCounting {

    public static int inversionsCounter(int[] a) {
    int n = a.length;
    if (n <= 1) return 0;

    if (n == 2) {
        if (a[0] > a[1]) {
            int aux = a[0];
            a[0] = a[1];
            a[1] = aux;
            return 1;
        }
        return 0;
    }

    int mid = n / 2;
    int[] left = Arrays.copyOfRange(a, 0, mid);
    int[] right = Arrays.copyOfRange(a, mid, n);

    return inversionsCounter(left) + inversionsCounter(right) + counting(left, right);
}

private static int counting(int[] left, int[] right) {
    int count = 0;
    int i = 0, j = 0;

    while (i < left.length && j < right.length) {
        if (left[i] <= right[j]) {
            i++;
        } else {
            count += (left.length - i);
            j++;
        }
    }
    return count;
}

}
