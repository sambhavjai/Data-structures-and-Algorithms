public class longest_increasing_path_matrix{
    // find the length of longest increasing path in a matrix
    // We use dp in a dfs to calculate the answer
    // we start dfs from each cell of the matrix as the path can start from each cell of the matrix
    public static int dfs(int mat[][],int i,int j,int dp[][])
    {
        if(dp[i][j]!=0)
        return dp[i][j];
        int max=0;
        if(i+1<mat.length&&mat[i+1][j]>mat[i][j]) // if increasing then call on next
        max=Math.max(max,dfs(mat,i+1,j,dp));
        if(j+1<mat[0].length&&mat[i][j+1]>mat[i][j])
        max=Math.max(max,dfs(mat,i,j+1,dp));
        if(i-1>=0&&mat[i-1][j]>mat[i][j])
        max=Math.max(max,dfs(mat,i-1,j,dp));
        if(j-1>=0&&mat[i][j-1]>mat[i][j])
        max=Math.max(max,dfs(mat,i,j-1,dp));
        dp[i][j]=max+1; // answer will be max of all the increasing sides+1 
        return dp[i][j];
    }
    public static int func(int mat[][])
    {
        if(mat.length==0||mat[0].length==0)
        return 0;
        int dp[][]=new int[mat.length][mat[0].length];
        int ans=0;
        for(int i=0;i<mat.length;i++)
        {
            for(int j=0;j<mat[0].length;j++)
            {
                ans=Math.max(ans,dfs(mat,i,j,dp));
            }
        }
        return ans;
    }
    public static void main(String args[])
    {
        int mat[][]={{3,4,5},
                     {3,2,6},
                     {2,2,1}};
        System.out.println(func(mat));
    }
}