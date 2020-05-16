public class find_missing_positive{
    // Given an array of integers find the first missing positive integer
    public static int func(int arr[])
    {
        // here we put the element i and its correct position i in the array,i.e., index i-1
        // we first store the value present at i-1 idx in next then store i at i-1 then repeat the same for next
        // we stop only at 3 conditions, either we get a negative number or we get a number no in the range for 1-n or we reach a number which is correctly stored,i.e., arr[i-1] = i
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]<=0||arr[i]>arr.length)  // simply ignore the 2 values
            continue;
            int val=arr[i]; // if we reach here it means arr[i] lies between 1 to n
            while(arr[val-1]!=val) // while we do not get a desired value
            {
                int next=arr[val-1]; // save the next value
                arr[val-1]=val; // store at correct position
                val=next; // assign for repiting the process for next val
                if(val<=0||val>arr.length) // if unfavourable conditions occur then break
                break;
            }
        }
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]!=i+1) // if an idx does not mathces the required condition then it is the missing number
            return i+1;
        }
        return arr.length+1; // if none number is missing from 1 to n then the next positive missing number will be n+1
    }
    public static void main(String args[])
    {
        int arr[]={3,4,-1,1};
        System.out.println(func(arr));
    }
}