import java.util.Arrays;

public class MergeSort {
   public void Sort(int [] arr, int lb, int ub){
    if(lb<ub){
        int mid= lb+(ub-lb)/2;
        Sort(arr, lb, mid);
        Sort(arr, mid+1, ub);
        Merge(arr,lb,mid,ub);
    }
   }

public void Merge(int [] arr,int lb,int mid,int ub){
    //copying the arra into temp array
    int [] temp= new int[arr.length];
    for(int i=0;i<arr.length;i++){
        temp[i]=arr[i];
    }
    int i =lb;
    int j=mid+1;
    int k=lb;
    while(i<=mid && j<=ub){

        if(temp[i]<temp[j]){
            arr[k]=temp[i];
            i++;
        }
        else{
            arr[k]=temp[j];
            j++;
        }
        k++;
    }

    if(i>mid && j<=ub){
        while(j<=ub){
            arr[k]=temp[j];
            j++;
            k++;
        }
    }
    else{
        while(i<=mid){
        arr[k]=temp[i];
        i++;
        k++;
    }}

}
    
public static void main(String[] args) {
    int [] nums={2,1,4,267,33,12,67,232,423,1,67,23};
    MergeSort ms= new MergeSort();
    ms.Sort(nums, 0, nums.length-1);
    System.out.println(Arrays.toString(nums));
}
    
}
