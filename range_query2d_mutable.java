public class range_query2d_mutable{
    // given a matrix and a range from start indexes to end indexes of a rectangle
    // calculate the sum of all elements in the rectangle in o(1) time
    public static class range_sum{
        int aux[][];
        int mat[][];
        public range_sum(int mat[][])
        {
            aux=new int[mat.length][mat[0].length];
            this.mat=mat;
            pre_process(mat,aux);
        }
        public void pre_process(int mat[][],int aux[][])
        // we process the given matrix and create an auxiliary matrix with each element having sum from 0,0 to that index
        {
            for(int i=0;i<mat[0].length;i++)
            {
                aux[0][i]=mat[0][i]; // copy the first row into the auxiliary array
            }
            for(int i=1;i<mat.length;i++)
            {
                for(int j=0;j<mat[0].length;j++)
                {
                    aux[i][j]=aux[i-1][j]+mat[i][j]; // add all the elements from the auxiliary array and matrix in a columnwise manner
                }
            }
            for(int i=0;i<mat.length;i++)
            {
                for(int j=1;j<mat[0].length;j++)
                {
                    aux[i][j]=aux[i][j]+aux[i][j-1]; // add all the elements with the previous elements in a row-wise manner
                }
            }
        }
        public void update(int row,int col,int val)
        {
            // to update an element in the matrix we update the corresponding auxiliary array
            // we calculate the difference created by subtracting the current element and adding the new element
            // now we add the difference in all elements which take current element in their answer
            // that is the elements present in the submatrix starting from current element
            int curr=mat[row][col];
            int diff=val-curr;
            for(int i=row;i<aux.length;i++)
            {
                for(int j=col;j<aux[0].length;j++)
                {
                    aux[i][j]=aux[i][j]+diff;
                }
            }
            mat[row][col]=val; // we update the new value in the original matrix
        }
        public int sum(int li,int lj,int ri,int rj)
        {
            // for calculating sum we take the answer of ri,rj which means sum of all elements taken from 0,0, to ri,rj
            // now we subtract the submatrix from left of li and above of li
            // answer for these submatrices are stored in aux[li-1][rj] that is above li and aux[ri][lj-1] that is left of li respectively
            // now we add the region which was common in both the matrices that is region defined by 0,0, to li-1,lj-1 as it has been subtracted twice
            // answer for this region is present in aux[li-1][lj-1]
            int ans=aux[ri][rj];
            if(li-1>=0)
            ans=ans-aux[li-1][rj];
            if(lj-1>=0)
            ans=ans-aux[ri][lj-1];
            if(li-1>=0&&lj-1>=0)
            ans=ans+aux[li-1][lj-1];
            return ans;
        }
    }
    public static void main(String args[])
    {
        int mat[][]={{3,0,1,4,2},
                     {5,6,3,2,1},
                     {1,2,0,1,5},
                     {4,1,0,1,7},
                     {1,0,3,0,5}};
        range_sum obj=new range_sum(mat);
        System.out.println(obj.sum(2,1,4,3));
        obj.update(3,2,2);
        System.out.println(obj.sum(2,1,4,3));
    }
}