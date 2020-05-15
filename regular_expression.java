public class regular_expression{
    // Find if the given string matches the regular expression
    // * allows repetition of the preceding character zero or more times
    // . allows with matching of any character
    public static boolean func(String s,String p)
    {
        // each cell represents whether the string upto current cell matches with pattern upto current idx
        boolean dp[][]=new boolean[s.length()+1][p.length()+1];
        dp[s.length()][p.length()]=true; // when both are null
        // last column will be by default false as it represents pattern being null and tring being not null
        for(int i=s.length();i>=0;i--)
        {
            for(int j=p.length()-1;j>=0;j--)
            {
                boolean first=false;
                if(i<s.length()&&(s.charAt(i)==p.charAt(j)||p.charAt(j)=='.'))
                first=true; // matching for the current character or the current character being . and string not being null
                // this matching is necessary because * only works for repetition of the previous character
                if(j+1<p.length()&&p.charAt(j+1)=='*')
                dp[i][j]=dp[i][j+2]||(first&&dp[i+1][j]); //  if the next character in pattern is * after the current char then either 
                // it will be left considering empty string (dp[i][j+2] we skip the 2 characters,i.e., * and preceding character)
                // or it will be taken into consideration only when the first character matches and answer will be taken from same pattern but next character of string to justify for repetiton of the first matched character
                else
                dp[i][j]=first&&dp[i+1][j+1]; // else if only the current character matches then remove 1 char from string and pattern each and store the answer
            }
        }
        return dp[0][0];
    }
    public static void main(String args[])
    {
        String s="aab";
        String p="c*a*b";
        System.out.println(func(s,p));
    }
}