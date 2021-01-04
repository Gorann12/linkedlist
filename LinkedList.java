public class LinkedList {
    private Node first;
    private Node last;
    private int size;
    private int sum;

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

    public void add(int data){
        Node newNode = new Node(data);
        if(first == null){
            first = newNode;
            last = first;
        }else{
            last.next = newNode;
            last = newNode;
        }

        size++;
        sum += data;
    }

    public String printAll(){
        StringBuilder sb = new StringBuilder();
        Node pointer = first;
        while(pointer != null){
            sb.append(pointer.data + " -> ");
            pointer = pointer.next;
        }
        sb.append("null");
        return sb.toString();
    }

    public void removeElement(int position){
        Node pointer = first;

        if (position <= size && position >= 0)
        {
           for (int i = 0; i < position - 2; i++)
           {
               pointer = pointer.next;
           }
           if (position > 0) {
               sum -= pointer.next.data;
               pointer.next = pointer.next.next;
           } else {
               sum -= pointer.data;
               first = pointer.next;
               pointer = null;
           }
           size--;
        }
    }

    private int size(){
        return size;
    }

    public double average(){
        if(size == 0) throw new ArithmeticException("Linked list is empty");
        return (double)sum / size;
    }


    public static void main(String[] args) {
        //Tests
        LinkedList list = new LinkedList();
        list.add(5);
        list.add(10);
        list.add(15);
        list.add(20);
        list.add(25);
        list.add(30);
        list.add(35);

        System.out.println(list.printAll());
        System.out.println("Average: " + list.average());
        System.out.println(list.size());
        list.removeElement(4);
        System.out.println(list.printAll());
        list.removeElement(6);
        System.out.println(list.printAll());
        list.removeElement(7);
        System.out.println(list.printAll());
        System.out.println(list.average());
        list.removeElement(1);
        System.out.println(list.printAll());
        list.removeElement(0);
        System.out.println(list.size());
        System.out.println(list.printAll());
        list.removeElement(0);
        System.out.println(list.size());
        System.out.println(list.printAll());
        list.removeElement(0);
        System.out.println(list.size());
        System.out.println(list.printAll());
        list.removeElement(0);
        System.out.println(list.size());
        System.out.println(list.printAll());
    }
}
