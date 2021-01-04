import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LinkedListAdv {
    private Node first;

    private class Node{
        private int data;
        private Node next;

        public Node(int data, Node next){
            this.data = data;
            this.next = next;
        }

        public Node(int data){
            this(data, null);
        }
    }

    public void add(int value){
        Node pointer = first;
        if(pointer == null){
            first = new Node(value);
            return;
        }
        while(pointer.next != null){
            pointer = pointer.next;
        }
        pointer.next = new Node(value);
    }

    public int indexOf (int value){
        int index = 0;
        Node pointer = first;
        while (pointer != null) {
            if (pointer.data == value){
                return index;
            }
            pointer = pointer.next;
            index++;
        }

        return -1;
    }

    private int size(){
        int size = 0;
        Node pointer = first;
        while (pointer != null) {
            size++;
            pointer = pointer.next;
        }
        return size;
    }

    public void insertAt(int position, int data) {
        int size = size();
        if (position > size || position < 0) return; // >= ? >

        if (position == 0) {
            insertFirst(data);
        } else if (position <= size) {
            insert(position, data);
        }
    }

    private void insertFirst(int value) {
        Node newNode = new Node(value);
        newNode.next = first;
        first = newNode;
    }

    private void insert(int position, int value) {
        int currentPosition = 0;
        Node pointer = first;
        while (currentPosition < position - 1) {
            currentPosition++;
            pointer = pointer.next;
        }
        Node newNode = new Node(value);
        Node oldNext = pointer.next;
        pointer.next = newNode;
        newNode.next = oldNext;
    }

    public Iterable<Node> nodesGreaterThan(int thisValue){
        Node pointer = first;
        List<Node> greaterNodes = new ArrayList<>();
        while (pointer != null) {
            if (pointer.data > thisValue) {
                greaterNodes.add(pointer);
            }
            pointer = pointer.next;
        }

        return greaterNodes;
    }

    public int compare (int position1, int position2) {
        Node firstElement = null;
        Node secondElement = null;
        Node pointer = this.first;
        int currentPosition = 0;
        if (!isValidPosition(position1) || !isValidPosition(position2)) {
            throw new IllegalArgumentException("positions should be between 0 and " + (size() - 1) + "(max index)");
        }

        while (firstElement == null || secondElement == null) {
            if (currentPosition == position1) {
                firstElement = pointer;
            }
            if (currentPosition == position2) {
                secondElement = pointer;
            }

            pointer = pointer.next;
            currentPosition++;
        }

        return (firstElement.data > secondElement.data) ? position1 : position2;
    }


    private boolean isValidPosition(int position) {
        return position >= 0 && position < size();
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node pointer = first;
        while (pointer != null) {
            sb.append(pointer.data + " -> ");
            pointer = pointer.next;
        }
        sb.append("null");
        return sb.toString();
    }

    public static void main(String[] args) {
        LinkedListAdv list = new LinkedListAdv();

        list.add(5);
        list.add(10);
        list.add(15);
        list.add(20);
        list.add(25);
        list.add(30);
        Iterable<Node> greaterNodes = list.nodesGreaterThan(15);
        Iterator<Node> iter = greaterNodes.iterator();

        while (iter.hasNext()) {
            System.out.println(iter.next().data);
        }
        System.out.println("---loop ended---");

        System.out.println(list);
        System.out.println(list.indexOf(5));
        System.out.println(list.indexOf(25));
        System.out.println(list.indexOf(15));
        System.out.println(list.size());

        list.insertAt(5, 222);
        System.out.println(list);
        list.insertAt(0, 233);
        System.out.println(list);
        list.insertAt(7, 266);
        System.out.println(list);
        list.insertAt(8, 276);
        System.out.println(list);
        list.insertAt(9, 300);
        System.out.println(list);
        System.out.println(list.size());
        list.insertAt(11, 320);
        System.out.println(list);
        list.insertAt(14, 330);
        System.out.println(list);
        System.out.println("Comparing");
        System.out.println(list.compare(3, 7));
        System.out.println(list.compare(5, 2));
        System.out.println(list.compare(1, 2));
        System.out.println(list.compare(0, 3));
        System.out.println(list);
        System.out.println(list.compare(0, list.size()));

    }
}
