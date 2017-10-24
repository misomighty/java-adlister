package com.codeup.adlister.dao;

import com.codeup.adlister.Config;
import com.codeup.adlister.models.User;
import com.mysql.cj.jdbc.Driver;

import java.sql.*;

public class MySQLUsersDao implements Users{
	private Connection connection = null;

	public MySQLUsersDao(Config config) {

		try {
			// Register Driver
			DriverManager.registerDriver(new Driver());
			connection = DriverManager.getConnection(
							config.getUrl(),
							config.getUser(),
							config.getPassword()
			);
		}catch (SQLException e) {
			throw new RuntimeException("Problem establishing connection to with MySQL" + e);
		}
	}
	@Override
	public User findByUsername(String username) {
		String sql = "SELECT * FROM users WHERE username=?";
		try {
			PreparedStatement ps = connection.prepareStatement(
							sql
			);
			ps.setString(1, username);

			ResultSet rs = ps.executeQuery();

			if(rs.next()) {
				User user = new User(
								rs.getLong("id"),
								rs.getString("username"),
								rs.getString("email"),
								rs.getString("password")
				);
				return user;
			} else {
				return null;
			}
		} catch (SQLException e) {
			throw new RuntimeException("Error finding user by username: ", e);
		}

	}

	@Override
	public Long insert(User user) {
		String sql = "INSERT INTO users (username, email, password)" +
						"VALUES (?, ?, ?)";
		try {

			PreparedStatement ps = connection.prepareStatement(
							sql,
							Statement.RETURN_GENERATED_KEYS
			);

			ps.setString(1, user.getUsername());
			ps.setString(2, user.getEmail());
			ps.setString(3, user.getPassword());

			ps.executeUpdate();
			ResultSet rs = ps.getGeneratedKeys();
			if (rs.next()) {
				return rs.getLong(1);
			} else {
				return null;
			}
		} catch (SQLException e) {

			throw new RuntimeException("Problem inserting user into database: ", e);
		}
	}
}