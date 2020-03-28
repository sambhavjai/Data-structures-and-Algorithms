//Find the increasing subsequence triplet (arr[i]<arr[j]<arr[k] i<j<k) in o(n) time and o(1) space
/* 
we find the smallest element in the array and store it in small
if a larger element then small is found then it becomes middle
if the element in hand is even larger than middle then we break and the sequence is complete as small+middle+arr[i]
if no larger element is ever found in the process and we reach the end of array then no such element exists
*/
public class increasing_triplet_subseq{
    public static String func(int arr[])
    {
        int small=Integer.MAX_VALUE;
        int middle=Integer.MAX_VALUE;
        int i=0;
        for(i=0;i<arr.length;i++)
        {
            if(arr[i]<=small)
            small=arr[i];
            else if(arr[i]<=middle)
            middle=arr[i];
            else
            break;
        }
        if(i==arr.length)
        return "No element found";
        for(int j=0;j<i;j++)  // we readjust small we might get displaced in the process by selecting an element smaller
        {                     // than middle but on the left of larger element always
            if(arr[j]<middle)
            small=arr[j];
        }
        return ""+small+" "+middle+" "+arr[i];
    }
    public static void main(String args[])
    {
        int arr[]={1,2,3,4,5};
        System.out.println(func(arr));
    }
}