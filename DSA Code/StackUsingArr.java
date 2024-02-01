public class StackUsingArr {
    static final int N= 5;
    static int []  stack= new int [N];
     int top;
    StackUsingArr(){
         top =-1 ;
    }
    
    // push the elemwnt or insert the element 
    public void push(int data){
        if(top==(N-1)){
            System.out.println("the stack is full ");
        }
        else{
            ++top;
            stack[top]=data;
        }
    }
   
    // Pop or Delete the element of the stack
    public void pop(){
        if(top==-1){
            System.out.println("the stack is empty");
        }
        else{
            top--;
        }
    }
    
    //Display all the item of the stack 
    public void Display(){
        if(top==-1){
            System.out.println("the stack is empty");
        }
        else{
            System.out.println("the stack element are following");
            for(int i=top;i>=0;i--){
                System.out.print(stack[i]+" ");
            }
            System.out.println();
        }
    }

    //top most elemnt of the stack 
    public void Peek(){
        System.out.println("the Topmost item of the stack is "+stack[top]);
    }

    // to check if the stack is full
    public void Isfull(){
        if(top==(N-1)){
            System.out.println("the stack is full ");
        }
    }

    // to check if th stack is empty
    public void Isempty(){
        if(top==-1){
            System.out.println("the stack is empty");
        }
    }

    // main Function (Method)

    public static void main(String[] args) {
        StackUsingArr ss = new StackUsingArr();

        // perform some stack operation 
        ss.push(77);
        ss.push(100);
        ss.push(52);
        ss.Display();
        ss.pop();
        ss.Peek();
        ss.Display();
    }
}
