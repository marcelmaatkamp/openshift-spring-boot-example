package jruby.configuration.asciidoctor;

import org.asciidoctor.Asciidoctor.Factory;
import org.asciidoctor.Asciidoctor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Collections;

/**
 * Created by marcelmaatkamp on 28/08/14.
 */

@Configuration
public class AsciiDoctorConfiguration {
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Bean
    Asciidoctor asciidoctor() {
        Asciidoctor asciidoctor = Factory.create();

        String rendered = asciidoctor.render("*This* is it.", Collections.EMPTY_MAP);
        log.info(rendered);

        return asciidoctor;
    }
}
