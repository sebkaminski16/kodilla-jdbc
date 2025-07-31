import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbManagerTestSuite {

    @Test
    void testConnect() {
        //given, when
        DbManager dbManager = DbManager.getInstance();
        //then
        Assertions.assertNotNull(dbManager.getConnection());
    }

    @Test
    void testSelectUsers() throws SQLException {
        //given
        DbManager dbManager = DbManager.getInstance();
        //when
        String SQLQuery = "SELECT * FROM users\n"
                + "WHERE ID > 2";
        Statement stmt = dbManager.getConnection().createStatement();
        ResultSet rs = stmt.executeQuery(SQLQuery);
        //then
        int counter = 0;
        while(rs.next()) {
//            System.out.println("ID: " + rs.getInt("ID")
//            + ", " + "FIRSTNAME: " + rs.getString("FIRSTNAME")
//            + ", " + "LASTNAME: " + rs.getString("LASTNAME"));
            counter++;
        }
//        System.out.printf("All results: %d", counter);
        rs.close();
        stmt.close();
        Assertions.assertEquals(6, counter);
    }

    @Test
    void testSelectUsersAndPosts() throws SQLException{
        //arrange
        DbManager dbManager = DbManager.getInstance();
        String SQLQuery = "SELECT U.FIRSTNAME, U.LASTNAME, COUNT(*) AS POSTS_NUMBER\n"
                + "FROM posts P JOIN users U ON U.ID = P.USERID\n"
                + "GROUP BY U.ID\n"
                + "HAVING COUNT(*) >= 2";
        //act
        Statement stmt = dbManager.getConnection().createStatement();
        ResultSet rs = stmt.executeQuery(SQLQuery);
        int recordsNum = 0;
        while(rs.next()) {
            String postAuthor = rs.getString("FIRSTNAME")
                    + " " + rs.getString("LASTNAME");
            System.out.println(postAuthor);
            recordsNum++;
        }
        //assert
        //!!! I deleted previous databases to revise the material, that's why there are not many records there.
        Assertions.assertEquals(1, recordsNum);
    }
}
