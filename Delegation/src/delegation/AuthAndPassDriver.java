package delegation;

public class AuthAndPassDriver {
	
	//Main class to demonstrate the Delegation Design Pattern
	 public static void main(String[] args) {
	     // Create user instance
	     User user = new User("user123", "password");

	     // Step 1: Delegate authentication task to DatabaseAuthentication
	     ECommerceManager manager = new ECommerceManager(new DatabaseAuthentication(), new CreditCardPayment());

	     // Authenticate the user
	     if (manager.loginUser(user)) {
	         // Step 2: Once authenticated, process the payment via CreditCard
	         manager.makePayment(100.00);
	     }

	     // Change authentication to OAuth and payment method to PayPal
	     manager.setAuthentication(new OAuthAuthentication());
	     manager.setPayment(new PayPalPayment());

	     // Attempt OAuth authentication and PayPal payment
	     user = new User("oauth_user", "oauth_pass"); // Update user details
	     if (manager.loginUser(user)) {
	         manager.makePayment(150.00);
	     }
	 }

}


/*
 * Authentication Interface: Defines the authenticate() method that all
 * authentication strategies (e.g., DatabaseAuthentication and
 * OAuthAuthentication) must implement.
 * 
 * DatabaseAuthentication simulates authentication by checking hardcoded
 * credentials. OAuthAuthentication simulates authentication via OAuth (e.g.,
 * Google/Facebook). Payment Interface: Defines the processPayment() method that
 * all payment strategies (e.g., CreditCardPayment and PayPalPayment) must
 * implement.
 * 
 * CreditCardPayment simulates processing a payment via credit card.
 * PayPalPayment simulates processing a payment via PayPal. ECommerceManager:
 * This class delegates the tasks of authentication and payment processing to
 * the appropriate objects (either an Authentication strategy or Payment
 * strategy). It can dynamically change the strategy for either task using
 * setAuthentication() and setPayment() methods.
 * 
 * User Class: Represents the user who is interacting with the e-commerce
 * system. It has credentials for authentication.
 * 
 * Delegation in Action:
 * 
 * First, the ECommerceManager is initialized with DatabaseAuthentication and
 * CreditCardPayment. The user is authenticated using database credentials, and
 * if successful, a credit card payment is processed. The system dynamically
 * switches to OAuthAuthentication and PayPalPayment. The user logs in with
 * OAuth credentials and, if successful, the payment is processed using PayPal.
 */