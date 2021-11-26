

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author Yuyuan Huang
 * @create 2021-06-19 16:26
 */
public class StackBasedOnLinkedList<Items> implements Iterable<Items> {
    private int N;
    private Node head;
    public StackBasedOnLinkedList(){
        head = new Node();
    }
    public void add(Items items){
        Node temp = new Node(items,null);
        temp.next = head;
        head = temp;
        N++;
    }
    public Items pop(){
        if (head==null){
            throw new NoSuchElementException();
        }
        Node temp = head.next;
        head.next = head;
        Items prev = (Items)head.items;
        head = temp;
        N--;
        return prev;
    }
    public int size(){
        return N;
    }
    public boolean isEmpty(){
        return head==null;
    }
    @Override
    public Iterator<Items> iterator(){
        return new LinkedListIterator<>();
    }
    private class LinkedListIterator<Items> implements Iterator<Items>{
        private Node temp = head;

        @Override
        public boolean hasNext() {
            return head.next!=null;
        }

        @Override
        public Items next() {
            Items next = (Items) temp.next.items;
            temp = temp.next;
            return next;
        }

        @Override
        public void remove() {
            try {
                throw new NoSuchMethodException();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
        }




    }

}
class Node<Items>{
    Items items;
    Node next;
    public Node(Items items,Node node){
        this.items = items;
        this.next = node;
    }
    public Node(){
        this.items = null;
        this.next = null;
    }

}

