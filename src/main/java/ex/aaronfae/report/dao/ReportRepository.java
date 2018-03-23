package ex.aaronfae.report.dao;

import ex.aaronfae.report.entity.Report;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface ReportRepository extends CrudRepository<Report, Integer> {
}
