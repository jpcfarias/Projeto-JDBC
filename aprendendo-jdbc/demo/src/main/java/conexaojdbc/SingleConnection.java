package conexaojdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class SingleConnection{
    private static String url = "jdbc:postgresql://localhost:5432/postgres";
    private static String senha = "root";
    private static String usuario = "postgres";
    private static Connection connection = null;

    static {
        conectar();
    }

    public SingleConnection(){
        conectar();
    }
    
    private static void conectar(){
        try {
            if(connection == null){
                Class.forName("org.postgresql.Driver");
                connection = DriverManager.getConnection(url, usuario, senha);
                connection.setAutoCommit(false);
                System.out.println("Conectou com sucesso");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection(){
        return connection;
    }
}