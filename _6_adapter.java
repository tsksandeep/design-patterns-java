// STRUCTURAL PATTERN

// If a class (3rd party) does not implement the interface
// Write a wrapper (adapter) that implements the interface

// Composition over Inheritance

interface Filter {
    void apply(Image image);
}

class VividFilter implements Filter {
    @Override
    public void apply(Image image) {
        System.out.println("apply vivid filter");
    }
}

// 3rd party filter but ir doesnt implement Filter interface
class Caramel {
    public void init() {
    };

    public void render(Image image) {
    };
}

// Can also use inheritance
class CaramelFilter implements Filter {
    private Caramel caramel;

    public CaramelFilter(Caramel caramel) {
        this.caramel = caramel;
    }

    @Override
    public void apply(Image image) {
        caramel.init();
        caramel.render(image);
    }
}

class ImageView {
    private Image image;

    public ImageView(Image image) {
        this.image = image;
    }

    public void apply(Filter filter) {
        filter.apply(image);
    }
}

class Image {
}

public class _6_adapter {
    public static void main(String[] args) {
        var imageView = new ImageView(new Image());
        imageView.apply(new VividFilter());
        imageView.apply(new CaramelFilter(new Caramel() ));
    }
}
