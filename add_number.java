public class add_number{
    // Add the given 2 numbers without using + or - operators
    public static int func(int a,int b)
    { // we use bitwise adding
        while(b!=0) // till carry is not equal to 0
        {
            int c=a&b; // when shifted by 1 to left it contains the carry value as it gives all set bits
                       // carry will be constituted by all the bits which are set in both the numbers 
            a=a^b; // it gives all bits as 1 which are different
                   // it adds all the bits which are 0 and 1 and result in 1 after addtition with the carry
            b=c<<1; // storing carry in b
        }
        return a;
    }
    public static void main(String args[])
    {
        int a=2;
        int b=3;
        System.out.println(func(a,b));
    }
}