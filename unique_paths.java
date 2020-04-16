// Find the number of unique paths from 0,0 to row-1,col-1 in row x col matrix
// We use memoisation
public class unique_paths{
    public static int func(int row,int col,int dp[][])
    {
        // Each cell of dp[][] represents the number of unique paths from that cell to the origin
        if(dp[row-1][col-1]!=0)
        return dp[row-1][col-1];
        if(row==1&&col==1)
        {
            dp[row-1][col-1]=1; // if we reach the origin cell then there is only 1 path from there that is the cell itself
            return dp[row-1][col-1];
        }
        int up=0,left=0;
        if(row-1>=1)
        up=func(row-1,col,dp);
        if(col-1>=1)
        left=func(row,col-1,dp);
        dp[row-1][col-1]=up+left; // total number of paths will be up + left
        return dp[row-1][col-1];
    }
    public static void main(String args[])
    {
        int row=3;
        int col=7;
        int dp[][]=new int[row][col];
        System.out.println(func(row,col,dp));
    }
}