package com.fideljose.reactivemiscelanea.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@PropertySources({
	@PropertySource("classpath:custome.properties"),
	@PropertySource("classpath:custome_data_2.properties")
})
public class LoadConfigFileData {
	
	@Autowired
	LoadConfigFileData loadConfigFileData;
	
	@Value("${custome_data.name}")
	public String name;
	
	@Value("${custome.lastname}")
	public String lastname;

	@Value("${custome.email}")
	public String email;
	
	@Value("${custome.address}")
	public String address;
	
	@Bean
	public void loadDFataFromConfigirationFile() {
		System.out.println("LOAD FROM CONFIGURATION NAME " + name);
		System.out.println("LOAD FROM CONFIGURATION LASTNAME " + loadConfigFileData.lastname);
		System.out.println("LOAD FROM CONFIGURATION EMAIL " + loadConfigFileData.email);
		System.out.println("LOAD FROM CONFIGURATION ADDRESS " + loadConfigFileData.address);
	}
	
	@Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
       return new PropertySourcesPlaceholderConfigurer();
    }
}
