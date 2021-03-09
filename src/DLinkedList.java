import java.util.Iterator;
import java.util.NoSuchElementException;

public class DLinkedList implements Iterable<String> {


        Node head;
        Node tail;


        public static class Node {
            String data;
            Node next;
            Node prev;

            public Node(String data, Node next, Node prev){
                this.data = data;
                this.next = next;
                this.prev = prev;
            }

        }
        public DLinkedList(){
            head = null;
            tail = null;

        }


        //Do i need to make this without a parameter?
        Boolean isEmpty(){
            Boolean check = false;
            if(head == null)
                check=true;

            return check;

        }

        boolean contains(String data){
            boolean contain = false;
            Node curr = head;
            while(curr != null && !contain){
                if(curr.data .equals(data))
                    contain = true;
                curr = curr.next;
            }
            return contain;

        }
        int size(){
            Node curr = head;
            int counter = 0;
            while(curr != null){
                curr = curr.next;
                counter++;
            }
            return counter;
        }

        int indexOf(String data){
            Node curr = head;
            boolean in = false;
            int count = 0;

            while(curr.next != null && !in){
                if (curr.data.equals(data))
                    in = true;
                curr = curr.next;
                count++;
            }
            if(!in)
                return -1;

            return count-1;
        }
        void addFirst(String data){
            if(head == null){
                head = new Node(data,null,null);
            }
            else {
                Node temp = new Node(data, head, null);
                head = temp;
            }
        }

        public String toString(){
            Node curr = head;
            String output = "";

            while(curr != null){
                output += curr.data +"\n" ;
                curr = curr.next;


            }
            return output;
        }


        public class DListIterator implements Iterator<String> {
            public Node nextNode = head;

            @Override
            public boolean hasNext(){
                return nextNode != null;
            }
            public String next(){
                if (!hasNext())
                    throw new NoSuchElementException("Iter exceeded");
                String data = nextNode.data;
                nextNode = nextNode.next;
                return data;

            }

        }

        public Iterator iterator(){
            return new DListIterator();
        }









}
