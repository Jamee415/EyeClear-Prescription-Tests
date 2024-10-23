import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.Date;

public class PrescriptionTest {

    @Test
    void testValidPrescription() {
        Prescription p = new Prescription("Ahnaf", "Tahmid", "2 Stirling Avenue, Malvern East, Melbourne, Australia", -4.5f, 3.0f, 90, "Dr. Jamee", new Date());
        assertTrue(p.addPrescription());  // Should be true for a valid prescription
    }

    @Test
    void testInvalidFirstName() {
        Prescription p = new Prescription("A", "Tahmid", "2 Stirling Avenue, Malvern East, Melbourne, Australia", -4.5f, 3.0f, 90, "Dr. Jamee", new Date());
        assertFalse(p.addPrescription());  // First name is too short
    }

    @Test
    void testInvalidAddress() {
        Prescription p = new Prescription("Ahnaf", "Tahmid", "Short Addr", -4.5f, 3.0f, 90, "Dr. Jamee", new Date());
        assertFalse(p.addPrescription());  // Address is too short
    }

    @Test
    void testValidRemark() {
        Prescription p = new Prescription("Ahnaf", "Tahmid", "2 Stirling Avenue, Malvern East, Melbourne, Australia", -4.5f, 3.0f, 90, "Dr. Jamee", new Date());
        assertTrue(p.addRemark("This is a valid remark example.", "Client"));  // Should be true for a valid remark
    }

    @Test
    void testInvalidRemarkTooFewWords() {
        Prescription p = new Prescription("Ahnaf", "Tahmid", "2 Stirling Avenue, Malvern East, Melbourne, Australia", -4.5f, 3.0f, 90, "Dr. Jamee", new Date());
        assertFalse(p.addRemark("Too short", "Client"));  // Remark has too few words
    }

    @Test
    void testRemarkLimitReached() {
        Prescription p = new Prescription("Ahnaf", "Tahmid", "2 Stirling Avenue, Malvern East, Melbourne, Australia", -4.5f, 3.0f, 90, "Dr. Jamee", new Date());
        p.addRemark("This is a valid remark example.", "Client");
        p.addRemark("This is another valid remark with optometrist.", "Optometrist");
        assertFalse(p.addRemark("This should fail as there are already two remarks.", "Client"));  // Should fail due to limit
    }
}
