// Fisher Yates algorithm for finding random permutations of an array in o(n) time
// The function should any permutation of the array given all permutations must be equally likely
import java.util.*;
public class fisher_yate{
    public static class shuffle{
        int original[];
        int arr[];
        public shuffle(int arr[])
        {
            original=arr.clone();
            this.arr=arr;
        }
        public int[] reset()
        {
            int ans[]=original;
            original=original.clone();
            return ans;
        }
        public int[] permute()
        {
            // We select a random number between current idx and arr.size then swap the current idx and the random idx generated
            // this will ensure the taking out of hat algorithm for randomness as we are removing the current element selected from the scope by swapping it
            Random rand=new Random();
            for(int i=0;i<arr.length;i++)
            {
                int idx=rand.nextInt(arr.length-i)+i;
                int temp=arr[idx];
                arr[idx]=arr[i];
                arr[i]=temp;
            }
            return arr;
        }
    }
    public static void main(String args[])
    {
        int arr[]={1,2,3};
        shuffle obj=new shuffle(arr);
        int ans[]=obj.permute();
        for(int i=0;i<ans.length;i++)
        {
            System.out.print(ans[i]+" ");
        }
        System.out.println();
        ans=obj.reset();
        for(int i=0;i<ans.length;i++)
        {
            System.out.print(ans[i]+" ");
        }
        System.out.println();
        ans=obj.permute();
        for(int i=0;i<ans.length;i++)
        {
            System.out.print(ans[i]+" ");
        }
        System.out.println();
        ans=obj.permute();
        for(int i=0;i<ans.length;i++)
        {
            System.out.print(ans[i]+" ");
        }
        System.out.println();
    }
}