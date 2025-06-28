package unl.edu.cc.jbrews.jakarta.controller;

import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;

import java.util.logging.Logger;

@Named
@RequestScoped
public class AuthenticationBean implements java.io.Serializable{

    private static Logger logger= Logger.getLogger(AuthenticationBean.class.getName());
    private String username;
    private String password;

    public String login(){
        logger.info("Logging in with username: "+username);
        logger.info("Logging in with password: "+ password);
        return "jbrews?faces-redirect=true";
    }

    public String register(){
        logger.info("Registering with username: "+username);
        logger.info("Registering with password: "+ password);
        FacesMessage fc=new FacesMessage("Registered Successfully");
        FacesContext.getCurrentInstance().addMessage(null,fc);
        fc.rendered();
        return "/login.xhtml?faces-redirect=true";
    }

    public String logout(){
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        FacesMessage fc=new FacesMessage("Logged out Succesfully");
        FacesContext.getCurrentInstance().addMessage(null,fc);
        fc.rendered();
        return "/login.xhtml?faces-redirect=true";
    }

    public static void setLogger(Logger logger) {
        AuthenticationBean.logger = logger;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
