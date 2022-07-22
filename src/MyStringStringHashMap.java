import java.util.*;

public class MyStringStringHashMap implements Map<String, String>{

    List<HashObject>[] hashList = new ArrayList[10];
    int size;

    public MyStringStringHashMap() {
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
    public boolean containsKey(Object key) {
        int hash = calcHash(key);
        for (HashObject hashObject : hashList[hash]) {
            if (hashObject.getKey().equals(key)){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        for (List<HashObject> hashObjects : hashList) {
            for (HashObject hashObject : hashObjects) {
                if (hashObject.getValue().equals(value)){
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public String get(Object key) {
        return null;
    }

    @Override
    public String put(String key, String value) {
        int index = calcHash(key);
        List<HashObject> objects = this.hashList[index];
        if (objects.size() == 0){
            HashObject hashObject = new HashObject(key, value);
            objects.add(hashObject);
            size++;
            return null;
        }else{
            for (HashObject object : objects) {
                if (object.getKey().equals(key)){
                    object.setValue(value);
                    return null;
                }
            }
            objects.add(new HashObject(key, value));
            size++;
        }
        return null;
    }



    @Override
    public String remove(Object key) {
        return null;
    }

    @Override
    public void putAll(Map<? extends String, ? extends String> m) {

    }

    @Override
    public void clear() {

    }

    @Override
    public Set<String> keySet() {
        return null;
    }

    @Override
    public Collection<String> values() {
        return null;
    }

    @Override
    public Set<Entry<String, String>> entrySet() {
        return null;

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (List<HashObject> hashObjects : this.hashList) {
            for (HashObject hashObject : hashObjects) {
                sb.append(hashObject.getKey()).append(" ")
                        .append(hashObject.getValue())
                        .append(System.lineSeparator());
            }

        }
        return sb.toString();
    }

    private <T> int calcHash(T t) {
        int hash = t.hashCode();
        return Math.abs(hash % 10);
    }
    public class HashObject {
        String key;
        String value;

        public HashObject(String key, String value) {
            this.key = key;
            this.value = value;
        }

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }
}
