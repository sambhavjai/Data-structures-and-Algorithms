import java.util.*;
public class permutation{
    // Find all the permutations of objects in the given array
    public static List<List<Integer>> ans=new ArrayList<>();
    public static void func(int arr[],int cl,boolean valid[],List<Integer> temp)
    {
        if(cl==arr.length) // if the current level becomes equal to max then add answer
        {
            List<Integer> base=new ArrayList<>(temp);
            ans.add(base);
            return;
        }
        for(int i=0;i<arr.length;i++)
        {
            if(valid[i]==false) // if the object is not chosen choose it and make the call then remove it before the next call
            {
                valid[i]=true;
                temp.add(arr[i]);
                func(arr,cl+1,valid,temp);
                temp.remove(temp.size()-1);
                valid[i]=false;
            }
        }
    }
    public static void main(String args[])
    {
        int arr[]={1,2,3};
        boolean valid[]=new boolean[arr.length];
        List<Integer> temp=new ArrayList<>();
        func(arr,0,valid,temp);
        System.out.println(ans);
    }
}