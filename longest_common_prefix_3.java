public class longest_common_prefix_3{
    // We use binary search in this approach; complexity : O(sum of all characters in the array*log(no. of strings))
    public static boolean isCommonPrefix(String arr[],int len)
    {
        String prefix=arr[0].substring(0,len);
        for(int i=1;i<arr.length;i++)
        {
            if(!arr[i].startsWith(prefix)) // if any string doesnot have a prefix of middle length common with other strings return false
            return false;
        }
        return true;
    }
    public static String func(String arr[])
    {
        int min=Integer.MAX_VALUE;
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i].length()<min)
            min=arr[i].length();
        } // FInd the minimum length string in the array lcp length cannot be greater than the min length
        int low=1;int high=min;
        while(low<=high)
        {
            int middle=(low+high)/2;
            if(isCommonPrefix(arr,middle)) // check if there is a common prefix of length middle
            low=middle+1; // if there is a common prefix then the ans could be greater and low should be moved after middle
            else
            high=middle-1; // if there is no common prefix then ans will be smaller than middle length so high will be before middle
        }
        return arr[0].substring(0,high); // ans will be substing of any string till high value
    }
    public static void main(String args[])
    {
        String arr[]={"flower","flue","flute"};
        System.out.println(func(arr));
    }
    }