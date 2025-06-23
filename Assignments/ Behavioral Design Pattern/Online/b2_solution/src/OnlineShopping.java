// Define the PaymentStrategy interface
interface PaymentStrategy {
    void processPayment(double amount);
}

// Concrete implementations for different payment methods

class CreditCardPayment implements PaymentStrategy {
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing credit card payment of BDT " + amount + "/= Taka");
    }
}

class PayPalPayment implements PaymentStrategy {
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing PayPal payment of BDT " + amount + "/= Taka");
    }
}

class CryptocurrencyPayment implements PaymentStrategy {
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing cryptocurrency payment of BDT " + amount + "/= Taka");
    }
}

class BkashPayment implements PaymentStrategy {
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing Bkash payment of BDT " + amount + "/= Taka");
    }

}

// Add new class for Bkash Payment

// Context class that uses a payment strategy
class ShoppingCart {
    private PaymentStrategy strategy;

    public void setStrategy(PaymentStrategy strategy) {
        this.strategy = strategy;
    }
    // add member variables and functions (if necessary)

    public void checkout(double totalAmount) {
        if(strategy!=null)
        {
            strategy.processPayment(totalAmount);
        }
        else
        {
            System.out.println("Select a payment method first ");
        }
        // add code to implement this method
    }
}

public class OnlineShopping {
    public static void main(String[] args) {
        ShoppingCart cart1 = new ShoppingCart();
        ShoppingCart cart2 = new ShoppingCart();
        cart1.setStrategy(new BkashPayment());
        cart2.setStrategy(new PayPalPayment());

        // add code here (if necessary)

        cart1.checkout(100.0); // Output: Processing Bkash payment of BDT 100.0/= Taka
        cart2.checkout(50.0);  // Output: Processing PayPal payment of BDT 50.0/= Taka
    }
}