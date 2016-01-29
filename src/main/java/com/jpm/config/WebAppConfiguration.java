package com.jpm.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;

@Configuration
@ComponentScan(basePackages = { "com.jpm.algo" } , excludeFilters = @Filter({ Controller.class }))
public class WebAppConfiguration {

}
