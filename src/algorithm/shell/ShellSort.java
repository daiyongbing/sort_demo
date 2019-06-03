package algorithm.shell;

/**
 * @Description:    希尔排序
 * 选择一个增量序列t1，t2，…，tk，其中ti>tj，tk=1；
 * 按增量序列个数k，对序列进行k 趟排序；
 * 每趟排序，根据对应的增量ti，将待排序列分割成若干长度为m 的子序列，分别对各子表进行直接插入排序。
 * 仅增量因子为1 时，整个序列作为一个表来处理，表长度即为整个序列的长度。
 * @Author:         daiyongbing
 * @CreateDate:     2019/6/3
 * @Version:        1.0
 */
public class ShellSort {
    public static int[] shellSort(int[] array) {
        int len = array.length;
        int temp, gap = len / 2;
        while (gap > 0) {
            for (int i = gap; i < len; i++) {
                temp = array[i];
                int preIndex = i - gap;
                while (preIndex >= 0 && array[preIndex] > temp) {
                    array[preIndex + gap] = array[preIndex];
                    preIndex -= gap;
                }
                array[preIndex + gap] = temp;
            }
            gap /= 2;
        }
        return array;
    }

    public static void main(String[] args) {
        int[] array = {45, 43, 1545, 585, 9, 44, 64, 30, 815, 764, 55};
        int[] sortedArray = shellSort(array);
        for (int i=0; i<sortedArray.length; i++) {
            System.out.println(sortedArray[i]);
        }
    }
}
