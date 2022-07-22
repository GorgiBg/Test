public class DoublyLinkedList {

    private Node first;
    private Node last;
    int size =0;

    public void addFirst(int element){
        Node node = new Node(element);
        if (this.size ==0){
            this.first = node;
            this.last = node;
        }else {
            node.previous = this.last;
            this.last.next = node;
            this.last = node;
        }
        this.size++;
    }

    public class Node{
        private int item;
        private Node next;
        private Node previous;

        public Node(int item) {
            this.item = item;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node current = first;
        while (current != null){
            sb.append(current.item);
            current = current.next;
        }
        return sb.toString();
    }
}
