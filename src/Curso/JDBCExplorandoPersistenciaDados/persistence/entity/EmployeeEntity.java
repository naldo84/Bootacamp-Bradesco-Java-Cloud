package Curso.JDBCExplorandoPersistenciaDados.persistence.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.time.OffsetDateTime;


@Data
public class EmployeeEntity {
    private Long id;
    private String name;
    private BigDecimal salary;
    private OffsetDateTime birthday;
    private ContactEntity contact;
}
