public class factorial_zeroes{
    // Find the number of trailing zeroes in factorial of n
    // 0s can only be generated in factorial by primes of 5s and 2s
    // if we count the number of 5s and 2s in n we can get the number of 0s
    // since no of 2s is always greater than or equal to no of 5s so we can only count the no of 5s
    public static int func(int n)
    {
        // first we start by dividing by 5 then an extra 5 will be generated by 25 so we divide by 25 and so on...
        int count=0;
        while(n>=5)
        {
            count=count+n/5;
            n=n/5; // instead of increasing the denominator we decrease the numerator
        }
        return count;
    }
    public static void main(String args[])
    {
        int n=5;
        System.out.println(func(n));
    }
}