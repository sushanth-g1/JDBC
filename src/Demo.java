import java.sql.*;

public class Demo {
    public static void main(String[] args) throws SQLException {
        String sql = "select * from student where id = ?";
        String url = "jdbc:mysql://localhost:3306/sushanthdb";
        String username = "root";
        String password = "Sushanth";

//        Connection con = DriverManager.getConnection(url,username,password);
//        Statement st = con.createStatement();                                       //use PreparedStatement for dynamic input
//        ResultSet set = st.executeQuery(sql);
//        while(set.next()){
//        String name = set.getString("name");
//        System.out.println(name);
//        }
//        con.close();

        Connection con = DriverManager.getConnection(url,username,password);
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        String parameterValue = "2";
        preparedStatement.setString(1,parameterValue);              //In the line preparedStatement.setString(1,parameterValue);, the 1 refers to the parameter index. In JDBC, parameter indexes are 1-based, meaning they start from 1, not 0.

        ResultSet set = preparedStatement.executeQuery();
        while(set.next()){
        String name = set.getString("name");
        System.out.println(name);
        }
        con.close();


    }
}

