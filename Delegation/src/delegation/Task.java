

/*In a company, a Manager may delegate tasks to different departments depending on the type of task.
For instance, a Technical Task will be delegated to the Engineering Department, 
while a Sales Task will be delegated to the Sales Department.*/


package delegation;

//Task interface to represent different types of tasks
interface Task {
 void execute(String details);
}

//Engineering Department - Handles technical tasks
class EngineeringDepartment implements Task {
 @Override
 public void execute(String details) {
     System.out.println("Engineering Department is working on: " + details);
 }
}

//Sales Department - Handles sales-related tasks
class SalesDepartment implements Task {
 @Override
 public void execute(String details) {
     System.out.println("Sales Department is working on: " + details);
 }
}

//Manager class - delegates tasks to the appropriate department
class Manager {
 private Task task;

 // Constructor to assign a task (department)
 public Manager(Task task) {
     this.task = task;
 }

 // Delegate the task to the assigned department
 public void assignTask(String details) {
     task.execute(details);
 }

 // Dynamically change the task (department)
 public void setTask(Task task) {
     this.task = task;
 }
}



