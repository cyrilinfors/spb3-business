package com.cmr.dev.business.service;

import com.cmr.dev.business.dao.IRoleRepository;
import com.cmr.dev.business.dto.RoleBasicDTO;
import com.cmr.dev.business.dto.RoleFullDTO;
import com.cmr.dev.business.entity.Role;

 

public interface IRoleService extends IAbstractSpb3Service<Role, RoleBasicDTO, RoleFullDTO, IRoleRepository> {
}