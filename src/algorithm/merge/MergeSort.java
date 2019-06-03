package algorithm.merge;

import java.util.Arrays;

/**
 * @Description:    归并排序
 * 把长度为n的输入序列分成两个长度为n/2的子序列；
 * 对这两个子序列分别采用归并排序；
 * 将两个排序好的子序列合并成一个最终的排序序列。
 * @Author:         daiyongbing
 * @CreateDate:     2019/6/3
 * @Version:        1.0
 */
public class MergeSort {
    public static int[] mergeSort(int[] array) {
        if (array.length < 2) return array;
        int mid = array.length / 2;
        int[] left = Arrays.copyOfRange(array, 0, mid);
        int[] right = Arrays.copyOfRange(array, mid, array.length);
        return merge(mergeSort(left), mergeSort(right));
    }
    /**
     * 归并排序——将两段排序好的数组结合成一个排序数组
     *
     * @param left
     * @param right
     * @return
     */
    public static int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        for (int index = 0, i = 0, j = 0; index < result.length; index++) {
            if (i >= left.length)
                result[index] = right[j++];
            else if (j >= right.length)
                result[index] = left[i++];
            else if (left[i] > right[j])
                result[index] = right[j++];
            else
                result[index] = left[i++];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] array1 = {45, 43, 1545, 585, 9, 44, 64, 30, 815, 764, 55};
        int[] array2 = {64, 45, 82, 64, 38, 71, 51,50};
        int[] sortedArray1 = mergeSort(array1);
        int[] sortedArray2 = mergeSort(array2);
        int[] sortedArray = merge(array1, array2);

        for (int i=0; i<sortedArray.length; i++) {
            System.out.println(sortedArray[i]);
        }
    }
}
