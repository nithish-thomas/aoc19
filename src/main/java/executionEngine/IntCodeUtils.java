package executionEngine;

import java.util.List;

public class IntCodeUtils {

    public static<T> T getLast(List<T> items){
        return items.get(items.size()-1);
    }

//    public static<T> T getLast(Queue<T> items){
//        T lastItem = null;
//        final Iterator<T> iterator = items.iterator();
//
//        while(iterator.hasNext()){
//            lastItem=iterator.next();
//        }
//        return lastItem;
//    }
}
