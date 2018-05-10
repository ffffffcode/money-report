package ex.aaronfae.report.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsersVO {

    private String username;
    private String password;
    private Boolean rememberMe;
}
