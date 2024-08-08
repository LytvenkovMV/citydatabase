package com.example.bankserver.configuration;

import com.example.bankserver.jookextranslator.ExceptionTranslator;
import lombok.RequiredArgsConstructor;
import org.jooq.impl.DefaultConfiguration;
import org.jooq.impl.DefaultDSLContext;
import org.jooq.impl.DefaultExecuteListenerProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;


//////////@Configuration
////////////@EnableTransactionManagement
/////////////@RequiredArgsConstructor
public class PersistenceContext {

//    private final Environment environment;
//
//    @Bean
//    public DataSource dataSource() {
//        DataSource dataSource = new JdbcDataSource();
//        dataSource.setUrl(environment.getRequiredProperty("db.url"));
//        dataSource.setUser(environment.getRequiredProperty("db.username"));
//        dataSource.setPassword(environment.getRequiredProperty("db.password"));
//
//        return dataSource;
//    }
//
//    @Bean
//    public TransactionAwareDataSourceProxy transactionAwareDataSource() {
//        return new TransactionAwareDataSourceProxy(dataSource());
//    }
//
//    @Bean
//    public DataSourceTransactionManager transactionManager() {
//        return new DataSourceTransactionManager(dataSource());
//    }
//
//    @Bean
//    public DataSourceConnectionProvider connectionProvider() {
//        return new DataSourceConnectionProvider(transactionAwareDataSource());
//    }
//
//    @Bean
//    public ExceptionTranslator exceptionTransformer() {
//        return new ExceptionTranslator();
//    }
//
//    @Bean
//    public DefaultDSLContext dsl() {
//        return new DefaultDSLContext(configuration());
//    }
//
//    @Bean
//    public DefaultConfiguration configuration() {
//        DefaultConfiguration jooqConfiguration = new DefaultConfiguration();
//        jooqConfiguration.set(new DefaultExecuteListenerProvider(exceptionTransformer()));
//
//        return jooqConfiguration;
//    }
}
