import java.util.*;
public class lru_cache{
    // LRU cache has been implemented using singly linked list and a hashmap
    // when removing a middle the trick of replacing it with values of next node and then deleting the next node is used
	public static class LRUCache {
		class node{
	        int key;
	        int val;
	        node next;
	        public node(int key,int val)
	        {
	            this.key=key;
	            this.val=val;
	            next=null;
	        }
	    }
	    node head;
	    node tail;
	    HashMap<Integer,node> map;
	    int size;
	    int max_size;
	    public LRUCache(int capacity) {
	        head=null;
	        tail=null;
	        map=new HashMap<>();
	        size=0;
	        max_size=capacity;
	    }
	    public int shift_to_end(int key)
	    {
	        node temp=map.get(key);
	        if(temp==tail)
	            return temp.val;
	        if(head==temp)
	        {
	            head=head.next;
	            tail.next=temp;
	            temp.next=null;
	            tail=temp;
	            return tail.val;
	        }
	        int val=temp.val;
	        temp.key=temp.next.key;
	        temp.val=temp.next.val;
	        map.put(temp.key,temp);
	        temp.next=temp.next.next;
	        if(temp.next==null)
	        	tail=temp;
	        temp=new node(key,val);
	        tail.next=temp;
	        tail=temp;
	        map.put(key,temp);
	        return temp.val;
	    }
	    public int get(int key) {
	        if(map.containsKey(key))
	        {
	            return shift_to_end(key);
	        }
	        else
	            return -1;
	    }
	    
	    public void put(int key, int value) {
	        if(map.containsKey(key))
	        {
	            node temp=map.get(key);
	            temp.val=value;
	            shift_to_end(key);
	        }
	        else
	        {
	           if(size==max_size)
	           {
	               map.remove(head.key);
	               if(head.next==null)
	               {
	                   head=null;
	                   tail=null;
	                   size--;
	               }
	             else
	             {
	                head=head.next;
	                size--;
	             }
	           }
	            node temp=new node(key,value);
	            if(head==null)
	            {
	                head=temp;
	                tail=temp;
	                map.put(key,head);
	                size++;
	            }
	            else
	            {
	                tail.next=temp;
	                tail=tail.next;
	                map.put(key,tail);
	                size++;
	            }
	        }
	    }
	}
	public static void main(String args[])
	{
//		["LRUCache","put","put","put","put","get","get","get","get","put","get","get","get","get","get"]
		//[[3],[1,1],[2,2],[3,3],[4,4],[4],[3],[2],[1],[5,5],[1],[2],[3],[4],[5]]
		LRUCache obj=new LRUCache(3);
		obj.put(1,1);
		obj.put(2,2);
		obj.put(3,3);
		obj.put(4,4);
		System.out.println(obj.get(4));
		System.out.println(obj.get(3));
		System.out.println(obj.get(2));
		System.out.println(obj.get(1));
		obj.put(5,5);
		System.out.println(obj.get(1));
		System.out.println(obj.get(2));
		System.out.println(obj.get(3));
		System.out.println(obj.get(4));
		System.out.println(obj.get(5));
	}
}