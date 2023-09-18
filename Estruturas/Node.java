package Estruturas;

public class Node {
  private int Value;
  private Node Next;

  public void setNext(Node next) {
    this.Next = next;
  }

  public Node getNext() {
    return this.Next;
  }

  public void setValue(int value) {
    this.Value = value;
  }

  public int getValue() {
    return this.Value;
  }

}
