package Estruturas;

import java.util.Random;

public class FilaEncadeada {
  private Pilha Head;
  private int Size;

  public FilaEncadeada(int size, int gameMode) {
    Pilha pilha1 = new Pilha(size, gameMode);
    Pilha pilha2 = new Pilha(size, gameMode);
    Pilha pilha3 = new Pilha(size, gameMode);
    this.Size = size;

    for (int i = size - 1; i >= 0; i--) {
      Random rand = new Random();
      int randomNumber = rand.nextInt(100);

      if (pilha1.getHead() != null) {
        if (gameMode == 2) {
          while (randomNumber <= pilha1.getHead().getValue()) {
            randomNumber = rand.nextInt(100);
          }
        } else {
          while (randomNumber >= pilha1.getHead().getValue()) {
            randomNumber = rand.nextInt(100);
          }
        }
      }

      Node node = new Node();
      node.setValue(randomNumber);
      pilha1.push(node);
    }

    this.Head = pilha1;
    pilha1.setNext(pilha2);
    pilha2.setNext(pilha3);
  }

  public Pilha getHead() {
    return this.Head;
  }

  public boolean moveValue(Pilha source, Pilha destination) {
    int sourceValue = source.getHead().getValue();

    if (sourceValue == -1) {
      System.out.println("A pilha que você está tentando mover está vazia!");
      return false;
    }

    Node node = new Node();
    node.setValue(sourceValue);

    boolean result = destination.push(node);
    if (result) {
      source.pop();
    }
    return true;
  }

  public void autoSolve(int size, int source, int destination) {
    Pilha pilhaSource = null;
    Pilha pilhaDestination = null;

    switch (source) {
      case 1:
        pilhaSource = this.getHead();
        break;
      case 2:
        pilhaSource = this.getHead().getNext();
        break;
      case 3:
        pilhaSource = this.getHead().getNext().getNext();
        break;
      default:
        break;
    }

    switch (destination) {
      case 1:
        pilhaDestination = this.getHead();
        break;
      case 2:
        pilhaDestination = this.getHead().getNext();
        break;
      case 3:
        pilhaDestination = this.getHead().getNext().getNext();
        break;
      default:
        break;
    }

    if (size == 1) {

      return;
    }
    int other = 3 - source - destination;

    moveValue(pilhaSource, pilhaDestination);
    autoSolve(size - 1, source, other);

    autoSolve(size - 1, other, destination);
    moveValue(pilhaSource, pilhaDestination);

  }

  public void print() {
    System.out.print("Pilha 1: ");
    this.Head.print();
    System.out.println();

    System.out.print("Pilha 2: ");
    this.Head.getNext().print();
    System.out.println();

    System.out.print("Pilha 3: ");
    this.Head.getNext().getNext().print();
    System.out.println();
    System.out.println();
  }
}
