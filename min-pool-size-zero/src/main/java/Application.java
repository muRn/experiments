import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;
import java.time.Instant;

public class Application {
    public static void main(String[] args) throws SQLException, InterruptedException {
        ComboPooledDataSource cpds = new ComboPooledDataSource();
        cpds.setMinPoolSize(0);
        cpds.setMaxPoolSize(1);
        cpds.setAcquireIncrement(1);
        cpds.setInitialPoolSize(1);
        cpds.setMaxIdleTime(10);
        cpds.setJdbcUrl("jdbc:postgresql://localhost/postgres");
        cpds.setUser("postgres");
        cpds.setPassword("mysecretpassword");

        try (Connection con = cpds.getConnection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("select 1")) {
            System.out.println("Connection retrieved & working");
        }

        Instant start = Instant.now();
        do {
            System.out.printf("%s: %d/%d connections open%n", Instant.now().toString(), cpds.getNumIdleConnections(), cpds.getNumConnections());
            Thread.sleep(100);
        } while (Duration.between(start, Instant.now()).getSeconds() < 15);
    }
}
