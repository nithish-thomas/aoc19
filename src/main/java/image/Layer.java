package image;

import java.util.List;

public class Layer {
    private final int width;
    private final int height;
    private final List<Integer> aSifCodedLayer;


    public Layer(int width, int height, List<Integer> aSifCodedLayer) {
        this.width = width;
        this.height = height;
        this.aSifCodedLayer = aSifCodedLayer;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public List<Integer> getaSifCodedLayer() {
        return aSifCodedLayer;
    }
}
