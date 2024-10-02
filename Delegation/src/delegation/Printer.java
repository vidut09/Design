package delegation;

// you have two printer types, a regular printer and a 3D printer, and you want to delegate printing tasks to the appropriate printer.


//Interface that defines the print functionality
interface Printer {
 void print(String message);
}

//A regular printer implementation
class RegularPrinter implements Printer {
 @Override
 public void print(String message) {
     System.out.println("Regular Printer printing: " + message);
 }
}

//A 3D printer implementation
class ThreeDPrinter implements Printer {
 @Override
 public void print(String message) {
     System.out.println("3D Printer printing object: " + message);
 }
}

//PrinterManager delegates printing tasks to the appropriate printer
class PrinterManager {
 private Printer printer;

 // Constructor to set the delegate (can be a RegularPrinter or ThreeDPrinter)
 public PrinterManager(Printer printer) {
     this.printer = printer;
 }

 // Delegate the print task to the actual printer
 public void print(String message) {
     printer.print(message);
 }

 // Optionally, allow changing the printer dynamically
 public void setPrinter(Printer printer) {
     this.printer = printer;
 }
}


/*
 * Separation of concerns: The PrinterManager doesn't need to know how to print;
 * it just delegates to another object. 
 * Flexibility: You can change the delegate at runtime, allowing the behavior to change dynamically. 
 * Reusability: Different classes can implement the Printer interface and be used by PrinterManager without changing its code.
 */




