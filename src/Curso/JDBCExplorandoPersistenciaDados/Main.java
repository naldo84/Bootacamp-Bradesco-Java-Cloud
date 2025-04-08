package Curso.JDBCExplorandoPersistenciaDados;

import Curso.JDBCExplorandoPersistenciaDados.persistence.*;
import Curso.JDBCExplorandoPersistenciaDados.persistence.entity.ContactEntity;
import Curso.JDBCExplorandoPersistenciaDados.persistence.entity.EmployeeEntity;
import Curso.JDBCExplorandoPersistenciaDados.persistence.entity.ModuleEntity;
import io.github.cdimascio.dotenv.Dotenv;
import net.datafaker.Faker;
import org.flywaydb.core.Flyway;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.*;
import java.util.ArrayList;
import java.util.Locale;
import java.util.stream.Stream;


public class Main {

    private final static EmployeeDAO employeeDAO = new EmployeeDAO();
    private final static EmployeeAuditDAO employeAuditDAO = new EmployeeAuditDAO();
    private final static EmployeeParamDAO employeeParamDAO = new EmployeeParamDAO();
    private final static Faker faker = new Faker(new Locale("pt", "BR"));
    private final static ModuleDAO moduleDAO = new ModuleDAO();
    private final static ContactDAO contatctDAO = new ContactDAO();

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

//        var employee = new EmployeeEntity();
//        employee.setName("Teste contatct");
//        employee.setSalary(new BigDecimal("3500"));
//        employee.setBirthday(OffsetDateTime.now().minusYears(10));
//        employeeDAO.insert(employee);
//        System.out.println("Employee: " + employee);
//
//        employeeParamDAO.insertWithProcedure(employee);
//        System.out.println("Employee depois do DAO" + employee);
//
//        employeeDAO.findAll().forEach(System.out::println);
//
//        System.out.println("Encontrado: " + employeeDAO.findById(2013));
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

//        var birthday = faker.timeAndDate().birthday();
//        System.out.println("Niver: " + birthday.getClass());
//
//        var entities = Stream.generate(() -> {
//            var employeeN = new EmployeeEntity();
//            employeeN.setName(faker.name().fullName());
//            employeeN.setSalary(new BigDecimal(faker.number().digits(4)));
//            employeeN.setBirthday(OffsetDateTime.of(LocalDate.now().minusYears(faker.number().numberBetween(40, 20)), LocalTime.MIN, ZoneOffset.UTC));
//
//            return employeeN;
//
//        }).limit(2000).toList();
//
//        employeeParamDAO.insertBatch(entities);
//
//
//        var contact1 = new ContactEntity();
//        contact1.setDescription("teste@testecontact.com.br");
//        contact1.setType("email");
//        contact1.setEmployee(employee);
//        contatctDAO.insert(contact1);
//        System.out.println("Employee: " + employee);
//
//        var contact2 = new ContactEntity();
//        contact2.setDescription("1199999999");
//        contact2.setType("celular");
//        contact2.setEmployee(employee);
//        contatctDAO.insert(contact2);
//        System.out.println("Employee: " + employee);

        //System.out.println("Busca: " + employeeParamDAO.findById(2013));
        //employeeParamDAO.findAll().forEach(System.out::println);


//        var entities = Stream.generate(() -> {
//            var employeeN = new EmployeeEntity();
//            employeeN.setName(faker.name().fullName());
//            employeeN.setSalary(new BigDecimal(faker.number().digits(4)));
//            employeeN.setBirthday(OffsetDateTime.of(LocalDate.now().minusYears(faker.number().numberBetween(40, 20)), LocalTime.MIN, ZoneOffset.UTC));
//            employeeN.setModules(new ArrayList<>());
//            var moduleAmount = faker.number().numberBetween(1, 4);
//            for (int i= 0; i < moduleAmount; i++){
//                var module = new ModuleEntity();
//                module.setId((long) (i +1));
//                employeeN.getModules().add(module);
//            }
//            return employeeN;
//
//        }).limit(5).toList();
//        entities.forEach(employeeParamDAO::insert);

        moduleDAO.findAll().forEach(System.out::println);
    }
}
