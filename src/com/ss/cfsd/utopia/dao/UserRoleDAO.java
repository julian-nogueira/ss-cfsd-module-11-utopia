package com.ss.cfsd.utopia.dao;

import com.ss.cfsd.utopia.domain.UserRole;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserRoleDAO extends BaseDAO<UserRole> {

	public UserRoleDAO(Connection conn) throws ClassNotFoundException, SQLException {
		super(conn);
	}
	
	// Create.
	public void createUserRole(UserRole userRole) throws SQLException, ClassNotFoundException {
		save("INSERT INTO user_role(name) VALUES(?);",
				new Object[] {userRole.getName()});
	}

	// Read.
	public List<UserRole> readUserRole() throws SQLException, ClassNotFoundException {
		return read("SELECT * FROM user_role;", new Object[] {});
	}
	
	// Update.
	public void updateUserRole(UserRole userRole) throws SQLException, ClassNotFoundException {
		save("UPDATE user_role SET name = ? WHERE id = ?;",
				new Object[] {userRole.getName(), userRole.getId()});
	}
	
	// Delete.
	public void deleteUserRole(UserRole userRole) throws SQLException, ClassNotFoundException {
		save("DELETE FROM user_role WHERE id = ?;",
				new Object[] {userRole.getId()});
	}

	@Override
	public List<UserRole> extractData(ResultSet rs) throws SQLException {
		List<UserRole> userRoleList = new ArrayList<UserRole>();
		while(rs.next()) {
			UserRole userRole = new UserRole();
			userRole.setId(rs.getInt("id"));
			userRole.setName(rs.getString("name"));
			userRoleList.add(userRole);
		}
		return userRoleList;
	}
}
