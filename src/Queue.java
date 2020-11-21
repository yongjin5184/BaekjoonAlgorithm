import java.util.Stack;

class Queue<T> {

  Stack<T> newestStack;
  Stack<T> oldestStack;

  Queue() {
    newestStack = new Stack<>();
    oldestStack = new Stack<>();
  }

  public void add(T value) {
    newestStack.push(value);
  }

  public int size() {
    return oldestStack.size() + newestStack.size();
  }

  public void shiftOldestStack() {
    if(oldestStack.empty()) {
      while (!newestStack.empty()) {
        oldestStack.push(newestStack.pop());
      }
    }
  }

  public T peek() {
    shiftOldestStack();
    return oldestStack.peek();
  }

  public T remove() {
    shiftOldestStack();
    return oldestStack.pop();
  }


  public static void main(String[] args) {
    Queue queue = new Queue();
    queue.add(3);
    queue.add(2);
    queue.add(1);

    System.out.println(queue.remove());
    System.out.println(queue.remove());
    System.out.println(queue.remove());
  }
}
