package Easytasks;
public class InsertionSort {
    public static void main(String args[]) {
        int n = 5;
        int[] arr = {67, 44, 82, 17, 20};
        // Print the array before sorting
        System.out.print("Array before Sorting: ");
        for(int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
        for(int i = 1; i < n; i++) { // Iterate from the second element to the end
            int key = arr[i]; // Take the current element to be inserted
            int j = i; // Initialize j to the current index

            // Shift elements of arr[0..i-1], that are greater than key, to one position ahead
            while(j > 0 && arr[j - 1] > key) {
                arr[j] = arr[j - 1]; // Move the larger element one position ahead
                j--; // Decrement j to check the next element
            }
            arr[j] = key; // Insert the key at its correct position
        }

        // Print the array after sorting
        System.out.print("Array After Sorting: ");
        for(int i = 0; i < n; i++)
            System.out.print(arr[i] + " "); // Print each element of the sorted array
        System.out.println(); // Print a new line
    }
}
