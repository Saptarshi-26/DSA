import java.util.*;

public class Heap_Sort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the length of the array ");
        int[] arr = new int[sc.nextInt()];
        System.out.println("enter the elements of the array ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        Heap_Sort heapSort = new Heap_Sort();
        heapSort.heapSort(arr);
        for (int x : arr)
            System.out.print(x + " ");

    }

    void swap(int[] sort, int i, int j) {
        int temp = sort[i];
        sort[i] = sort[j];
        sort[j] = temp;
    }

    void insertion(int[] arr, int[] sort) {
        for (int i = 1; i <= arr.length; i++) {
            sort[i - 1] = arr[i - 1];
            int j = i;
            int parent = j / 2;
            while (parent >= 1 && sort[parent - 1] > sort[j - 1]) {
                int temp = sort[parent - 1];
                sort[parent - 1] = sort[j - 1];
                sort[j - 1] = temp;
                j = parent;
                parent = j / 2;
            }
        }
    }

    void del_sort(int[] sort, int[] ans) {
        int j = sort.length - 1;
        for (int i = 0; i < sort.length; i++) {
            ans[i] = sort[0];
            sort[0] = sort[j--];
            int k = 1;
            while (k * 2 - 1 <= j) {
                if (k * 2 - 1 <= j && k * 2 <= j) {
                    int min = sort[k * 2 - 1] < sort[k * 2] ? k * 2 - 1 : k * 2;
                    if (sort[min] < sort[k - 1]) swap(sort, min, k - 1);
                    else break;
                    k = min == k * 2 ? k * 2 + 1 : k * 2;
                } else if (k * 2 - 1 <= j) {
                    if (sort[k * 2 - 1] < sort[k - 1]) swap(sort, k * 2 - 1, k - 1);
                    else break;
                    k = k * 2;
                } else {
                    if (sort[k * 2] < sort[k - 1]) swap(sort, k * 2, k - 1);
                    else break;
                    k = k * 2 + 1;
                }

            }
        }
    }

    public void heapSort(int[] arr) {
        // code here
        int[] sort = new int[arr.length];
        insertion(arr, sort);
        int[] ans = new int[arr.length];
        del_sort(sort, ans);
        System.arraycopy(ans, 0, arr, 0, arr.length);
    }
}
