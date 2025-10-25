package data;

import org.testng.annotations.DataProvider;

public class PatientData {

    @DataProvider(name = "patientData")
    public Object[][] getPatient() {
        return new Object[][]{
                {
                        "John",
                        "Doe",
                        "Male",
                        "20",
                        "Main St",
                        "11111",
                        "Parent"
                }
        };
    }
}
