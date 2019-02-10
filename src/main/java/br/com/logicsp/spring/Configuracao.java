package br.com.logicsp.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@SpringBootApplication
public class Configuracao {
    public static void main(String[] args) {
        SpringApplication.run(Configuracao.class, args);
    }

    @Bean
    public DataSource dataSource(){
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        driverManagerDataSource.setUrl("jdbc:mysql://localhost:3306/listavip");
        driverManagerDataSource.setUsername("root");
        driverManagerDataSource.setPassword("Locusamenus01");
        return driverManagerDataSource;
    }
}
