package Curso.JDBCExplorandoPersistenciaDados.persistence;

import Curso.JDBCExplorandoPersistenciaDados.persistence.entity.EmployeeEntity;
import com.mysql.cj.jdbc.StatementImpl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class EmployeeDAO {

    public void insert(final EmployeeEntity entity) {
        String sql = "INSERT INTO employees (name, salary, birthday) VALUES (?, ?, ?)";

        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, entity.getName());
            statement.setString(2, entity.getSalary().toString());
            statement.setDate(3, Date.valueOf(entity.getBirthday().toLocalDate()));
            statement.executeUpdate();

            System.out.printf("Foram afetados %s registros na base de dados: ", statement.getUpdateCount());

            if (statement instanceof StatementImpl impl){
                entity.setId(impl.getLastInsertID());

            }

        } catch (SQLException ex){
            ex.printStackTrace();
        }
    }

    public void update(final EmployeeEntity entity){

    }

    public void delete(final long id){

    }

    public List<EmployeeEntity> findAll(){
        return null;
    }

    public EmployeeEntity findById(final long id){
        return  null;
    }
}
