import java.util.*;
public class next_greater_element{
    // Find the next greater element for each element in the array if no greater is present then return -1;
    public static int[] func(int arr[])
    {
        Stack<Integer> st=new Stack<>();
        int ans[]=new int[arr.length];
        for(int i=arr.length-1;i>=0;i--) // we traverse from right
        {
            // peek of stack will always have the idx of next greater element
            while(!st.empty()&&arr[st.peek()]<=arr[i]) // if the element at peek is smaller than pop
            {
                st.pop();
            }
            if(st.empty()) // if stack becomes empty it means no next greater element is present
            ans[i]=-1;
            else
            ans[i]=arr[st.peek()]; // else element is present at the peek
            st.push(i); // push the current element in stack
        }
        return ans;
    }
    // if we want to find the next greater element towards left of each element traverse the above loop from left to right
    // if we want to find the next smaller element towards right of each element change the condition for pop
   // if we want to find the next smaller element towards left of each element traverse the above loop from left to right and change the conditions for pop
   public static int[] func_2(int arr[])
   {
       // this function calculates the next greater element while traversing from left to right
        Stack<Integer> st=new Stack<>();
        int ans[]=new int[arr.length];
        for(int i=0;i<arr.length;i++)
        {
            // each element in stack has its nge below it
            while(!st.empty()&&arr[st.peek()]<arr[i]) // if we have smaller element at peek then pop it and find its answer
            {
                int curr_idx=st.pop();
                ans[curr_idx]=arr[i];
            }
            st.push(i);
        }
        while(!st.empty()) // all the remaining elements dont have a nge
        {
            int curr_idx=st.pop();
            ans[curr_idx]=-1;
        }
        return ans; 
   }
    public static void main(String args[])
    {
        int arr[]={1,2,3,4,5};
        int ans[]=func(arr);
        for(int i=0;i<ans.length;i++)
        {
            System.out.print(ans[i]+" ");
        }
        System.out.println();
        int ans2[]=func_2(arr);
        for(int i=0;i<ans2.length;i++)
        {
            System.out.print(ans2[i]+" ");
        }
        System.out.println();
        }
}