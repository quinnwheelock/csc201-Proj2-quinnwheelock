import java.util.Iterator;
import java.util.NoSuchElementException;

public class WCLinkedList implements Iterable<WordCount> {
    Node head;
    Node tail;


    public static class Node {
        WordCount data;
        Node next;
        Node prev;

        public Node(WordCount data, Node next, Node prev){
            this.data = data;
            this.next = next;
            this.prev = prev;
        }

    }
    public WCLinkedList(){
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

    boolean contains(WordCount wc){
        boolean contain = false;
        Node curr = head;
        //System.out.println(curr.data.getWord());
        //System.out.println(wc.getWord());
        while(curr != null && !contain){
            if(curr.data.getWord().equals(wc.getWord())) {
                contain = true;
            }
            //System.out.println("curr: " + curr.data.getWord());
            //System.out.println("wc " + wc.getWord());
            //System.out.println(contain);
            curr = curr.next;

        }
        //System.out.println(contain + " "+ wc.toString());
        if(contain)
           wc.incrementCount();
        //System.out.println(wc.toString());
        //System.out.println(contain + " " + wc.toString());

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
    void addFirst(WordCount data){
        if(head == null){
            head = new Node(data,null,null);
        }
        else {
            Node temp = new Node(data, head, null);
            head = temp;
        }
    }
    public Node refNode(WordCount wc){
        Node temp = head;
        while(!temp.data.getWord().equals(wc.getWord())){
            temp = temp.next;
        }
        return temp;
    }

    public String toString(){
        Node curr = head;
        String output = "";

        while(curr != null){
            output += curr.data.getWord() + " " +curr.data.getCount() +"\n" ;
            curr = curr.next;


        }
        return output;
    }



    public class DListIterator implements Iterator<WordCount> {
        public Node nextNode = head;

        @Override
        public boolean hasNext(){
            return nextNode != null;
        }
        @Override
        public WordCount next(){
            if (!hasNext())
                throw new NoSuchElementException("Iter exceeded");
            WordCount data = nextNode.data;
            nextNode = nextNode.next;
            return data;

        }

    }

    public Iterator iterator(){
        return new DListIterator();
    }







}


