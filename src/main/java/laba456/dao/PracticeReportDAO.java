package laba456.dao;

import laba456.models.PracticeReport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PracticeReportDAO {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PracticeReportDAO(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<PracticeReport> index() {
        return jdbcTemplate.query("SELECT * FROM practicereport", new BeanPropertyRowMapper<>(PracticeReport.class));
    }
    public void save(PracticeReport practiceReport) {
        jdbcTemplate.update("INSERT practicereport(practiceId, studentId,expirationDate,grade) " +
                        "VALUES(?,?,?,?)",
                practiceReport.getPracticeId(), practiceReport.getStudentId(),
                practiceReport.getExpirationDate(), practiceReport.getGrade());
    }
    public PracticeReport show(int id) {
        return jdbcTemplate.query("SELECT * FROM practicereport WHERE id=?",
                new Object[]{id},  new BeanPropertyRowMapper<>(PracticeReport.class))
                .stream().findAny().orElse(null);
    }
    public void update(int id, PracticeReport practiceReport) {
        jdbcTemplate.update("UPDATE practicereport SET practiceId=?, studentId=?, expirationDate=?, grade=? WHERE id=?",
                practiceReport.getPracticeId(), practiceReport.getStudentId(),
                practiceReport.getExpirationDate(), practiceReport.getGrade(),id);
    }

    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM practicereport WHERE id=?",id);
    }
}
