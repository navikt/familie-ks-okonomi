package no.nav.familie.ks.okonomi.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.flyway.FlywayConfigurationCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;

@Configuration
@Profile("!dev")
@EnableJdbcRepositories
public class FlywayConfiguration {

    private static final Logger LOG = LoggerFactory.getLogger(FlywayConfiguration.class);

    @Bean
    public FlywayConfigurationCustomizer flywayConfig(@Value("${spring.cloud.vault.database.role}") String role) {
        LOG.info("Setter riktig rolle på databasebruker før flywaymigrering");
        return c -> c.initSql(String.format("SET ROLE \"%s\"", role));
    }
}
