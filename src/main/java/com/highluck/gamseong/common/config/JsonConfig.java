package com.highluck.gamseong.common.config;




import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.joda.JodaModule;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

@EnableWebMvc
@Configuration
public class JsonConfig extends WebMvcConfigurerAdapter{
	
	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		// TODO Auto-generated method stub
		MappingJackson2HttpMessageConverter jacksonMessageConverter
		= new MappingJackson2HttpMessageConverter();
		ObjectMapper objectMapper = jacksonMessageConverter.getObjectMapper();
		
		objectMapper.registerModule(new JodaModule());
		objectMapper.configure(SerializationFeature.WRITE_DATE_KEYS_AS_TIMESTAMPS, true);
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		objectMapper.configure(DeserializationFeature.READ_UNKNOWN_ENUM_VALUES_AS_NULL, true);

		converters.add(jacksonMessageConverter);
	}
/*
	@Bean
    public ObjectMapper objectMapper() {

        return Jackson2ObjectMapperBuilder
        		.json().featuresToDisable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
        		.modules(new JavaTimeModule()).build()
        		.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
        		.configure(DeserializationFeature.READ_UNKNOWN_ENUM_VALUES_AS_NULL, true);
    }*/
}
