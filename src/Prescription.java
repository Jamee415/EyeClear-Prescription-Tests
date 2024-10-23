import java.util.ArrayList;
import java.util.Date;

public class Prescription {
    private String firstName;
    private String lastName;
    private String address;
    private float sphere;
    private float cylinder;
    private int axis;
    private String optometrist;
    private Date examinationDate;
    private ArrayList<String> postRemarks = new ArrayList<>();

    private String[] remarkTypes = {"Client", "Optometrist"};

    // Constructor
    public Prescription(String firstName, String lastName, String address, float sphere, float cylinder, int axis, String optometrist, Date examinationDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.sphere = sphere;
        this.cylinder = cylinder;
        this.axis = axis;
        this.optometrist = optometrist;
        this.examinationDate = examinationDate;
    }

    // Method to add prescription
    public boolean addPrescription() {
        if (firstName.length() < 4 || firstName.length() > 15) return false;
        if (lastName.length() < 4 || lastName.length() > 15) return false;
        if (address.length() < 20) return false;
        if (sphere < -20.00 || sphere > 20.00) return false;
        if (cylinder < -4.00 || cylinder > 4.00) return false;
        if (axis < 0 || axis > 180) return false;
        if (optometrist.length() < 8 || optometrist.length() > 25) return false;
        // Save prescription details to a file (not implemented)
        return true;
    }

    // Method to add remark
    public boolean addRemark(String remark, String type) {
        if (postRemarks.size() >= 2) return false; // Limit to 2 remarks
        if (type == null || (!type.equals("Client") && !type.equals("Optometrist"))) return false;
        if (remark.split(" ").length < 6 || remark.split(" ").length > 20) return false;
        if (!Character.isUpperCase(remark.charAt(0))) return false;
        postRemarks.add(remark);
        // Save remark to a file (not implemented)
        return true;
    }
}
