package com.cmr.dev.business.service;

import com.cmr.dev.business.dto.PrivilegeBasicDTO;
import com.cmr.dev.business.dto.PrivilegeFullDTO;
import com.cmr.dev.business.entity.Privilege;
import com.cmr.dev.business.dao.IPrivilegeRepository;
 
public interface IPrivilegeService extends IAbstractSpb3Service<Privilege, PrivilegeBasicDTO, PrivilegeFullDTO, IPrivilegeRepository> {
}