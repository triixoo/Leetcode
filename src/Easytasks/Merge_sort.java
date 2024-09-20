package Easytasks;
public class Merge_sort {
    class Solution {
        public void mergeSort(int arr[], int l, int r) {
            if (l < r) {
                int middle = l + (r - l) / 2;
                mergeSort(arr, l, middle);
                mergeSort(arr, middle + 1, r);
                merge(arr, l, middle, r);
            }
        }
        public void merge(int arr[], int l, int middle, int r) {
            int n1 = middle - l + 1;
            int n2 = r - middle;
            int leftArray[] = new int[n1];
            int rightArray[] = new int[n2];
            for (int i = 0; i < n1; ++i)
                leftArray[i] = arr[l + i];
            for (int j = 0; j < n2; ++j)
                rightArray[j] = arr[middle + 1 + j];
            int i = 0, j = 0;
            int k = l;
            while (i < n1 && j < n2) {
                if (leftArray[i] <= rightArray[j]) {
                    arr[k] = leftArray[i];
                    i++;
                } else {
                    arr[k] = rightArray[j];
                    j++;
                }
                k++;
            }
            while (i < n1) {
                arr[k] = leftArray[i];
                i++;
                k++;
            }
            while (j < n2) {
                arr[k] = rightArray[j];
                j++;
                k++;
            }
        }
    }

    public static void main(String[] args) {
        Merge_sort ms = new Merge_sort();
        Solution solution = ms.new Solution();
        int arr[] = {12, 11, 13, 5, 6, 7};

        System.out.println("First massive:");
        printArray(arr);

        solution.mergeSort(arr, 0, arr.length - 1);

        System.out.println("\nEnding massive:");
        printArray(arr);
    }
    public static void printArray(int arr[]) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
