
/*Imagine we have an e-commerce system where the AuthenticationManager is responsible for authenticating users, and based on the user's credentials, the PaymentManager is responsible for processing payments using different payment methods (e.g., CreditCardPayment, PayPalPayment).

In this example, we use delegation to assign specific tasks like authentication and payment processing to the appropriate classes.*/



package delegation;

//Define an interface for Authentication
interface Authentication {
 boolean authenticate(String username, String password);
}

//Implementation for Database-based Authentication
class DatabaseAuthentication implements Authentication {
 @Override
 public boolean authenticate(String username, String password) {
     // Simulate database lookup for user authentication
     if ("user123".equals(username) && "password".equals(password)) {
         System.out.println("User authenticated via Database.");
         return true;
     }
     System.out.println("Database authentication failed.");
     return false;
 }
}

//Implementation for OAuth-based Authentication (e.g., using Google or Facebook)
class OAuthAuthentication implements Authentication {
 @Override
 public boolean authenticate(String username, String password) {
     // Simulate OAuth token verification
     if ("oauth_user".equals(username) && "oauth_pass".equals(password)) {
         System.out.println("User authenticated via OAuth.");
         return true;
     }
     System.out.println("OAuth authentication failed.");
     return false;
 }
}

//Define an interface for Payment processing
interface Payment {
 boolean processPayment(double amount);
}

//Credit Card Payment implementation
class CreditCardPayment implements Payment {
 @Override
 public boolean processPayment(double amount) {
     // Simulate credit card payment processing
     System.out.println("Processing credit card payment of $" + amount);
     return true;
 }
}

//PayPal Payment implementation
class PayPalPayment implements Payment {
 @Override
 public boolean processPayment(double amount) {
     // Simulate PayPal payment processing
     System.out.println("Processing PayPal payment of $" + amount);
     return true;
 }
}

//User class representing the e-commerce user
class User {
 private String username;
 private String password;

 public User(String username, String password) {
     this.username = username;
     this.password = password;
 }

 public String getUsername() {
     return username;
 }

 public String getPassword() {
     return password;
 }
}

//Manager class that delegates authentication and payment tasks
class ECommerceManager {
 private Authentication authentication;
 private Payment payment;

 // Constructor to initialize the authentication and payment methods
 public ECommerceManager(Authentication authentication, Payment payment) {
     this.authentication = authentication;
     this.payment = payment;
 }

 // Method to authenticate a user
 public boolean loginUser(User user) {
     return authentication.authenticate(user.getUsername(), user.getPassword());
 }

 // Method to process the payment
 public boolean makePayment(double amount) {
     return payment.processPayment(amount);
 }

 // Method to change the authentication strategy
 public void setAuthentication(Authentication authentication) {
     this.authentication = authentication;
 }

 // Method to change the payment strategy
 public void setPayment(Payment payment) {
     this.payment = payment;
 }
}



