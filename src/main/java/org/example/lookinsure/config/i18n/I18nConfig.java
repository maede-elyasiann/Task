package org.example.lookinsure.config.i18n;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.servlet.LocaleResolver;

import java.util.Locale;

@Configuration
public class I18nConfig {

    @Value("${default.language}")
    private String defaultLanguage;

    @Bean
    public LocaleResolver localeResolver() {
        AcceptHeaderResolver localeResolver = new AcceptHeaderResolver();
        localeResolver.setDefaultLocale(new Locale(defaultLanguage));
        return localeResolver;
    }

    @PostConstruct
    public void changeDefaultLocale() {
        LocaleContextHolder.setDefaultLocale(new Locale(defaultLanguage));
    }
}
