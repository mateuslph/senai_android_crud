import java.sql.*;

public class Main {
    static final String DATABASE_URL = "jdbc:mysql://localhost:3306/senai_uc10_sa2";
    public static void main(String[] args) {
        Connection connection = null;
        Statement stm = null;
        ResultSet rs = null;

        try {
            connection = DriverManager.getConnection(DATABASE_URL, "root", "10.20-Ma.login");
            stm = connection.createStatement();
            stm.execute("insert into produtos (idProduto, descricao, preco, unidade) values (5, 'Linguíça', 28.2, 'kg');");
            stm.execute("update produtos set descricao = 'Farinha' where descricao = 'Açúcar';");
            stm.execute("delete from produtos where descricao = 'Carne';");
            rs = stm.executeQuery("select * from produtos");
            while (rs.next())
                System.out.println(rs.getInt(1) + " " +
                        rs.getString(2) + " " +
                        rs.getFloat(3) + " " +
                        rs.getString(4));
            connection.close();
        } catch (SQLException se) {
            se.printStackTrace();
        }
    }
}