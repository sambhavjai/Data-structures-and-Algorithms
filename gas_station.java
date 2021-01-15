public class gas_station{
    // Gas array has the gas in units which is present at each index and cost array is the cost or gas required to move from that index to the next
    // The array can be traversed in a circular fashion. Return the starting index from where we can cover all the indices of the array.
    public static int func(int gas[],int cost[])
    {
        int start=-1;
        int sum=0;
        int total=0;
        int diff=0;
        for(int i=0;i<gas.length;i++)
        {
            diff=gas[i]-cost[i];
            sum=sum+diff; // Denotes the total gas left till now
            total=total+diff; // Denotes the total value of gas
            if(start==-1&&diff>=0)
            {
                start=i; // We havent found a start index yet so take the start index as the index with first diff >=0
            }
            else if(diff<0&&sum<0)
            {
                start=-1; // We cannot move further so current start index cannot be used discard it
                sum=0;
            }
        }
        return (total>=0)?start:-1; // Check if the array as a whole can be traversed or not
    }
    public static void main(String args[])
    {
        int gas[]={1,2,3,4,5};
        int cost[]={3,4,5,1,2};
        System.out.println(func(gas,cost));
    }
}