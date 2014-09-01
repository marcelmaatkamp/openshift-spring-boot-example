package jruby;

import org.jruby.embed.ScriptingContainer;
import org.jruby.runtime.builtin.IRubyObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.autoconfigure.thymeleaf.ThymeleafAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.io.InputStream;


@Configuration
@ComponentScan
@EnableConfigurationProperties
@EnableAutoConfiguration

public class JRubyApplicationStarter {
    private final Logger log = LoggerFactory.getLogger(this.getClass());



    public static void main(String[] args) {
        new SpringApplicationBuilder(JRubyApplicationStarter.class).web(false).run(args);
    }
}
