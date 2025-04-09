package Desafios.CriandoBoardDeTarefas.persitence.config;

import io.github.cdimascio.dotenv.Dotenv;
import lombok.NoArgsConstructor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public final class ConnectionConfig {

    public static Connection getConnection() throws SQLException {
        Dotenv dotenv = Dotenv.load();
        String dbUrl = dotenv.get("DB_URL_BOARD");
        String dbUser = dotenv.get("DB_USER_ADM");
        String dbPass = dotenv.get("DB_PASSWORD_ADM");

        var connection = DriverManager.getConnection(dbUrl, dbUser, dbPass);
        connection.setAutoCommit(false);
        return connection;
    }
}
