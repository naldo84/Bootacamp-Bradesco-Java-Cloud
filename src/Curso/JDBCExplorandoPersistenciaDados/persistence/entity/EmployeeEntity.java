package Curso.JDBCExplorandoPersistenciaDados.persistence.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.OffsetDateTime;


@Getter
@Setter
@ToString
public class EmployeeEntity {
    private Long id;
    private String name;
    private BigDecimal salary;
    private OffsetDateTime birthday;

}
