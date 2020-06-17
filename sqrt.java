public class sqrt{
    // Find the floor of sqrt of the given number
    // y = x^1/2;
    // log10 y = 1/2 log10 x
    // y=10^(1/2 log10 x)
    public static int func(int x)
    {
        double z=Math.log10(x)/2.0;
        return (int)(Math.pow(10,z));
    }
    public static void main(String args[])
    {
        int x=8;
        System.out.println(func(x));
    }
}