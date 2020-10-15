package com.demo.bean.session;

import java.io.Serializable;

public class SessionUser implements Serializable {

    private String username;

    private Boolean enabled;

    public SessionUser() {
    }

    public SessionUser(String username) {
        this(username,true);
    }

    public SessionUser(String username, Boolean enabled) {
        this.username = username;
        this.enabled = enabled;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }
}
