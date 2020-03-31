//Given a matrix set the rows and columns of all the zero elements as zero in O(n*n) time and O(1) space
public class zero_matrix{
    public static void func(int mat[][])
    {
        // We can use the start indices of the rows and columns having zeroes as flags to mark the 
        // rows and column which need to be changed
        // Cell mat[0][0] will be common for first row and first col so we use a seperate variable for first col
        // while the cell mat[0][0] is used for first row
        boolean is_col=false;
        for(int i=0;i<mat.length;i++)
        {
            if(mat[i][0]==0) // Checking for first column
             is_col=true;
            for(int j=1;j<mat[0].length;j++)
            {
                if(mat[i][j]==0)
                {
                    mat[i][0]=0;
                    mat[0][j]=0;
                }
            }
        }
        for(int i=1;i<mat.length;i++)
        {
            for(int j=1;j<mat[0].length;j++)
            {
                if(mat[i][0]==0||mat[0][j]==0) // Setting the whole matrix except for first row and first col
                mat[i][j]=0;
            }
        }
        if(mat[0][0]==0)  // Checking for first row
        {
            for(int i=0;i<mat[0].length;i++)
            {
                mat[0][i]=0;
            }
        }
        if(is_col)  // Checking for first col
        {
            for(int i=0;i<mat.length;i++)
            {
                mat[i][0]=0;
            }
        }
    }
    public static void main(String args[])
    {
        int mat[][]={{0,1,2,0},
                     {3,4,5,2},
                     {1,3,1,5}};
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