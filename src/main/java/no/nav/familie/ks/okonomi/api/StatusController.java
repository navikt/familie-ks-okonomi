package no.nav.familie.ks.okonomi.api;

import no.nav.familie.ks.okonomi.db.ØkonomiJdbcRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/internal/status")
public class StatusController {

    private ØkonomiJdbcRepository økonomiDb;

    public StatusController(@Autowired ØkonomiJdbcRepository økonomiDb) {
        this.økonomiDb = økonomiDb;
    }

    @GetMapping("/isAlive")
    public String isAlive() {
        return "OK";
    }

    @GetMapping("/isReady")
    public String isReady() {
        økonomiDb.ping();
        return "OK";
    }
}
