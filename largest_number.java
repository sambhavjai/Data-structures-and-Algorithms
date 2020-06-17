import java.util.*;
public class largest_number{
    // Find the largest number which can be formed using the numbers in the given array
    // We add all the number to a max pq to find the correct order
    // Since 2 numbers have to compared digit wise so we create a custom comparator
    // we check for both the possible combinations between 2 strings
    // that is either of the string can come first
    // then we compare both the combinations and return the one forming the larger number
    public static class string_comparator implements Comparator<String>{
        public int compare(String a,String b)
        {
            String order1=a+b;
            String order2=b+a;
            return order1.compareTo(order2);
        }
    }
    public static String func(int arr[])
    {
        PriorityQueue<String> pq=new PriorityQueue<>(Collections.reverseOrder(new string_comparator()));
        for(int i=0;i<arr.length;i++)
        {
            pq.add(arr[i]+"");
        }
        String ans="";
        while(pq.size()>0&&pq.peek().equals("0")) // We check if the largest number possible is 0 (leading 0s)
        {                                         // possible in case of input given as all 0s
            pq.remove();
        }
        if(pq.size()==0) // if it is all 0s we return 0
        return "0";
        while(pq.size()>0)
        {
            ans=ans+pq.remove();
        }
        return ans;
    }
    public static void main(String args[])
    {
        int arr[]={3,30,34,5,9};
        System.out.println(func(arr));
    }
}