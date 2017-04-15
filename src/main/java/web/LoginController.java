/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;

@Named
@RequestScoped
public class LoginController extends BaseController {

    private static final Logger LOG = Logger.getLogger(LoginController.class.getName());
    @NotNull(message = "Enter username")
    private String username;
    @NotNull(message = "Enter password")
    private String password;

    public LoginController() {
    }

    @PostConstruct
    protected void postConstruct() {
        super.postConstruct();

    }

    public String doLogin() {
        try {
            HttpServletRequest req = (HttpServletRequest) context.getExternalContext().getRequest();
            req.login(username, password);
        } catch (ServletException ex) {
            LOG.warning("User unable to login: " + username);
            LOG.warning("User unable to login: " + password);
            LOG.log(Level.SEVERE, null, ex);
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Incorrect username/password combination", "Incorrect username/password combination"));
            return "/login.xhtml";
        }

        return conditionalizeContextPath("welcome.xhtml");
    }

    protected String conditionalizeContextPath(String intent) {
        if (isPlayers()) {
            return "/players/" + intent;
        } else if (isManager()) {
            return "/manager/" + intent;
        } else {
            return intent;
        }
    }

    public boolean isPlayers() {
        return context.getExternalContext().isUserInRole("players");
    }

    public boolean isManager() {
        return context.getExternalContext().isUserInRole("manager");
    }

    public String doLogout() {
        try {
            HttpServletRequest req = (HttpServletRequest) context.getExternalContext().getRequest();
            req.logout();
        } catch (ServletException ex) {
            LOG.log(Level.SEVERE, null, ex);
            LOG.warning("Problem with the logout occurred");
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Bad Logout Summary", "Error in logging out"));
        }
        return "/login.xhtml";
    }

    public String getRemoteUser() {
        return context.getExternalContext().getRemoteUser();
    }

    /**
     * Get the value of username
     *
     * @return the value of username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Set the value of username
     *
     * @param username new value of username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Get the value of password
     *
     * @return the value of password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Set the value of password
     *
     * @param password new value of password
     */
    public void setPassword(String password) {
        this.password = password;
    }

}
