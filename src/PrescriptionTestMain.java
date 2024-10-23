import java.util.Date;

public class PrescriptionTestMain {
    public static void main(String[] args) {
        // Create a prescription object with valid data
        Prescription p = new Prescription(
            "Ahnaf",      // First name (4-15 characters)
            "Tahmid",     // Last name (4-15 characters)
            "2 Stirling Avenue, Malvern East, Melbourne, Australia",  // Updated address
            -4.5f,        // Sphere (between -20.00 and +20.00)
            3.0f,         // Cylinder (between -4.00 and +4.00)
            90,           // Axis (between 0 and 180)
            "Dr. Jamee",   // Optometrist name (8-25 characters)
            new Date()    // Examination date
        );

        // Try adding the prescription and print the result
        boolean result = p.addPrescription();
        System.out.println("Prescription added: " + result);  // Should print true if valid

        // Add the first remark (should succeed)
        boolean remarkResult = p.addRemark("This is a valid remark example.", "Client");
        System.out.println("Remark added: " + remarkResult);  // Should print true

        // Add the second remark (should also succeed)
        boolean secondRemark = p.addRemark("This is another valid remark with optometrist.", "Optometrist");
        System.out.println("Second remark added: " + secondRemark);  // Should print true

        // Try adding a third remark (should fail, limit is 2)
        boolean thirdRemark = p.addRemark("This should fail as there are already two remarks.", "Client");
        System.out.println("Third remark added: " + thirdRemark);  // Should print false
    }
}
