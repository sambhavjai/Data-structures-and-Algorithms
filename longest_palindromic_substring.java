public class longest_palindromic_substring{
    // Find the longest palindromic substring in the given string
    // move in gap
    // base cases : g=0 (only 1 character) all are palindromes
    //              g=1 (only 2 characters) true only if both chars are same
    // if char is same check for diagonal box,i.e., remove the same chars present at the start and end of the given substring
    // if diagonal is true this will be true
    // if chars are not same then it cannot be a palindrome
    // index at which the last true occurs is the length of the longest palindrome
    public static String func(String s)
    {
        if(s.length()==0)
        return "";
        boolean dp[][]=new boolean[s.length()][s.length()];
        int ans_i=0,ans_j=0;
        for(int g=0;g<s.length();g++)
        {
            for(int i=0,j=i+g;j<s.length();j++,i++)
            {
                if(g==0)
                {
                    dp[i][j]=true;
                    ans_i=i;
                    ans_j=j;
                }
                else if(g==1)
                {
                    if(s.charAt(i)==s.charAt(j))
                    {
                        dp[i][j]=true;
                        ans_i=i;
                        ans_j=j;
                    }
                }
                else
                {
                    if(s.charAt(i)==s.charAt(j))
                    {
                        if(dp[i+1][j-1]==true)
                        {
                            dp[i][j]=true;
                            ans_i=i;
                            ans_j=j;
                        }
                    }
                }
            }
        }
        return s.substring(ans_i,ans_j+1);
    }
    public static void main(String args[])
    {
        String s="cbbd";
        System.out.println(func(s));
    }
}