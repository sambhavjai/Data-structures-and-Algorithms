public class median_sorted_arrays{
    public static double func1(int nums1[],int nums2[])
    {
        // This function runs with a complexity of O(n+m) and works like merge sorted arrays keeping store of the minimum element till we reach the half length required
        if((nums1.length+nums2.length)%2==0)
        {
            // if the merged array is of even length then median will be average of arr.length/2 and arr.length/2-1
            int m=0; // to store the current smallest element;
            int p=0; // to store the previous element
            int count=0;
            int i=0,j=0;
            while(count<=((nums1.length+nums2.length)/2))
            {
                p=m;
                if(i<nums1.length&&j<nums2.length)
                {
                    if(nums1[i]<nums2[j])
                    m=nums1[i++];
                    else
                    m=nums2[j++];
                }
                else if(i==nums1.length)
                m=nums2[j++];
                else
                m=nums1[i++];
                count++;
            }
            return (m+p)/2.0;
        }
        else
        {
            // if the merged array is of odd length then median will be the element at arr.length/2;
            int m=0;
            int count=0;
            int i=0,j=0;
            while(count<=(nums1.length+nums2.length)/2)
            {
                if(i<nums1.length&&j<nums2.length)
                {
                    if(nums1[i]<nums2[j])
                    m=nums1[i++];
                    else
                    m=nums2[j++];
                }
                else if(i==nums1.length)
                m=nums2[j++];
                else
                m=nums1[i++];
                count++;
            }
            return (double)m;
        }
    }
    public static double median (int arr[])
    {
        if(arr.length%2==0)
        {
            return (arr[arr.length/2]+arr[arr.length/2-1])/2.0;
        }
        else
        return arr[arr.length/2]/1.0;
    }
    public static double func2(int nums1[],int nums2[])
    {
        // complexity : O(log(min(m,n)))
        // if either of the array is empty return the median of the other
        if(nums1.length==0)
        return median(nums2);
        if(nums2.length==0)
        return median(nums1);
        // if we are able to find the left part of the output array such that both parts are equal in length and each element of left is smaller than each element of right
        // then the last element of the left part is the median in case of odd and the averge of last element of left and first element of right is the median in case of even
        // always store the smaller array in nums1 as we will be counting the number of elements each array is contributing in the left part
        // so the smaller array can contribute 0 elements in the left part
        // length of left part= (length of 1+length of 2 + 1)/2; 
        if(nums1.length>nums2.length)
        {
            int temp[]=nums1;
            nums1=nums2;
            nums2=temp;
        }
        int count_1=0;  // number of elements 1 is contributing
        int count_2=0; // number of elements 2 is contributing
        int half_length=(nums1.length+nums2.length+1)/2; // length of left half of the array
        // we are using a type of binary search to find the contribution of smaller array in the left part
        // contribution for larger array will be half_length-contribution for smaller array
        int min_1=0;  // min no of elements smaller can contribute
        int max_1=nums1.length; // max no of elements smaller can contribute
        while(min_1<=max_1)
        {
            count_1=(min_1+max_1)/2; // we consider first that smaller contributes half its elements
            count_2=half_length-count_1; // elements of larger 
            // now we check if the elements contributed contain the median or not
            // if the last element contributed by smaller array is larger than element succeeding the last element contributed by larger array
            // then the median(belonging to smaller array) lies after the half length and we will need to decrease the contribution of smaller array
            if(count_1>min_1&&nums1[count_1-1]>nums2[count_2]) 
            max_1=count_1-1; // decreasing the contribution by changing the range
            // else if the last element contributed by larger array is greater than the element succeeding the last element contributed by smaller array
            // then we need to decrease the contribution of larger array as median(belonging to larger array) now lies after the half length
            // to decrease the contribution of larger array we can simply increase the contribution of smaller array
            else if(count_1<max_1&&nums2[count_2-1]>nums1[count_1])
            max_1=count_1-1; // increasing the contribution of smaller array
            else
            {
                // if we reach here it means the 2 parts of equal length such that each element in left is smaller than each element in right have been found
                // now we find the end of left part
                int left_end=0;
                if(count_1==0) // if there is no contribution from smaller array then left end will be last contribution from larger array
                left_end=nums2[count_2-1];
                else if(count_2==0)// if there is no contribution from larger array then left end will be last contribution from smaller array
                left_end=nums1[count_1-1];
                else
                left_end=Math.max(nums1[count_1-1],nums2[count_2-1]); // if the both array are contributing then left end will be max of last contributions from both array
                // now we find the first element of right part for median of even length
                int right_first=0;
                if(count_1==nums1.length) // if smaller array is contributing completely then right_first will be the element succeeding the last contribution of larger array
                right_first=nums2[count_2];
                else if(count_2==nums2.length)// if larger array is contributing completely then right_first will be the element succeeding the last contribution of smaller array
                right_first=nums1[count_1];
                else
                right_first=Math.min(nums1[count_1],nums2[count_2]);// if both array are contributing partially then right_first will be min of the elements succeeding the last contributions from both arrays
                if((nums1.length+nums2.length)%2==0) // merged length is even find the median as average of left_end and right_first
                return (left_end+right_first)/2.0;
                else
                return (left_end)/1.0; // merged length is odd find the median as the left end
            }
        }
        return 0.0;
    }
    public static void main(String args[])
    {
        int nums1[]={1,2};
        int nums2[]={3,4};
        System.out.println(func2(nums1,nums2));
    }
}