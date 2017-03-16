package com.feng.dao;

import com.feng.entity.Role;

public interface UserRoleDao {
	public Role roleByUserId(int userId);

}
