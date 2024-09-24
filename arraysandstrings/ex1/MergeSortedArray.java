package arraysandstrings.ex1;

public class MergeSortedArray {
    public static void merge(int[] a, int m, int[] b, int n) {
        int k = m + n - 1; //k pointeur sur le dernier zero
        int j = n - 1; //pointeur sur le dernier element de a
        int i = m - 1; //pointeur sur le dernier element non nul de num1
        while (i >= 0 || j >= 0) {
            // Si `i` est hors du tableau, on place le reste de b
            if (i < 0) {
                a[k] = b[j];
                j--;
            }
            // Si `j` est hors du tableau, on copie simplement `a[i]`
            else if (j < 0) {
                a[k] = a[i];
                i--;
            }
            if (j < 0) {
                return;
            } else if (i < 0) {
                for (int j1 = 0; j1 < k; j1++) {
                    b[j1] = a[j];
                }
                return;
            }
            k--;
        }
    }

    public static void main(String[] args) {
        int[] a = {1, 3, 5, 0, 0, 0};
        int[] b = {2, 4, 6};
        merge(a, 6, b, 3);
    }
}
