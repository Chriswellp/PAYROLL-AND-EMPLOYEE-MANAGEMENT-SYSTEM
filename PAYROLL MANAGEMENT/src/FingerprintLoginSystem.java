import java.sql.*;
import java.util.Scanner;

public class FingerprintLoginSystem {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/fingerprint_system";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter fingerprint ID: ");
        int fingerprintId = scanner.nextInt();

        if (authenticateFingerprint(fingerprintId)) {
            System.out.println("Fingerprint authentication successful.");
            // Perform additional actions or grant access to the user.
        } else {
            System.out.println("Fingerprint authentication failed.");
            // Handle authentication failure scenario.
        }
    }

    private static boolean authenticateFingerprint(int fingerprintId) {
        try {
            Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            String query = "SELECT * FROM fingerprints WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, fingerprintId);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return true; // Fingerprint match found.
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false; // Fingerprint match not found.
    }
}
