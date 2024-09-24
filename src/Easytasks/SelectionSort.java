package Easytasks;
public class SelectionSort {
    public static void main(String args[]) {
        int n = 7;
        int[] arr = {67, 44, 55, 52, 17, 69, 34};


        System.out.print("Array before Sorting: ");
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
        for (int i = 0; i < n - 1; i++) { // Loop through each element
            int minIndex = i; // Assume the current position is the minimum


            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) { // Update minIndex if a smaller element is found
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                int temp = arr[i]; // Store current element
                arr[i] = arr[minIndex]; // Place minimum element in current position
                arr[minIndex] = temp; // Move current element to minIndex
            }
        }
        System.out.print("Array After Sorting: ");
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
}
