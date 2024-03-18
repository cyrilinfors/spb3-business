package com.cmr.dev.business.service.impl;
 
import jakarta.annotation.Resource;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;
import com.cmr.dev.business.dao.IPrivilegeRepository;
import com.cmr.dev.business.dao.IRoleRepository;
import com.cmr.dev.business.dao.IUserRepository;
import com.cmr.dev.business.dto.UserBasicDTO;
import com.cmr.dev.business.dto.UserFullDTO;
import com.cmr.dev.business.dto.UserRegistrationDTO;
import com.cmr.dev.business.dto.UserRegistrationResponseDTO;
import com.cmr.dev.business.entity.User;
import com.cmr.dev.business.exception.Spb3BusinessException;
import com.cmr.dev.business.service.IUserService;
import com.cmr.dev.business.utils.ConstBusinessRules;
import com.cmr.dev.business.utils.ConstsValues;
 import com.cmr.dev.business.utils.ReglesGestion;
import com.cmr.dev.business.entity.Privilege;
import com.cmr.dev.business.entity.Role;

@Service(ConstsValues.ServiceKeys.USER_SERVICE_KEY)
public class UserServiceImpl extends AbstractSpb3ServiceImpl<User, UserBasicDTO, UserFullDTO, IUserRepository> implements  IUserService, UserDetailsService {
	@Resource(name = ConstsValues.ConstsDAO.USER_DAO_KEY)
    private IUserRepository userRepository;

    

    @Resource(name = ConstsValues.ConstsDAO.ROLE_DAO_KEY)
    private IRoleRepository roleRepository;

    @Resource(name = ConstsValues.ConstsDAO.PRIVILEGE_DAO_KEY)
    private IPrivilegeRepository privilegeRepository;

    @Resource(name = "BCRYPT_ENCODER")
    private BCryptPasswordEncoder passwordEncoder;

    public UserServiceImpl() {
        super(User.class, UserBasicDTO.class, UserFullDTO.class);

    }

    @Override
    public IUserRepository getDAO() {
        return this.userRepository;
    }

    @Override
    public boolean isExistUserByEmail(String email) {
        return this.findAll().stream().anyMatch(u -> email.equals(u.getEmail()));
    }

    @Override
    public boolean isExistUserByEmail(String email, Integer id) {
        return this.findAll().stream().anyMatch(u -> email.equals(u.getEmail()) && !id.equals(u.getId()));
    }

    @Override
    public UserFullDTO findUserByEmail(String email) {
       Optional<User> user = this.getDAO().findUserByEmail(email);
        if (user.isPresent()) {
            return getModelMapper().map(user, UserFullDTO.class);
        }
        return null;
    }

    @Override
    public UserDetails loadUserByUsername(String username)    {
      Optional<User> userDetail = userRepository.findUserByEmail(username);
        return userDetail.orElseThrow(() -> new UsernameNotFoundException("User not found " + username));
    }

    @Override
    public UserRegistrationResponseDTO registerUser(UserRegistrationDTO dto) throws Spb3BusinessException  {
        User user = new User();

        if (isExistUserByEmail(dto.getEmail())) {
            throw new Spb3BusinessException(ConstBusinessRules.RG02);
        }

        Role role = roleRepository.findByRoleName(dto.getRoleName());

       
        user = this.getModelMapper().map(dto, User.class);
        user.setCreationDate(new Date());
        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        user = userRepository.save(user);

        Privilege privilege = new Privilege();
        privilege.setUser(user);
        privilege.setRole(role);
        privilege.setCreationDate(new Date());

        privilegeRepository.save(privilege);

        return new UserRegistrationResponseDTO(user.getId(), user.getEmail());
    }  }  
