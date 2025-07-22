
public class Main {
    public static void main(String[] args) throws Exception {

        // testing CustomerServices class
        CustomerServices.addCustomer("Sana","km@gmail.com","09361433990");
        CustomerServices.addAccount(1, "k200", 1500.0);
        CustomerServices.depositMoney(1,200);
        CustomerServices.withdrawMoney(1,200);
        CustomerServices.transferMoney(1,2,200);
        CustomerServices.deleteAccount(2);

        System.out.println("***********");

        // testing StudentServices class
        StudentServices.addStudent("Ali", "Rezai", "AliRezai@yahoo.com");
        StudentServices.addCourse("Java Programming", "Learn Java fundamentals", 3);
        StudentServices.updateStudent(1, "Mohsen", "Roozdar", "Mohsen.roozdar@gmail.com");
        StudentServices.updateCourse(1, "Advanced Java", "Data Structure and Algorithms", 4);
        StudentServices.registerStudentForCourse(1,1);
        StudentServices.deleteStudent(2);
        StudentServices.deleteCourse(2);
        StudentServices.deleteRegistration(1,1);
    }
}



