package com.web.onlineLibrary.domain;

public class Role {

    private Integer id;
    private String roleName;
    private String roleMsg;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleMsg() {
        return roleMsg;
    }

    public void setRoleMsg(String roleMsg) {
        this.roleMsg = roleMsg;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", roleName='" + roleName + '\'' +
                ", roleMsg='" + roleMsg + '\'' +
                '}';
    }
}
