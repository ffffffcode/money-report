package ex.aaronfae.report.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "BIGINT UNSIGNED")
    private Long id;
    @Column(columnDefinition = "CHAR(4)", nullable = false)
    private String realName;
    @Column(columnDefinition = "DECIMAL(19,2) UNSIGNED", nullable = false)
    private BigDecimal price;
    @Column(columnDefinition = "DATE", nullable = false)
    private Date contributingTime;
    @Column(nullable = false)
    private Date submitTime;
    private Date confirmTime;
    @Column(columnDefinition = "VARCHAR(50)", nullable = false)
    private String intention;

}
