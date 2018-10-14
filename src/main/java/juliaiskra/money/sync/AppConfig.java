package juliaiskra.money.sync;

import javax.sql.DataSource;
import juliaiskra.money.sync.domain.mapperes.AccountMapper;
import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Julia Nemtseva
 */
@Configuration
public class AppConfig {

    @Bean
    public DataSource dataSource() {
        return new PooledDataSource(
                "org.postgresql.Driver",
                "jdbc:postgresql://localhost:5432/postgres",
                "postgres",
                "postgres");
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource());
        return sqlSessionFactoryBean.getObject();
    }

    @Bean
    public AccountMapper accountMapper() throws Exception {
        MapperFactoryBean mapperFactoryBean = new MapperFactoryBean();
        mapperFactoryBean.setSqlSessionFactory(sqlSessionFactory());
        mapperFactoryBean.setMapperInterface(AccountMapper.class);
        return (AccountMapper) mapperFactoryBean.getObject();
    }
}
