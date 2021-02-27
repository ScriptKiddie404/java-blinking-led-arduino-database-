package Model;

import ConnectionUtilities.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static Model.SQLQueries.LedQueries.*;

public class LedDAO implements Repositorio<Led> {

    @Override
    public void save(Led led) {
        try (PreparedStatement statement = getConnection().prepareStatement(SAVE)) {
            statement.setString(1, led.getLedState());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Connection getConnection() throws SQLException {
        return DBConnection.getInstance();
    }
}
