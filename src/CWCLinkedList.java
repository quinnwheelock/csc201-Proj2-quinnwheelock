public class CWCLinkedList extends WCLinkedList {

    public boolean contains(WordCount wc){
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
        if(contain){
            wc.incrementCount();
            swapNode(refNode(wc));

        }


        return contain;
    }

    public void swapNode(Node nd){
        if(nd.prev == null)
            return;
        if((nd.data.compareTo(nd.prev.data) < 0))
            return;
        if(head == null)
            throw new RuntimeException("DLL is empty");
        if(head.next == null)
            throw new NullPointerException("DLL has one node");

        int num = indexOf(nd.data.getWord());

        Node temp = head;
        for(int i = 0;i<num;i++){
            temp = temp.next;
        }
        if(temp.prev != null) {
            Node second = temp.prev;
            WordCount td = temp.data;
            temp.data = second.data;
            second.data = td;
        }

    }

}
