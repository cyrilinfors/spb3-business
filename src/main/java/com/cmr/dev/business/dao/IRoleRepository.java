package com.cmr.dev.business.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cmr.dev.business.entity.Role;
import com.cmr.dev.business.utils.ConstsValues;
/**
 * This interface serves as a repository for managing {@link Role} entities in
 * the database. It extends JpaRepository, providing CRUD operations for the
 * {@link Role} entity with Integer as the type of its primary key.
 */
@Repository(value = ConstsValues.ConstsDAO.ROLE_DAO_KEY)
public interface IRoleRepository extends JpaRepository<Role, Integer> {
	Role findByRoleName(String roleName);
}