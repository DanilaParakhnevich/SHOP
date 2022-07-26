package by.parakhnevich.shop.locale;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;


@Configuration
public class LocaleConfiguration {
    private String PROPERTIES_BASENAME = "localization/exceptions";

    @Bean
    public LocaleResolver localeResolver() {
        return new WebLocaleResolver();
    }

    @Bean(name = "textsResourceBundleMessageSource")
    public ResourceBundleMessageSource messageSource() {
        ResourceBundleMessageSource rs = new ResourceBundleMessageSource();
        rs.setBasename(PROPERTIES_BASENAME);
        rs.setDefaultEncoding("UTF-8");
        rs.setUseCodeAsDefaultMessage(true);
        return rs;
    }

}
