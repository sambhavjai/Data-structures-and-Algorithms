public class rotate_array{
    public static int _gcd(int a,int b)
    {
        if(b==0)
        return a;
        return _gcd(b,a%b);
    }
    public static void rotate(int arr[],int k)
    {
        // Rotate the given array clockwise (towards right) by k steps
        int n=arr.length;
        k=k%n;
        int gcd=_gcd(n,k); // we divide the array into gcd(n,k) number sets and do rotation for each set indiviually
        for(int i=0;i<gcd;i++)
        {
            int start=n-1-i; // mark the last element as start index // for left rotation start = i
            int temp=arr[start];
            int j=start;
            while(true)
            { 
                int z=(j-k); // calculate the next idx where the current element will be placed (in jumps of k)
                if(z<0) // for left rotation jump will be positive z=(z+k)%n
                z=n+z;
                if(z==start) // if after jumping we reach the start again then the set is complete
                break;
                arr[j]=arr[z]; // swap the element and shift toward the next element
                j=z;
            }
            arr[j]=temp; // put the final element in place
        }
    }
    public static void main(String args[])
    {
        int arr[]={1,2,3,4,5,6,7};
        int k=3;
        rotate(arr,k);
        for(int i=0;i<arr.length;i++)
        {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
}