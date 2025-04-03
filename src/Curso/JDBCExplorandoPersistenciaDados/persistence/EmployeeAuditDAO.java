package Curso.JDBCExplorandoPersistenciaDados.persistence;

import Curso.JDBCExplorandoPersistenciaDados.persistence.entity.EmployAduditEntity;
import Curso.JDBCExplorandoPersistenciaDados.persistence.entity.EmployeeEntity;
import Curso.JDBCExplorandoPersistenciaDados.persistence.entity.OperationEnum;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;

import static java.time.ZoneOffset.UTC;
import static java.util.Objects.isNull;

public class EmployeeAuditDAO {
    public List<EmployAduditEntity> findAll(){
        List<EmployAduditEntity> entities = new ArrayList<>();

        try(
                Connection connection = ConnectionUtil.getConnection();
                Statement statement = connection.createStatement();
        ){
            statement.executeQuery("SELECT * FROM view_employee_audit");
            var resultSet = statement.getResultSet();


            while (resultSet.next()){
                entities.add(new EmployAduditEntity(
                        resultSet.getLong("employee_id"),
                        resultSet.getString("name"),
                        resultSet.getString("old_name"),
                        resultSet.getBigDecimal("salary"),
                        resultSet.getBigDecimal("old_salary"),
                        getDateTimeOrNull(resultSet, "birthday"),
                        getDateTimeOrNull(resultSet, "old_birthday"),
                        OperationEnum.getByDbOperation(resultSet.getString("operation"))
                ));

            }

            System.out.println("Qtde registros: " + entities.size());

        } catch (SQLException ex){
            ex.printStackTrace();
        }

        return entities;
    }

    public OffsetDateTime getDateTimeOrNull(final ResultSet resultSet, final String field) throws SQLException {
        return isNull(resultSet.getTimestamp(field)) ? null :
                OffsetDateTime.ofInstant(
                        resultSet.getTimestamp(field).toInstant(), UTC);
    }
}
