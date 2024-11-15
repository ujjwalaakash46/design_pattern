public class StrategyDesignPattern {

    /**
     *
     * The Strategy Pattern is especially useful when you have multiple algorithms for a specific task and want the
     * flexibility to switch between them at runtime.
     *
     *
     * Here’s why the Factory Pattern isn’t ideal for this use case:
     *
     * 	1.	Behavior vs. Object Creation: The Factory Pattern is focused on creating objects, while the Strategy Pattern is about selecting and executing specific behaviors at runtime.
     * 	2.	Runtime Flexibility: Strategy Pattern lets you switch between behaviors dynamically. Factory Pattern only creates objects once, and switching behavior afterward isn’t straightforward.
     * 	3.	Encapsulation of Algorithms: Strategy encapsulates multiple algorithms, allowing each to be independently modified and selected, while Factory just returns instances.
     * 	4.	Reducing Conditionals in Context: Strategy allows the context (ShoppingCart) to operate with a chosen behavior without if-else or switch statements, which a Factory alone would not simplify.
     */
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        // Choose to pay with Credit Card
        cart.setPaymentStrategy(new CreditCardPayment("1234-5678-9012-3456", "John Doe"));
        cart.checkout(500);

        // Switch to PayPal payment
        cart.setPaymentStrategy(new PayPalPayment("john@example.com"));
        cart.checkout(300);
    }
}

interface PaymentStrategy {
    void pay(int amount);
}

class CreditCardPayment implements PaymentStrategy {
    private String cardNumber;
    private String cardHolder;

    public CreditCardPayment(String cardNumber, String cardHolder) {
        this.cardNumber = cardNumber;
        this.cardHolder = cardHolder;
    }

    @Override
    public void pay(int amount) {
        System.out.println("Paid " + amount + " using Credit Card");
    }
}

class PayPalPayment implements PaymentStrategy {
    private String email;

    public PayPalPayment(String email) {
        this.email = email;
    }

    @Override
    public void pay(int amount) {
        System.out.println("Paid " + amount + " using PayPal");
    }
}

class ShoppingCart {
    private PaymentStrategy paymentStrategy;

    // Allow setting a payment strategy at runtime
    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void checkout(int amount) {
        paymentStrategy.pay(amount);
    }
}