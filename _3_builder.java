// CREATIONAL PATTERN

// Separate construction of the object to representation

import java.util.ArrayList;
import java.util.List;

class Slide {
    private String text;

    public Slide(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}

interface PresentationBuilder {
    void addSlide(Slide slide);
}

class PdfDocument {
    public void addPage(String text) {
        System.out.println("adding a page to pdf");
    }
}

class PdfDocumentBuilder implements PresentationBuilder {
    private PdfDocument document = new PdfDocument();

    @Override
    public void addSlide(Slide slide) {
        document.addPage(slide.getText());
    }

    public PdfDocument getDocument() {
        return document;
    }
}

class Movie {
    public void addFrom(String text) {
        System.out.println("adding a page to pdf");
    }
}

class MovieBuilder implements PresentationBuilder {
    private Movie movie = new Movie();

    @Override
    public void addSlide(Slide slide) {
        movie.addFrom(slide.getText());
    }

    public Movie getDocument() {
        return movie;
    }
}

class Presentation {
    private List<Slide> slides = new ArrayList<Slide>();

    public void addSlide(Slide slide) {
        slides.add(slide);
    }

    public void Export(PresentationBuilder builder) {
        builder.addSlide(new Slide("Copyright"));
        for (Slide slide : slides) {
            builder.addSlide(slide);
        }

    }
}

public class _3_builder {

    public static void main() {
        var presentation = new Presentation();
        presentation.addSlide(new Slide("1"));
        presentation.addSlide(new Slide("2"));

        var builder = new PdfDocumentBuilder();
        presentation.Export(builder);
        builder.getDocument(); 
    }

}
