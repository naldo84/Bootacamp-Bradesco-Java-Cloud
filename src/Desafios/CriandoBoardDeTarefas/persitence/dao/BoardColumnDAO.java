package Desafios.CriandoBoardDeTarefas.persitence.dao;

import Desafios.CriandoBoardDeTarefas.persitence.entity.BoardColumnEntity;
import Desafios.CriandoBoardDeTarefas.persitence.entity.BoardColumnKindEnum;
import com.mysql.cj.jdbc.StatementImpl;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static Desafios.CriandoBoardDeTarefas.persitence.entity.BoardColumnKindEnum.findByName;

@RequiredArgsConstructor
public class BoardColumnDAO {

    private final Connection connection;

    public BoardColumnEntity insert(final BoardColumnEntity entity) throws SQLException{
        var sql = "INSERT INTO BOARDS+COLUMNS (name, `order`, kind, board_id ) VALUES (?, ?, ?, ?)";
        try(PreparedStatement statement = connection.prepareStatement(sql)){
            var i = 1;
            statement.setString(1, entity.getName());
            statement.setInt(2, entity.getOrder());
            statement.setString(3, entity.getKind().name());
            statement.setLong(4, entity.getBoard().getId());
            statement.executeUpdate();

            if (statement instanceof StatementImpl impl){
                entity.setId(impl.getLastInsertID());
            }

            return entity;
        }
    }

    public List<BoardColumnEntity> findByBoardId(Long id) throws SQLException{
        List<BoardColumnEntity> entities = new ArrayList<>();
        var sql = "SELECT id, name, `order` FROM BOARDS_COLUMNS WHERE board_id = ? ORDER BY `order`";
        try (PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setLong(1, id);
            statement.executeQuery();
            var resultSet = statement.getResultSet();

            while (resultSet.next()){
                var entity = new BoardColumnEntity();
                entity.setId(resultSet.getLong("id"));
                entity.setName(resultSet.getString("name"));
                entity.setOrder(resultSet.getInt("order"));
                entity.setKind(findByName(resultSet.getString("kind")));
                entities.add(entity);
            }
            return entities;
        }
    }
}
