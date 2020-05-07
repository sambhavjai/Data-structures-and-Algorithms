public class buy_sell_stocks_1{
    // Find the max profit if we are able to buy and sell the stock only once 
    public static int func(int arr[])
    {
        int min_price=Integer.MAX_VALUE;
        int max_profit=0;
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]<min_price) // we keep track of the min_price till date to buy the stock at the min_price
            min_price=arr[i];
            if(arr[i]-min_price>max_profit) // we calculate the profit for the day by selling the stock at current price and updating the max profit possible
            max_profit=arr[i]-min_price;
        }
        return max_profit;
    }
    public static void main(String args[])
    {
        int arr[]={7,1,5,3,6,4};
        System.out.println(func(arr));
    }
}