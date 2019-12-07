package executionEngine;

import java.util.Iterator;
import java.util.List;
import java.util.Queue;

public class IntCodeUtils {

    public static<T> T getLast(List<T> items){
        return items.get(items.size()-1);
    }

    public static<T> T getLast(Queue<T> items){
        T lastItem = null;
        final Iterator<T> iterator = items.iterator();

        while(iterator.hasNext()){
            lastItem=iterator.next();
        }
        return lastItem;
    }
}
