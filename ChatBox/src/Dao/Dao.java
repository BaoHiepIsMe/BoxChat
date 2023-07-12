package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Dao {
	private static final String DB_URL = "jdbc:mysql://localhost:3306/ta_tch_chatbox";
	private static final String DB_USERNAME = "root";
	private static final String DB_PASSWORD = "Hiep12062004@";

//đăng nhập
	public boolean authenticate(String HoTen, String pass) {
		try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)) {
			String query = "SELECT * FROM ta_tch_user WHERE HoTen = ? AND pass = ?";
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, HoTen);
			statement.setString(2, pass);

			ResultSet resultSet = statement.executeQuery();
			return resultSet.next();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}
//check người dùng đã tồn tại chưa
	public boolean checkUserExists(String HoTen) {
		try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)) {
			String query = "SELECT COUNT(*) FROM ta_tch_user WHERE HoTen = ?";
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, HoTen);

			ResultSet resultSet = statement.executeQuery();
			if (resultSet.next()) {
				int count = resultSet.getInt(1);
				return count > 0;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	// đăng kí
	public boolean register(String HoTen, String pass, String gioitinh, String email) {
		if (checkUserExists(HoTen)) {
			System.out.println("Người dùng đã tồn tại");
			return false;
		}

		try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)) {
			String query = "INSERT INTO ta_tch_user(HoTen, pass, giotinh, email) VALUES (?, ?, ?, ?)";
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, HoTen);
			statement.setString(2, pass);
			statement.setString(3, gioitinh);
			statement.setString(4, email);

			int rowsInserted = statement.executeUpdate();
			return rowsInserted > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

//lấy tên người dùng
	public boolean User(String sodienthoai, String Hoten) {
		try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)) {
			String query = "SELECT sodienthoai FROM ta_tch_user WHERE sodienthoai = ?";
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, sodienthoai);
			statement.setString(2, Hoten);
			ResultSet resultSet = statement.executeQuery();
			if (resultSet.next()) {
				int count = resultSet.getInt(1);
				return count > 0;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}
}
