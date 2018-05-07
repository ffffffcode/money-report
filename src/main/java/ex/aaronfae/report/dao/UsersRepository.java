package ex.aaronfae.report.dao;

import ex.aaronfae.report.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, Long> {

    Users findByUsername(String username);
}
