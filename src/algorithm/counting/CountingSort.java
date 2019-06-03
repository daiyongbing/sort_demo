package algorithm.counting;

import java.util.Arrays;

/**
 * @Description:    计数排序
 * 找出待排序的数组中最大和最小的元素；
 * 统计数组中每个值为i的元素出现的次数，存入数组C的第i项；
 * 对所有的计数累加（从C中的第一个元素开始，每一项和前一项相加）；
 * 反向填充目标数组：将每个元素i放在新数组的第C(i)项，每放一个元素就将C(i)减去1。
 * @Author:         daiyongbing
 * @CreateDate:     2019/6/3
 * @Version:        1.0
 */
public class CountingSort {
    public static int[] countingSort(int[] array) {
        if (array.length == 0) return array;
        int bias, min = array[0], max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max)
                max = array[i];
            if (array[i] < min)
                min = array[i];
        }
        bias = 0 - min;
        int[] bucket = new int[max - min + 1];
        Arrays.fill(bucket, 0);
        for (int i = 0; i < array.length; i++) {
            bucket[array[i] + bias]++;
        }
        int index = 0, i = 0;
        while (index < array.length) {
            if (bucket[i] != 0) {
                array[index] = i - bias;
                bucket[i]--;
                index++;
            } else
                i++;
        }
        return array;
    }

    public static void main(String[] args) {
        int[] array = {45, 43, 1545, 585, 9, 44, 64, 30, 815, 764, 55};
        int[] sortedArray = countingSort(array);
        for (int i=0; i<sortedArray.length; i++) {
            System.out.println(sortedArray[i]);
        }
    }
}
