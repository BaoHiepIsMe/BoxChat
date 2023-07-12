package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Model.Message;

public class DAOMESSAGE {
	private static final String DB_URL = "jdbc:mysql://localhost:3306/ta_tch_chatbox";
	private static final String DB_USERNAME = "root";
	private static final String DB_PASSWORD = "Hiep12062004@";

	public boolean saveMess(String HoTen, String content) {
		try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)) {
			String query = "INSERT INTO ta_tch_message(Hoten,content)" + "  VALUES (?, ? )";
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, HoTen);
			statement.setString(2, content);

			int rowsInserted = statement.executeUpdate();
			return rowsInserted > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}
//hiển thị tin nhắn khoảng 12h đổ lại
	public List<Message> getRecentMessages() {
		List<Message> messages = new ArrayList<>();

		try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)) {
			String query = "SELECT HoTen, content, date_send FROM ta_tch_message WHERE date_send >= NOW() - INTERVAL 12 HOUR";
			PreparedStatement statement = connection.prepareStatement(query);

			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				String HoTen = resultSet.getString("HoTen");
				String content = resultSet.getString("content");
				String dateSend = resultSet.getString("date_send");

				Message message = new Message(HoTen, content, dateSend);
				messages.add(message);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return messages;
	}
}
