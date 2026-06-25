public class Main {

    public static int[] union(int[] arr1, int[] arr2) {

        int[] result = new int[arr1.length + arr2.length];
        int k = 0;

        int i = 0;
        int j = 0;

        while (i < arr1.length && j < arr2.length) {

            if (arr1[i] < arr2[j]) {
                if (k == 0 || result[k - 1] != arr1[i]) {
                    result[k++] = arr1[i];
                }
                i++;
            }
            else if (arr1[i] > arr2[j]) {
                if (k == 0 || result[k - 1] != arr2[j]) {
                    result[k++] = arr2[j];
                }
                j++;
            }
            else {
                if (k == 0 || result[k - 1] != arr1[i]) {
                    result[k++] = arr1[i];
                }
                i++;
                j++;
            }
        }

        while (i < arr1.length) {
            if (k == 0 || result[k - 1] != arr1[i]) {
                result[k++] = arr1[i];
            }
            i++;
        }

        while (j < arr2.length) {
            if (k == 0 || result[k - 1] != arr2[j]) {
                result[k++] = arr2[j];
            }
            j++;
        }

        return java.util.Arrays.copyOf(result, k);
    }

    public static void main(String[] args) {
        int[] arr1 = {1,2,4};
        int[] arr2 = {2,3,4};

        int[] ans = union(arr1, arr2);

        for (int x : ans)
            System.out.print(x + " ");
    }
}
