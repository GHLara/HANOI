import java.util.Scanner;

import Estruturas.FilaEncadeada;
import Estruturas.Pilha;

public class Controlador {
  private FilaEncadeada torreDeHanoi;
  private boolean isGameEndend = false;
  private int Movimentos;
  private int GameMode;
  private int SizeOfPilha;

  public Controlador(int sizeOfPilha, int gameMode) {
    this.torreDeHanoi = new FilaEncadeada(sizeOfPilha, gameMode);
    this.GameMode = gameMode;
    this.SizeOfPilha = sizeOfPilha;
  }

  public boolean MoverEntrePilhas(int source, int destination) {
    Pilha pilhaSource = null;
    Pilha pilhaDestination = null;

    if (source < 1 || source > 3) {
      return false;
    } else if (destination < 1 || destination > 3) {
      return false;
    } else if (destination == source) {
      return false;
    }

    switch (source) {
      case 1:
        pilhaSource = this.torreDeHanoi.getHead();
        break;
      case 2:
        pilhaSource = this.torreDeHanoi.getHead().getNext();
        break;
      case 3:
        pilhaSource = this.torreDeHanoi.getHead().getNext().getNext();
        break;
      default:
        break;
    }

    switch (destination) {
      case 1:
        pilhaDestination = this.torreDeHanoi.getHead();
        break;
      case 2:
        pilhaDestination = this.torreDeHanoi.getHead().getNext();
        break;
      case 3:
        pilhaDestination = this.torreDeHanoi.getHead().getNext().getNext();
        break;
      default:
        break;
    }

    int valorMovido = pilhaSource.getHead().getValue();
    boolean result = this.torreDeHanoi.moveValue(pilhaSource, pilhaDestination);

    if (result) {
      this.Movimentos += 1;
      System.out.println("Movendo... [" + valorMovido + "], Pilha " + source + " to " + "Pilha " + destination);
      System.out.println("Movimentos: " + Movimentos);
    }

    Pilha Pilha2 = this.torreDeHanoi.getHead().getNext();
    Pilha Pilha3 = this.torreDeHanoi.getHead().getNext().getNext();

    if (Pilha2.isFull() || Pilha3.isFull()) {
      this.isGameEndend = true;
      printGame();
      return result;
    }

    System.out.println();
    this.torreDeHanoi.print();

    return result;
  }

  public boolean JogoManual() {
    int source;
    int destination;

    System.out.println("Começando Jogo manual...");
    Scanner scanner = new Scanner(System.in);

    System.out.println("[0]Sair [1]Movimentar");
    int opcao = scanner.nextInt();

    printGame();
    while (opcao != 0) {
      System.out.print("Mover de: ");
      source = scanner.nextInt();

      System.out.print("Para: ");
      destination = scanner.nextInt();

      this.MoverEntrePilhas(source, destination);
      if (this.isGameEndend == true) {
        System.out.println("Você Venceu!!!");
        return true;
      }

      System.out.println("[0]Sair [1]Movimentar");
      opcao = scanner.nextInt();
    }

    return false;

  }

  public void JogoAutomatico(int tamanho, int origem, int destino, int auxiliar) {
    if (tamanho == 1) {
      MoverEntrePilhas(origem, destino);
    } else {
      JogoAutomatico(tamanho - 1, origem, auxiliar, destino);
      MoverEntrePilhas(origem, destino);
      JogoAutomatico(tamanho - 1, auxiliar, destino, origem);
    }
  }

  public boolean gameIsFinished() {
    return this.isGameEndend;
  }

  public void printGame() {
    this.torreDeHanoi.print();
  }

}
