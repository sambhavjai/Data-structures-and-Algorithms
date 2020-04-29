public class array_product{
    // Find the product of array except the current element for each element without using division operator
    public static int[] func(int arr[])
    {
        int ans[]=new int[arr.length];
        ans[0]=1;
        for(int i=1;i<ans.length;i++)
        {
            ans[i]=ans[i-1]*arr[i-1]; // Each cell contains the product of all the elements towards its left
        }
        int r=1; // Storing the product of all the elements towards right of each element
        for(int i=arr.length-1;i>=0;i--)
        {
            ans[i]=ans[i]*r; // multiplying the product towards left with product towards right will give us the desired product
            r=r*arr[i]; // update r for the next element
        }
        return ans;
    }
    public static void main(String args[])
    {
        int arr[]={1,2,3,4};
        int ans[]=func(arr);
        for(int i=0;i<ans.length;i++)
        {
            System.out.print(ans[i]+" ");
        }
        System.out.println();
    }
}