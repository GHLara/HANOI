package Estruturas;

public class Pilha {
  private Node Head = null;
  private Pilha Next = null;
  private int GameMode;
  private int Size;
  private int MaxSize;

  public Pilha(int maxSize, int gameMode) {
    this.MaxSize = maxSize;
    this.GameMode = gameMode;
  }

  public boolean push(Node node) {
    if (this.Size >= this.MaxSize) {
      System.out.println("Pilha cheia");
      return (false);
    }

    if (this.Head == null) {
      this.Head = node;
      return true;
    }

    switch (this.GameMode) {
      case 1: // Decrescente topo maior -> corpo valores menores que o topo
        if (node.getValue() > this.Head.getValue()) {
          System.out.println("Você não pode realizar esse movimento");
          return false;
        }
        break;
      case 2:
        if (node.getValue() < this.Head.getValue()) {
          System.out.println("Você não pode realizar esse movimento");
          return false;
        }
        break;
      default:
        break;
    }

    node.setNext(this.Head);
    this.Head = node;
    this.Size += 1;
    return (true);
  }

  public int pop() {
    if (this.Head == null) {
      return (-1);
    } else {
      Node poped = this.Head;
      Node node = this.Head.getNext();

      this.Head = node;
      this.Size -= 1;
      return (poped.getValue());
    }
  }

  public boolean print() {
    Node node = this.Head;

    if (node == null) {
      System.out.print("Pilha vazia");
      return false;
    }

    System.out.print("Head -> [");
    while (node.getNext() != null) {
      System.out.print(node.getValue() + ", ");
      node = node.getNext();
    }
    System.out.print(node.getValue() + "]");
    return true;
  }

  public void setNext(Pilha next) {
    this.Next = next;
  }

  public Pilha getNext() {
    return this.Next;
  }

  public Node getHead() {
    return this.Head;
  }

  public boolean isFull() {
    int cont = 0;
    Node node = this.Head;

    while (node != null) {
      cont += 1;
      node = node.getNext();
    }

    if (cont == this.MaxSize) {
      return true;
    }

    return false;
  }

}
