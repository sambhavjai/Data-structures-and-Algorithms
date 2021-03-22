public class min_steps_reach_end {
    // Calculate the min number of steps required to reach the end of the array
    // Greedy approach
    // maxReach represents the max index we can reach from the current index
    // steps represent the number of steps we can use
    // jumps is the number of jumps we took
    public static int func(int arr[])
    {
        if(arr.length<=1)
        return 0;
        if(arr[0]==0)
        return -1;
        int maxReach = arr[0];
        int steps=arr[0];
        int jump=1;
        for(int i=1;i<arr.length;i++)
        {
            if(i==arr.length-1) // we have reached the end
            return jump;
            maxReach=Math.max(maxReach,arr[i]+i); // calculate the max reach
            steps--; // decrease because we used a step in reaching the current index
            if(steps==0)
            {
                jump++; // if no more steps are left we must have taken a jump
                if(i>=maxReach) // no possible solution
                return -1;
                steps=maxReach-i; // reinitialize the steps remaining which will be the max index we can reach - current index
            }
        }
        return -1;
    }
    public static void main(String args[])
    {
        int arr[]={1,3,5,8,9,2,6,7,6,8,9};
        System.out.println(func(arr));
    }
}