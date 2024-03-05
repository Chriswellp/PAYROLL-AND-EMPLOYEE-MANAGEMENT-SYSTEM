import java.sql.*;

public class FingerprintDataUploader {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/your_database_name";
    private static final String DB_USER = "your_username";
    private static final String DB_PASSWORD = "your_password";

    public static void main(String[] args) {
        int userId = 1; // ID of the user to associate with the fingerprint
        byte[] fingerprintData = getFingerprintData(); // Replace this with the actual fingerprint data

        if (uploadFingerprint(userId, fingerprintData)) {
            System.out.println("Fingerprint uploaded successfully.");
        } else {
            System.out.println("Failed to upload fingerprint.");
        }
    }

    private static boolean uploadFingerprint(int userId, byte[] fingerprintData) {
        try {
            Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            String query = "INSERT INTO fingerprints (user_id, fingerprint_data) VALUES (?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, userId);
            preparedStatement.setBytes(2, fingerprintData);

            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    private static byte[] getFingerprintData() {
            // Assume you are using a fingerprint reader device with a library called "FingerprintReaderLib"

            // Initialize the fingerprint reader device
            FingerprintReaderLib.initialize();

            // Capture the fingerprint data
            byte[] fingerprintData = FingerprintReaderLib.captureFingerprint();

            // Cleanup and release resources
            FingerprintReaderLib.close();

            return fingerprintData;

    }
}
