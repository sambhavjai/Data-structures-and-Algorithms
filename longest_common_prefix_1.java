public class longest_common_prefix_1{
    // Find the longest common prefix among the string array
    // We use horizontal scannning; complexity : o(sum of all characters in the string array)
    public static String func(String arr[])
    {
        if(arr.length==0)
        return "";
        String prefix=arr[0]; // assume the first string to be prefix
        for(int i=1;i<arr.length;i++) // traverse in the remaining array
        {
            while(arr[i].indexOf(prefix)!=0) // reduce the length of prefix by 1 each time we find that the prefix is not the starting of next string
            {
                prefix=prefix.substring(0,prefix.length()-1);
                if(prefix.length()==0) // while reducing if the length becomes 0 it means no common prefix exists between strings 
                return "";
            }
        }
        return prefix;
    }
    public static void main(String args[])
    {
        String strs[]={"flower","flow","flight"};
        System.out.println(func(strs));
    }
}