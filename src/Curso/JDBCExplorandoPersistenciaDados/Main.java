package Curso.JDBCExplorandoPersistenciaDados;

import Curso.JDBCExplorandoPersistenciaDados.persistence.ConnectionUtil;
import Curso.JDBCExplorandoPersistenciaDados.persistence.EmployeeDAO;
import Curso.JDBCExplorandoPersistenciaDados.persistence.entity.EmployeeEntity;
import io.github.cdimascio.dotenv.Dotenv;
import org.flywaydb.core.Flyway;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.OffsetDateTime;


public class Main {

    private final static EmployeeDAO employeeDAO = new EmployeeDAO();

    public static void main(String[] args) throws SQLException {
//        try (Connection connection = ConnectionUtil.getConnection()){
//            System.out.println("Conectou!!");
//
//        } catch (SQLException ex){
//            ex.printStackTrace();
//        }

        Dotenv dotenv = Dotenv.load();
        String dbUrl = dotenv.get("DB_URL");
        String dbUser = dotenv.get("DB_USER_ADM");
        String dbPas = dotenv.get("DB_PASSWORD_ADM");

        var flyway = Flyway.configure()
                .dataSource(dbUrl, dbUser, dbPas)
                .load();

        try (Connection connection = ConnectionUtil.getConnection();
             Statement statement = connection.createStatement()) {

            ResultSet rs = statement.executeQuery("SELECT DATABASE()");
            if (rs.next()) {
                System.out.println("Banco de dados ativo: " + rs.getString(1));
            } else {
                System.out.println("Nenhum banco de dados ativo!");
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        //flyway.repair();
        flyway.migrate();

//        var employee = new EmployeeEntity();
//        employee.setName("Erinaldo");
//        employee.setSalary(new BigDecimal("5000"));
//        employee.setBirthday(OffsetDateTime.now().minusYears(20));
//        System.out.println("Employee: " + employee);
//
//        employeeDAO.insert(employee);
//        System.out.println("Employee depois do DAO" + employee);
    }
}
