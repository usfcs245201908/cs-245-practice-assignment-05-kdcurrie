public class MergeSort implements SortingAlgorithm{
    @Override
    public void sort(int[] a) {
        int left = 0;
        int right = a.length-1;
        mergeSort(a, left, right);
    }
    void mergeSort(int[] a, int left, int right) {
        if (left < right) {
            int middle = (left+right)/2;
            mergeSort(a,left,middle);
            mergeSort(a,middle+1,right);
            merge_arrays(a,left,middle,right);
        }
    }

    void merge_arrays(int[] a, int left, int middle, int right) {
        int left_a = middle-left+1; //finds sizes of the two subarrays to be merged
        int right_a = right-middle;
        int left_temp[] = new int[left_a]; //creates new temp arrays
        int right_temp[] = new int[right_a];

        for (int i = 0; i<left_a; i++) { //copies data from array to left temp array
            left_temp[i] = a[left+i];
        }
        for (int j = 0; j<right_a; j++) {
            right_temp[j] = a[middle + 1 + j];
        }

        int x = 0, y = 0;
        int z = left;

        while(x < left_a && y < right_a) {
            if (left_temp[x]<=right_temp[y]) {
                a[z] = left_temp[x];
                x++;
            }
            else {
                a[z] = right_temp[y];
                y++;
            }
            z++;
        }

        while (x < left_a) {
            a[z] = left_temp[x];
            x++;
            z++;
        }

        while (y < right_a) {
            a[z] = right_temp[y];
            y++;
            z++;
        }
    }
}
