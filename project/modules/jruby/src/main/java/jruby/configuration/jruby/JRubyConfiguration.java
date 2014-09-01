package jruby.configuration.jruby;

import org.jruby.embed.ScriptingContainer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by marcelmaatkamp on 28/08/14.
 */
@Configuration
@EnableScheduling
public class JRubyConfiguration {

    private final Logger log = LoggerFactory.getLogger(this.getClass());


    @Bean
    ClassLoader classLoader() {
        return Thread.currentThread().getContextClassLoader();
    }

    @Bean
    ScriptingContainer scriptingContainer() throws IOException {
        ch.qos.logback.classic.spi.ThrowableProxy p;

        ScriptingContainer scriptingContainer = new ScriptingContainer();

        String filename = "ruby/burn.rb";

        InputStream is = classLoader().getResource(filename).openStream();
        scriptingContainer.runScriptlet(is, filename);

        scriptingContainer.put("message", "Hello from Java with help from Ruby!"); // <1>
        log.info(""+scriptingContainer.runScriptlet("message.upcase")); // <4>
        return scriptingContainer;
    }


}
