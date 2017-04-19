package com.lorelib.hawk.infrastructure.email;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class UserAuthenticator extends Authenticator {

    private String username;
    private String password;

    public UserAuthenticator() {

    }

    public UserAuthenticator(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    protected PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(this.username, this.password);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
