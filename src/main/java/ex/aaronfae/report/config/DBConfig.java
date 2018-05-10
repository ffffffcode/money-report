package ex.aaronfae.report.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DBConfig {

    @Bean
    public DruidDataSource dataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/dormitory?characterEncoding=UTF-8");
        dataSource.setUsername("root");
        dataSource.setPassword("");
        dataSource.setMaxActive(10);
        return dataSource;
    }
}
