package dao;

import entity.Dish;
import entity.DishType;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DishDao {
	
	private Connection connection;
	private final String GET_DISH_QUERY = "select * from dish";
	private final String CREATE_DISH_QUERY = "insert into dish (dish_name, dish_type) VALUES(?, ?)";
	private final String UPDATE_DISH_QUERY = "update dish (dish_name, dish_type) VALUES(?, ?) WHERE id = ?";
	private final String DELETE_DISH_QUERY = "DELETE from dish WHERE id = ?";
	private final String GET_DISH_BY_ID_QUERY = "select * from dish where id = ?";
	private final String GET_DISH_BY_NAME = "SELECT id FROM dish WHERE dish_name = ?";
	private final String CREATE_DISH_STAT = "INSERT INTO dish_stats (dish_id, count) VALUES (?, 0)";
	
	public DishDao(){
		connection = DBConnection.getConnection();
	}

    public List<Dish> getAllDishes() throws SQLException {
    	ResultSet rs = connection.prepareStatement(GET_DISH_QUERY).executeQuery();

        List<Dish> dishList = new ArrayList<>();

        while (rs.next()) {
            dishList.add(
                    new Dish(
                            rs.getInt(1),
                            rs.getString(2),
                            DishType.get(rs.getString(3))
                    )
            );
        }

        return dishList;
    }
    public Dish getDishById(int id) throws SQLException {
    	PreparedStatement ps = connection.prepareStatement(GET_DISH_BY_ID_QUERY);
    	ps.setInt(1, id);
    	ResultSet rs = ps.executeQuery();
    	rs.next();
    	return new Dish(rs.getInt(1), rs.getString(2), DishType.get(rs.getString(3)));
    }
    
    private int getDishByName(String name) throws SQLException {
    	PreparedStatement ps = connection.prepareStatement(GET_DISH_BY_NAME);
    	ps.setString(1, name);
    	ResultSet rs = ps.executeQuery();
    	if (rs.next()) return rs.getInt(1);
		return 0;
    }
    
    private void createDishStat(int id) throws SQLException {
    	PreparedStatement ps = connection.prepareStatement(CREATE_DISH_STAT);
    	ps.setInt(1, id);
    	ps.executeUpdate();
    }

    public void CreateNewDish(String dishName, String dishType) throws SQLException {
    	PreparedStatement ps = connection.prepareStatement(CREATE_DISH_QUERY);
    	ps.setString(1, dishName);
    	ps.setString(2, dishType);
    	System.out.println(ps.toString());
    	ps.executeUpdate();
    	
    	createDishStat(getDishByName(dishName));
    }
    public void UpdateDish(String dishName, String dishType) throws SQLException{
    	PreparedStatement ps = connection.prepareStatement(UPDATE_DISH_QUERY);
    	ps.setString(1, dishName);
    	ps.setString(2, dishType);
    	ps.executeUpdate();
    }
    public void DeleteDish(int id) throws SQLException {
    	PreparedStatement ps = connection.prepareStatement(DELETE_DISH_QUERY);
    	ps.setInt(1, id);
    	ps.executeUpdate();

    }
}
