package com.cmr.dev.business.dto;

import java.util.Date;

public class PrivilegeBasicDTO implements IDTO {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
    private Date creationDate;
    private Date updateDate;


    public PrivilegeBasicDTO() {
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }


}
