package com.feng.dao;

import java.util.List;

import com.feng.entity.Function;

public interface RoleFunctionDao {
	public List<Function> functionByRoleId(int roleId);

}
