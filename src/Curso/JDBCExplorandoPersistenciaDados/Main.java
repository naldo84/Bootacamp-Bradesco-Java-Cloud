package Curso.JDBCExplorandoPersistenciaDados;

import Curso.JDBCExplorandoPersistenciaDados.persistence.EmployeeDAO;
import org.flywaydb.core.Flyway;


public class Main {

    private final static EmployeeDAO employeeDAO = new EmployeeDAO();

    public static void main(String[] args) {
//        try (Connection connection = ConnectionUtil.getConnection()){
//            System.out.println("Conectou!!");
//
//        } catch (SQLException ex){
//            ex.printStackTrace();
//        }

        var flyway = Flyway.configure()
                .dataSource("jdbc:mysql://localhost/test", "naldo", "naldo123")
                .load();

        flyway.repair();
        flyway.migrate();
    }
}
