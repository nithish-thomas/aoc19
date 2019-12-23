package nanoFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Chemical {
    private final String name;

    private Chemical(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private final static Map<String, Chemical> store = new HashMap<>();
    public static Chemical getChemical(String name){
        String nameProcessed = name.trim();
        store.putIfAbsent(nameProcessed, new Chemical(nameProcessed));
        return store.get(nameProcessed);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Chemical chemical = (Chemical) o;
        return Objects.equals(name, chemical.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Chemical{" +
          "name='" + name + '\'' +
          '}';
    }
}
