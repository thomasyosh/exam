public class LinkedQueue implements Queue{
    LinkedList list = new LinkedList();

    public void enqueue(Node treeNode){
        list.addToHead(treeNode);
    }

    public Node dequeue() throws EmptyListException{
        return list.removeFromTail();
    }

    public boolean isEmpty(){
        return list.isEmpty();
    }

    public String toString(){
        return list.toString();
    }
}
