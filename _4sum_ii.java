// Find the number of tuples in 4 lists a[],b[],c[],d[] such that a[i]+b[j]+c[k]+d[l]=sum;
import java.util.*;
public class _4sum_ii{
    public static int func(int a[],int b[],int c[],int d[],int total)
    {
        // We take the first 2 lists and add their sums' frequency in the hashmap
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<a.length;i++)
        {
            for(int j=0;j<b.length;j++)
            {
                int sum=a[i]+b[j];
                map.put(sum,map.getOrDefault(sum,0)+1);
            }
        }
        // we check if the sum of next 2 lists is the desired remaining sum or not then increase the count
        int count=0;
        for(int i=0;i<c.length;i++)
        {
            for(int j=0;j<d.length;j++)
            {
                int sum=total-(c[i]+d[i]);
                if(map.containsKey(sum))
                {
                    count=count+map.get(sum);
                }
            }
        }
        return count;
    }
    public static void main(String args[])
    {
        int a[]={1,2};
        int b[]={-2,-1};
        int c[]={-1,2};
        int d[]={0,2};
        int sum=0;
        System.out.println(func(a,b,c,d,sum));
    }
}