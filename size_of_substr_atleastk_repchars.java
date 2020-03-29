//Find the length of strength with atleast k repeating characters
//First we make the frequency map
//find the breakpoints (characters with freq less than k) and use recursion for the strings without breakpoints
public class size_of_substr_atleastk_repchars{
    public static int func(String s,int k)
    {
        if(s.length()<k)
        return 0;  //not sufficient characters present
        if(k<1)
        return 0;
        if(k==1)
        return s.length();
        int map[]=new int[26];
        int count=0;
        for(int i=0;i<s.length();i++)
        {
            int t=++map[s.charAt(i)-'a'];
            if(t==1)
            count++;
            if(t==k)
            count--;
        }
        if(count==0)
        return s.length(); // all the characters are present atleast k times
        int ans=Integer.MIN_VALUE;
        String temp=""; // store substring present between breakpoints
        for(int i=0;i<s.length();i++)
        {
            if(map[s.charAt(i)-'a']<k) // breakpoint achieved
            {
                ans=Math.max(ans,func(temp,k));
                temp="";
            }
            else
            temp=temp+s.charAt(i);
        }
        ans=Math.max(ans,func(temp,k)); // checking for the last substring after the last breakpoint
        return ans;
    }
    public static void main(String args[])
    {
        String s="aababc";
        int k=2;
        System.out.println(func(s,k));
    }
}