public class kmp{
    public static void compute_lps(String pat,int lps[])
    {
        lps[0]=0;
        int i=1;
        int len=0;
        while(i<pat.length())
        {
            if(pat.charAt(i)==pat.charAt(len))
            {
                len++;
                lps[i]=len;
                i++;
            }
            else
            {
                if(len!=0)
                {
                    len=lps[len-1];
                }
                else
                {
                    lps[i]=len;
                    i++;
                }
            }
        }
    }
    // lps=longest prefix which is also a suffix
    public static void func(String txt,String pat)
    {
        int m=pat.length();
        int n=txt.length();
        int i=0;
        int j=0;
        int lps[]=new int[m];
        compute_lps(pat,lps);
        while(i<n)
        {
            if(txt.charAt(i)==pat.charAt(j))
            {
                i++;
                j++;
            }
            if(j==m)
            {
                System.out.println("Found at index "+(i-j));
                j=lps[j-1];
            }
            else if(i<n&&txt.charAt(i)!=pat.charAt(j))
            {
                if(j!=0)
                {
                    j=lps[j-1];
                }
                else
                {
                    i++;
                }
            }
        }
    }
    public static void main(String args[])
    {
        String txt="abbaaaaabbbbbbbabbcdcdabb";
        String pat="abb";
        func(txt,pat);
    }
}