import java.util.Random;
import java.util.Scanner;

class Board {

    int[][] board = new int[3][3];
    int winner;

    public Board() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = 0;
            }
        }
    }

    public boolean checkBoard(int i, int j) {
        if (board[i][j] == 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean setBoard(int i, int j, int player) {
        if (checkBoard(i, j)) {
            board[i][j] = player;
            return true;
        }
        return false;
    }

    public boolean checkWin(int first) {
        if (checkDiagonals(first) || checkRowWise(first) || checkColumnWise(first)) {
            winner = first;
            return true;
        }
        return false;
    }

    public boolean checkDiagonals(int p) {
        int count1 = 0, count2 = 0;
        for (int i = 0; i < 3; i++) {
            if (board[i][i] == p) {
                count1 += 1;
            }
            if (board[i][2 - i] == p) {
                count2 += 1;
            }
        }

        if (count1 == 3 || count2 == 3) {
            return true;
        }
        return false;

    }

    public boolean checkRowWise(int p) {
        int count = 0;
        for (int i = 0; i < 3; i++) {
            count = 0;
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == p) {
                    count += 1;
                }
            }
            if (count == 3) {
                return true;
            }
        }
        return false;
    }

    public boolean checkColumnWise(int p) {
        int count = 0;
        for (int i = 0; i < 3; i++) {
            count = 0;
            for (int j = 0; j < 3; j++) {
                if (board[j][i] == p) {
                    count += 1;
                }
            }
            if (count == 3) {
                return true;
            }
        }
        return false;
    }

    public int getWinner() {
        return winner;
    }

    public boolean isFilled() {
        int count = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] != 0) {
                    count += 1;
                }
            }
        }
        if (count == 9) {
            return true;
        }
        return false;
    }

    public void display() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == 0) {
                    System.out.print("- ");
                } else if (board[i][j] == 1) {
                    System.out.print("X ");
                } else {
                    System.out.print("O ");
                }
            }
            System.out.println();
        }
    }
}

public class XOSingle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean check = true;
        String name1, name2;
        Random rand = new Random();
        int i, j;

        System.out.println("----------- Single Player XO Game ---------------");
        System.out.println("Enter Player X name : ");
        name1 = sc.nextLine();
        System.out.println("Enter Player O name : ");
        name2 = sc.nextLine();
        System.out.println("======================================================");
        int first = rand.nextInt(2) + 1;

        Board board = new Board();
        String winner;
        int win;
        board.display();

        if (first == 1) {
            System.out.println("Toss won by Player X : " + name1);
            System.out.println("Enter Row : ");
            i = sc.nextInt();
            System.out.println("Enter Column : ");
            j = sc.nextInt();

        } else {
            System.out.println("Toss won bu Player O : " + name2);
            System.out.println("Enter Row : ");
            i = sc.nextInt();
            System.out.println("Enter Column : ");
            j = sc.nextInt();
        }
        while (check) {
            if (board.setBoard(i - 1, j - 1, first)) {
                board.display();
                if (board.checkWin(first)) {
                    win = board.getWinner();
                    if (win == 0) {
                        winner = name1;
                    } else {
                        winner = name2;
                    }
                    check = false;
                    System.out.println("Winner is " + winner);
                    break;
                }

                if (board.isFilled()) {
                    check = false;
                    break;
                }

                if (first == 2) {
                    first = 1;
                } else {
                    first += 1;
                }

            } else {
                System.out.println("Already Filled!\nEnter new Row and Column");
            }

            System.out.println("Enter Row : ");
            i = sc.nextInt();
            System.out.println("Enter Column :");
            j = sc.nextInt();
        }
        System.out.println("=================== Game Finished =======================");
    }
}