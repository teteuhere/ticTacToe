import java.util.*;

public class ticTacToe {
    static String[] board;
    static String turn;

    static String verificandoVencedor() {
        for (int a = 0; a < 8; a++) {
            String line = null;
            switch (a) {
                case 0:
                    line = board[0] + board[1] + board[2];
                    break;
                case 1:
                    line = board[3] + board[4] + board[5];
                    break;
                case 2:
                    line = board[6] + board[7] + board[8];
                    break;
                case 3:
                    line = board[0] + board[3] + board[6];
                    break;
                case 4:
                    line = board[1] + board[4] + board[7];
                    break;
                case 5:
                    line = board[2] + board[5] + board[8];
                    break;
                case 6:
                    line = board[0] + board[4] + board[8];
                    break;
                case 7:
                    line = board[2] + board[4] + board[6];
                    break;
            }
            if ("XXX".equals(line)) {
                return "X";
            } else if ("000".equals(line)) {
                return "O";
            }
        }
        for (int a = 0; a < 9; a++) {
            if (Arrays.asList(board).contains(String.valueOf(a + 1))) {
                break;
            } else if (a == 8) {
                return "empate";
            }
        }
        System.out.println(
                turn + ":selecione um espaço para jogar" + turn + " em: ");
        return null;
    }

    static void printBoard() {
        System.out.println("|-|-|-|");
        System.out.println("|" + board[0] + "|"
                + board[1] + "|" + board[2] + "|");
        System.out.println("|-----|");
        System.out.println("|" + board[3] + "|"
                + board[4] + "|" + board[5] + "|");
        System.out.println("|-----|");
        System.out.println("|" + board[6] + "|"
                + board[7] + "|" + board[8] + "|");
        System.out.println("|-|-|-|");
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        board = new String[9];
        turn = "X";
        String vencedor = null;
        for (int a = 0; a < 9; a++) {
            board[a] = String.valueOf(a + 1);
        }
        System.out.println("Bem vindo ao jogo da velha 3x3.");
        printBoard();
        System.out.println("X irá jogar primeiro, escolha onde irá depositar:");
        while (vencedor == null) {
            int numInput;
            try {
                numInput = in.nextInt();
                if (!(numInput > 0 && numInput <= 9)) {
                    System.out.println("Número inválido, escolha novamente.");
                    continue;
                }
            } catch (InputMismatchException e) {
                System.out.println("Número inválido.");
                continue;
            }
            if (board[numInput - 1].equals(
                    String.valueOf(numInput))) {
                board[numInput - 1] = turn;
                if (turn.equals("X")) {
                    turn = "O";
                } else {
                    turn = "X";
                }
                printBoard();
                vencedor = verificandoVencedor();
            } else {
                System.out.println("Espaço já em uso, escolha novamente: ");
            }
        }
        if (vencedor != null && vencedor.equalsIgnoreCase("Empate")) {
            System.out.println("O jogo terminou com um empate");
        } else {
            System.out.println("Parabéns! " + vencedor + " ganhou! Obrigado por jogar comigo.");
        }
        in.close();
    }
}
