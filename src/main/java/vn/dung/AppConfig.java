package vn.dung;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

public class AppConfig {

    private String migrationDir;
    private String jdbcConnection;
    private String dbUser;
    private String dbPassword;

    private AppConfig() {
    }

    public static AppConfig init() throws IOException {
        AppConfig appConfig = new AppConfig();
        Properties properties = new Properties();
        properties.load(FileUtils.openInputStream(new File("db-config.properties")));

        appConfig.migrationDir = properties.getProperty("db-migration-dir");
        readDbInfo(properties.getProperty("config-properties-file"), appConfig);

        return appConfig;
    }

    private static void readDbInfo(String propertyFile, AppConfig appConfig) throws IOException {
        Properties properties = new Properties();
        properties.load(FileUtils.openInputStream(new File(propertyFile)));

        appConfig.jdbcConnection = properties.getProperty("sonar.jdbc");
        appConfig.dbUser = properties.getProperty("sonar.user");
        appConfig.dbPassword = properties.getProperty("sonar.password");
    }


    public String getMigrationDir() {
        return migrationDir;
    }

    public void setMigrationDir(String migrationDir) {
        this.migrationDir = migrationDir;
    }

    public String getJdbcConnection() {
        return jdbcConnection;
    }

    public void setJdbcConnection(String jdbcConnection) {
        this.jdbcConnection = jdbcConnection;
    }

    public String getDbUser() {
        return dbUser;
    }

    public void setDbUser(String dbUser) {
        this.dbUser = dbUser;
    }

    public String getDbPassword() {
        return dbPassword;
    }

    public void setDbPassword(String dbPassword) {
        this.dbPassword = dbPassword;
    }
}
