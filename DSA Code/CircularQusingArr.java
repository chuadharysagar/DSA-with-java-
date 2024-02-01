public class CircularQusingArr {
    static final int size = 6;
    static int[] arr = new int[size];
    static int front;
    static int rear;

    public CircularQusingArr() {
        front = rear = -1;
    }

    public void Enqueue(int val) {
        if (front == -1 && rear == -1) {
            front = rear = 0;
            arr[rear] = val;
        } else if ((rear + 1) % size == front) {
            System.out.println("the queuen full ");
        } else {
            rear = (rear + 1) % size;
            arr[rear] = val;
        }
    }

    public void Dequeue() {
        if (front == -1 && rear == -1) {
            System.out.println("the queue is Empty");
        } else if (front == rear) {
            front = rear = -1;

        } else {
            front = (front + 1) % size;

        }
    }

    public void Display(){
        if (front == -1 && rear == -1) {
            System.out.println("the queue is Empty");
        }
        else{
            int i=front;
            while(i!=rear){
               System.out.print(arr[i]+" ");
               i=(i+1)%size;
            }
            System.out.print(arr[i]);
        }
    }


    public static void main(String[] args) {
        CircularQusingArr cq= new CircularQusingArr();
        
        cq.Enqueue(12);
        cq.Enqueue(100);
        cq.Display();
    }

}
