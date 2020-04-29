// Turn the matrix clockwise by 90 degrees in place
public class rotate_matrix{
    public static void func(int mat[][])
    {
        // We rotate the elements cycle by cycle considering the outer ring as the first cycle
        int n=mat.length;
        for(int i=0;i<n/2;i++) // iterating through all the cycles
        {
            for(int j=i;j<n-1-i;j++) // iterating through all the elements of the cycle
            {
                int temp=mat[i][j];
                mat[i][j]=mat[n-1-j][i]; // j is down so sits in front
                mat[n-1-j][i]=mat[n-1-i][n-1-j]; // both are down so i and j take their usual place
                mat[n-1-i][n-1-j]=mat[j][n-1-i]; // i is down but j doesnt leave the front seat
                mat[j][n-1-i]=temp;
            }
        }
    }
    // For anti-clockwise rotation switch the i and j and the row and column indexes in each swap
    public static void main(String args[])
    {
        int mat[][]={{1,2,3,4},
                     {5,6,7,8},
                     {9,10,11,12},
                     {13,14,15,16}};
        func(mat);
        for(int i=0;i<mat.length;i++)
        {
            for(int j=0;j<mat[0].length;j++)
            {
                System.out.print(mat[i][j]+" ");
            }
            System.out.println();
        }
    }
}