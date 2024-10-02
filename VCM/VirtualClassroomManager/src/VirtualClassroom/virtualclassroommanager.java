package VirtualClassroom;

import java.util.*;

public class virtualclassroommanager
{
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Map<String, Classroom> classrooms = new HashMap<>();
		Map<String, List<Student>> studentsByClass = new HashMap<>();
        List<Assignment> assignments = new ArrayList<>();
        boolean run=true;
        while (run) {
            try{
            System.out.println("Menu");
            System.out.println("1. Classroom");
            System.out.println("2. Add Student");
            System.out.println("3. Schedule Assignment");
            System.out.println("4. Submit Assignment");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character
            switch(choice)
            {
                case 1:
                    int userChoice=0;
                    while(userChoice!=4){
                    try{
                    System.out.println("*Classroom*");
                    System.out.println("1.Add Classroom");
                    System.out.println("2.List Classroom");
                    System.out.println("3.Remove Classroom");
                    System.out.println("4.Back to Main menu");
                    System.out.print("Enter Choice : ");
                    userChoice=scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character
                    switch(userChoice){
                    case 1:
                            System.out.print("Enter className :");
                            String className = scanner.nextLine();
                            classrooms.put(className, new Classroom(className));
                            System.out.println("Classroom "+className+" has been created.");
                            break;
                    case 2:
                        System.out.println("Classrooms List :");
                        for (String clsName : classrooms.keySet()) {
                            System.out.print(clsName +" ");
                        }
                        System.out.println();
                        break;
                    case 3:
                        System.out.print("Enter className to Remove : ");
                        String cName=scanner.nextLine();
                        boolean classroomfound=false;
                        if (classrooms.containsKey(cName)) {
                            classroomfound=true;
                            classrooms.remove(cName);
                        }
                        if(classroomfound)
                        System.out.println("Class room "+cName+" removed");
                        else
                        System.out.println("Class room "+cName+" not found");
                        break;
                    case 4:
                        System.out.println("Back to main menu....");
                        break;
                    default:
                        System.out.println("Invalid Choice.Try again.....");
                    }
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input. Please enter a number.");
                        scanner.next(); // Clear the invalid input
                    }
                }
                break;
                case 2:
                    System.out.print("Enter the student ID: ");
                    String studentId = scanner.nextLine();
                    System.out.print("Enter the class name the student to be enrolled: ");
                    String studentClassName = scanner.nextLine();
                    boolean studentEnrolledFlag=false;
                    for (String clsName : classrooms.keySet()) {
                        if (clsName.equals(studentClassName))
                         {
                            
                            studentEnrolledFlag = true;
                            Student student = new Student(studentId, studentClassName);
                            List<Student> students = studentsByClass.get(studentClassName);
                            if (students == null) {
                            students = new ArrayList<>();
                            studentsByClass.put(studentClassName, students);
                            }
                        students.add(student);
                        break;
                         }
                    }
                    if (studentEnrolledFlag)
                    System.out.println("Student "+studentId+" has been enrolled in class "+studentClassName+".");
                    else
                    System.out.println("Class name "+studentClassName+" not found");
                    break;
                case 3:
                    System.out.print("Enter the class name: ");
                    String assignmentClassName = scanner.nextLine();
                    boolean assignmentScheludeFlag=false;
                    for (String clsName : classrooms.keySet()) {
                        if (clsName.equals(assignmentClassName))
                         {
                            System.out.print("Enter assignment details: ");
                            String assignmentDetails = scanner.nextLine();
                            Assignment assignment = new Assignment(assignmentClassName, assignmentDetails);
                            assignments.add(assignment);
                            assignmentScheludeFlag=true;
                            break;
                         }
                    }
                    if(assignmentScheludeFlag)
                    System.out.println("Assignment for class "+assignmentClassName+" has been scheduled.");
                    else
                    System.out.println("Assignment Class "+assignmentClassName+" not found");
                    break;
                case 4:
                    System.out.print("Enter student ID: ");
                    String studentIdForSubmission = scanner.nextLine();
                    System.out.print("Enter class name: ");
                    String classNameForSubmission = scanner.nextLine();
                    System.out.print("Enter assignment details: ");
                    String assignmentDetailsForSubmission = scanner.nextLine();

                    boolean assignmentSubmittedFlag = false;

                    for (Assignment a : assignments) {
                        if (a.getClassName().equals(classNameForSubmission)
                                && a.getAssignmentDetails().equals(assignmentDetailsForSubmission)) {
                            System.out.println("Assignment submitted by Student "+studentIdForSubmission+" in class "+classNameForSubmission+".");
                            assignmentSubmittedFlag = true;
                            break;
                        }
                    }

                    if (!assignmentSubmittedFlag) {
                        System.out.println("Assignment "+assignmentDetailsForSubmission+" not found.");
                    }
                    break;
                case 5:
                    System.out.println("Exit the program....");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice.Try again........");
                    break;
                
            }  
            } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.next(); // Clear the invalid input
            }
        }
            
    }
}
