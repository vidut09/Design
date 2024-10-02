package delegation;

public class PrinterDriver {
	
	//Main class to test the delegation pattern
	
	 public static void main(String[] args) {
	     // Create a PrinterManager with a regular printer
	     PrinterManager printerManager = new PrinterManager(new RegularPrinter());
	     printerManager.print("Hello, World!");

	     // Change the printer to a 3D printer dynamically
	     printerManager.setPrinter(new ThreeDPrinter());
	     printerManager.print("Cool 3D Model");
	 }

}
