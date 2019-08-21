package no.nav.familie.ks.okonomi;

import no.nav.familie.ks.okonomi.config.ApplicationConfig;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication(exclude = ErrorMvcAutoConfiguration.class)
@EnableTransactionManagement
public class DevLauncher {

    public static void main(String... args) {
        new SpringApplicationBuilder(ApplicationConfig.class)
                .profiles("dev")
                .run(args);
    }
}
