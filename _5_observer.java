// BEHAVIOURAL PATTERN

// Oberserver is connected to the source
// When the source is updated, it notifies all the observers
// push style (update with parameter) and pull style (update fetches the data it needs from source)

import java.util.ArrayList;
import java.util.List;

interface Observer {
    void update();
}

class SpreadSheet implements Observer {
    private DataSource dataSource;

    public SpreadSheet(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void update() {
        System.out.println("sheet updated " + dataSource.getValue());
    }
}

class Chart implements Observer {
    @Override
    public void update() {
        System.out.println("chart updated");
    }
}

class Observable {
    private List<Observer> observers = new ArrayList<Observer>();

    public void addObserver(Observer observer) {
        this.observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        this.observers.remove(observer);
    }

    public void notifyObserver() {
        for (Observer observer : observers) {
            observer.update();
        }
    }
}

class DataSource extends Observable {
    private int value;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
        notifyObserver();
    }

}

public class _5_observer {
    public static void main(String[] args) {
        var source = new DataSource();
        var spreadSheet = new SpreadSheet(source);
        var chart = new Chart();

        source.addObserver(spreadSheet);
        source.addObserver(chart);

        source.setValue(10);
    }
}
