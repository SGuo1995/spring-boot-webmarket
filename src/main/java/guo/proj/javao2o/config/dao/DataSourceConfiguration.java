package guo.proj.javao2o.config.dao;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import guo.proj.javao2o.util.DESUtil;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.beans.PropertyVetoException;

/**
 *Do configuration of data source in IOC container
 */
@Configuration
//Configure mybatis scan path
@MapperScan("guo.proj.javao2o.dao")
public class DataSourceConfiguration {
    @Value("${jdbc.driver}")
    private String jdbcDriver;
    @Value("${jdbc.url}")
    private String jdbcUrl;
    @Value("${jdbc.username}")
    private String jdbcUsername;
    @Value("${jdbc.password}")
    private String jdbcPassword;

    /**
     * generate bean "dataSource" which is corresponding to spring-dao.xml
     */
    @Bean(name = "dataSource")
    public ComboPooledDataSource createDataSource() throws PropertyVetoException {
        //create dataSource instance
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        //configure the same info as spring-dao.xml
        //driver
        dataSource.setDriverClass(jdbcDriver);
        dataSource.setJdbcUrl(jdbcUrl);
        dataSource.setUser(DESUtil.getDecryptString(jdbcUsername));
        dataSource.setPassword(DESUtil.getDecryptString(jdbcPassword));
        //Configure properties of c3p0
        //Max number of threads of pool
        dataSource.setMaxPoolSize(30);
        //Min number of threads
        dataSource.setMinPoolSize(10);
        dataSource.setInitialPoolSize(10);
        //Do not auto-commit when close connection
        dataSource.setAutoCommitOnClose(false);
        //Time out time
        dataSource.setCheckoutTimeout(10000);
        //Max number of retries
        dataSource.setAcquireIncrement(2);
        return dataSource;

    }

}
