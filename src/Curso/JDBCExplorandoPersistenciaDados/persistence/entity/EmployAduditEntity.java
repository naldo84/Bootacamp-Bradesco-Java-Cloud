package Curso.JDBCExplorandoPersistenciaDados.persistence.entity;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

public record EmployAduditEntity(
        Long employee_id,
        String name,
        String oldName,
        BigDecimal salary,
        BigDecimal oldSalary,
        OffsetDateTime birthday,
        OffsetDateTime oldBirthday,
        OperationEnum operation
) {
}
