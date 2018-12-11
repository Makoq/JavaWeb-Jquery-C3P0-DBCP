package heimaexc.entity;

import java.util.HashMap;
import java.util.Map;

public class DButil {

    private static Map<String, heimaexc.entity.book> book = new HashMap<>();

    static {
        book.put("1", new book("1", "西游记", "2.5", "张三"));
        book.put("2", new book("2", "格列夫游记", "3.5", "李四"));
        book.put("3", new book("3", "红楼梦", "5.5", "王五"));
        book.put("4", new book("4", "水浒传", "6.5", "王二麻子"));
        book.put("5", new book("5", "三国演义", "7.5", "孤独求败"));
    }

    public static Map<String, book> showAllBooks() {
        return book;

    }

    public static book getBooksById(String id) {
        return book.get(id);

    }


}
