package com.jpm.config;

import java.util.Locale;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.jpm.algo"} , includeFilters = @Filter({ Controller.class }))
public class WebMvcConfiguration extends WebMvcConfigurationSupport {

	/**
	 * CSS / JavaScript / Image 등의 정적 리소스 처리해주는 핸들러 등록
	 */
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
		// registry.addResourceHandler("/static/**").addResourceLocations("/static/");
	}

	/**
	 * JSP를 뷰로 사용하는 뷰 리졸버 등록
	 * 
	 * @return
	 */
	@Bean
	public ViewResolver jspViewResorver() {
		InternalResourceViewResolver viewResorver = new InternalResourceViewResolver();
		viewResorver.setViewClass(JstlView.class);
		viewResorver.setPrefix("/WEB-INF/views/");
		viewResorver.setSuffix(".jsp");
		viewResorver.setOrder(1);
		return viewResorver;
	}
		
	/**
	 * Controller 타지 않아도 되는 정적 페이지 등록시
	 */
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/temp/tempUrl").setViewName("/temp/tempUrl");
	}
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		LocaleChangeInterceptor localeChangeInteceptor = new LocaleChangeInterceptor();
		localeChangeInteceptor.setParamName("lang");
		registry.addInterceptor(localeChangeInteceptor);
	}
	
	@Bean
	public LocaleResolver localeResover() {
		final CookieLocaleResolver localeResolver = new CookieLocaleResolver();
		localeResolver.setDefaultLocale(new Locale("ko_KR"));
		return localeResolver;
	}
	
	
}
