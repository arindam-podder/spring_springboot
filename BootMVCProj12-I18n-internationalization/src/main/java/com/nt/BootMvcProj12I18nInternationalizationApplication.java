package com.nt;

import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@SpringBootApplication
public class BootMvcProj12I18nInternationalizationApplication {

	//this is to activate I18n in spring mvc app
	@Bean(name = "localeResolver")	//fixed name
	public SessionLocaleResolver localeResolver() {
		SessionLocaleResolver sessionLocaleResolver = new SessionLocaleResolver();
		sessionLocaleResolver.setDefaultLocale(new Locale("en", "US"));
		return sessionLocaleResolver;
	}
	
	//local change interceptor will trap req and take the locale value from req param 
	@Bean
	public LocaleChangeInterceptor localeChangeInterceptor() {
		LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
		localeChangeInterceptor.setParamName("lang"); 	//along with request this param will have local info
		return localeChangeInterceptor;
	}
	
	
	
	public static void main(String[] args) {
		SpringApplication.run(BootMvcProj12I18nInternationalizationApplication.class, args);
	}

}
