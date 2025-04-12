package Desafios.CriandoBoardDeTarefas.ui;

import Desafios.CriandoBoardDeTarefas.persitence.entity.BoardColumnEntity;
import Desafios.CriandoBoardDeTarefas.persitence.entity.BoardColumnKindEnum;
import Desafios.CriandoBoardDeTarefas.persitence.entity.BoardEntity;
import Desafios.CriandoBoardDeTarefas.service.BoardQueryService;
import Desafios.CriandoBoardDeTarefas.service.BoardService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static Desafios.CriandoBoardDeTarefas.persitence.config.ConnectionConfig.getConnection;
import static Desafios.CriandoBoardDeTarefas.persitence.entity.BoardColumnKindEnum.*;

public class MainMenu {
    private final Scanner scanner = new Scanner(System.in);

    public void execute() throws SQLException{
        System.out.println("Bem vindo ao gerenciador de Boards. Escolha a opção desejada");
        var option = -1;

        while (true){
            System.out.println("1 - Criar um novo board");
            System.out.println("2 - Selecionar um board existente");
            System.out.println("3 - Excluir um board");
            System.out.println("4 - Sair");

            option = scanner.nextInt();

            switch (option){
                case 1 -> createBoard();
                case 2 -> selectBoard();
                case 3 -> deleteBoard();
                case 4 -> System.exit(0);
                default -> System.out.println("Opção inválida. Informe uma opção válida do menu");
            }

        }
    }

    private void createBoard() throws SQLException {
        var entity = new BoardEntity();
        System.out.print("Informe o nome do seu board: ");
        entity.setName(scanner.next());

        System.out.println("Seu board terá colunas além das 3 padrões? ");
        System.out.println("Se sim, informe quants. Se não, digite 0: ");
        int additionalcolumns = scanner.nextInt();

        List<BoardColumnEntity> columns = new ArrayList<>();
        System.out.println("Informe o nome da coluna inicial do Board: ");
        var initialColumnName = scanner.next();
        var initialColum = createColumn(initialColumnName, INITIAL, 0);
        columns.add(initialColum);

        for (int i=1; i< additionalcolumns; i++){
            System.out.println("Informe o nome da coluna de tarefa pendente do board: ");
            var pendingColumnName = scanner.next();
            var pendingColumn = createColumn(pendingColumnName, PENDING, i+1);
            columns.add(pendingColumn);
        }

        System.out.println("Informe o nome da coluna final do Board: ");
        var finalColumnName = scanner.next();
        var finalColumn = createColumn(finalColumnName, FINAL, additionalcolumns + 1);
        columns.add(finalColumn);

        System.out.println("Informe o nome da coluna de cancelamento do Board: ");
        var cancelColumnName = scanner.next();
        var cancelColumn = createColumn(cancelColumnName, CANCEL, additionalcolumns + 1);
        columns.add(cancelColumn);

        entity.setBoardColumn(columns);
        try(var connection = getConnection()) {
            var service = new BoardService(connection);
            service.insert(entity);
        }
    }

    private void selectBoard()throws SQLException {
        System.out.print("Informe o Id do Board que deseja selecionar: ");
        var id = scanner.nextLong();
        try(var connection = getConnection()){
            var queryService = new BoardQueryService(connection);
            var optional = queryService.findById(id);

            optional.ifPresentOrElse(b -> new BoardMenu(b).execute(),
                    () -> System.out.printf("Não foi encontrado um board com o id %s\n", id));
        }
    }

    private void deleteBoard() throws SQLException {
        System.out.print("Informe o Id do Board que será excluído: ");
        var id = scanner.nextLong();
        try (var connection = getConnection()){
            var service = new BoardService(connection);
            if (service.delete(id)){
                System.out.printf("O board %s foi excluído!\n", id);
            } else {
                System.out.printf("Não foi encontrado um board com o id %s\n", id);
            }

        }
    }

    private BoardColumnEntity createColumn(final String name, final BoardColumnKindEnum kind, final int order){
        var boardcolumn = new BoardColumnEntity();
        boardcolumn.setName(name);
        boardcolumn.setKind(kind);
        boardcolumn.setOrder(order);

        return boardcolumn;
    }
}
