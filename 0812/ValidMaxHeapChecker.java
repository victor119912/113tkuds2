public class ValidMaxHeapChecker {
    public static boolean isValidMaxHeap(int[] arr) {
        int n = arr.length;
        for (int i = 0; i <= (n - 2) / 2; i++) {
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            if (left < n && arr[i] < arr[left]) {
                System.out.println("違反規則: index " + left);
                return false;
            }
            if (right < n && arr[i] < arr[right]) {
                System.out.println("違反規則: index " + right);
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] arr1 = {100, 90, 80, 70, 60, 75, 65};
        int[] arr2 = {100, 90, 80, 95, 60, 75, 65};
        System.out.println(isValidMaxHeap(arr1)); // true
        System.out.println(isValidMaxHeap(arr2)); // false
    }
}
