package pblproj.pblschedule.config

import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.datasource.DriverManagerDataSource
import javax.sql.DataSource


@Configuration
class JdbcConfiguration {

    @Bean
    fun dataSource(): DataSource? {
        val dataSource = DriverManagerDataSource()
        dataSource.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver")
        dataSource.url = "jdbc:sqlserver://localhost:1433;database=newdb"
        dataSource.username = "kotlin_user"
        dataSource.password = "kotlin_pass"
        return dataSource
    }

    //Create a JdbcTemplate Bean that connects to our database
    @Bean
    fun jdbcTemplate(@Qualifier("dataSource") dataSource: DataSource): JdbcTemplate {
        return JdbcTemplate(dataSource)
    }
}