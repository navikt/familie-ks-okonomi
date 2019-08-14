package no.nav.familie.ks.okonomi;

import no.nav.familie.ks.okonomi.config.ApplicationConfig;
import no.nav.familie.ks.okonomi.config.DelayedShutdownHook;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Launcher {

    public static void main(String... args) {
        SpringApplication app = new SpringApplication(ApplicationConfig.class);
        app.setRegisterShutdownHook(false);
        ConfigurableApplicationContext applicationContext = app.run(args);
        Runtime.getRuntime().addShutdownHook(new DelayedShutdownHook(applicationContext));
    }
}
