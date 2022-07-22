import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class LinkList  implements List<Integer> {

    Node first;
    Node last;
    int size = 0;



    public static class Node{
        int value;
        Node next;
        Node prev;
        public Node(int value) {
            this.value= value;
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<Integer> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean add(Integer integer) {
        Node current = new Node(integer);
        if (this.first == null){
            this.first = current;
            this.last = current;
        }else{
            this.last.next = current;
            current.prev = this.last;
            this.last = current;
        }

        size++;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        int value = (int) o;
        Node current = this.first;
        while (current != null){
            if (current.value == value){
                current.prev.next = current.next;
                current.next.prev = current.prev;
                size--;
                return true;
            }
            current = current.next;
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends Integer> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends Integer> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {
        this.first = null;
        this.last = null;
        size = 0;
    }

    @Override
    public Integer get(int index) {
        return null;
    }

    @Override
    public Integer set(int index, Integer element) {
        return null;
    }

    @Override
    public void add(int index, Integer element) {

    }

    @Override
    public Integer remove(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<Integer> listIterator() {
        return null;
    }

    @Override
    public ListIterator<Integer> listIterator(int index) {
        return null;
    }

    @Override
    public List<Integer> subList(int fromIndex, int toIndex) {
        return null;
    }

    @Override
    public String toString() {
        if (size <=0){
            return "empty";
        }
        StringBuilder sb = new StringBuilder();
        Node current = first;
        while (current != null){
            sb.append(current.value).append(" ");
            current = current.next;
        }
        return sb.toString();
    }
}
