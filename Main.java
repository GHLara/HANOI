import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        System.out.println("[1]Ordem crescente\n[2]Ordem decrescente");
        System.out.print(">>");
        int gameMode = scanner.nextInt();

        System.out.println("Tamanho das Pilhas: ");
        System.out.print(">>");
        int Size = scanner.nextInt();

        Controlador controlador = new Controlador(Size, gameMode);

        System.out.println("[1]Jogo Manual\n[2]Jogo Automatico");
        System.out.print(">>");
        int playerChoice = scanner.nextInt();

        switch (playerChoice) {
            case 1:
                controlador.JogoManual();
                break;
            case 2:
                controlador.printGame();
                controlador.JogoAutomatico(Size, 1, 3, 2);
                break;
            default:
                break;
        }
    }
}
