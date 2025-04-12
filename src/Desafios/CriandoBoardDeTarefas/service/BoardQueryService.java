package Desafios.CriandoBoardDeTarefas.service;

import Desafios.CriandoBoardDeTarefas.persitence.dao.BoardColumnDAO;
import Desafios.CriandoBoardDeTarefas.persitence.dao.BoardDAO;
import Desafios.CriandoBoardDeTarefas.persitence.entity.BoardEntity;
import lombok.AllArgsConstructor;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Optional;

@AllArgsConstructor
public class BoardQueryService {
    private final Connection connection;

    public Optional<BoardEntity>  findById(final long id) throws SQLException {
        var dao = new BoardDAO(connection);
        var boardColumnDAO = new BoardColumnDAO(connection);
        var optional = dao.findById(id);
        if (optional.isPresent()){
            var entity = optional.get();
            entity.setBoardColumn(boardColumnDAO.findByBoardId(entity.getId()));
            return Optional.of(entity);
        }
        return Optional.empty();
    }
}
