package Curso.JDBCExplorandoPersistenciaDados.persistence;

import Curso.JDBCExplorandoPersistenciaDados.persistence.entity.EmployeeEntity;
import com.mysql.cj.jdbc.StatementImpl;

import java.sql.*;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
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
        try(Connection connection = ConnectionUtil.getConnection();
                Statement statement = connection.createStatement();
                ){
            var sql = "UPDATE employees set " +
                    "name     = '" + entity.getName() + "', " +
                    "salary   = '" + entity.getSalary() + "', " +
                    "birthday = '" + entity.getBirthday() + "'" +
                    "WHERE id = " + entity.getId();

            statement.executeUpdate(sql);
            System.out.println("Afetado na base: " + statement.getUpdateCount());
            if (statement instanceof  StatementImpl imp)
                entity.setId(imp.getLastInsertID());

        } catch (SQLException ex){
            ex.printStackTrace();
        }

    }

    public void delete(final long id){
        try(Connection connection = ConnectionUtil.getConnection();
            Statement statement = connection.createStatement();
        ){
            var sql = "DELETE FROM employees WHERE id = " + id;

            statement.executeUpdate(sql);
            System.out.println("Afetado na base: " + statement.getUpdateCount());

        } catch (SQLException ex){
            ex.printStackTrace();
        }


    }

    public List<EmployeeEntity> findAll(){
        List<EmployeeEntity> entities = new ArrayList<>();

        try(
                Connection connection = ConnectionUtil.getConnection();
                Statement statement = connection.createStatement();
                ){
            statement.executeQuery("SELECT * FROM employees ORDER BY name");
            var resultSet = statement.getResultSet();

            while (resultSet.next()){
                var entity = new EmployeeEntity();
                entity.setId(resultSet.getLong("id"));
                entity.setName(resultSet.getString("name"));
                entity.setSalary(resultSet.getBigDecimal("salary"));
                var birthdayInstant = resultSet.getTimestamp("birthday").toInstant();
                var birthday = OffsetDateTime.ofInstant(birthdayInstant, ZoneOffset.UTC);
                entity.setBirthday(birthday);
                entities.add(entity);
            }

            System.out.println("Qtde registros: " + entities.size());

        } catch (SQLException ex){
            ex.printStackTrace();
        }

        return entities;
    }

    public EmployeeEntity findById(final long id){
        var entity = new EmployeeEntity();
        try (
                Connection connection = ConnectionUtil.getConnection();
                Statement statement = connection.createStatement();
                ){
            statement.executeQuery("SELECT * FROM employees WHERE id=" + id);
            var resultSet = statement.getResultSet();

            if (resultSet.next()){

                entity.setId(resultSet.getLong("id"));
                entity.setName(resultSet.getString("name"));
                entity.setSalary(resultSet.getBigDecimal("salary"));
                var birthdayInstant = resultSet.getTimestamp("birthday").toInstant();
                var birthday = OffsetDateTime.ofInstant(birthdayInstant, ZoneOffset.UTC);
                entity.setBirthday(birthday);
            }


        } catch (SQLException ex){
            ex.printStackTrace();
        }

        return  entity;
    }
}
