public class LinkedStack implements Stack{
    private LinkedList list = new LinkedList();

    public int size(){
        return list.getCount();
    }
    
    public boolean isEmpty(){
        return list.isEmpty();
    }

    public void push(Object item) throws StackFullException{
        list.addToHead(item);
    }

    public Object pop() throws StackEmptyException{
        try{
            Object item = list.removeFromHead();
            return item;
        }catch(EmptyListException e){
            throw new StackEmptyException();
        }
    }

    public Object top() throws StackEmptyException{
        try{
            Object item = list.removeFromHead();
            list.addToHead(item);
            return item;
        }catch(EmptyListException e){
            throw new StackEmptyException();
        }
    }

    public String toString(){
        return list.toString();
    }
}
