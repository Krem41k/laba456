package laba456.dao;

import laba456.models.Practice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PracticeDAO {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PracticeDAO(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Practice> index() {
        return jdbcTemplate.query("SELECT * FROM practice", new BeanPropertyRowMapper<>(Practice.class));
    }
    public void save(Practice practice) {
        jdbcTemplate.update("INSERT practice(nameOfOrganization, city,positionHeld,dateOfReceipt, salary) " +
                        "VALUES(?,?,?,?,?)", practice.getNameOfOrganization(), practice.getCity(),
                practice.getPositionHeld(), practice.getDateOfReceipt(), practice.getSalary());
    }
    public Practice show(int id) {
        return jdbcTemplate.query("SELECT * FROM practice WHERE id=?",
                new Object[]{id},  new BeanPropertyRowMapper<>(Practice.class))
                .stream().findAny().orElse(null);
    }
    public void update(int id, Practice practice) {
        jdbcTemplate.update("UPDATE practice SET nameOfOrganization=?, positionHeld=?, city=?, " +
                        "dateOfReceipt=?, salary=? WHERE id=?",
                 practice.getNameOfOrganization(), practice.getPositionHeld(),
                practice.getCity(), practice.getDateOfReceipt(), practice.getSalary(), id);
    }

    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM practice WHERE id=?",id);
    }
}
