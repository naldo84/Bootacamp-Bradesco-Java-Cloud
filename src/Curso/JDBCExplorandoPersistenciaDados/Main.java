package Curso.JDBCExplorandoPersistenciaDados;

import Curso.JDBCExplorandoPersistenciaDados.persistence.ConnectionUtil;
import Curso.JDBCExplorandoPersistenciaDados.persistence.EmployeeAuditDAO;
import Curso.JDBCExplorandoPersistenciaDados.persistence.EmployeeDAO;
import Curso.JDBCExplorandoPersistenciaDados.persistence.EmployeeParamDAO;
import Curso.JDBCExplorandoPersistenciaDados.persistence.entity.EmployeeEntity;
import io.github.cdimascio.dotenv.Dotenv;
import net.datafaker.Faker;
import org.flywaydb.core.Flyway;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.*;
import java.util.Locale;
import java.util.stream.Stream;


public class Main {

    private final static EmployeeDAO employeeDAO = new EmployeeDAO();
    private final static EmployeeAuditDAO employeAuditDAO = new EmployeeAuditDAO();
    private final static EmployeeParamDAO employeeParamDAO = new EmployeeParamDAO();
    private final static Faker faker = new Faker(new Locale("pt", "BR"));

    public static void main(String[] args) throws SQLException {

        Dotenv dotenv = Dotenv.load();
        String dbUrl = dotenv.get("DB_URL");
        String dbUser = dotenv.get("DB_USER_ADM");
        String dbPas = dotenv.get("DB_PASSWORD_ADM");

        var flyway = Flyway.configure()
                .dataSource(dbUrl, dbUser, dbPas)
                .outOfOrder(true)
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

        flyway.repair();
        flyway.migrate();

        var employee = new EmployeeEntity();
        employee.setName("Teste");
        employee.setSalary(new BigDecimal("35000"));
        employee.setBirthday(OffsetDateTime.now().minusYears(15));
        System.out.println("Employee: " + employee);

        employeeParamDAO.insertWithProcedure(employee);
        System.out.println("Employee depois do DAO" + employee);
//
//        employeeDAO.findAll().forEach(System.out::println);
//
//        System.out.println("Encontrado: " + employeeDAO.findById(1));
//
//        var employee2 = new EmployeeEntity();
//        employee2.setId(1L);
//        employee2.setName("Eriosvaldo");
//        employee2.setSalary(new BigDecimal("40000"));
//        employee2.setBirthday(OffsetDateTime.now().minusYears(10));
//        employeeDAO.update(employee2);
//        employeeDAO.delete(1);
//
//        employeAuditDAO.findAll().forEach(System.out::println);

        var birthday = faker.timeAndDate().birthday();
        System.out.println("Niver: " + birthday.getClass());

        var entities = Stream.generate(() -> {
            var employeeN = new EmployeeEntity();
            employeeN.setName(faker.name().fullName());
            employeeN.setSalary(new BigDecimal(faker.number().digits(4)));
            employeeN.setBirthday(OffsetDateTime.of(LocalDate.now().minusYears(faker.number().numberBetween(40, 20)), LocalTime.MIN, ZoneOffset.UTC));

            return employeeN;

        }).limit(2000).toList();

        employeeParamDAO.insertBatch(entities);
    }
}
