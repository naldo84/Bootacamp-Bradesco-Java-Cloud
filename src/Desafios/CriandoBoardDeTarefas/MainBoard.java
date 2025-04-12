package Desafios.CriandoBoardDeTarefas;

import Desafios.CriandoBoardDeTarefas.persitence.migration.MigrationStrategy;

import java.sql.SQLException;

import static Desafios.CriandoBoardDeTarefas.persitence.config.ConnectionConfig.getConnection;

public class MainBoard {
    public static void main(String[] args) throws SQLException {
        try (var connection = getConnection()){
            new MigrationStrategy(connection).executeMigration();

            //arquivo properties para consulta
//            changeLogFile=src/main/resources/db/changelog/db.changelog-master.yml
//            url=${ENV:DB_URL_BOARD}
//            username=${ENV:DB_USER_ADM}
//            password=${ENV:DB_PASSWORD_ADM}
//            driver=com.mysql.cj.jdbc.Driver
            //Iniciar o vídeo entidades e acessos a dados

        }
    }
}
