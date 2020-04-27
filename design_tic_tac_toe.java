public class design_tic_tac_toe{
    public static class tic_tac_toe{
        int n;
        int row[][];
        int col[][];
        int diag[];
        int xdiag[];
        public tic_tac_toe(int n)
        {
            this.n=n;
            row=new int[2][n]; // To store the number of Xs and Os in nth row
            col=new int[2][n]; // To store the number of Xs and Os in nth col
            diag=new int[2]; // To store the number of Xs and Os in the diagonal
            xdiag=new int[2]; // To store the number of Xs and Os in the anti-diagonal
        }
        public int move(int player,int r,int c) // Returns 0 if the current player does not win else return the player number
        {
            row[player-1][r]++;
            col[player-1][c]++;
            diag[player-1]++;
            xdiag[player-1]++;
            if(row[player-1][r]==n||col[player-1][c]==n||diag[player-1]==n||xdiag[player-1]==n) // Check if the player with current move wins
            return player;
            return 0;
        }
    }
    public static void main(String args[])
    {
        int n=3;
        tic_tac_toe obj=new tic_tac_toe(n);
        if(obj.move(1,0,0)==1)
        System.out.println("Player 1 wins");
        else if(obj.move(2,0,2)==2)
        System.out.println("Player 2 wins");
        else if(obj.move(1,2,2)==1)
        System.out.println("Player 1 wins");
        else if(obj.move(2,1,1)==2)
        System.out.println("Player 2 wins");
        else if(obj.move(1,2,0)==1)
        System.out.println("Player 1 wins");
        else if(obj.move(2,1,0)==2)
        System.out.println("Player 2 wins");
        else if(obj.move(1,2,1)==1)
        System.out.println("Player 1 wins");
    }
}