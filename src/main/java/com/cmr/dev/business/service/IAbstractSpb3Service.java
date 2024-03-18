package com.cmr.dev.business.service;

import java.nio.file.AccessDeniedException;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cmr.dev.business.exception.Spb3BusinessException;

 
public interface IAbstractSpb3Service<Entity, BasicDTO, FullDTO extends BasicDTO, IEntityDAO extends JpaRepository<Entity, Integer>> {
	public FullDTO create(FullDTO ent) throws Spb3BusinessException;
	public FullDTO update(FullDTO entToUpdate) throws Spb3BusinessException, AccessDeniedException;
	public void deleteById(int id) throws Spb3BusinessException, AccessDeniedException;
	public List<BasicDTO> findAll();
	public List<FullDTO> findAllByFull();
	public FullDTO findById(int id) throws Spb3BusinessException;
	public boolean ifEntityExistById(int id) throws Spb3BusinessException;
	public <T extends BasicDTO> T findById(int id, Class<T> type) throws Spb3BusinessException;
	public IEntityDAO getDAO();
}
