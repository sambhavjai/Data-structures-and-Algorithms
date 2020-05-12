import java.util.*;
public class max_points_line{
    // Given an array of coordinates return how many points of the given array lie in a straight line
    public static int _gcd(int a,int b)
    {
        if(b==0)
        return a;
        return _gcd(b,a%b);
    }
    public static int func(int points[][])
    {
        int ans=0;
        HashMap<String,Integer> map=new HashMap<>(); // We calculate the slope of points and store the number of occurences for that slope in a hashmap
        for(int i=0;i<points.length;i++)
        {
            int vertical=0; // count for storing number of vertical points
            int same=0; // count for storing number of overlapping points
            int smallans=0; // for soting max count for current slope
            for(int j=i+1;j<points.length;j++)
            {
                if(points[i][0]==points[j][0]&&points[i][1]==points[j][1])
                {
                    same++;
                }
                else{
                    int x_diff=points[j][0]-points[i][0];
                    int y_diff=points[j][1]-points[i][1];
                    if(x_diff==0)
                    vertical++;
                    else
                    {
                        int gcd=_gcd(x_diff,y_diff); // due to precision errors instead of storing the slops we store the x_diff and y_diff values reduced by their gcd
                        x_diff=x_diff/gcd;
                        y_diff=y_diff/gcd;
                        String temp=x_diff+"@"+y_diff;
                        map.put(temp,map.getOrDefault(temp,0)+1);
                        smallans=Math.max(smallans,map.get(temp)+1); // +1 for the current ith coordinate we are working with
                    }
                }
            }
            ans=Math.max(ans,Math.max(vertical,smallans)+same); // we take max with current answer 
            map.clear();
        }
        return ans;
    }
    public static void main(String args[])
    {
        int points[][]={{1,1},{3,2},{5,3},{4,1},{2,3},{1,4}};
        //int points[][]={{0,0},{1,1},{0,0}};
        System.out.println(func(points));
    }
}