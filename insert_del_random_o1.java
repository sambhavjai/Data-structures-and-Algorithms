// Create a data structure that inserts, deletes and gets an random number in o(1) time
// In get_random each number should be equi-probable
import java.util.*;
public class insert_del_random_o1
{
    public static class data{
        ArrayList<Integer> arr;  // For storing the data
        HashMap<Integer,Integer> map;  // Value -> index pair
        public data()
        {
            arr=new ArrayList<Integer>();
            map=new HashMap<Integer,Integer>();
        }
        public boolean insert(int val)
        {
            if(map.containsKey(val))
            return false;
            arr.add(val);
            map.put(val,arr.size()-1);
            return true;
        }
        public boolean remove(int val)
        {
            if(!map.containsKey(val))
            return false;
            int idx=map.get(val);
            int last=arr.get(arr.size()-1); // put last value instead of the argument value and remove the last value
            arr.set(idx,last);
            map.put(last,idx);
            arr.remove(arr.size()-1);
            map.remove(val);
            return true;
        }
        public int get_random()
        {
            Random rand=new Random();
            int idx=rand.nextInt(arr.size());
            return arr.get(idx);
        }
    }
    public static void main(String args[])
    {
        data obj=new data();
        System.out.println(obj.insert(1));
        System.out.println(obj.remove(2));
        System.out.println(obj.insert(2));
        System.out.println(obj.get_random());
        System.out.println(obj.remove(1));
        System.out.println(obj.insert(2));
        System.out.println(obj.get_random());
    }
} 