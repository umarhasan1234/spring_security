package com.securityDemo.service;

import java.util.List;

import com.securityDemo.dto.UserWithRoleDto;
import com.securityDemo.entity.UserEntity;

public interface UserService {
	public void saveData(UserWithRoleDto userWithRoleDto);

	public List<UserEntity> getData();

}
