public class LinkedList{
    public static class Node{
        int data;
        Node next;
        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    public static Node head;
    public static Node tail;
    public static int size;

    public void addFirst(int data){
        //step1 = create new node
        Node newNode = new Node(data);
        size++;
        if(head == null){
            head = tail = newNode;
            return;
        }

        //step2 = newNode next = head
        newNode.next = head;//link

        //step3 = head = newNode
        head = newNode;
    }

    public void addLast(int data){
        //step1 = create new node
        Node newNode = new Node(data);
        if(tail == null){
            head = tail = newNode;
            return;
        }
        //step2 = tail next = newNode
        tail.next = newNode;

        //step3 = tail = newNode
        tail = newNode;
        size++;
    }

    public void printList(){
        if(head == null){
            System.out.println("List is empty");
            return;
        }
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("null");
    }
    public void add(int index,int data){
        if(index == 0){
            addFirst(data);
            return;
        }
        Node newNode = new Node(data);
        size++;
        Node temp = head;
        int i=0;
        while(i<index-1 && temp!=null){
            temp = temp.next;
            i++;
        }
        if(temp == null){
            System.out.println("Index out of bounds");
            return;
        }
        newNode.next = temp.next;
        temp.next = newNode;
        if(newNode.next == null){
            tail = newNode;
        }
    }
    public int removeFirst(){
        if(head == null){
            System.out.println("List is empty");
            return -1;
        }else if(size == 1){
            int val = head.data;
            head = tail = null;
            size--;
            return val;
        }
        int val = head.data;
        head = head.next;
        size--;
        return val;
    }
    public int removeLast(){
        if(size == 0){
            System.out.println("List is empty");
            return -1;
        }else if(size == 1){
            int val = head.data;
            head = tail = null;
            size--;
            return val;
        }
        Node prev = head;
        for(int i = 0; i<size-2; i++){
            prev = prev.next;
        }
        int val = tail.data;
        prev.next = null;
        tail = prev;
        size--;
        return val;
    }

    public int itrSearch(int key){
        Node temp = head;
        int i = 0;
        while(temp != null){
            if(temp.data == key){
                return i;
            }
            temp = temp.next;
            i++;
        }
        return -1;
    }

    public int helper(Node head, int key){
        if(head == null){
            return -1; // Base case: key not found
        }
        if(head.data == key){
            return 0; // Key found at current position
        }
        int index = helper(head.next, key); // Recursive call
        if(index == -1){
            return -1;
        }else{
            return index + 1; // Increment index for the current node
        }
    }

    public int recSearch(int key){
        return helper(head, key);
    }

    public void reverse(){
        if(head == null || head.next == null){
            return; // List is empty or has only one element
        }
        Node prev = null;
        Node curr = tail = head;
        Node next ;
        
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;

    }

    public void deleteNthFromENd(int n){
        int sz = 0;
        Node temp = head;
        while(temp!=null){
            temp = temp.next;
            sz++;
        }
        if(n == sz ){
            head = head.next;
            size--;
            return;
        }

        int i =1;
        int iToFind = sz - n;
        Node prev = head;
        while(i < iToFind){
            prev = prev.next;
            i++;
        }

        prev.next = prev.next.next;
        if(prev.next == null){
            tail = prev;
        }
        size--;
        return;
    }

    public Node findMid(Node head){
        Node slow = head;
        Node fast = head;
        while(fast!=null && fast.next!= null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow; // Mid node
    }

    public boolean checkPalindrome(){
        //step1 = find mid
        Node midNode = findMid(head);
        if(midNode == null || midNode.next == null){
            return true; // List is empty or has only one element
        }
        Node secondHalf = midNode.next;
        midNode.next = null; // Split the list into two halves

        //step2 = reverse second half
        Node prev = null;
        Node curr = midNode;
        Node next;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        Node right = prev;
        Node left = head;

        //step3 = compare first half and second half
        while(right != null){
            if(left.data != right.data){
                return false; // Not a palindrome
            }
            left = left.next;
            right = right.next;
        }
        return true; // Is a palindrome
    }

    public static boolean isCycle(){ //Floyd's Cycle Detection Algorithm
        Node fast;
        Node slow;
        fast = slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                return true; // Cycle detected
            }
        }
        return false; // No cycle detected
    }

    public static void removeCycle(){
        Node fast;
        Node slow;
        boolean cycle = false;
        fast = slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                cycle = true; // Cycle detected
                break;
            }
        }
        if(cycle == false){
            System.out.println("No cycle to remove");
            return;
        }
        slow = head;
        Node prev = null;
        if(slow == fast){
            while(fast.next != slow){
                fast = fast.next;
            }
            fast.next = null;
            return;
        }
        while(slow != fast){
            prev = fast;
            fast = fast.next;
            slow = slow.next;
        }

        // Now fast and slow are at the start of the cycle
        if(prev != null){   
            prev.next = null; // Remove the cycle by breaking the link
        }
    }

    private Node getMid(Node head){
        Node slow = head;
        Node fast = head.next;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;

    }

    private Node merge(Node head1 , Node head2){
        Node mergedLL = new Node(-1);
        Node temp = mergedLL;

        while(head1 != null && head2 != null){
            if(head1.data <= head2.data){
                temp.next = head1;
                head1 = head1.next;
                temp = temp.next;
            }else{
                temp.next = head2;
                head2 = head2.next;
                temp = temp.next;
            }
        }
        while(head1 != null){
            temp.next = head1;
            head1 = head1.next;
            temp = temp.next;
        }
        while(head2 != null){
            temp.next = head2;
            head2 = head2.next;
            temp = temp.next;
        }
        return mergedLL.next;
    }

    public Node mergeSort(Node head){
        if(head == null || head.next == null) return head;
        //find mid
        Node mid = getMid(head);
        //left & right MS
        Node rightHead= mid.next;
        mid.next = null;
        Node newLeft = mergeSort(head);
        Node newRight =mergeSort(rightHead);

        //merge
        return merge(newLeft, newRight);
    }

    public void zigZag(){
        //find mid
        Node slow = head;
        Node fast = head.next;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        Node mid = slow ;

        //reverse 2nd half
        Node curr = mid.next;
        mid.next = null;
        Node prev = null;
        Node next;

        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        Node left = head;
        Node right = prev;
        Node nextL ; 
        Node nextR;

        //alt merge - zigzag merge
        while(left != null && right != null){
            nextL = left.next;
            left.next = right;
            nextR = right.next;
            right.next = nextL;

            left = nextL;
            right = nextR;
        }
    }

    public static void main(String[] args){
        LinkedList ll = new LinkedList();
        ll.addFirst(1);
        ll.addFirst(2);
        ll.addFirst(3);
        ll.addFirst(4);
        ll.addFirst(5);
        ll.printList();
        ll.head = ll.mergeSort(ll.head);
        ll.printList();
        ll.zigZag();
        ll.printList();
        // head = new Node(1);
        // Node temp = new Node(2);
        // head.next = temp;
        // head.next.next = new Node(3);
        // head.next.next.next = head;
        // System.out.println(isCycle());
        // System.out.println("Removing cycle...");
        // removeCycle();
        // System.out.println(isCycle());

    }
}