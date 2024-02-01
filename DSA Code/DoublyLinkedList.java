import org.w3c.dom.Node;

public class DoublyLinkedList {
       private Dnode head;
       private Dnode tail;
       private int size;

        public  DoublyLinkedList(){
            this.size=0;
         }

    class Dnode {
        private int data;
        private Dnode next;
        private Dnode prev;

        public Dnode(int data) {
            this.data = data;
        }  
    }


    // insertion of the node at the last of the list Dobly linked list
      public void NodeInsert(int val){
        Dnode newnode = new Dnode(val);
        newnode.next=newnode.prev=null;
        if(head==null &&  tail == null){
            newnode.next=newnode.prev=null;
            head=tail=newnode;
            
        }
        else{
            tail.next= newnode;
            newnode.prev=tail;
            tail=newnode;
           
        }
        size++;
      }
    


      //Insert  at the beggining of the list
      public void FirstInsert(int val){
        Dnode newnode= new Dnode(val);
        newnode.next=newnode.prev=null;
        if(head==null &&  tail == null){
            newnode.next=newnode.prev=null;
            head=tail=newnode;  
        }
        else{
            newnode.next=head;
            head.prev=newnode;
            head= newnode;
        }
        size++;
      }


      //Inbsert  at the any position 
      public void InserAny(int val,int position){
        if(position>size){
        System.out.println("the list is of size"+size+"Inserted at last");
        NodeInsert(val);
        }
        else{
            Dnode newnode = new Dnode(val);
            Dnode temp= head;
            for(int i=1;i<position-1;i++){
                 temp=temp.next;
            }
            newnode.next=temp.next;
            newnode.prev=temp;
            temp.next.prev=newnode;
            temp.next=newnode;
            System.out.println("node inserted at "+position);
            size++;

        }
      }

      
      //Display function 
      public void Display(){
        Dnode temp=head;
        while(temp!=null){
            System.out.print(temp.data+" -> ");
            temp=temp.next;
        }
        System.out.print("NULL");
      }

//delete at any position 
  public void AnyPosDel(int pos){
     if(pos==1){
        Delfirst();
     }
     else if(pos==size || pos>size){
        DelLast();
     }
     else{
        Dnode temp=head;
       for(int i=1;i<pos-1;i++){
        temp=temp.next;
       }
       temp.next.next.prev=temp;
       temp.next=temp.next.next;
       size--;
       System.out.println("node deleted");
     }

  }

  // delete at first positon os the list
  public void Delfirst(){
    head=head.next;
    head.prev=null;
    size--;
  }

  //Delete at the last position 
  public void DelLast(){
    Dnode temp=head;
        while(temp!=null){
            System.out.print(temp.data+" <-> ");
            temp=temp.next;
        }
        temp.prev.next=null;
        size--; 
        System.out.println("the item is deleted");
  }
      public static void main(String[] args){
       DoublyLinkedList dl= new DoublyLinkedList();
       dl.NodeInsert(90);
       dl.NodeInsert(77);
       dl.NodeInsert(2);
       dl.NodeInsert(7);
       dl.NodeInsert(10);
       dl.NodeInsert(53);
       dl.Display();
       dl.AnyPosDel(3);
       dl.Display();
      }
}
