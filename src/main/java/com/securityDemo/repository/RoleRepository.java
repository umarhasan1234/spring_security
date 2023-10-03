package com.securityDemo.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.securityDemo.entity.RolesEntity;

public interface RoleRepository extends JpaRepository<RolesEntity, Long>{
	Set<RolesEntity> findByRoleIn(Set<String> roleNames);
}
