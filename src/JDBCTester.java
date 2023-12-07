import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCTester {

    public static void main(String[] args) {

        String sqlQuery = "SELECT Qno, Qtext, Opt1, Opt2, Opt3, Opt4, CorrAns FROM TimeSeriesQuestions";

        // Create a 2D array to store the data
        String[][] timeSeriesData = new String[10][7];

        try{
             ConnectorSQL c = new ConnectorSQL();
             ResultSet resultSet = c.s.executeQuery(sqlQuery);

            // Iterate through the result set and populate the array
            int row = 0;
            while (resultSet.next()) {
                timeSeriesData[row][0] = resultSet.getString("Qno");
                timeSeriesData[row][1] = resultSet.getString("Qtext");
                timeSeriesData[row][2] = resultSet.getString("Opt1");
                timeSeriesData[row][3] = resultSet.getString("Opt2");
                timeSeriesData[row][4] = resultSet.getString("Opt3");
                timeSeriesData[row][5] = resultSet.getString("Opt4");
                timeSeriesData[row][6] = resultSet.getString("CorrAns");

                // Move to the next row
                row++;
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }

        // Print the fetched data (optional)
        for (String[] row : timeSeriesData) {
            for (String value : row) {
                System.out.print(value + "\t");
            }
            System.out.println();
        }
        System.out.print(timeSeriesData[1][1]);
    }
}
