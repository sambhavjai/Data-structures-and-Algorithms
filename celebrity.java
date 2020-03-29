//Find the celebrity
// Celebrity is a person who knows everyone but does not know anybody
public class celebrity{
    public static int func(int mat[][])
    {
        // Using 2 pointer approach. It gives us the answer to who might be the celebrity
        int a=0;
        int b=mat.length-1;
        while(a<b)
        {
            if(mat[a][b]==1)
            a++;              // If a knows b then a is not the celebrity so we shift the pointer
            else 
            b--;             // If b is not known by a then b is not the celebrity
        }
        //Now we confirm again that we have the celebrity by traversing in the loop
        for(int i=0;i<mat.length;i++)
        {
            if(i!=a&&(mat[a][i]!=0||mat[i][a]!=1))
            return -1;
        }
        return a;
    }
    public static void main(String args[])
    {
        int mat[][]={{0,1,0},
                     {0,0,0},
                     {0,1,0}};
        System.out.println(func(mat));
    }
}