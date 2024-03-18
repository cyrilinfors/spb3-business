package com.cmr.dev.business.dto;

public class PrivilegeMediumDTO extends PrivilegeBasicDTO {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private UserBasicDTO user;
    private RoleBasicDTO role;


    public UserBasicDTO getUser() {
        return user;
    }

    public void setUser(UserBasicDTO user) {
        this.user = user;
    }


    public RoleBasicDTO getRole() {
        return role;
    }

    public void setRole(RoleBasicDTO role) {
        this.role = role;
    }
}

