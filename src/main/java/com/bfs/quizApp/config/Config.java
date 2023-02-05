package com.bfs.quizApp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.sql.DataSource;

@Configuration
public class Config implements WebMvcConfigurer {
//    private LoginFilter loginFilter;
//
//    @Autowired
//    public WebMvcConfig(LoginFilter loginFilter) {
//        this.loginFilter = loginFilter;
//    }



    private final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    private final String DB_URL = "jdbc:mysql://127.0.0.1:3306/quizApp";
    private final String USER = "root";
    private final String PASSWORD = "dbuserdbuser";


    @Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/jsp/");
        resolver.setSuffix(".jsp");
        return resolver;
    }


    @Bean
    public DataSource jdbcDataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(JDBC_DRIVER);
        dataSource.setUrl(DB_URL);
        dataSource.setUsername(USER);
        dataSource.setPassword(PASSWORD);
        return dataSource;
    }

//    @Bean
//    public FilterRegistrationBean<LoginFilter> filterRegistrationBean() {
//        FilterRegistrationBean<LoginFilter> registrationBean = new FilterRegistrationBean<>();
//        LoginFilter loginFilter = new LoginFilter();
//
//        registrationBean.setFilter(loginFilter);
//        registrationBean.addUrlPatterns("/login/*");
//        registrationBean.setOrder(2); //set precedence
//        return registrationBean;
//    }
}
