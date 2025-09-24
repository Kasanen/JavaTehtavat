package dao;

import entity.CurrencyEntity;
import java.sql.*;
import datasource.MariaDbConnection;
import java.util.*;

public class CurrencyDao {
    public List<CurrencyEntity> getAllCurrencyEntitys() {
        Connection conn = MariaDbConnection.getConnection();
        String sql = "SELECT abbreviation, name, conversion_rate FROM CURRENCY";
        List<CurrencyEntity> currencies = new ArrayList<CurrencyEntity>();

        try {
            Statement s = conn.createStatement();
            ResultSet rs = s.executeQuery(sql);

            while (rs.next()) {
                String abbreviation = rs.getString(1);
                String name = rs.getString(2);
                double conversion_rate = rs.getDouble(3);
                CurrencyEntity emp = new CurrencyEntity(abbreviation, name, conversion_rate);
                currencies.add(emp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return currencies;
    }
}

