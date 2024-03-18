package com.cmr.dev.business.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class UserFullDTO extends UserMediumDTO {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserFullDTO() {
    }

    @JsonIgnore
    private List<PrivilegeFullDTO> privileges;

    public List<PrivilegeFullDTO> getPrivileges() {
        return privileges;
    }

    public void setPrivileges(List<PrivilegeFullDTO> privileges) {
        this.privileges = privileges;
    }
}