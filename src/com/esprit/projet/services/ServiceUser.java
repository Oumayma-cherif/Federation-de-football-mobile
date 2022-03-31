/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.projet.services;

import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.MultipartRequest;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.Dialog;
import com.codename1.ui.events.ActionListener;
import com.esprit.projet.entities.User;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Rahmouni
 */
public class ServiceUser {
    private static User session;

    public static User getSession() {
        return session;
    }

    public static void setSession(User session) {
        ServiceUser.session = session;
    }
    
    
	private ConnectionRequest request;

    private boolean responseResult;
    public boolean resultOK;
    public ArrayList<User> users;
    public ArrayList<User> Users;
	User user = new User();
	
	public ServiceUser() {
        request = DataSource.getInstance().getRequest();
    }
	
	public User loginUser(User u)
	{
		
        request.setUrl(BaseService.BASE_URL+"/cnxMobileApp");
		
        request.setPost(false);
        request.addArgument("_mdp", u.getMdp());
	request.addArgument("_username", u.getUsername());
        request.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                user = getLogin(new String(request.getResponseData()));
                request.removeResponseListener(this);
            }
        });
		NetworkManager.getInstance().addToQueueAndWait(request);

                session = user;
		return user;
	}
	
	public User getLogin(String jsonText)  {
		User u = new User();
		u.setRole("null");
		if (jsonText.equals("null")) {
			return u;
		}
        try {
            JSONParser jp = new JSONParser();
            
           //String s = "["+jsonText+"]";
            Map<String, Object> ProjectListJson = jp.parseJSON(new CharArrayReader(find_(jsonText).toCharArray()));
            List<Map<String, Object>> list = (List<Map<String, Object>>) ProjectListJson.get("root");
            for (Map<String, Object> obj : list) {
                
                if(obj.get("id") != null) {
                    u.setId((int)Float.parseFloat(obj.get("id").toString()));
                } else {
                    u.setId(0);
                }
                
                if(obj.get("username") != null) {
                    u.setUsername(obj.get("username").toString()); 
                } else {
                    u.setUsername("");
                }
                
                if(obj.get("email") != null) {
                    u.setEmail(obj.get("email").toString()); 
                } else {
                    u.setEmail("");
                }
                
                if(obj.get("mdp") != null) {
                    u.setMdp(obj.get("mdp").toString()); 
                } else {
                    u.setMdp("");
                }
                
                if(obj.get("role") != null) {
                    u.setRole(obj.get("role").toString()); 
                } else {
                    u.setRole("");
                }
            }
			


        } catch (IOException ex) {
            
        }
        

        return u;
    }
	
	public String  find_(String a) {
            if(!a.substring(0,1).equals("[")) {
                a = "["+a+"]";
            }  
        return a;
        }
	
	
	
	
     
	public void signUp(User p) {            
            MultipartRequest cr = new MultipartRequest();
            cr.setUrl(BaseService.BASE_URL+"/UserRegisterMobileApp");
        cr.setPost(false);
            cr.addArgument("username", p.getUsername());
			cr.addArgument("email", p.getEmail());
			cr.addArgument("mdp", p.getMdp());

            cr.addResponseListener(e -> {
             

                if(cr.getResponseCode() == 200)
                    Dialog.show("Sign Up","User added " +  p.getUsername(), "OK",null);

         
            });
            NetworkManager.getInstance().addToQueueAndWait(cr);
            
        
    }

	
}
