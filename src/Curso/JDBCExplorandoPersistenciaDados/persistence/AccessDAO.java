package Curso.JDBCExplorandoPersistenciaDados.persistence;

import Curso.JDBCExplorandoPersistenciaDados.persistence.entity.EmployeeEntity;
import com.mysql.cj.jdbc.StatementImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

import static java.time.ZoneOffset.UTC;

public class AccessDAO {
    public void insert(final Long employeeId, final Long moduloId) {
        String sql = "INSERT INTO accesses (employee_id, module_id) VALUES (?, ?)";

        try (Connection connection = ConnectionUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setLong(1, employeeId);
            statement.setLong(2, moduloId);
            statement.executeUpdate();

        } catch (SQLException ex){
            ex.printStackTrace();
        }
    }
}
