import java.util.HashMap;
import java.util.Scanner;
class Statistics{
public static void statisticsMenu() {
    int choice;

    do {

        System.out.println("\n=== STATISTICS MENU ===");
        System.out.println("1. Total Revenue Per Patient");
        System.out.println("2. Total Revenue Per Exam");
        System.out.println("3. Total Revenue Per Category");
        System.out.println("0. Back");

        System.out.print("Choice: ");

        switch (choice) {

            case 1:
                totalRevenuePerPatient(patients, appointments);
                break;

            case 2:
                totalRevenuePerExam();
                break;

            case 3:
                totalRevenuePerCategory();
                break;

            case 0:
                System.out.println("Returning...");
                break;

            default:
                System.out.println("Invalid choice.");
        }

    } while (choice != 0);
}



public static void totalRevenuePerPatient(HashMap <Integer, Patient> patients, HashMap <Integer, Appointment> appointments) {

    double grandTotal = 0;

    for (Patient patient : patients.values()) {

        double patientTotal = 0;

        System.out.println("\nPatient ID: " + patient.getCode());
        System.out.println("Patient Name: " + patient.getName());

        boolean found = false;

        for (Appointment appointment : appointments.values()) {

            if (appointment.getPatientID()
                    == patient.getCode()) {

                Exam exam =
                        findExamById(appointment.getExamID());

                if (exam != null) {

                    double cost =
                            exam.getCost(
                                    appointment.getFastResults());

                    System.out.println(
                            "\nAppointment ID: "
                                    + appointment.getCode());

                    System.out.println(
                            "Exam: "
                                    + exam.getExamName());

                    System.out.println(
                            "Date: "
                                    + appointment.getExamDate());

                    System.out.println(
                            "Fast Results: "
                                    + appointment.getFastResults());

                    System.out.println(
                            "Cost: "
                                    + cost);

                    patientTotal += cost;

                    found = true;
                }
            }
        }

        if (!found) {
            System.out.println("No appointments.");
        }

        System.out.println(
                "Total Revenue From Patient: "
                        + patientTotal);

        grandTotal += patientTotal;
    }

    System.out.println(
            "\nTOTAL REVENUE FROM ALL PATIENTS: "
                    + grandTotal);
}



public static void totalRevenuePerExam(HashMap <Integer, Exam> exams, HashMap <Integer, Appointment> appointments) {

    double grandTotal = 0;

    System.out.println("\n=== TOTAL REVENUE PER EXAM ===");

    for (Exam exam : exams.values()) {

        double examTotal = 0;

        System.out.println("\nExam ID: "
                + exam.getCode());

        System.out.println("Exam Name: "
                + exam.getExamName());

        boolean found = false;

        for (Appointment appointment : appointments.values()) {

            if (appointment.getExamID()
                    == exam.getCode()) {

                Patient patient =
                        findPatientById(
                                appointment.getPatientID());

                double cost =
                        exam.getCost(
                                appointment.getFastResults());

                System.out.println(
                        "\nAppointment ID: "
                                + appointment.getCode());

                System.out.println(
                        "Patient: "
                                + patient.getName());

                System.out.println(
                        "Date: "
                                + appointment.getExamDate());

                System.out.println(
                        "Cost: "
                                + cost);

                examTotal += cost;

                found = true;
            }
        }

        if (!found) {
            System.out.println("No appointments.");
        }

        System.out.println(
                "Total Revenue From Exam: "
                        + examTotal);

        grandTotal += examTotal;
    }

    System.out.println(
            "\nTOTAL REVENUE FROM ALL EXAMS: "
                    + grandTotal);
}



public static void totalRevenuePerCategory(HashMap <Integer, Patient> patients, HashMap <Integer, Appointment> appointments) {

    double imagingTotal = 0;
    double microbiologicalTotal = 0;
    double specializedTotal = 0;

    System.out.println("\n=== TOTAL REVENUE PER CATEGORY ===");

    for (Appointment appointment : appointments.values()) {

        Exam exam =
                findExamById(appointment.getExamID());

        if (exam != null) {

            double cost =
                    exam.getCost(
                            appointment.getFastResults());

            System.out.println(
                    "/nAppointment ID: "
                            + appointment.getCode());

            System.out.println(
                    "Exam: "
                            + exam.getExamName());

            System.out.println(
                    "Category: "
                            + exam.getCategoryName());

            System.out.println(
                    "Cost: "
                            + cost);

            if (exam instanceof ImagingExamination) {

                imagingTotal += cost;

            } else if (exam
                    instanceof MicrobiologicalExamination) {

                microbiologicalTotal += cost;

            } else if (exam
                    instanceof SpecializedExamination) {

                specializedTotal += cost;
            }
        }
    }

    System.out.println(
            "\nImaging Revenue: "
                    + imagingTotal);

    System.out.println(
            "Microbiological Revenue: "
                    + microbiologicalTotal);

    System.out.println(
            "Specialized Revenue: "
                    + specializedTotal);

    double grandTotal =
            imagingTotal
                    + microbiologicalTotal
                    + specializedTotal;

    System.out.println(
            "\nTOTAL REVENUE FROM ALL CATEGORIES: "
                    + grandTotal);
}



public static Exam findExamById(int examID) {

    for (Exam exam : exams) {

        if (exam.getExamID() == examID) {

            return exam;
        }
    }

    return null;
}



public static Patient findPatientById(int patientID) {

    for (Patient patient : patients) {

        if (patient.getPatientID() == patientID) {

            return patient;
        }
    }

    return null;
}
}