package com.cmr.dev.business.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cmr.dev.business.entity.Privilege;
import com.cmr.dev.business.entity.Role;
import com.cmr.dev.business.entity.User;
import com.cmr.dev.business.utils.ConstsValues;
 
 
 

/**
 * This interface serves as a repository for managing {@link Privilege} entities
 * in the database. It extends JpaRepository, providing CRUD operations for the
 * {@link Privilege} entity with Integer as the type of its primary key.
 */
@Repository(value = ConstsValues.ConstsDAO.PRIVILEGE_DAO_KEY)
public interface IPrivilegeRepository extends JpaRepository<Privilege, Integer> {
	List<Privilege> findByRole(Role role);

	List<Privilege> findByUser(User user);
}
