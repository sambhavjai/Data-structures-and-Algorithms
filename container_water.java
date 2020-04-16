// Given an array representing heights in a container. Calculate the max area the container can hold
public class container_water{
    public static int func(int arr[])
    {
        int max=0;
        int i=0,j=arr.length-1;// Use 2 pointers
        while(i<j) // Shift the pointer with the smaller side
        {          // We reject all the other combinations with the smaller side and the other pointer as the other pointer will be either
            if(arr[i]<arr[j]) // large then the area will be reduced or it will be smaller in which case also the area will be reduced due
            {                // to decreasing distance and smaller partition. 
                int area=arr[i]*(j-i);
                if(area>max)
                max=area;
                i++;
            }
            else
            {
                int area=arr[j]*(j-i);
                if(area>max)
                max=area;
                j--;
            }
        }
        return max;
    }
    public static void main(String args[])
    {
        int arr[]={1,8,6,2,5,4,8,3,7};
        System.out.println(func(arr));
    }
}