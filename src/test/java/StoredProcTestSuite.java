import org.junit.jupiter.api.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StoredProcTestSuite {
    @Test
    public void testUpdateVipLevels() throws SQLException {
        // Given
        DbManager dbManager = DbManager.getInstance();
        String sqlUpdate = "UPDATE READERS SET VIP_LEVEL=\"Not set\"";
        Statement statement = dbManager.getConnection().createStatement();
        statement.executeUpdate(sqlUpdate);
        String sqlCheckTable = "SELECT COUNT(*) AS HOW_MANY FROM READERS WHERE VIP_LEVEL=\"Not set\"";

        // When
        Statement statement2 = dbManager.getConnection().createStatement();
        String sqlProcedureCall = "CALL UpdateVipLevels()";
        statement2.execute(sqlProcedureCall);
        ResultSet rs = statement.executeQuery(sqlCheckTable);

        // Then
        int howMany = -1;
        if (rs.next()) {
            howMany = rs.getInt("HOW_MANY");
        }
        assertEquals(0, howMany);
        rs.close();
        statement.close();
        statement2.close();
    }

    @Test
    public void testUpdateBestsellers() throws SQLException {
        //arrange
        DbManager dbManager = DbManager.getInstance();
        Statement statement = dbManager.getConnection().createStatement();
        String sqlReset = "UPDATE BOOKS SET BESTSELLER = FALSE";
        statement.executeUpdate(sqlReset);

        String sqlCheckReset = "SELECT COUNT(*) AS HOW_MANY FROM BOOKS WHERE BESTSELLER = TRUE";
        ResultSet rsReset = statement.executeQuery(sqlCheckReset);
        int countBefore = 0;
        if (rsReset.next()) {
            countBefore = rsReset.getInt("HOW_MANY");
        }
        assertEquals(0, countBefore);
        rsReset.close();

        //act
        Statement statement2 = dbManager.getConnection().createStatement();
        statement2.execute("CALL UpdateBestsellers()");
        String sqlCheckAfter = "SELECT COUNT(*) AS HOW_MANY FROM BOOKS WHERE BESTSELLER = TRUE";
        ResultSet rsAfter = statement.executeQuery(sqlCheckAfter);
        int countAfter = -1;
        if (rsAfter.next()) {
            countAfter = rsAfter.getInt("HOW_MANY");
        }

        //assert
        assertEquals(1, countAfter);
        rsAfter.close();
        statement.close();
        statement2.close();
    }

}