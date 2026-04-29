package util.sequences;

import java.util.Arrays;

public class MinimumSumSubsequence {

    public static Subseq<Integer> minimumSumSubsequence(Integer[] sequence) {
        int n = sequence.length;
        if (n == 0) return new Subseq<>(0, -1, -1);
        

        return minimumSumSubsequence(sequence, 0, n - 1);
    }

    private static Subseq<Integer> minimumSumSubsequence(Integer[] sequence, int left, int right) {
        // Caso base: un solo elemento
        if (left == right) {
            if (sequence[left] >= 0) {
                return new Subseq<>(0, -1, -1);
            } else {
                return new Subseq<>(sequence[left], left, right);
            }
        }

        int mid = left + (right - left) / 2;


        // Retornar el mínimo de los tres
        return Subseq.minSeq(Subseq.minSeq(minimumSumSubsequence(sequence, left, mid), minimumSumSubsequence(sequence, mid + 1, right)), mediumMinSeq(sequence, left, mid, right));
    }

    private static Subseq<Integer> mediumMinSeq(Integer[] sequence, int left, int mid, int right) {
        // Encontrar la suma mínima en la parte izquierda (desde mid hacia left)
        int leftSum = 0;
        int minLeftSum = Integer.MAX_VALUE;
        int minLeftIndex = mid;
        
        for (int i = mid; i >= left; i--) {
            leftSum += sequence[i];
            if (leftSum < minLeftSum) {
                minLeftSum = leftSum;
                minLeftIndex = i;
            }
        }

        // Encontrar la suma mínima en la parte derecha (desde mid+1 hacia right)
        int rightSum = 0;
        int minRightSum = Integer.MAX_VALUE;
        int minRightIndex = mid;
        
        for (int i = mid + 1; i <= right; i++) {
            rightSum += sequence[i];
            if (rightSum < minRightSum) {
                minRightSum = rightSum;
                minRightIndex = i;
            }
        }

        // La subsequencia que cruza el punto medio
        int totalMinSum = minLeftSum + minRightSum;
        
        // Si la suma total es positiva, retornar subsequencia vacía
        if (totalMinSum >= 0) {
            return new Subseq<>(0, -1, -1);
        }
        
        return new Subseq<>(totalMinSum, minLeftIndex, minRightIndex);
    }

}