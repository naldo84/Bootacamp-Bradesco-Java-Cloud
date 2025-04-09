package Desafios.CriandoBoardDeTarefas;

import Desafios.CriandoBoardDeTarefas.persitence.migration.MigrationStrategy;

import java.sql.SQLException;

import static Desafios.CriandoBoardDeTarefas.persitence.config.ConnectionConfig.getConnection;

public class MainBoard {
    public static void main(String[] args) throws SQLException {
        try (var connection = getConnection()){
            new MigrationStrategy(connection).executeMigration();

        }
    }
}
