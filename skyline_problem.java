import java.util.*;
public class skyline_problem{
    // Given an array in form of coordinates of a building as left end, right end , height
    // calculate the skyline of the city with the start point of each horizontal line
    public static class pair{
        int left;
        int right;
        int height;
        public pair(int left,int right,int height)
        {
            this.left=left;
            this.right=right;
            this.height=height;
        }
    }
    public static class pairComparatorStart implements Comparator<pair>{
        public int compare(pair a,pair b)
        {
            if(a.left==b.left)
            return b.height-a.height;
            return a.left-b.left;
        }
    }
    public static class pairComparatorEnd implements Comparator<pair>{
        public int compare(pair a,pair b)
        {
            return a.right-b.right;
        }
    }
    public static List<List<Integer>> func(int buildings[][])
    {
        // we solve this as merging overlapping intervals
        // we sort the start array(left coordinates) and end array (right coordinates) separately
        // if the start coordinates of 2 buildings are same then we sort them using the height
        // larger height coordinate will be preferred for skyline
        pair start[]=new pair[buildings.length];
        pair end[]=new pair[buildings.length];
        for(int i=0;i<buildings.length;i++)
        {
            start[i]=new pair(buildings[i][0],buildings[i][1],buildings[i][2]);
            end[i]=new pair(buildings[i][0],buildings[i][1],buildings[i][2]);
        }
        Arrays.sort(start,new pairComparatorStart());
        Arrays.sort(end,new pairComparatorEnd());
        int i=0,j=0;
        List<List<Integer>> temp=new ArrayList<>();
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder()); // max heap
        // here we do the merge part
        while(i<buildings.length||j<buildings.length)
        {
            if(i<buildings.length&&start[i].left<=end[j].right) // if the current interval is overlapping with the existing
            {
                pq.add(start[i].height); // then add the height to heap and make a point as start coordinate,max height
                int h=(pq.size()==0)?0:pq.peek();
                temp.add(new ArrayList<>(Arrays.asList(start[i].left,h)));
                i++;
            }
            else
            { // else we an interval has ended so remove its height from the peak and add the point as end coordinate,max height
                pq.remove(end[j].height);
                int h=(pq.size()==0)?0:pq.peek();
                temp.add(new ArrayList<>(Arrays.asList(end[j].right,h)));
                j++;
            }
        }
        List<List<Integer>> ans=new ArrayList<>();
        int pre=0;
        // here we remove duplicacy,i.e,multiple points with same height will not be considered for skyline
        // end of the sequence will always be marked with the end point,0 to denote a sequence completion
        for(i=0;i<temp.size();i++)
        {
            if(temp.get(i).get(0)==end[end.length-1].right&&temp.get(i).get(1)!=0) // this is to remove a point from the answer with the left as end coordinate but height not being 0
            continue;
            if(temp.get(i).get(1)!=pre) // check with the previously added height;
            ans.add(temp.get(i));
            pre=temp.get(i).get(1); // update the previous variable
        }
        return ans;
    }
    public static void main(String args[])
    {
        int buildings[][]={{2,9,10},{3,7,15},{5,12,12},{15,20,10},{19,24,8}};
        System.out.println(func(buildings));
    }
}