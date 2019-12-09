package image;

import com.google.common.collect.Iterators;
import com.google.common.collect.Streams;
import com.google.common.collect.UnmodifiableIterator;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.OptionalInt;
import java.util.stream.Collectors;

public class Image {
    public static final int TRANSPARENT_COLOR = 2;
    private List<Layer> layer;

    public Image(List<Layer> layer) {
        this.layer = layer;
    }

    public List<Layer> getLayer() {
        return layer;
    }

    public static Image createImage(int width, int height, String image){
        final List<Integer> sifCodes = image.chars()
          .map(c -> Integer.parseInt("" + (char) c))
          .boxed()
          .collect(Collectors.toList());

        return createImage(width,height,sifCodes);
    }

    public static Image createImage(int width, int height, List<Integer> sifCode) {
        final UnmodifiableIterator<List<Integer>> sifCodedLayers = Iterators.partition(sifCode.iterator(), width * height);

        final List<Layer> layers = Streams.stream(sifCodedLayers)
          .map(aSifCodedLayer -> new Layer(width, height, aSifCodedLayer))
          .collect(Collectors.toList());

        return new Image(layers);
    }

    public Layer findLeastCorruptedLayer() {
        final List<Layer> layer = getLayer();
        long minNumOfZerosPerLayerTillNow = Integer.MAX_VALUE;
        Layer leastCorrupted = null;
        for (Layer aLayer:layer) {
            final long countOfZeros = aLayer.getSifCode().stream()
              .mapToInt(Integer::intValue)
              .filter(value -> value == 0)
              .count();

            if(minNumOfZerosPerLayerTillNow>countOfZeros){
                minNumOfZerosPerLayerTillNow =countOfZeros;
                leastCorrupted = aLayer;
            }
        }
        return leastCorrupted;
    }


    public Layer processImage(){
        final int width = getLayer().get(0).getWidth();
        final int height = getLayer().get(0).getHeight();

        int res[]=new int[width*height];
        for (int i = 0; i < res.length; i++) {
            res[i]=getFirstNonTransparentPixel(i);
        }
        return new Layer(width,height, Arrays.stream(res).boxed().collect(Collectors.toList()));
    }

    private int getFirstNonTransparentPixel(int i) {
        final OptionalInt first = getLayer().stream()
          .mapToInt(layer -> layer.getValueAt(i))
          .filter(color -> color != TRANSPARENT_COLOR)
          .findFirst();
        return first.orElse(TRANSPARENT_COLOR);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Image image = (Image) o;
        return Objects.equals(layer, image.layer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(layer);
    }
}
