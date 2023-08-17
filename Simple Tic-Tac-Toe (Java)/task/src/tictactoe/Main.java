package tictactoe;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] symbols = new char[9];
        for (int i = 0; i < 9; i++) {
            symbols[i] = ' ';
        }
        System.out.println("---------");
        for (int i = 0; i < 9; i += 3) {
            System.out.println("| " + symbols[i] + " " + symbols[i + 1] + " " + symbols[i + 2] + " |");
        }
        System.out.println("---------");

        boolean xTurn = true;
        while (true) {

            boolean validInput = false;
            while (!validInput) {
                System.out.print("Enter the coordinates: ");
                String coordinates = scanner.nextLine();
                String[] parts = coordinates.split(" ");
                if (parts.length != 2) {
                    System.out.println("You should enter two numbers!");
                    continue;
                }
                int x, y;
                try {
                    x = Integer.parseInt(parts[0]);
                    y = Integer.parseInt(parts[1]);
                } catch (NumberFormatException e) {
                    System.out.println("You should enter numbers!");
                    continue;
                }
                if (x < 1 || x > 3 || y < 1 || y > 3) {
                    System.out.println("Coordinates should be from 1 to 3!");
                    continue;
                }
                int index = (x - 1) * 3 + (y - 1);
                if (symbols[index] != ' ') {
                    System.out.println("This cell is occupied! Choose another one!");
                    continue;
                }
                symbols[index] = xTurn ? 'X' : 'O';
                validInput = true;
            }

            System.out.println("---------");
            for (int i = 0; i < 9; i += 3) {
                System.out.println("| " + symbols[i] + " " + symbols[i + 1] + " " + symbols[i + 2] + " |");
            }
            System.out.println("---------");

            boolean xWins = false;
            boolean oWins = false;
            boolean gameNotFinished = false;

            for (int i = 0; i < 9; i += 3) {
                if (symbols[i] == symbols[i + 1] && symbols[i + 1] == symbols[i + 2]) {
                    if (symbols[i] == 'X') {
                        xWins = true;
                    } else if (symbols[i] == 'O') {
                        oWins = true;
                    }
                }
            }

            for (int i = 0; i < 3; i++) {
                if (symbols[i] == symbols[i + 3] && symbols[i + 3] == symbols[i + 6]) {
                    if (symbols[i] == 'X') {
                        xWins = true;
                    } else if (symbols[i] == 'O') {
                        oWins = true;
                    }
                }
            }

            if (symbols[0] == symbols[4] && symbols[4] == symbols[8]) {
                if (symbols[0] == 'X') {
                    xWins = true;
                } else if (symbols[0] == 'O') {
                    oWins = true;
                }
            }
            if (symbols[2] == symbols[4] && symbols[4] == symbols[6]) {
                if (symbols[2] == 'X') {
                    xWins = true;
                } else if (symbols[2] == 'O') {
                    oWins = true;
                }
            }

            for (int i = 0; i < 9; i++) {
                if (symbols[i] == ' ') {
                    gameNotFinished = true;
                    break;
                }
            }

            if (xWins) {
                System.out.println("X wins");
                break;
            } else if (oWins) {
                System.out.println("O wins");
                break;
            } else if (!gameNotFinished) {
                System.out.println("Draw");
                break;
            }

            xTurn = !xTurn;
        }
    }
}

