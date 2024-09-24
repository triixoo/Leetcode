package Easytasks;

public class Bubble {
    // Method to perform bubble sort on an array
    static void bubbleSort(int arr[], int n) {
        int i, j, temp; // Declare variables for iteration and temporary storage
        boolean swapped; // Flag to check if a swap occurred

        // Outer loop for n-1 passes
        for (int k = 0; k < n - 1; k++) {
            swapped = false; // Reset swapped flag for this pass

            // Inner loop to compare adjacent elements
            for (int l = 0; l < n - k - 1; l++) {
                // If the current element is greater than the next
                if (arr[l] > arr[l + 1]) {
                    // Swap the elements
                    temp = arr[l]; // Store the current element in temp
                    arr[l] = arr[l + 1]; // Move the next element to the current position
                    arr[l + 1] = temp; // Assign temp (original current element) to the next position
                    swapped = true; // Set swapped to true indicating a swap occurred
                }
            }
            // If no swaps were made, the array is already sorted
            if (swapped == false)
                break; // Exit the loop early
        }
    }

    // Function to print the array
    static void printArray(int arr[], int size) {
        int i; // Declare loop variable
        // Loop through the array to print each element
        for (i = 0; i < size; i++)
            System.out.print(arr[i] + " "); // Print current element followed by a space
        System.out.println(); // Print a new line after the array
    }

    // Driver program to test the bubble sort
    public static void main(String args[]) {
        // Initialize an array of integers
        int arr[] = { 64, 34, 25, 12, 22, 11, 90 };
        int n = arr.length; // Get the length of the array

        // Call the bubbleSort method to sort the array
        bubbleSort(arr, n);

        System.out.println("Sorted array: ");
        printArray(arr, n);
    }
}


