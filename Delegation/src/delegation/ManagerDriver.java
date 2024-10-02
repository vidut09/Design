package delegation;

//Main class to test the delegation pattern
public class ManagerDriver {
public static void main(String[] args) {
   // Manager delegates a technical task to the Engineering Department
   Manager manager = new Manager(new EngineeringDepartment());
   manager.assignTask("Develop a new feature for the app");

   // Manager changes the task delegation to the Sales Department for a sales task
   manager.setTask(new SalesDepartment());
   manager.assignTask("Sell the new product to clients");
}
}