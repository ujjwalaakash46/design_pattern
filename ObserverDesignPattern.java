import java.util.ArrayList;
import java.util.List;

public class ObserverDesignPattern {

    /**
     *
     * Advantages of the Observer Pattern
     *
     * 	•	Decoupling: Observers and subjects are loosely coupled, making it easier to modify or add new observers without changing the subject.
     * 	•	Flexibility: It’s easy to add or remove observers at runtime, which makes it useful for applications where dynamic updates are necessary.
     *
     * Disadvantages of the Observer Pattern
     *
     * 	•	Potential for Memory Leaks: If observers are not properly removed, they can lead to memory leaks.
     * 	•	Uncontrolled Notifications: In systems with many observers, frequent notifications can cause performance issues if not managed carefully.
     */
    public static void main(String[] args) {
        Stock stock = new Stock();
        Investor investor1 = new Investor("Alice");
        Investor investor2 = new Investor("Bob");

        stock.addObserver(investor1);
        stock.addObserver(investor2);

        stock.setPrice(100); // Notifies all observers
        stock.setPrice(150); // Notifies all observers
    }
}

class Investor implements Observer {
    private final String name;

    public Investor(String name) {
        this.name = name;
    }

    @Override
    public void update(float price) {
        System.out.println(name + " received an update: Stock price changed to " + price);
    }
}

// Observer Interface
interface Observer {
    void update(float price);
}

// Subject Class
class Stock {
    private List<Observer> observers = new ArrayList<>();
    private float price;

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void setPrice(float price) {
        this.price = price;
        notifyObservers();
    }

    private void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(price);
        }
    }
}
