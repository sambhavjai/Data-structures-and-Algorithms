public class jump_game{
    // each idx contains the number of steps we can take from that index 
    // return if we can reach the last idx of the array or not
    // we can do this easily using dp (top-down or bottom-up approach)
    // here we have used greedy approach
    public static boolean func(int arr[])
    {
        int lastpos=arr.length-1;// the last idx found from where we can reach the end
        for(int i=arr.length-1;i>=0;i--)
        {
            if(i+arr[i]>=lastpos) // if we can reach the last satisfying idx from current idx then this idx becomes the last satisfying idx
            lastpos=i;
        }
        return lastpos==0; // if last satisfying position becomes the starting idx then we have reached the answer 
    }
    public static void main(String args[])
    {
        int arr[]={2,3,1,1,4};
        System.out.println(func(arr));
    }
}