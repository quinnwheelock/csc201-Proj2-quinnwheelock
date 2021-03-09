public class TWCLinkedList extends WCLinkedList {
    public boolean contains(WordCount wc){
        boolean contain = false;
        Node curr = head;
        //System.out.println(wc.getWord());
        //System.out.println(curr.data.getWord());
        //System.out.println(wc.getWord());
        while(curr != null && !contain){
            if(curr.data.getWord().equals(wc.getWord())) {
                curr.data.incrementCount();
                //System.out.println(curr.data.toString());
                swapNode(curr);
                contain = true;
            }
//            System.out.println("curr: " + curr.data.getWord());
//            System.out.println("wc " + wc.getWord());
//            System.out.println(contain);
            curr = curr.next;

        }
        //System.out.println(contain + " "+ wc.toString());
//            if(contain){
//                wc.incrementCount();
//                swapNode(refNode(wc));
//
//            }


            return contain;
    }

    public void swapNode(Node nd){

        if(head == null)
            return;

        if(head.next == null)
            return;

        //int num = indexOf(nd.data.getWord());

        Node temp = head;
//        for(int i = 0;i<num;i++){
//            temp = temp.next;
//        }
        temp = nd;
        if(temp.prev != null) {
           // System.out.println(temp.data.toString() + temp.prev.data.toString());
            Node second = temp.prev;
            WordCount td = temp.data;
            temp.data = second.data;
            second.data = td;
            //System.out.println(temp.data.toString() + temp.prev.data.toString());
        }


    }


}
