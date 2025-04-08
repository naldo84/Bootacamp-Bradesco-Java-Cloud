package Curso.JDBCExplorandoPersistenciaDados.persistence;

import Curso.JDBCExplorandoPersistenciaDados.persistence.entity.ContactEntity;
import Curso.JDBCExplorandoPersistenciaDados.persistence.entity.EmployeeEntity;
import com.mysql.cj.jdbc.StatementImpl;

import java.sql.*;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;

import static java.time.ZoneOffset.UTC;
import static java.util.TimeZone.LONG;

public class EmployeeParamDAO {

    private final ContactDAO contactDAO = new ContactDAO();

    public void insert(final EmployeeEntity entity) {
        String sql = "INSERT INTO employees (name, salary, birthday) VALUES (?, ?, ?)";

        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, entity.getName());
            statement.setBigDecimal(2, entity.getSalary());
            statement.setTimestamp(3, Timestamp.valueOf(entity.getBirthday().atZoneSimilarLocal(UTC).toLocalDateTime()));
            statement.executeUpdate();

            System.out.printf("Foram afetados %s registros na base de dados: ", statement.getUpdateCount());

            if (statement instanceof StatementImpl impl){
                entity.setId(impl.getLastInsertID());

            }

        } catch (SQLException ex){
            ex.printStackTrace();
        }
    }

    public void insertWithProcedure(final EmployeeEntity entity) {
        String sql = "call prc_insert_employee (?, ?, ?, ?);";

        try (Connection connection = ConnectionUtil.getConnection();
             var statement = connection.prepareCall(sql)) {

            statement.registerOutParameter(1, LONG );
            statement.setString(2, entity.getName());
            statement.setBigDecimal(3, entity.getSalary());
            statement.setTimestamp(4,
                    Timestamp.valueOf(entity.getBirthday().atZoneSimilarLocal(UTC).toLocalDateTime()));

            statement.execute();
            entity.setId(statement.getLong(1));

        } catch (SQLException ex){
            ex.printStackTrace();
        }
    }

    public void insertBatch(final List<EmployeeEntity> entities) {
        String sql = "INSERT INTO employees (name, salary, birthday) VALUES (?, ?, ?)";

        try (Connection connection = ConnectionUtil.getConnection()){
            try(PreparedStatement statement = connection.prepareStatement(sql)){
                connection.setAutoCommit(false);
                for  (var entity : entities){
                    statement.setString(1, entity.getName());
                    statement.setBigDecimal(2, entity.getSalary());
                    statement.setTimestamp(3, Timestamp.valueOf(entity.getBirthday().atZoneSimilarLocal(UTC).toLocalDateTime()));

                    statement.addBatch();
                }

                statement.executeBatch();
                connection.commit();

            }  catch (SQLException ex){
                connection.rollback();
                ex.printStackTrace();
            }



        } catch (SQLException ex){
            ex.printStackTrace();
        }
    }

    public void update(final EmployeeEntity entity){
        String sql = "UPDATE employees set " +
                "name = ? , salary = ?, birthday = ? WHERE id = ?";

        try(Connection connection = ConnectionUtil.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql);
                ){

            statement.setString(1, entity.getName());
            statement.setBigDecimal(2, entity.getSalary());
            statement.setTimestamp(3, Timestamp.valueOf(entity.getBirthday().atZoneSimilarLocal(UTC).toLocalDateTime()));
            statement.executeUpdate();


            System.out.println("Afetado na base: " + statement.getUpdateCount());

            if (statement instanceof  StatementImpl imp)
                entity.setId(imp.getLastInsertID());

        } catch (SQLException ex){
            ex.printStackTrace();
        }

    }

    public void delete(final long id){
        var sql = "DELETE FROM employees WHERE id = ?";

        try(Connection connection = ConnectionUtil.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
        ){
            statement.setLong(1, id);
            statement.executeUpdate();
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
                var birthday = OffsetDateTime.ofInstant(birthdayInstant, UTC);
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
        //String sql = "SELECT * FROM employees INNER JOIN contacts ON contacts.employee_id = employees.id WHERE id = ?";
        String sql = "SELECT e.id employee_id,\n" +
                "   e.name, \n" +
                "   e.salary, \n" +
                "   e.birthday, \n" +
                "   c.id contact_id, \n" +
                "   c.description, \n" +
                "   c.type \n" +
                "FROM employees e\n" +
                "LEFT JOIN contacts c\n" +
                "ON c.employee_id = e.id\n " +
                "WHERE e.id = ?";

        try (
                Connection connection = ConnectionUtil.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql);
                ){

            statement.setLong(1, id);
            statement.executeQuery();

            var resultSet = statement.getResultSet();

            if (resultSet.next()){
                entity.setId(resultSet.getLong("employee_id"));
                entity.setName(resultSet.getString("name"));
                entity.setSalary(resultSet.getBigDecimal("salary"));
                var birthdayInstant = resultSet.getTimestamp("birthday").toInstant();
                var birthday = OffsetDateTime.ofInstant(birthdayInstant, UTC);
                entity.setBirthday(birthday);


                entity.setContact(new ArrayList<>());

                do {
                    Long contactId = resultSet.getObject("contact_id", Long.class);
                    if (contactId != null){
                        var contact = new ContactEntity();
                        contact.setId(contactId);
                        contact.setDescription(resultSet.getString("description"));
                        contact.setType(resultSet.getString("type"));
                        entity.getContact().add(contact);
                    }


                } while (resultSet.next());
//                entity.setContact(new ContactEntity());
//                entity.getContact().setId(resultSet.getLong("contact_id"));
//                entity.getContact().setDescription(resultSet.getString("description"));
//                entity.getContact().setType(resultSet.getString("type"));

//                Long contactId = resultSet.getObject("contact_id", Long.class);
//                if (contactId != null){
//                    ContactEntity contact = new ContactEntity();
//                    contact.setId(contactId);
//                    contact.setDescription(resultSet.getString("description"));
//                    contact.setType(resultSet.getString("type"));
//                    entity.setContact(contact);
//                }
            }


        } catch (SQLException ex){
            ex.printStackTrace();
        }

        return  entity;
    }
}
