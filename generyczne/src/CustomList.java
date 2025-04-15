import java.util.*;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class CustomList<E> extends AbstractList<E> {
    private class Node{
        E value;
        Node next;

        public Node(E value) {
            this.value = value;
            this.next = null;
        }
    }
    private Node head;
    private Node tail;
    private int size;

    public CustomList() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public E get(int index) {
        if (size <= index || index < 0) {
            throw new IndexOutOfBoundsException("indeks poza zakresem [0, "+(size-1)+"]");
        }
        Node element = head;
        for (int i=0; i<index; i++) {
            element = element.next;
        }
        return element.value;
    }

    public boolean add(E e) {
        addLast(e);
        return true;
    }

    public void addLast(E value) {
        Node newNode = new Node(value);
        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    public E getLast() {
        if (tail == null) {
            throw new IllegalStateException("Lista jest pusta");
        }
        return tail.value;
    }

    public void addFirst(E value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        size++;
    }

    public E getFirst() {
        if (head == null) {
            throw new IllegalStateException("Lista jest pusta");
        }
        return head.value;
    }

    public E removeFirst() {
        if (head == null) {
            throw new IllegalStateException("Lista jest pusta");
        }
        E value = head.value;
        size--;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        return value;
    }

    public E removeLast() {
        if (tail == null) {
            throw new IllegalStateException("Lista jest pusta");
        }
        E value = tail.value;
        size--;

        if(tail == head) {
            // 1 element, wyczyść listę
            head = tail = null;
            return value;
        }

        Node curr = head;
        while (curr.next != tail) {
            curr = curr.next;
        }
        curr.next = null;
        tail = curr;
        return value;
    }

    @Override
    public Iterator<E> iterator() {
        return new Itr(head);
    }

    @Override
    public Stream<E> stream() {
        return StreamSupport.stream(
                Spliterators.spliteratorUnknownSize(this.iterator(), Spliterator.ORDERED),
                false
        );
    }

    private class Itr implements Iterator<E> {
        Node current;

        public Itr(Node current) {
            this.current = current;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            E value = current.value;
            current = current.next;
            return value;
        }
    }

}
