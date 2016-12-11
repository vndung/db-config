package vn.dung;

import org.flywaydb.core.Flyway;

import java.io.IOException;

public class Application {
    public static void main(String[] args) throws IOException {
        AppConfig config = AppConfig.init();
        Flyway flyway = new Flyway();

        flyway.setLocations("filesystem:" + config.getMigrationDir());
        flyway.setDataSource(config.getJdbcConnection(), config.getDbUser(), config.getDbPassword());

        flyway.migrate();
    }
}
