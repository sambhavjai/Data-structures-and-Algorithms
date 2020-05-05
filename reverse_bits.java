// reverse the bits of the given integer
public class reverse_bits{
    public static int func(int n)
    {
        int count= 32; // max no. of bits possible in the integer
        int ans=n;
        while(n!=0)
        {
            ans=ans<<1; // left shift the ans by 1 bit
            ans=(ans|(n&1)); // if the lsb of n is 1 then make the lsb of ans as 1
            n=n>>>1; // right shift n (unsigned shift) by 1
            count--; // decrease a bit shifted
        }
        ans=ans<<count; // for reversing bits remaining zeroes need to be added in the start in the start of the number count no. of times
        return ans;
    }
    public static void main(String args[])
    {
        int n=2;
        System.out.println(func(n));
    }
}