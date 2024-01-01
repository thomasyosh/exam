public class LinkedList {
    ListNode head,tail;
    Node treeNode;
    int count;

    boolean isEmpty(){
        return head == null;
    }

    void addToHead(Node treeNode){
        if (isEmpty())
            head = tail = new ListNode(treeNode);
        else{
            head = new ListNode(treeNode,head);
            
        }
        
        count++;       
    }

    Node removeFromHead() throws EmptyListException{
        if (isEmpty())
            throw new EmptyListException();
        else{
            Node headNode = head.treeNode;
            head = head.next;
            count--;
            return headNode;           
        }
    }

    Node removeFromTail() throws EmptyListException{
        if(isEmpty())
            throw new EmptyListException();

        else if (head==tail){
            ListNode listNode = head;
            head = tail = null;
            return listNode.treeNode;
        }

        else{
            ListNode listNode = head;
            while (listNode.next != tail){
                listNode = listNode.next;
            }
                Node removeTreeNode = tail.treeNode;
                tail = listNode;
                tail.next = null;
            return removeTreeNode;
        }
    }

    public String toString() {
        String s = "[";

        ListNode temp = head;

        while(temp != null){
            s += temp.treeNode.getData();
            System.out.println("HIHIHI");
            temp = temp.next;
        }
        return s +"]";
    }

}
