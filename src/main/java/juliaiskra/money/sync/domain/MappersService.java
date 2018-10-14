package juliaiskra.money.sync.domain;

import javax.sql.DataSource;
import juliaiskra.money.sync.domain.mapperes.AccountMapper;
import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

/**
 * @author Julia Nemtseva
 */
public class MappersService {
    private SqlSessionFactory sqlSessionFactory;

    public MappersService() {
        setupMappers();
    }

    private void setupMappers() {
        DataSource dataSource = new PooledDataSource("org.postgresql.Driver",
                "jdbc:postgresql://localhost:5432/postgres", "postgres", "postgres");
        TransactionFactory transactionFactory = new JdbcTransactionFactory();
        Environment environment = new Environment("development", transactionFactory, dataSource);
        Configuration configuration = new Configuration(environment);
        configuration.addMapper(AccountMapper.class);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
    }

    public <T> T getMapper(Class<T> aClass) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            return session.getMapper(aClass);
        }
    }
}
