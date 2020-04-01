// Search in a matrix row-wise and column-wise sorted
public class matrix_search{
    public static String func(int mat[][],int x)
    {
        int row=0;            // Starting from the top right corner
        int col=mat[0].length-1;
        while(row<mat.length&&col>=0)
        {
            if(mat[row][col]==x)
            return row+" "+col;
            else if(mat[row][col]<x) // It means the whole is smaller than target
            row++;
            else
            col--; // Whole column will be larger than the current element
        }
        return "Not found";
    }
    public static void main(String args[])
    {
        int mat[][]={{1,4,7,11,15},
                     {2,5,8,12,19},
                     {3,6,9,16,22},
                     {10,13,14,17,24},
                     {18,21,23,26,30}};
        System.out.println(func(mat,5));
    }
}