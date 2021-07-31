package com.ss.cfsd.utopia.dao;

import com.ss.cfsd.utopia.domain.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO extends BaseDAO<User> {

	public UserDAO(Connection conn) throws ClassNotFoundException, SQLException {
		super(conn);
	}
	
	// Create.
	public void createUser(User user) throws SQLException, ClassNotFoundException {
		save("INSERT INTO user(role_id, given_name, family_name, username, email, password, phone) VALUES(?, ?, ?, ?, ?, ?, ?);",
				new Object[] {user.getRoleId(), user.getGivenName(), user.getFamilyName(), user.getUsername(),
						user.getEmail(), user.getPassword(), user.getPhone()});
	}

	// Read.
	public List<User> readUser() throws SQLException, ClassNotFoundException {
		return read("SELECT * FROM user;", new Object[] {});
	}
	
	public List<User> readUserWhereRoleIdEqualsTravelerId() throws SQLException, ClassNotFoundException {
		return read("SELECT * FROM user WHERE role_id ="
				+ " (SELECT id FROM user_role WHERE name='Traveler');", new Object[] {});
	}
	
	public List<User> readUserWhereRoleIdEqualsEmployeeId() throws SQLException, ClassNotFoundException {
		return read("SELECT * FROM user WHERE role_id ="
				+ " (SELECT id FROM user_role WHERE name='Employee');", new Object[] {});
	}
	
	// Update.
	public void updateUser(User user) throws SQLException, ClassNotFoundException {
		save("UPDATE user SET role_id = ?, given_name = ?, family_name = ?, username = ?, email = ?, password = ?, phone = ? WHERE id = ?;",
				new Object[] {user.getRoleId(), user.getGivenName(), user.getFamilyName(), user.getUsername(),
						user.getEmail(), user.getPassword(), user.getPhone(), user.getId()});
	}
	
	// Delete.
	public void deleteUser(User user) throws SQLException, ClassNotFoundException {
		save("DELETE FROM user WHERE id = ?;",
				new Object[] {user.getId()});
	}

	@Override
	public List<User> extractData(ResultSet rs) throws SQLException {
		List<User> userList = new ArrayList<User>();
		while(rs.next()) {
			User user = new User();
			user.setId(rs.getInt("id"));
			user.setRoleId(rs.getInt("role_id"));
			user.setGivenName(rs.getString("given_name"));
			user.setFamilyName(rs.getString("family_name"));
			user.setUsername(rs.getString("username"));
			user.setEmail(rs.getString("email"));
			user.setPassword(rs.getString("password"));
			user.setPhone(rs.getString("phone"));
			userList.add(user);
		}
		return userList;
	}
}
