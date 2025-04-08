package Curso.JDBCExplorandoPersistenciaDados.persistence;

import Curso.JDBCExplorandoPersistenciaDados.persistence.entity.ContactEntity;
import Curso.JDBCExplorandoPersistenciaDados.persistence.entity.EmployeeEntity;
import com.mysql.cj.jdbc.StatementImpl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


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

    public List<ContactEntity> findByEmployeeId(final Long employeeId){
        List<ContactEntity> entities = new ArrayList<>();
        String sql = "SELECT * FROM contacts WHERE employee_id = ?";

        try(
                Connection connection = ConnectionUtil.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql);
        ){
            statement.setLong(1, employeeId);
            statement.executeQuery();
            var resultSet = statement.getResultSet();

            while (resultSet.next()){
                var entity = new ContactEntity();
                entity.setId(resultSet.getLong("id"));
                entity.setDescription(resultSet.getString("description"));
                entity.setType(resultSet.getString("type"));
                entity.setEmployee(new EmployeeEntity());
                entity.getEmployee().setId(resultSet.getLong("employee_id"));
                entities.add(entity);


            }

           // System.out.println("Qtde registros: " + entities.size());

        } catch (SQLException ex){
            ex.printStackTrace();
        }

        return entities;
    }
}
