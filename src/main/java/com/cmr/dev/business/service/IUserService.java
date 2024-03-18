package com.cmr.dev.business.service;


import org.springframework.security.core.userdetails.UserDetailsService;

import com.cmr.dev.business.dao.IUserRepository;
import com.cmr.dev.business.dto.UserBasicDTO;
import com.cmr.dev.business.dto.UserFullDTO;
import com.cmr.dev.business.dto.UserRegistrationDTO;
import com.cmr.dev.business.dto.UserRegistrationResponseDTO;
import com.cmr.dev.business.entity.User;
import com.cmr.dev.business.exception.Spb3BusinessException;

 
public interface IUserService extends IAbstractSpb3Service<User, UserBasicDTO, UserFullDTO, IUserRepository>, UserDetailsService {
    boolean isExistUserByEmail(String email);

    boolean isExistUserByEmail(String email, Integer id);
   


	UserFullDTO findUserByEmail(String email);

	UserRegistrationResponseDTO registerUser(UserRegistrationDTO dto) throws Spb3BusinessException; 
}