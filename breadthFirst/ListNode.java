class ListNode{
    Node treeNode;
    ListNode next;

    ListNode(Node treeNode){
        this.treeNode = treeNode;
    }

    ListNode(Node treeNode,ListNode head){
        this.treeNode = treeNode;
        this.next = head;
    }

}