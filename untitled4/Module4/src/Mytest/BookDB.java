package Mytest;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

public class BookDB {
    private static Map<String,Book> books=new LinkedHashMap<>();
    static {
        books.put("1",new Book("1","a"));
        books.put("2",new Book("2","b"));
        books.put("3",new Book("3","c"));
        books.put("4",new Book("4","d"));
        books.put("5",new Book("5","e"));
    }
    public static Collection<Book> getAll(){
        return books.values();
    }
    public static Book getBook(String id){
        return books.get(id);
    }
}
