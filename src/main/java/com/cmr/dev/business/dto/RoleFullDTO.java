package com.cmr.dev.business.dto;

import java.util.List;

public class RoleFullDTO extends RoleMediumDTO {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public RoleFullDTO() {

    }

    private List<PrivilegeBasicDTO> privileges;

    public List<PrivilegeBasicDTO> getPrivileges() {
        return privileges;
    }

    public void setPrivileges(List<PrivilegeBasicDTO> privileges) {
        this.privileges = privileges;
    }
}