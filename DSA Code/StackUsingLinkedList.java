
public class StackUsingLinkedList {
    private Snode top = null;
    private int size;

    StackUsingLinkedList() {
        size = 0;
    }

    class Snode {
        private int val;
        private Snode next;

        public Snode(int val) {
            this.val = val;
        }

        public Snode(int val, Snode next) {
            this.val = val;
            this.next = next;
        }
    }

    public void Push(int data) {
        Snode newnode = new Snode(data);
        newnode.next = top;
        top = newnode;
        size++;
    }

    public void pop() {
        if (size < 0 || top == null) {
            System.out.println("the Stack is empty");
        } else {
            top = top.next;
            size--;
        }
        
    }

    public void Display() {
        if (top == null) {
            System.out.println("the Stack is empty");
        }

        else {
            Snode temp = top;
            System.out.println("the stack elements");
            while (temp != null) {
                System.out.print(temp.val + " ");
                temp = temp.next;
            }
            System.out.println();
        }

    }

    public void peek() {
        if (top == null) {
            System.out.println("the Stack is empty");
        }
        else{
        System.out.println("the topmost element in the stack " + top.val);
    }
    }

    public static void main(String[] args) {
        StackUsingLinkedList sl = new StackUsingLinkedList();

        // now let's perform some stack operation
        sl.Push(50);
        sl.Push(44);
        sl.Push(45);
        sl.Push(52);
        sl.peek();
        sl.Display();
        sl.pop();
        sl.Display();
    }
}
