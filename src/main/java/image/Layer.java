package image;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Layer {
    private final int width;
    private final int height;
    private final List<Integer> sifCode;


    public Layer(int width, int height, List<Integer> sifCode) {
        this.width = width;
        this.height = height;
        this.sifCode = new ArrayList<>(sifCode);
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public List<Integer> getSifCode() {
        return sifCode;
    }

    public int getValueAt(int index){
        return sifCode.get(index);
    }

    public String print() {
        StringBuilder builder = new StringBuilder();
//        for (int i = 0; i < height; i++) {
//            for (int j = 0; j <width; j++) {
//                builder.append(sifCode.get((height*i)+j));
//            }
//            builder.append('\n');
//        }
//        return builder.deleteCharAt(builder.length()-1).toString();

        for (int i = 0; i < sifCode.size(); i++) {
            if(i!=0&&i%width==0){
                builder.append('\n');
            }
            builder.append(sifCode.get(i));
        }
        return builder.toString();
    }

    public String specialPrint() {
        return print().replace("0"," ");
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Layer layer = (Layer) o;
        return width == layer.width &&
          height == layer.height &&
          Objects.equals(sifCode, layer.sifCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(width, height, sifCode);
    }
}
