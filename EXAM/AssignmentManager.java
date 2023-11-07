
//ASSIGNMENT MANAGER

package EXAM;




import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.ProcessHandle.Info;
import java.util.*;

class Student{
    String name;
    int prno;

    public Student(String name, int prno) {
        this.name = name;
        this.prno = prno;
    }
}
class Trainer{
    String name;

    public Trainer(String name) {
        this.name = name;
    }
}
class Assignment{
    String title;
    Date date;
    String description;
    Student assignee;
    Trainer trainer;

    public Assignment(String title, Date date, String description, Student assignee, Trainer trainer) {
        this.title = title;
        this.date = date;
        this.description = description;
        this.assignee = assignee;
        this.trainer = trainer;
    } 

    Assignment(String title, String date, String description, String assignee) {
         }
}
class ManageAssignment{
    List<Assignment> assignments;
    
    public ManageAssignment(){
        assignments = new ArrayList<>();
        
    }
    public void createAssignment(){
        Scanner s = new Scanner(System.in);
        System.out.println("Enter Assignment Title : ");
        String title = s.nextLine();
        System.out.println("Enter Assignment Date : ");
        String date = s.nextLine();
        System.out.println("Enter Description : ");
        String description = s.nextLine();
        System.out.println("Enter Asignee : ");
        String assignee = s.nextLine();
        
        Assignment assignment = new Assignment(title, date, description, assignee);
        assignments.add(assignment);
        System.out.println("Assignment created and added to the collection.");
    }
     public void addAssignment(Assignment assignment) {
        assignments.add(assignment);
    }
    public void showAssignments(){
        System.out.println("--- Assignments ---");
        for (Assignment assignment : assignments) {
            System.out.println("Title: " + assignment.title);
            System.out.println("Date: " + assignment.date);
            System.out.println("Description: " + assignment.description);
            System.out.println("Assignee: " + assignment.assignee.name);
            System.out.println("Created by: " + assignment.trainer.name);
            System.out.println();
        }
    }
    public void saveAssignnment() {
         (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(info)) 
           
            System.out.println("Assignments saved to file: " + info);
       
         }
    public void loadAssignment() {
        (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(info)) {
            assignments = (List<Assignment>) inputStream.readObject();
            System.out.println("Assignments loaded from file: " + info);
        
        
    }
    public void checkAssignment(String targetDate) {
        for (Assignment assignment : assignments) {
            if (assignment.date.equals(targetDate)) {
                System.out.println("Assignment Title: " + assignment.title);
                System.out.println("Description: " + assignment.description);
                System.out.println("Assignee: " + assignment.assignee);
                System.out.println();
            }
        }
}

   
   
}
public class AssignmentManager {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ManageAssignment manage = new ManageAssignment();

        while (true) {
            System.out.println("Assignment Manager Menu:");
            System.out.println("1. Create Assignment");
            System.out.println("2. Add Assignment ");
            System.out.println("3. Show Assignments ");
            System.out.println("4. Save Assignments ");
            System.out.println("5. Load Assignments ");
            System.out.println("6. Check Assignments by Date");
            System.out.println("7. Exit");

            System.out.print("Select an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    manage.createAssignment();
                    break;
                case 2:
                    System.out.println("Enter Title for the Assignment ; ");
                    String title = scanner.nextLine();
                    System.out.print("Enter date of Assignment: ");
                    String date = scanner.nextLine();
                    System.out.print("Enter Description: ");
                    String description = scanner.nextLine();
                    System.out.print("Enter assignee  ");
                    String assignee = scanner.nextLine();

                    Assignment assignment = new Assignment(title, date, description, assignee);
                    manage.addAssignment(assignment);
                    System.out.println("Assignment added to the collection.");
                    break;
                case 3:
                    manage.showAssignments();
                    break;
                case 4:
                    System.out.print("Enter the file name to save assignments: ");
                    String saveFile = scanner.nextLine();
                    manage.saveAssignment(saveFile);
                    break;
                case 5:
                    System.out.print("Enter the file name to load assignments from: ");
                    String loadFile = scanner.nextLine();
                    manage.loadAssignment(loadFile);
                    break;
                case 6:
                    System.out.print("Enter the date to check assignments: ");
                    String targetDate = scanner.nextLine();
                    manage.checkAssignment(targetDate);
                    break;
                case 7:
                    System.out.println("Exiting the Assignment Manager.");
                    System.exit(0);
                    break;
                    
                default:
                    System.out.println("Invalid option...Please try again !!");
                    
                    break;
                    
                    
                    
            
            }
        }
    }
        
    
}
