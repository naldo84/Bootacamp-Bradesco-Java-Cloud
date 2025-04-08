package Curso.JDBCExplorandoPersistenciaDados.persistence;

import Curso.JDBCExplorandoPersistenciaDados.persistence.entity.ContactEntity;
import Curso.JDBCExplorandoPersistenciaDados.persistence.entity.EmployeeEntity;
import Curso.JDBCExplorandoPersistenciaDados.persistence.entity.ModuleEntity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import static java.time.ZoneOffset.UTC;

public class ModuleDAO {

    public List<ModuleEntity> findAll(){
        List<ModuleEntity> entities = new ArrayList<>();
        String sql = "select m.id module_id, m.name module_name, e.id employee_id, e.name employee_name, e.salary employee_salary, e.birthday employee_birthday\n" +
                "from modules m\n" +
                "inner join accesses a \n" +
                "   on a.module_id = m.id\n" +
                "inner join employees e \n" +
                "   on e.id = a.employee_id\n" +
                "order by m.id;";
        try(
                Connection connection = ConnectionUtil.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql);
        ){
            statement.executeQuery();
            var resultSet = statement.getResultSet();

            var hasNext = resultSet.next();
            while (resultSet.next()){
                ModuleEntity module = new ModuleEntity();
                module.setId(resultSet.getLong("module_id"));
                module.setName(resultSet.getString("module_name"));
                module.setEmployees(new ArrayList<>());
                do {
                    var employee = new EmployeeEntity();
                    employee.setId(resultSet.getLong("employee_id"));
                    employee.setName(resultSet.getString("employee_name"));
                    employee.setSalary(resultSet.getBigDecimal("employee_salary"));
                    var birthdayInstant = resultSet.getTimestamp("employee_birthday").toInstant();
                    var birthday = OffsetDateTime.ofInstant(birthdayInstant, UTC);
                    employee.setBirthday(birthday);
                    module.getEmployees().add(employee);
                    hasNext = resultSet.next();
                }while ((hasNext) && (module.getId() == resultSet.getLong("module_id")));
                entities.add(module);
            }
        } catch (SQLException ex){
            ex.printStackTrace();
        }
        return entities;
    }
}
