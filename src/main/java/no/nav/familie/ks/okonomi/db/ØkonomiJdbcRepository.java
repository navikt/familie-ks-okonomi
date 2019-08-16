package no.nav.familie.ks.okonomi.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ØkonomiJdbcRepository {

    private JdbcTemplate jdbcTemplate;

    public ØkonomiJdbcRepository(@Autowired JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void ping() {
        jdbcTemplate.execute("SELECT 1 FROM OKONOMI");
    }
}
