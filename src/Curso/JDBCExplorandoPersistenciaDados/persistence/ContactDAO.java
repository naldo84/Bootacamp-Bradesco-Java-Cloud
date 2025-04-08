package Curso.JDBCExplorandoPersistenciaDados.persistence;

import Curso.JDBCExplorandoPersistenciaDados.persistence.entity.ContactEntity;
import Curso.JDBCExplorandoPersistenciaDados.persistence.entity.EmployeeEntity;
import com.mysql.cj.jdbc.StatementImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

import static java.time.ZoneOffset.UTC;

public class ContactDAO {
    public void insert(final ContactEntity entity) {
        String sql = "INSERT INTO contacts (description, type, employee_id) VALUES (?, ?, ?)";

        try (Connection connection = ConnectionUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, entity.getDescription());
            statement.setString(2, entity.getType());
            statement.setLong(3, entity.getEmployee().getId());
            statement.executeUpdate();

            System.out.printf("Foram afetados %s registros na base de dados: ", statement.getUpdateCount());

            if (statement instanceof StatementImpl impl){
                entity.setId(impl.getLastInsertID());
            }

        } catch (SQLException ex){
            ex.printStackTrace();
        }
    }
}
