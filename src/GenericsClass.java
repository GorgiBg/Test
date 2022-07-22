import java.util.ArrayList;
import java.util.List;

public class GenericsClass <T>{
    private T data;

    public GenericsClass(T data) {
        this.data = data;
    }
    public T getData(){
        return this.data;
    }
    public static <T extends Number> void genericsMethod (T data){
        System.out.println("This is the data: " + data);
    }

    public ArrayList<T> listAdd(T t){
        ArrayList<T> list = new ArrayList<>();
        list.add(t);
        return list;
    }

}
