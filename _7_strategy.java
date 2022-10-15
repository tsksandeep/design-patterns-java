// BEHAVIOURAL PATTERN

// No reference to context
// Strategies are passed to the context object as parameters

interface Compressor {
    void compress(String fileName);
}

class JpegCompressor implements Compressor {
    @Override
    public void compress(String fileName) {
        System.out.println("compressing jpeg");
    }
}

class PngCompressor implements Compressor {
    @Override
    public void compress(String fileName) {
        System.out.println("compressing png");
    }
}

interface Filter {
    void apply(String fileName);
}

class BlackAndWhiteFilter implements Filter {
    @Override
    public void apply(String fileName) {
        System.out.println("applying black and white filter");
    }
}

class ImageStorage {
    public void store(String fileName, Compressor compressor, Filter filter) {
        compressor.compress(fileName);
        filter.apply(fileName);
    }
}

public class _7_strategy {
    public static void main(String[] args) {
        ImageStorage imageStorage = new ImageStorage();
        imageStorage.store("a", new PngCompressor(), new BlackAndWhiteFilter());
    }
}