package Desafios.CriandoBoardDeTarefas.service;

import Desafios.CriandoBoardDeTarefas.persitence.dao.BoardColumnDAO;
import Desafios.CriandoBoardDeTarefas.persitence.dao.BoardDAO;
import Desafios.CriandoBoardDeTarefas.persitence.entity.BoardEntity;
import lombok.AllArgsConstructor;

import java.sql.Connection;
import java.sql.SQLException;

@AllArgsConstructor
public class BoardService {
    private final Connection connection;

    public BoardEntity insert(final BoardEntity entity) throws SQLException{
        BoardDAO dao = new BoardDAO(connection);
        BoardColumnDAO boardColumnDAO = new BoardColumnDAO(connection);

        try {
            dao.insert(entity);
            var columns = entity.getBoardColumn().stream().map(c ->{
                c.setBoard(entity);
                return c;
            }).toList();

            for (var column : columns){
                boardColumnDAO.insert(column);
            }

            connection.commit();

        } catch (SQLException ex){
            connection.rollback();
            throw ex;
        }

        return entity;

    }

    public boolean delete(final Long id) throws SQLException {
        var boardDao = new BoardDAO(connection);
        try {
            if (!boardDao.exists(id)){
                return false;
            }

            boardDao.delete(id);
            connection.commit();
            return true;
        } catch (SQLException ex){
            connection.rollback();
            throw ex;
        }

    }
}
