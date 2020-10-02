class Solution {
    public boolean isSquare(int[][] mat, int i1, int j1, int i2, int j2){
        for(int a=i1; a<=i2; a++){
            for(int b=j1; b<=j2; b++){
                if(mat[a][b]==0) return false;
            }
        }
        return true;
    }
    public int numSubmat(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int count = 0;
        for(int i1=0; i1<m; i1++){
            for(int j1=0; j1<n; j1++){
                for(int i2=i1; i2<m; i2++){
                    for(int j2=j1; j2<n; j2++){
                        if(isSquare(mat, i1, j1, i2, j2)){
                            count++;
                        }else{
                            break;
                        }
                    }
                }
            }
        }
        return count;
    }
}
