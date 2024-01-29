package ruby.spring.config;

import com.zaxxer.hikari.HikariDataSource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.JdbcTransactionManager;
import org.springframework.transaction.TransactionManager;

import javax.sql.DataSource;

/**
 * 스프링부트에서 자동구성을 통해 DataSource, TransactionManager, JdbcTemplate 을 빈으로 등록해준다.
 * - 별도의 설정이 없으면 메모리 DB 를 사용하도록 설정됨
 */
@Slf4j
//@Configuration - 주석처리
public class DbConfig {

    @Bean
    public DataSource dataSource() {
        log.info("DbConfig.dataSource 빈 등록");
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setDriverClassName("org.h2.Driver");
        dataSource.setJdbcUrl("jdbc:h2:mem:test");      // JVM 내부에서 동작하는 메모리 DB 사용. 테스트용
        dataSource.setUsername("sa");
        dataSource.setPassword("");
        return dataSource;
    }

    @Bean
    public TransactionManager transactionManager() {
        log.info("DbConfig.transactionManager 빈 등록");
        // JdbcTransactionManager : DataSourceTransactionManager 를 상속하는, 예외 변환 기능이 보강된 클래스
        return new JdbcTransactionManager(dataSource());
    }

    @Bean
    public JdbcTemplate jdbcTemplate() {
        log.info("DbConfig.JdbcTemplate 빈 등록");
        return new JdbcTemplate(dataSource());
    }
}
