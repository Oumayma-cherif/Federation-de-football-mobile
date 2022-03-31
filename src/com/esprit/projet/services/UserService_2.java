/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.projet.services;

import com.esprit.projet.entities.User_2;
import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Map;
import org.json.simple.JSONObject;
/**
 *
 * @author wassim
 */
public class UserService_2 extends BaseService{
    public static Boolean authenticate(String email, String password) {
        ConnectionRequest req = new ConnectionRequest(){
            protected void buildRequestBody(OutputStream os) throws IOException {
                JSONObject json = new JSONObject();
                json.put("email", email);
                json.put("password", password);
                os.write(json.toString().getBytes("UTF-8"));
            }
            @Override
            protected void handleErrorResponseCode(int code, String message) {
                System.out.println("dialog absent");
            }
        };

        req.setUrl(apiUrl + "login");
        req.setPost(true);
        req.setContentType("application/json");
        NetworkManager.getInstance().addToQueueAndWait(req);
        try {
            if (req.getResponseCode() != 200) {
                return false;
            }
            String str = new String(req.getResponseData());//Récupération de la réponse du serveur
            System.out.println(str);//Affichage de la réponse serveur sur la console
            req.setPost(true);
            JSONParser j = new JSONParser();
        
            Map<String, Object> obj = j.parseJSON(new CharArrayReader(str.toCharArray()));
            
            
            int id = (int)Float.parseFloat(obj.get("id").toString());
           // String email = obj.get("email").toString();
            String userUername = obj.get("username").toString();
            //String profilePictureUrl = obj.get("profile_picture").toString();
           // String profilePictureUrl = obj.get("email").toString()+"?size=200x200";
            String profilePictureUrl = email + "?size=200x200";

            User_2.setAuthenticatedUser(id, userUername, email, profilePictureUrl);
        } catch (IOException ex) {

        }
        return true;
    }
    
        public static ArrayList<User_2> getAllUsers() {
                ConnectionRequest req = new ConnectionRequest();
        User_2 connectedUser = User_2.getAuthenticatedUser();
        //req.setUrl(apiUrl + "all_user" + connectedUser.getId());
        req.setUrl(apiUrl + "all_user");
        System.out.println(req.getUrl());
        req.setPost(true);
        req.setContentType("application/json");
        NetworkManager.getInstance().addToQueueAndWait(req);
        try {
            if (req.getResponseCode() != 200) {
                return new ArrayList<User_2>(); 
            }
            String str = new String(req.getResponseData());//Récupération de la réponse du serveur
            System.out.println(str);//Affichage de la réponse serveur sur la console
            req.setPost(true);
            JSONParser j = new JSONParser();
            Map<String, Object> obj = j.parseJSON(new CharArrayReader(str.toCharArray()));
            ArrayList<Map<String, Object>> usersMapList = (ArrayList) obj.get("root");
            ArrayList<User_2> allThreadsUsers = new ArrayList<User_2>();
            for(Map<String, Object> userMap: usersMapList) {
                User_2 connectedUserWithMessage = new User_2(
                        (int)Float.parseFloat(userMap.get("id").toString()), 
                        userMap.get("username").toString(), 
                        userMap.get("email").toString(), 
                        //userMap.get("profile_picture").toString());
                        userMap.get("email").toString() + "?size=200x200"
                );
                allThreadsUsers.add(connectedUserWithMessage);
            }
            System.out.println(allThreadsUsers);
            return allThreadsUsers;
        } catch (IOException ex) {

        }
        return new ArrayList<User_2>();
    }
    
    public static String getProfilePictureUrl(User_2 user) {
        return imgUrl + user.getProfilePictureUrl();
    }
}