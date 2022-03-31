/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.services;


import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import com.mycompany.myapp.entities.club;


import com.mycompany.myapp.utils.Statics;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/**
 *
 * @author oumayma cherif
 */
public class serviceclub {
    
  public ArrayList<club> clubb;
    
    public static serviceclub instance=null;
    public boolean resultOK;
    private ConnectionRequest req;

    public serviceclub() {
         req = new ConnectionRequest();
    }

    public static serviceclub getInstance() {
        if (instance == null) {
            instance = new serviceclub();
        }
        return instance;
    }



    public ArrayList<club> parseCat(String jsonText){
        try {
            clubb =new ArrayList<>();
            JSONParser j = new JSONParser();// Instanciation d'un objet JSONParser permettant le parsing du résultat json

          
            Map<String,Object> clubListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
       
            List<Map<String,Object>> list = (List<Map<String,Object>>)clubListJson.get("root");
            
            //Parcourir la liste des tâches Json
            for(Map<String,Object> obj : list){
                //Création des tâches et récupération de leurs données
               
               
                     club e = new club();
                    
                     try {
                float id = Float.parseFloat(obj.get("id").toString());
                
                
                      e.setId((int)id);
                     } 
                     catch (Exception e1) {
                    System.out.println("houni1");
        }
                      
                      try {
                      e.setNom(obj.get("nomc").toString());
                      } catch (Exception e2) {
                    System.out.println("houni2");
        }
                     
                      try {
                      e.setDescr(obj.get("descr").toString());
                      } catch (Exception e4) {
                    System.out.println("houni4");
        }
                      try {
                      e.setpresident(obj.get("president").toString());
                      } catch (Exception e5) {
                    System.out.println("houni5");
        }
                      try {
                      e.setLogo(obj.get("logo").toString());
                      } catch (Exception e5) {
                    System.out.println("houni5");
        }
                       
                
             try {
                clubb.add(e);
                } catch (Exception e6) {
                    System.out.println("houni6");
        }
            }
            
            
        } catch (IOException ex) {
            
        }
         /*
            A ce niveau on a pu récupérer une liste des tâches à partir
        de la base de données à travers un service web
        
        */
        return clubb ;
    }
     public List<String>fillintot()
    {
        List<String> tournoiss = new ArrayList<String>();
        clubb = getAllclub();
        for(club tr:clubb)
        {
            tournoiss.add(tr.getNomc());
          //  tournoiss.add("");
        }
     
      //  System.out.println(tournoiss);
        return tournoiss;
    }
     
     
      //  System.out.println(tournoiss);
        
    public ArrayList<club> getAllclub(){
         String url = Statics.BASE_URL + "/viewc";
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                clubb = parseCat(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return clubb;
    }
    
   
    public boolean  Delete(int id){
       String url = Statics.BASE_URL + "/SuppCl/" +id;

        req.setUrl(url);

        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
               
                req.removeResponseListener(this);
            }

        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return resultOK;
      
      
      }
    
    
}
