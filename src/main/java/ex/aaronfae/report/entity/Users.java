package ex.aaronfae.report.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "BIGINT UNSIGNED")
    private Long id;
    @Column(columnDefinition = "VARCHAR(16)", nullable = false, unique = true)
    private String username;
    @Column(columnDefinition = "VARCHAR(32)", nullable = false)
    private String password;
    @Column(columnDefinition = "CHAR(4)", nullable = false)
    private String realName;
}
