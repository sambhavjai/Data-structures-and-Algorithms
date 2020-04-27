// FInd the kth smallest element in a row-wise and column-wise sorted element
import java.util.*;
public class kth_element_in_matrix{
    public static class pair{
        int val;
        int row;
        int col;
        public pair(int val,int row,int col)
        {
            this.val=val;
            this.row=row;
            this.col=col;
        }
    }
    public static class pairComparator implements Comparator<pair>
    {
        public int compare(pair a,pair b)
        {
            return a.val-b.val;
        }
    }
    public static int func(int mat[][],int k)
    {
        // Since the elements are sorted row-wise and column-wise
        // Add all elements from the first row in the priority queue
        // Remove the first k elements and after removing each element add back the next element in the same column
        // We are kicking out the next smaller each time and adding the element bigger than it from the same list in the competition
        // Just like merging 4 sorted lists and stopping when we get the kth element
        PriorityQueue<pair> pq=new PriorityQueue<>(new pairComparator()); 
        for(int i=0;i<mat[0].length;i++)
        {
            pq.add(new pair(mat[0][i],0,i));
        }
        pair ans=null;
        while(k>0)
        {
            ans=pq.remove();
            if(ans.row+1<mat.length)
            pq.add(new pair(mat[ans.row+1][ans.col],ans.row+1,ans.col));
            k--;
        }
        return ans.val;
    }
    public static void main(String args[])
    {
        int mat[][]={{1,5,9},
                     {10,11,13},
                     {12,13,15}};
        int k=8;
        System.out.println(func(mat,k));
    }
}
