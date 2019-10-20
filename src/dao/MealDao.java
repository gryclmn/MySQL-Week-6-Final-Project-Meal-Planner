package dao;

import java.sql.Connection;

public class MealDao {

    private Connection connection;

    public MealDao() {
        connection = DBConnection.getConnection();
    }
}
