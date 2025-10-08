package utility;

import org.junit.After;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DBUtils {

    public static Connection connectToDB() throws SQLException {
        return DriverManager.getConnection("jdbc:sqlite:sampl.db");
    }



    public void addUser(Map<String,String> hshuser) throws SQLException {
        try (Connection connection = connectToDB()) {
            try (Statement stmt = connection.createStatement()) {
                stmt.execute("CREATE TABLE IF NOT EXISTS users (id INTEGER PRIMARY KEY, name TEXT, email TEXT, phone TEXT, city TEXT, country TEXT, zipcode TEXT)");
            }

            String insertSql = "INSERT OR REPLACE INTO users (id, name, email, phone, city, country, zipcode) VALUES (?, ?, ?, ?, ?, ?, ?)";
            try (PreparedStatement ps = connection.prepareStatement(insertSql)) {
                ps.setInt(1, Integer.parseInt(hshuser.get("id")));
                ps.setString(2, hshuser.get("name"));
                ps.setString(3, hshuser.get("email"));
                ps.setString(4, hshuser.get("phone"));
                ps.setString(5, hshuser.get("city"));
                ps.setString(6, hshuser.get("country"));
                ps.setString(7, hshuser.get("zipcode"));
                ps.executeUpdate();
            }
        }
    }

    public static List<Map<String,Object>> readUserData() throws SQLException {
        Connection conn = connectToDB();
        Statement stmt = conn.createStatement();

        List<Map<String, Object>> table = new ArrayList<>();
        ResultSet rs = stmt.executeQuery("Select * from users");

        ResultSetMetaData rsMetaData = rs.getMetaData();
        int colCount = rsMetaData.getColumnCount();

        while(rs.next()){
            Map<String, Object> row = new HashMap<>();
            for(int i=1;i<=colCount;i++)
            {
                row.put(rsMetaData.getColumnName(i),rs.getObject(i));
            }
            table.add(row);
        }
        stmt.close();
        rs.close();
        conn.close();

        return table;
    }
}
