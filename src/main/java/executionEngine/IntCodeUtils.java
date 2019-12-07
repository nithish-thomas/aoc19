package executionEngine;

import java.util.List;

public class IntCodeUtils {

    public static<T> T getLast(List<T> items){
        return items.get(items.size()-1);
    }
}
