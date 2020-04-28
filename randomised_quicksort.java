public class randomised_quicksort{
    // Find the kth largest element in the array
    public static void swap(int arr[],int a,int b)
    {
        int temp=arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
    }
    public static int sort(int arr[],int start,int end,int pivotIdx)
    {
        swap(arr,pivotIdx,end); // shift the pivot element at the end of array
        pivotIdx=start; // assume pivot element to be placed at the start
        for(int i=start;i<=end;i++)
        {
            if(arr[i]<arr[end])
            {
                swap(arr,pivotIdx,i); // if an element is found smaller than pivot swap the element with the pivot position 
                pivotIdx++;           // and shift the pivot position
            }
        }
        swap(arr,pivotIdx,end); // place the pivot element at the actual desired position
        return pivotIdx;
    }
    // We perform quicksort and find the correct position for each element and stop when we get the element for desired position
    public static int func(int arr[],int k,int start,int end)
    {
        int pivotIdx=start+(end-start)/2; // Assume pivot at the middle element of the array
        pivotIdx=sort(arr,start,end,pivotIdx); // get the pivot position in the sorted array
        if(pivotIdx==k) // if answer is found return it
        return arr[pivotIdx];
        else if(pivotIdx<k) // it k is at right of the pivot element call only at the right
        return func(arr,k,pivotIdx+1,end);
        else
        return func(arr,k,start,pivotIdx-1); // else call only at the left
    }
    public static void main(String args[])
    {
        int arr[]={3,2,1,5,6,4};
        int k=2;
        System.out.println(func(arr,arr.length-k,0,arr.length-1));
    }
}