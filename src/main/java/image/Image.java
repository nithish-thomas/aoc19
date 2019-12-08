package image;

import com.google.common.collect.Iterators;
import com.google.common.collect.Streams;
import com.google.common.collect.UnmodifiableIterator;

import java.util.List;
import java.util.stream.Collectors;

public class Image {
    private List<Layer> layer;

    public Image(List<Layer> layer) {
        this.layer = layer;
    }

    public List<Layer> getLayer() {
        return layer;
    }

    public static Image createImage(int widht, int height, List<Integer> sifCode) {
        final UnmodifiableIterator<List<Integer>> sifCodedLayers = Iterators.partition(sifCode.iterator(), widht * height);

        final List<Layer> layers = Streams.stream(sifCodedLayers)
          .map(aSifCodedLayer -> new Layer(widht, height, aSifCodedLayer))
          .collect(Collectors.toList());

        return new Image(layers);
    }

    public Layer findLeastCorruptedLayer() {
        final List<Layer> layer = getLayer();
        long minNumOfZerosPerLayerTillNow = Integer.MAX_VALUE;
        Layer leastCorrupted = null;
        for (Layer aLayer:layer) {
            final long countOfZeros = aLayer.getaSifCodedLayer().stream()
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
}
