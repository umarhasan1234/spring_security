
package com.securityDemo.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.securityDemo.dto.UserWithRoleDto;
import com.securityDemo.entity.UserEntity;
import com.securityDemo.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	//http://localhost:9090/user/saveData
	@PostMapping("/saveData")
	public void saveUser(@RequestBody UserWithRoleDto userWithRoleDto) {
		System.out.println("hii");
		userService.saveData(userWithRoleDto);
	}
	
	@GetMapping("/get")
	public List<UserEntity> getUser() {
		List<UserEntity> data = userService.getData();
		return data;
	}
	
}
