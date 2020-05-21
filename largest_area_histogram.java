import java.util.*;
public class largest_area_histogram{
    // Find the largest area of rectangle in the given histogram
    public static int func(int arr[])
    {
        // we follow the left to right traversal approach for calculating the left boundary of each element 
        // the left boundary will be the smaller element towards its left
        // it will be always stored at the peek of stack
        // right boundary will be the element which is smaller than it and towards right
        // it will always be the element which has popped the current element
        Stack<Integer> st=new Stack<>();
        int max_area=0;
        for(int i=0;i<arr.length;i++)
        {
            while(!st.empty()&&arr[st.peek()]>arr[i])
            {
                int curr_idx=st.pop(); // we calculate the ans for the popped idx element
                int lb=(st.empty())?-1:st.peek();
                int rb=i;
                int curr_area=(rb-lb-1)*arr[curr_idx];
                max_area=Math.max(max_area,curr_area);
            }
            st.push(i);
        }
        while(!st.empty()) // if there are elements left in the stack it means they were never popped which means that there was no next smaller element present for them
        // so the next smaller element for them of the right boundary will be the length of the array
        {
            int curr_idx=st.pop();
            int lb=(st.empty())?-1:st.peek();
            int rb=arr.length;
            int curr_area=(rb-lb-1)*arr[curr_idx];
            max_area=Math.max(max_area,curr_area);
        }
        return max_area;
    }
    public static void main(String args[])
    {
        int arr[]={2,1,5,6,2,3};
        System.out.println(func(arr));
    }
}