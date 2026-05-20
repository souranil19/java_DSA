package searching_algorithm;

class linear_search {
    public int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i; // Target found at index i
            }
        }
        return -1; // Target not found
    }
}


class binary_search {
    public static int binarySearch(int[] arr, int target, int left, int right) {
        if (left > right) {
            return -1; // Target not found
        }

        int mid = left + (right - left) / 2;

        if (arr[mid] == target) {
            return mid; // Target found at index mid
        }
        if (arr[mid] < target) {
            return binarySearch(arr, target, mid + 1, right); // Search in right half
        }
        return binarySearch(arr, target, left, mid - 1); // Search in left half
    }
}


public class search {
    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 10, 40};
        int target = 10;

        // Linear Search
        linear_search ls = new linear_search();
        int linearResult = ls.linearSearch(arr, target);
        if (linearResult != -1) {
            System.out.println("Linear Search: Element found at index " + linearResult);
        } else {
            System.out.println("Linear Search: Element not found");
        }

        // Binary Search (array must be sorted)
        int binaryResult = binary_search.binarySearch(arr, target, 0, arr.length - 1);
        if (binaryResult != -1) {
            System.out.println("Binary Search: Element found at index " + binaryResult);
        } else {
            System.out.println("Binary Search: Element not found");
        }
    }
}