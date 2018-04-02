package com.tfar.beans;

import com.tfar.entity.User;
import com.tfar.services.UserService;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 *
 * @author TFAR
 */
@ManagedBean(name = "loginBean")
public class LoginBean implements Serializable {



    @ManagedProperty(value = "#{UserService}")
    private UserService userService;

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }
    @ManagedProperty("#{code}")
    private int iduser;
    @ManagedProperty("#{nom}")
    private String username;
    private String login;
    private String password;   
    private User currentUser;
    @ManagedProperty(value="#{authenticationManager}")
    protected AuthenticationManager authenticationManager;



    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public Authentication authenticate() throws AuthenticationException {
        String username = this.getLogin();
        String password = this.getPassword();
        System.out.println("username : " + username);
        currentUser = userService.getUserParLogin(username);
 
        if (currentUser == null) {
            throw new BadCredentialsException("Username not found.");
        }
 
        if (!password.equals(currentUser.getPasswd())) {
            throw new BadCredentialsException("Wrong password.");
        }
 
        Role role = new Role();
        role.setName("ROLE_ADMIN");
        List<Role> authority = new ArrayList<Role>();
        authority.add(role);        
        Collection<? extends GrantedAuthority> authorities = authority;
 
        return new UsernamePasswordAuthenticationToken(currentUser, password, authorities); 

    } 
    
    public void login() throws IOException {
        System.out.println("Credentials : Test : "+ this.getLogin());
     //   List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
//authorities.add(new GrantedAuthorityImpl("ROLE_ADMIN"));
        //Authentication request = this.authenticate();
                Role role = new Role();
        role.setName("ROLE_ADMIN");
        List<Role> authority = new ArrayList<Role>();
        authority.add(role);        
        Collection<? extends GrantedAuthority> authorities = authority;
                
        Authentication request = new UsernamePasswordAuthenticationToken(this.getLogin(), this.getPassword(), authorities);

                
                
        System.out.println("Login --- Hatem (0) is authenticated : " + request.isAuthenticated());
        System.out.println("Login --- Hatem (1): " + request.toString() + "Password : " +  this.getPassword());
        
        System.out.println("Login --- Hatem (2) Authorities : " + request.getAuthorities().toString());        
        System.out.println("Login --- Hatem (3) Authorities : " + request.getCredentials().toString()); 
        //Authentication result = authenticationManager.authenticate(request);
        System.out.println("Login --- Hatem : " + this.getLogin());
        SecurityContextHolder.getContext().setAuthentication(request);
        currentUser = userService.getUserParLogin(this.getLogin());
        iduser=currentUser.getCode();
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("iduser", iduser);
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("username", currentUser.getNom()+" "+currentUser.getPrenom());
        FacesContext.getCurrentInstance().getExternalContext().redirect("ListeFiches.jsf");
System.out.println("Credentials : Test : ok");
    }
    
    
    public void logout() throws IOException {
        
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        FacesContext.getCurrentInstance().getExternalContext().redirect("index.jsf");
    }




    /**
     * @return the authenticationManager
     */
    public AuthenticationManager getAuthenticationManager() {
        return authenticationManager;
    }

    /**
     * @param authenticationManager the authenticationManager to set
     */
    public void setAuthenticationManager(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }



    /**
     * @return the iduser
     */
    public int getIduser() {
        return iduser;
    }

    /**
     * @param iduser the iduser to set
     */
    public void setIduser(int iduser) {
        this.iduser = iduser;
    }




    /**
     * @return the login
     */
    public String getLogin() {
        return login;
    }

    /**
     * @param login the login to set
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }
    
/*
    
           <user-service>
        <user name="sondes" password="hdiji" authorities="ROLE_USER, ROLE_ADMIN" />
        <user name="bob" password="bobspassword" authorities="ROLE_USER" />
      </user-service>
    
    
    
    
    
                <jdbc-user-service data-source-ref="dataSource"
                               users-by-username-query="SELECT Login , Passwd, TypeUser as ROLE  FROM User where Login=?"
                               authorities-by-username-query="SELECT Login, TypeUser as ROLE FROM User WHERE Login=?"
            />
    */


}



class Role implements GrantedAuthority {
 
    private static final long serialVersionUID = 1L;
    private String name;
 

 
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
 
    @Override
    public String getAuthority() {
        return this.name;
    }


}