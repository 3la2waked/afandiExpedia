package com.expedia.beans;

/**
 * Represents logged in user info
 *
 * @author Alaa Fandi waked75@gmail.com
 */
public class UserInfo {

    private Persona persona;
    private String userId;

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
