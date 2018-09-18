package Day12;

public interface LineList {
    boolean add(String e, int index);
    String remove(int index);
    void set(int index, String newValue);
    int indexOf(String e);
    boolean isEmpty();
}
