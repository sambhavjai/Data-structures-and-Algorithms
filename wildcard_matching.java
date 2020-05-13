public class wildcard_matching{
    // Given a pattern in string p tell if string s satisfies the pattern or not
    public static boolean func(String s,String p)
    {
        // We use dp
        // the rows represent the string + 1 extra for string being null
        // the columns represent the pattern +1 extra for pattern being null
        // cell i,j represents whether string of length i matches pattern upto length j
        boolean dp[][]=new boolean[s.length()+1][p.length()+1];
        dp[0][0]=true; // if both are null then ans is true
        for(int i=1;i<dp.length;i++)
        {
            dp[i][0]=false; // if pattern is null then any string is false
        }
        for(int i=1;i<dp[0].length;i++)
        {
            if(p.charAt(i-1)=='*')
            {
                dp[0][i]=dp[0][i-1]; // if string is null then pattern is true only if it is * or sequence of *
            }
            else
            {
                dp[0][i]=false;
            }
        }
        for(int i=1;i<dp.length;i++)
        {
            for(int j=1;j<dp[0].length;j++)
            {
                if(p.charAt(j-1)=='*')
                {
                    dp[i][j]=dp[i-1][j]||dp[i][j-1]; // if we have a * then 2 choices occur whether we leave the * (string is empty at the point) or we match the star with the current character
                }// dp[i-1][j] means we leave the * out of the pattern and dp[i][j-1] means we have matched it
                 // so whatever option satisfies our answer becomes our answer
                else if(p.charAt(j-1)=='?')
                {
                    dp[i][j]=dp[i-1][j-1]; // if it is a question mark we always match it with current char and store the same answer as by removing 1 char from string and pattern each
                }
                else if(p.charAt(j-1)==s.charAt(i-1))
                {
                    dp[i][j]=dp[i-1][j-1]; // if the characters in the string and pattern match we remove them and store the answer
                }
                else
                {
                    dp[i][j]=false; // if none matches then it is false
                }
            }
        }
        return dp[dp.length-1][dp[0].length-1];
    }
    public static void main(String args[])
    {
        String s="accb";
        String p="a*c?b";
        System.out.println(func(s,p));
    }
}