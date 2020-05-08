public class buy_sell_stocks_2{
    // Find the max profit possible with infinte transactions
    // We can buy and sell any number of times but we must sell current stock before buying the next one
    public static int func(int arr[])
    {
        int ans=0;
        for(int i=0;i<arr.length-1;i++)
        {
            if(arr[i+1]>arr[i]) // whenever there is an increase in price at next day buy at the current day then sell at the next day
            ans=ans+arr[i+1]-arr[i];
        }
        return ans;
    }
    public static void main(String args[])
    {
        int arr[]={7,1,5,3,6,4};
        System.out.println(func(arr));
    }
}
