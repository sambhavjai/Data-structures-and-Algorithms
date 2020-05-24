public class trapping_rain_water{
    // Given heights of buildings in an array calculate how many units of rain water can be trapped
    // an element can trap rain water equal to the height of min(max height towards left,max height towards right)-self height
    public static int func(int arr[])
    {
        int max_left[]=new int[arr.length]; // calculate max height towards left for each element
        int max=0;
        for(int i=0;i<arr.length;i++)
        {
            max=Math.max(max,arr[i]);
            max_left[i]=max;
        }
        int max_right[]=new int[arr.length]; // calculate max height towards right for each element
        max=0;
        for(int i=arr.length-1;i>=0;i--)
        {
            max=Math.max(max,arr[i]);
            max_right[i]=max;
        }
        int ans=0;
        for(int i=0;i<arr.length;i++)
        {
            ans=ans+Math.min(max_left[i],max_right[i])-arr[i]; // calculate the answer
        }
        return ans;
    }
    public static void main(String args[])
    {
        int arr[]={0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(func(arr));
    }
}