package com.cmr.dev.business.service.impl;

import org.springframework.stereotype.Service;

import com.cmr.dev.business.dao.IPrivilegeRepository;
import com.cmr.dev.business.dto.PrivilegeBasicDTO;
import com.cmr.dev.business.dto.PrivilegeFullDTO;
import com.cmr.dev.business.entity.Privilege;
import com.cmr.dev.business.service.IPrivilegeService;
import com.cmr.dev.business.utils.ConstsValues;

import jakarta.annotation.Resource;

@Service(ConstsValues.ServiceKeys.PRIVILEGE_SERVICE_KEY)
public class PrivilegeServiceImpl extends AbstractSpb3ServiceImpl<Privilege, PrivilegeBasicDTO, PrivilegeFullDTO, IPrivilegeRepository> implements IPrivilegeService {

    @Resource(name = ConstsValues.ConstsDAO.PRIVILEGE_DAO_KEY)
    private IPrivilegeRepository privilegeRepository;

    public PrivilegeServiceImpl() {
        super(Privilege.class, PrivilegeBasicDTO.class, PrivilegeFullDTO.class);
    }

    @Override
    public IPrivilegeRepository getDAO() {
        return this.privilegeRepository;
    }
}