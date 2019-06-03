package algorithm.insertion;

/**
 * @Description:    插入排序
 * 从第一个元素开始，该元素可以认为已经被排序；
 * 取出下一个元素，在已经排序的元素序列中从后向前扫描；
 * 如果该元素（已排序）大于新元素，将该元素移到下一位置；
 * 重复步骤3，直到找到已排序的元素小于或者等于新元素的位置；
 * 将新元素插入到该位置后；
 * 重复步骤2~5。
 * @Author:         daiyongbing
 * @CreateDate:     2019/6/3
 * @Version:        1.0
 */
public class InsertionSort {
    public static int[] insertionSort(int[] array) {
        if (array.length == 0)
            return array;
        int current;
        for (int i = 0; i < array.length - 1; i++) {
            current = array[i + 1];
            int preIndex = i;
            while (preIndex >= 0 && current < array[preIndex]) {
                array[preIndex + 1] = array[preIndex];
                preIndex--;
            }
            array[preIndex + 1] = current;
        }
        return array;
    }

    public static void main(String[] args) {
        int[] array = {45, 43, 1545, 585, 9, 44, 64, 30, 815, 764, 55};
        int[] sortedArray = insertionSort(array);
        for (int i=0; i<sortedArray.length; i++) {
            System.out.println(sortedArray[i]);
        }
    }
}
