package org.example.lookinsure.config.i18n;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

public class AcceptHeaderResolver extends AcceptHeaderLocaleResolver {

    @Value("${default.language:en}")
    private String defaultLanguage;

    private final List<Locale> supportedLocales = Arrays.asList(
            new Locale("en"));

    @NotNull
    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        String headerLang = request.getHeader("Accept-Language");
        if (!StringUtils.hasLength(headerLang)) {
            Locale.setDefault(new Locale(defaultLanguage));
            return Locale.getDefault();
        } else {
            Locale lookup = Locale.lookup(Locale.LanguageRange.parse(headerLang), supportedLocales);
            if (Objects.isNull(lookup)) {
                Locale.setDefault(new Locale(defaultLanguage));
                return Locale.getDefault();
            }
            return lookup;
        }
    }
}
