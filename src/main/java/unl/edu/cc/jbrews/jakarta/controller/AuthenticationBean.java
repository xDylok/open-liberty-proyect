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

    public String logout(){
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        FacesMessage fc=new FacesMessage("Logged out Succesfully");
        FacesContext.getCurrentInstance().addMessage(null,fc);
        fc.rendered();
        return "/login.xhtml?faces-redirect=true";
    }

    public String recuperarContrasena() {
        if (username == null || username.trim().isEmpty()) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Debe ingresar su nombre de usuario.");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            return null;
        }

        // Simular envío de correo de recuperación
        logger.info("Solicitud de recuperación de contraseña para el usuario: " + username);

        // Aquí podrías validar si el usuario existe en la base de datos y luego enviar el correo

        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Éxito",
                "Se ha enviado un enlace de recuperación al correo asociado al usuario.");
        FacesContext.getCurrentInstance().addMessage(null, msg);

        return null; // No redireccionamos, solo mostramos el mensaje
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
