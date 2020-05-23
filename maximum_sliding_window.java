import java.util.*;
public class maximum_sliding_window{
    // Calculate the max element in a sliding window of size k
    public static List<Integer> func(int arr[],int k)
    {
        // first calculate the nge array for the given array
        // here each nge means the last index in the array till which the current element is the largest starting from the current index
        // that is for each element idx of nge-1
        // then traverse each window and check if the nge of current element lies outside the window or not
        // if its nge lies outside it means it is the max in current window
        // else check for the next element
        // if nge of no element lies outside the window it means that the rightmost element of the window will be the max 
        Stack<Integer> st=new Stack<>();
        int nge[]=new int[arr.length];
        for(int i=arr.length-1;i>=0;i--) // calculating nge
        {
            while(!st.empty()&&arr[st.peek()]<=arr[i])
            {
                st.pop();
            }
            if(st.empty())
            nge[i]=arr.length-1;
            else
            nge[i]=st.peek()-1;
            st.push(i);
        }
        List<Integer> ans=new ArrayList<>();
        for(int i=0;i<=arr.length-k;i++)
        {
            int j=i;
            while(nge[j]<i+k-1) // checking nge idx for each element
            {
                j++;
            }
            ans.add(arr[j]);
        }
        return ans;
    }
    public static void main(String args[])
    {
        int arr[]={1,3,-1,-3,5,3,6,7};
        int k=3;
        System.out.println(func(arr,k));
    }
}