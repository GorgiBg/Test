import java.util.*;

public class MyStringHashSet implements Set<String> {

    List<String>[] hashList = new ArrayList[10];
    int size;

    public MyStringHashSet() {
        for (int i = 0; i < 10; i++) {
            hashList[i] = new ArrayList<>();
        }
        size = 0;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public boolean contains(Object o) {
        if (!(o instanceof String)) {
            return false;
        }
        int index = calcHash(o);
        if (this.hashList[index].size() == 0) {
            return false;
        }
        for (String s : this.hashList[index]) {
            if (o.equals(s)) {
                return true;
            }
        }
        return false;
    }

    private <T> int calcHash(T t) {
        int hash = t.hashCode();
        return Math.abs(hash % 10);
    }

    @Override
    public Iterator<String> iterator() {
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
    public boolean add(String s) {

        int index = calcHash(s);
        List<String> toAdd = hashList[index];
        if (size == 0) {
            toAdd.add(s);
            this.size++;
            return true;
        }
        if (toAdd.contains(s)) {
            return false;
        } else {
            toAdd.add(s);
            this.size++;
            return true;
        }
    }

    @Override
    public boolean remove(Object o) {
        if (!(o instanceof String)) {
            return false;
        }
        int index = calcHash(o);
        List<String> list = hashList[index];
        boolean isRemoved = list.removeIf(e -> e.equals(o));
        if (isRemoved){
            this.size --;
        }
        return isRemoved;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends String> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {
        this.size = 0;
        for (List<String> list : this.hashList) {
            list.clear();
        }
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Arrays.stream(hashList)
                .filter(Objects::nonNull)
                .forEach(sb::append);
        return sb.toString();
    }
}
