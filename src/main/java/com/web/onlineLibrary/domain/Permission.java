package com.web.onlineLibrary.domain;

public class Permission {
    private Integer id;
    private String power;
    private String roleId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    @Override
    public String toString() {
        return "Permission{" +
                "id=" + id +
                ", power='" + power + '\'' +
                ", roleId='" + roleId + '\'' +
                '}';
    }
}
