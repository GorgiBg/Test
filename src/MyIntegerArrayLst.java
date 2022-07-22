import java.util.*;

public class MyIntegerArrayLst implements List<Integer> {

    private int[] numbers;
    private int elementsCounter = 0;

    public MyIntegerArrayLst() {
        this.numbers = new int[4];
    }
    @Override
    public int size() {
        return this.elementsCounter;
    }

    @Override
    public boolean isEmpty() {
        return this.size() == 0;
    }

    @Override
    public boolean contains(Object o) {
        if (!(o instanceof Integer)){
            return false;
        }

        for (int number : this.numbers) {
            if (((Integer) number).equals(o)){
                return true;
            }
        }
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
        if (elementsCounter == numbers.length){
            int[] newNumbers = Arrays.copyOf(numbers, numbers.length +1);
            newNumbers[newNumbers.length-1] = integer;
            elementsCounter++;
            numbers = newNumbers;
            return true;
        }else{
            this.numbers[elementsCounter] = integer;
            elementsCounter++;
            return true;
        }
    }

    private void addElement(Integer integer) {

    }

    @Override
    public boolean remove(Object o) {
        if (!(o instanceof Integer)){
            return false;
        }
        if (numbers.length == 0){
            return false;
        }
        int[] newNumbers = new int[numbers.length-1];
        int indexToRemove = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == (int)o){
                indexToRemove = i;
            }
        }
        System.arraycopy(numbers, 0, newNumbers, 0, indexToRemove);
        for (int i = indexToRemove; i < numbers.length-1 ; i++) {
            newNumbers[i] = numbers[i+1];
        }
        numbers = newNumbers;
        return true;
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
        numbers = new int[Math.max(4, elementsCounter)];
    }

    @Override
    public Integer get(int index) {
        return this.numbers[index];
    }

    @Override
    public Integer set(int index, Integer element) {
        return null;
    }

    @Override
    public void add(int index, Integer element) {
        if (index>= numbers.length || index<0){
            throw new IllegalArgumentException("index out of bounds!");
        }
        int[] newNumbers = new int[numbers.length+1];
        System.arraycopy(numbers,0, newNumbers, 0,index);
        newNumbers[index] = element;
        for (int i = index+1; i < numbers.length+1 ; i++) {
            newNumbers[i] = numbers[i-1];
        }
        numbers = newNumbers;
    }

    @Override
    public Integer remove(int index) {
        if (index<0 || index>= numbers.length){
            throw new IllegalArgumentException("index out of bounds!");

        }
        int[] newNumbers = new int[numbers.length-1];

        System.arraycopy(numbers, 0, newNumbers, 0, index);
        for (int i = index; i < numbers.length-1 ; i++) {
            newNumbers[i] = numbers[i+1];
        }
        numbers = newNumbers;
        return numbers[index];
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
        return Arrays.toString(numbers);
    }
}
