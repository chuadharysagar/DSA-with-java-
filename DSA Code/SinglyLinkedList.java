class SinglyLinkedList {
    private Node head;
    private Node tail;
    private int size;

    // constructer for the szie count # when the Class will be intialized the
    // constructer will intilazie and sdize==0
    public SinglyLinkedList() {
        size = 0;
    }

    // singly linkerd list
    class Node {
        private int data;
        private Node next;

        public Node(int data) {
            this.data = data;
        }

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    // node insertion
    public void InsertNode(int val) {
        Node newnode = new Node(val);

        if (head == null && tail == null) {
            head = tail = newnode;

        } else {
            tail.next = newnode;
            tail = newnode;
        }
        size++;
    }

    // Display the all the node of the List
    public void Display(Node head) {
        Node temp = head;
        if (temp == null) {
            System.out.println("List is empty");
            return;
        } else {
            while (temp != null) {
                System.out.print(temp.data + "->");
                temp = temp.next;
            }
            System.out.print("NULL\n");
        }
    }

    // insert the node at First position
    public void Insertfirst(int val) {
        Node newnode = new Node(val);
        newnode.next = head;
        head = newnode;
        System.out.println("node inserted at first");
        size++;
    }

    // Insert at any position
    public void InsertAtanyPosition(int val, int position) {
        if (position > size) {
            System.out.println("the list is of size" + size + "Inserted at last");
            InsertNode(val);
        } else {
            Node newnode = new Node(val);
            Node temp = head;
            for (int i = 1; i < position - 1; i++) {
                temp = temp.next;
            }
            newnode.next = temp.next;
            temp.next = newnode;
            System.out.println("node inserted at " + position);
            size++;

        }
    }

    // Delete node at first position
    public void DelAtFirst() {
        head = head.next;
        size--;
    }

    // delete at any position
    public void DelAtAny(int pos) {
        if (pos == 1) {
            DelAtFirst();
        }
        Node temp = head;
        for (int i = 1; i < pos - 1; i++) {
            temp = temp.next;
        }
        temp.next = temp.next.next;
        size--;
        System.out.println("node deleted");
    }

    // Delete at last position of the linked list
    public void DelLast() {
        Node temp = head;
        Node prev = head;
        while (temp.next != null) {
            prev = temp;
            temp = temp.next;
        }
        prev.next = null;
        size--;
    }

    // Reverse the linked list
    public Node ListReverse(Node head) {
        Node temp, prev, nextnode;
        prev = null;
        temp = nextnode = head;
        while (nextnode != null) {
            nextnode = nextnode.next;
            temp.next = prev;
            prev = temp;
            temp = nextnode;
        }

        return prev;
    }

    // now to remove the duplicate element from the list
    public void RemDuplicate() {
        Node temp = head;
        Node prev = temp;
        while (temp != null) {
            prev = temp;
            temp = temp.next;
            if (temp != null && prev.data == temp.data) {
                while (temp != null && prev.data == temp.data) {
                    temp = temp.next;
                }
                prev.next = temp.next;
            }

        }
        System.out.println("duplicate removed");
    }

    // find the mid node of the list we can use the fast and slow pointer to find
    // the mid node
    public Node MidNode(Node head) {
        Node slow = null;
        Node fast = head;
        while (fast != null && fast.next != null) {
            if (slow == null) {
                slow = head;
            } else {
                slow = slow.next;
            }
            fast = fast.next.next;
        }

        Node mid = (slow != null) ? slow.next : null;
        if (slow != null) {
            slow.next = null; // Divide the list into two parts, then merge it
        }
        return mid;
    }

    // merge two sorted list #divide it into the two list and sort it
    public Node MergeList(Node h1, Node h2) {
        Node dummyhead = new Node(-1);
        Node dummytail = dummyhead;
        while (h1 != null && h2 != null) {
            if (h1.data < h2.data) {
                dummytail.next = h1;
                h1 = h1.next;
            } else {
                dummytail.next = h2;
                h2 = h2.next;
            }
            dummytail = dummytail.next;
        }

        if (h1 == null) {
            dummytail.next = h2;
        } else {
            dummytail.next = h1;
        }

        return dummyhead.next;
    }

    // sort the list by recursion
    public Node sortlist(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node mid = MidNode(head);
        Node left = sortlist(head);
        Node right = sortlist(mid);

        return MergeList(left, right);
    }

    // count list size
    int lengthList(Node head) {
        Node temp = head;
        int l = 0;
        while (temp != null) {
            temp = temp.next;
            l++;
        }
        return l;
    }

    // Reverse list II LEETCODE 92
    public void PartRev(int left, int right) {
        if (left == right) {
            return;
        }
        Node prev = null;
        Node current = head;

        for (int i = 0; i < left - 1 && current != null; i++) {
            prev = current;
            current = current.next;
        }

        Node dummyhead = prev;
        Node Leftnode = current;

        // nodes to be eleminated
        Node nextNode = current.next;
        for (int i = 0; i < right - left + 1 && current != null; i++) {
            current.next = prev;
            prev = current;
            current = nextNode;
            if (nextNode != null) {
                nextNode = nextNode.next;
            }
        }

        if (dummyhead != null) {
            dummyhead.next = prev;
        } else {
            head = prev;
        }

        Leftnode.next = current;
    }

    // MidddleNode of the List
    public Node MidddleNode() {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        Node temp = slow.next;
        slow.next = null;
        return temp;
    }

    // ReOrder the List #LeetCode 143
    public Node Roederist(Node h1, Node h2) {
        Node temp;
        Node copy = h1;
        while (h2 != null && h2 != null) {
            temp = h1.next;
            h1.next = h2;
            h1 = temp;

            temp = h2.next;
            h2.next = h1;
            h2 = temp;

        }
        return copy;
    }

    Node checkpos(Node head, int pos) {
        Node next = head;
        for (int i = 0; i < pos - 1; i++) {
            next = next.next;
        }
        return next;
    }

    public Node RotateList(int n) {
        int len = lengthList(head);
        Node temp = head;
        if (n == 0 || n == len) {
            return head;
        }
        if (n > len) {
            n = n - len;
        }

        for (int i = 0; i < (len - n - 1); i++) {
            temp = temp.next;
        }
        Node temp2 = temp.next;
        Node temp3 = temp2;
        temp.next = null;
        while (temp2.next != null) {
            temp2 = temp2.next;
        }
        temp2.next = head;

        return temp3;
    }

    // swap the adjacent node of the list
    public Node SwapInPair() {
        int n = lengthList(head) / 2;
        Node temp = head;
        head = head.next;
        Node prev;
        Node temp2;
        while (n > 0 && temp != null) {
            prev = temp;

            for (int i = 0; i < 1; i++) {
                prev = temp;
                temp = temp.next;
            }
            temp2 = temp;
            temp.next = prev.next;
            prev.next = temp2;
            temp = temp2;
            --n;
        }
        return head;
    }


    //Leetcode No.82 Remove Duplicates II
    public Node EliminateDuplicateNode() {
        Node newhead = null;
        Node temp = null;
        Node nextNode = head;
        Node prev = head;

        while (nextNode != null) {
            prev = nextNode;
            nextNode = nextNode.next;

            if (nextNode != null && prev.data == nextNode.data) {
                while (nextNode != null && prev.data == nextNode.data) {
                    nextNode = nextNode.next;
                }

                // Update temp and newhead when duplicates are encountered
                if (newhead == null) {
                    newhead = temp = nextNode;
                } else {
                    temp.next = nextNode;
                }
                prev = nextNode;
            } else {
                // Update temp and newhead when no duplicates
                if (newhead == null) {
                    newhead = temp = prev;
                } else {
                    temp.next = prev;
                    temp = temp.next;
                }
            }
        }
        temp.next=nextNode;

        return newhead;
    }

    // Reverse k Node in group LeetCode 25
    // public Node RverseKNode(Node head,int k){
    // int len= lengthList(head);
    // int N = len/k;
    // while(N>0){
    // for(int i=0 ;i<k-1;i++){

    // }
    // }
    // }
    // Main Function
    public static void main(String[] args) {
        SinglyLinkedList ll = new SinglyLinkedList();
        ll.InsertNode(1);
        ll.InsertNode(1);
        ll.InsertNode(2);
        // ll.InsertNode(3);
        // ll.InsertNode(3);
        // ll.InsertNode(4);
        // System.out.println(ll.size);
        // ll.InsertNode(4);
        // ll.InsertNode(6);
        // ll.InsertNode(7);
        // Node N=ll.checkpos(ll.head,2);
        // System.out.println("pos "+N.data);

        // Node temp1= ll.checkpos(ll.head,2);
        // System.out.println(ll.lengthList(ll.head)/2);
        ll.Display(ll.head);
        // Node swap=ll.SwapInPair();
        Node Rem=ll.EliminateDuplicateNode();
        ll.Display(Rem);

        // Node cnode=ll.RotateList(10);
        // ll.RemDuplicate();
        // ll.InsertAtanyPosition(700,2);
        // ll.DelLast();
        // ll.ListReverse();
        // System.out.println("size"+ll.size);
        // Node result = ll.MidddleNode();
        // System.out.println("the mid node is " + result.data);

        // ll.Display(ll.head);
        // Node check= ll.position(4);
        // System.out.println("position "+check.data);
        // ll.PartRev(2,4);
        // Node temp1=ll.ListReverse(result);
        // Node check=ll.Roederist(ll.head,temp1);
        // ll.Display(check);

    }

}