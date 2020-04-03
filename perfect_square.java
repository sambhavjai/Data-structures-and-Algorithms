// Find the least number of perfect squares which sum up to a given a number n
// We use dp due to present of overlapping substructure
public class perfect_square{
    public static int func(int n)
    {
        if(n<=3)
        return n;  // Base case since no perfect square is present below 3 so only answer will be to add up 1 n times
        int dp[]=new int[n+1];
        dp[0]=0; // Base cases
        dp[1]=1;
        dp[2]=2;
        dp[3]=3;
        for(int i=4;i<=n;i++)
        {
            dp[i]=i; // Putting maximum possible as answer first (adding n 1s)
            for(int j=1;j<=i;j++)
            {
                if(j*j>i) // Testing for squares of all numbers before i
                break;
                else
                dp[i]=Math.min(dp[i],dp[i-j*j]+1);  // We substract the current square in test and check for the answer of the remaining number
            }                                       // We add 1 to include the current square we are substracting
        }
        return dp[n];
    }
    public static void main(String args[])
    {
        int n=12;
        System.out.println(func(n));
    }
}