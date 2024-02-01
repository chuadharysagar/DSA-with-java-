public class QueueUsingARR {
    static int size=5;
    static int [] Queue= new int [size];
    static  int front;
    static int rear;
    public QueueUsingARR(){
        front=rear=-1;
    }
    
    //Insert the data into the Queue
    public void Enqueue(int data){
        if(rear>size-1){
            System.out.println("The queuee is full");
            }
        else if(front==-1 && rear==-1){
            front=rear=0;
            Queue[rear]=data;
        }    
        else{
            ++rear;
            Queue[rear]=data;
        }    
}


// Now remove the data from the Queue from the front of the queue 
public void Dequeue(){
    if(front==-1 && rear==-1){
        System.out.println("the queue is empty");
    }
    else if(front==rear){
        front=rear=-1;
    }
    else{
        front++;
    }
}

//Display the front element of the queue 
public void frontElement(){
    if(front==-1 && rear==-1){
        System.out.println("the queue is empty");
    }
    else{
        System.out.printf("The front element is %d",Queue[front]);
    }
}


//Display all the elemnt of the queue from front to the rear

public void Display(){
    if(front==-1 && rear==-1){
        System.out.println("the queue is empty");
    }
    else{ int temp=front;
        while (temp<=rear) {
            System.out.println(Queue[temp]+" ");
            temp++;
        }
    }
}


// main function 
public static void main(String[] args) {
    QueueUsingARR q= new QueueUsingARR();
    q.Enqueue(12);
    q.Dequeue();
    q.Enqueue(100);
    q.Enqueue(77);
    q.Enqueue(65);
    q.Display();
    q.frontElement();
}

}

