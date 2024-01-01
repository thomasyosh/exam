class Node{
    int data;
    Node left,right;

    Node(int data){
        this.data = data;
    }

    Node getLeft(){
        return left;
    }

    Node getRight(){
        return right;
    }

    int getData(){
        return data;
    }

    void setLeft(Node leftNode){
        this.left = leftNode;
    }

    void setRight(Node rightNode){
        this.right = rightNode;
    }
}