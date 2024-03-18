package com.cmr.dev.business.service.impl;

 
import org.springframework.stereotype.Service;

import com.cmr.dev.business.dao.IRoleRepository;
import com.cmr.dev.business.dto.RoleBasicDTO;
import com.cmr.dev.business.dto.RoleFullDTO;
import com.cmr.dev.business.entity.Role;
import com.cmr.dev.business.service.IRoleService;
import com.cmr.dev.business.utils.ConstsValues;

import jakarta.annotation.Resource;

@Service(ConstsValues.ServiceKeys.ROLE_SERVICE_KEY)
public class RoleServiceImpl extends AbstractSpb3ServiceImpl<Role, RoleBasicDTO, RoleFullDTO, IRoleRepository> implements IRoleService {


    @Resource(name = ConstsValues.ConstsDAO.ROLE_DAO_KEY)
    private IRoleRepository roleRepository;

    public RoleServiceImpl() {
        super(Role.class, RoleBasicDTO.class, RoleFullDTO.class);
    }

    @Override
    public IRoleRepository getDAO() {
        return this.roleRepository;
    }
}