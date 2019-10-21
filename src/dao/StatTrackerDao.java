package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class StatTrackerDao {

    public Connection connection;

    private final String TABLE = "dish_stats";
    private final String GET_ALL_QUERY = "SELECT * FROM " + TABLE;
    private final String GET_BY_ID_QUERY = "SELECT count FROM " + TABLE + " WHERE id = ?";
    private final String CREATE_NEW_QUERY = "INSERT INTO " + TABLE + " (name, quantity, price) VALUES (?, ?, ?)";
    private final String UPDATE_QUERY = "UPDATE " + TABLE + " SET count = ? WHERE id = ?";
    private final String DELETE_QUERY = "DELETE FROM " + TABLE + " WHERE id = ?";

    public StatTrackerDao() {
        connection = DBConnection.getConnection();
    }

    public Map<Integer, Integer> getAll() {
        ResultSet resultSet;
        Map<Integer, Integer> map = new HashMap<>();
		try {
			resultSet = connection.prepareStatement(GET_ALL_QUERY).executeQuery();
			while (resultSet.next()) {
	            map.put(resultSet.getInt(1), resultSet.getInt(2));
	        }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        return map;
    }
    
    public int getDishStat(int dishId) throws SQLException {
    	PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_ID_QUERY);
    	preparedStatement.setInt(1, dishId);
    	
        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            return resultSet.getInt(1);
        }

        return 0;
    }
    
    public void increaseDishStat(int dishId) throws SQLException {    	
    	PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_QUERY);

    	preparedStatement.setInt(1, getDishStat(dishId) + 1);
        preparedStatement.setInt(2, dishId);
        System.out.println(preparedStatement.toString());
        preparedStatement.executeUpdate();
    }

}
