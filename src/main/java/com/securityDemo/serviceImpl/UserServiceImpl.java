package com.securityDemo.serviceImpl;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.securityDemo.dto.UserWithRoleDto;
import com.securityDemo.entity.RolesEntity;
import com.securityDemo.entity.UserEntity;
import com.securityDemo.repository.RoleRepository;
import com.securityDemo.repository.UserRepository;
import com.securityDemo.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private RoleRepository roleRepo;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public void saveData(UserWithRoleDto userWithRoleDto) {
		UserEntity user = new UserEntity();
        user.setUserName(userWithRoleDto.getUserName());
        user.setUserPassword(passwordEncoder.encode(userWithRoleDto.getUserPassword()));

        // Fetch roles based on role names
        Set<RolesEntity> roles = roleRepo.findByRoleIn(userWithRoleDto.getRoleNames());

        user.setRoles(roles);

         userRepo.save(user);
    }

	@Override
	public List<UserEntity> getData() {
		List<UserEntity> get = userRepo.findAll();
		return get;
	}

}
