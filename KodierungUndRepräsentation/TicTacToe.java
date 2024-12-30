class Pos {
    static int of(int x, int y) {
        assert x >= 1 && x <= 3;
        assert y >= 1 && y <= 3;
        return (3 - y) * 3 + (x - 1);
    }
    static int of(char x, int y) {
        return of(x < 'a' ? x - 'A' + 1 : x - 'a' + 1, y);
    }
}

assert Pos.of(1,3) == 0 && Pos.of(2,3) == 1 && Pos.of(3,3) == 2;
assert Pos.of(1,2) == 3 && Pos.of(2,2) == 4 && Pos.of(3,2) == 5;
assert Pos.of(1,1) == 6 && Pos.of(2,1) == 7 && Pos.of(3,1) == 8;
assert Pos.of('a',2) == Pos.of('A',2) && Pos.of('a',2) == Pos.of(1,2);
assert Pos.of('b',1) == Pos.of('B',1) && Pos.of('b',1) == Pos.of(2,1);
assert Pos.of('c',2) == Pos.of('C',2) && Pos.of('c',2) == Pos.of(3,2);

class TicTacToe {
    private int[] board = {0,0,0,0,0,0,0,0,0};
    private int turn = +1;
    private char[] symbols = {'O','.','X'};
    private int[] history = new int[board.length];
    private int counter = 0;
    
    TicTacToe() { }
    
    TicTacToe(int ...moves) {
        for(int move : moves) move(move);
    }

    public void move(int m) {
        assert contains(generateMoves(), m): "move must address a valid, empty field";
        assert !wonTheGame(): "no party should have won the game";
        board[m] = turn;
        turn = -turn;
        history[counter++] = m;
    }

    private static boolean contains(int[] numbers, int number) {
        for (int n : numbers)
            if (n == number) return true;
        return false;
    }

    public void undoMove() {
        if (counter == 0) return;
        board[history[--counter]] = 0;
        turn = -turn;
    }

    public int[] generateMoves() {
        int[] moves = new int[board.length - counter];
        for(int i = 0, j = 0; i < board.length; i++)
            if (board[i] == 0) moves[j++] = i;
        return moves;
    }

    public boolean wonTheGame() {
        int[][] rows = {{0,1,2},{3,4,5},{6,7,8},
                        {0,3,6},{1,4,7},{2,5,8},
                        {0,4,8},{2,4,6}};
        for(int[] row : rows) {
            int sum = board[row[0]] + board[row[1]] + board[row[2]];
            if (Math.abs(sum) == 3) return true;
        }
        return false;
    }

    public int[] history() {
        int[] moves = new int[counter];
        for(int i = 0; i < moves.length; i++)
            moves[i] = history[i];
        return moves;
    }

    TicTacToe toggle() {
        char c = symbols[0];
        symbols[0] = symbols[2];
        symbols[2] = c;
        return this;
    }

    public String toString() {
        String repr = "";
        for(int i = 0; i < board.length; i++) {
            if (i % 3 == 0) repr += "\n";
            repr += symbols[board[i] + 1];
        }
        return repr;
    }
}

assert new TicTacToe().toString().equals("\n...\n...\n...");
assert new TicTacToe().toggle().toString().equals("\n...\n...\n...");
assert new TicTacToe(0,2).toString().equals("\nX.O\n...\n...");
assert new TicTacToe(7,3,0,2).toString().equals("\nX.O\nO..\n.X.");
assert new TicTacToe(0,3,7,2).toggle().toString().equals("\nO.X\nX..\n.O.");
assert new TicTacToe(0,6,1,7,2).wonTheGame();
assert new TicTacToe(0,6,1,7,3,8).wonTheGame();

