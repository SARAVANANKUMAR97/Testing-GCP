public class NQueen {

    static boolean safe(int[] board, int row, int col) {
        for (int i = 0; i < row; i++) {
            if (board[i] == col ||
                board[i] - i == col - row ||
                board[i] + i == col + row) {
                return false;
            }
        }
        return true;
    }

    static void solve(int[] board, int row, int n) {

        if (row == n) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (board[i] == j)
                        System.out.print("Q ");
                    else
                        System.out.print(". ");
                }
                System.out.println();
            }
            System.out.println();
            return;
        }

        for (int col = 0; col < n; col++) {
            if (safe(board, row, col)) {
                board[row] = col;
                solve(board, row + 1, n);
            }
        }
    }

    public static void main(String[] args) {

        int n = 4;
        int[] board = new int[n];

        for (int i = 0; i < n; i++) {
            board[i] = -1;
        }

        solve(board, 0, n);
    }
}