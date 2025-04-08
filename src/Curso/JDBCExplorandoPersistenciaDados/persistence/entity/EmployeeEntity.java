package Curso.JDBCExplorandoPersistenciaDados.persistence.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.List;


@Data
public class EmployeeEntity {
    private Long id;
    private String name;
    private BigDecimal salary;
    private OffsetDateTime birthday;
    private List<ContactEntity> contact;
    private List<ModuleEntity> modules;
}
