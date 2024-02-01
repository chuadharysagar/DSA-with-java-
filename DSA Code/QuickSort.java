import java.util.Arrays;

public class QuickSort {
    public void Sort(int [] arr, int low, int high){
        int s=low;
        int e=high;
        int m= s+(e-s);
        int pivot=arr[m];
        while(s<=e){
            while(arr[s]<pivot){
                s++;
            }
            while(arr[e]>pivot){
                e--;
            }

            if(s<e){
                int t= arr[s];
                arr[s]=arr[e];
                arr[e]=t;
            }
        }

        Sort(arr, low, e);
        Sort(arr, s, high);
    }


    public static void main(String[] args) {
        int [] nums={2,1,4,267,33,12,67,232,423,1,67,23};
        QuickSort qs= new QuickSort();
        qs.Sort(nums, 0, nums.length-1);
        System.out.println(Arrays.toString(nums));

    }
    
}
