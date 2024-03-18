package com.cmr.dev.business.service.impl;

import java.nio.file.AccessDeniedException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.data.jpa.repository.JpaRepository;

import com.cmr.dev.business.dto.IDTO;
import com.cmr.dev.business.entity.IEntity;
import com.cmr.dev.business.exception.Spb3BusinessException;
import com.cmr.dev.business.service.IAbstractSpb3Service;

import jakarta.annotation.Resource;

public abstract class AbstractSpb3ServiceImpl<Entity extends IEntity, BasicDTO extends IDTO, FullDTO extends BasicDTO, IEntityDAO extends JpaRepository<Entity, Integer>> implements IAbstractSpb3Service<Entity, BasicDTO, FullDTO, IEntityDAO> {
    private final Class<Entity> entityClass;
    private final Class<BasicDTO> basicClass;
    private final Class<FullDTO> fullClass;
    @Resource(name = "spb3-modelmapper")
    private ModelMapper mapper;

    public AbstractSpb3ServiceImpl(Class<Entity> myEntityClass, Class<BasicDTO> basicClass, Class<FullDTO> fullViewClass) {
        this.entityClass = myEntityClass;
        this.basicClass = basicClass;
        this.fullClass = fullViewClass;
    }

    public FullDTO create(FullDTO view) throws Spb3BusinessException {
        view.setCreationDate(new Date());
        Entity entity = this.getDAO().saveAndFlush(this.getModelMapper().map(view, this.entityClass));
        view.setId(entity.getId());
        return view;
    }

    public FullDTO update(FullDTO viewToUpdate) throws Spb3BusinessException, AccessDeniedException {
        viewToUpdate.setUpdateDate(new Date());
        Entity entity = this.getDAO().findById(viewToUpdate.getId()).orElse(null);
        if (entity != null) {
            BeanUtils.copyProperties(viewToUpdate, entity);
            this.getDAO().saveAndFlush(entity);
        } else {
            throw new Spb3BusinessException("L'objet à modifier N'existe pas en Base...");
        }
        return viewToUpdate;
    }

    public void deleteById(int id) throws Spb3BusinessException, AccessDeniedException {
        this.getDAO().deleteById(id);
    }

    public List<BasicDTO> findAll() {
        List<Entity> list = this.getDAO().findAll();
        List<BasicDTO> viewList = new ArrayList<BasicDTO>();
        for (Entity ent : list) {
            BasicDTO view = this.getModelMapper().map(ent, this.basicClass);
            viewList.add(view);
        }
        return viewList;
    }
    
    public List<FullDTO> findAllByFull() {
        List<Entity> list = this.getDAO().findAll();
        List<FullDTO> viewList = new ArrayList<FullDTO>();
        for (Entity ent : list) {
            FullDTO view = this.getModelMapper().map(ent, this.fullClass);
            viewList.add(view);
        }
        return viewList;
    }

    public FullDTO findById(int id) throws Spb3BusinessException {
        Entity ent = this.getDAO().findById(id).orElse(null);
        if (ent == null) {
            return null;
        }
        return this.getModelMapper().map(ent, this.fullClass);
    }

    public boolean ifEntityExistById(int id) throws Spb3BusinessException {
        return this.getDAO().existsById(id);
    }

    public <T extends BasicDTO> T findById(int id, Class<T> type) {
        Entity ent = this.getDAO().findById(id).orElse(null);
        if (ent != null) {
            return this.getModelMapper().map(ent, type);
        }
        return null;
    }

    public abstract IEntityDAO getDAO();

    public ModelMapper getModelMapper() {
        return this.mapper;
    }

}
