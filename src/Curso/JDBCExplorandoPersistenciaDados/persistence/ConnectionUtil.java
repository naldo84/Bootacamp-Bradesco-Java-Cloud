package Curso.JDBCExplorandoPersistenciaDados.persistence;

import io.github.cdimascio.dotenv.Dotenv;
import lombok.NoArgsConstructor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class ConnectionUtil {

    public static Connection getConnection() throws SQLException {
        Dotenv dotenv = Dotenv.load();
        String dbUrl = dotenv.get("DB_URL");
        String dbUser = dotenv.get("DB_USER_ADM");
        String dbPas = dotenv.get("DB_PASSWORD_ADM");

        return DriverManager.getConnection(dbUrl, dbUser, dbPas);
    }
}
