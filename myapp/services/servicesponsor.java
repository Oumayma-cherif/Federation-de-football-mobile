/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.services;

import com.codename1.components.ImageViewer;

import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import com.mycompany.myapp.entities.club;
import com.mycompany.myapp.entities.joueur;
import com.mycompany.myapp.entities.sponsor;

import com.mycompany.myapp.utils.Statics;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author oumayma cherif
 */
public class servicesponsor {

    public ArrayList<sponsor> sponsor;

    public static servicesponsor instance = null;
    public boolean resultOK;
    private ConnectionRequest req;

    public servicesponsor() {
        req = new ConnectionRequest();
    }

    public static servicesponsor getInstance() {
        if (instance == null) {
            instance = new servicesponsor();
        }
        return instance;
    }


    public ArrayList<sponsor> parseCat(String jsonText) {
        try {
            sponsor = new ArrayList<>();
            JSONParser j = new JSONParser();// Instanciation d'un objet JSONParser permettant le parsing du résultat json

            
            Map<String, Object> sponsorListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));

            
            List<Map<String, Object>> list = (List<Map<String, Object>>) sponsorListJson.get("root");

            //Parcourir la liste des tâches Json
            for (Map<String, Object> obj : list) {
                //Création des tâches et récupération de leurs données

                sponsor e = new sponsor();

                try {
                    float id = Float.parseFloat(obj.get("id").toString());

                    e.setId((int) id);
                } catch (Exception e1) {
                    System.out.println("id");
                }

                try {
                    e.setnoms(obj.get("noms").toString());
                } catch (Exception e2) {
                    System.out.println("noms");
                }

                try {
                    e.setlogoS(obj.get("logoS").toString());
                } catch (Exception e4) {
                    System.out.println("logoS");
                }

                try {
                    sponsor.add(e);
                } catch (Exception e6) {
                    System.out.println("sponsor");
                }
            }

        } catch (IOException ex) {

        }
       
        return sponsor;
    }

    public ArrayList<sponsor> getAllsponsor() {
        String url = Statics.BASE_URL + "/viewsponsor";
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                sponsor = parseCat(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return sponsor;
    }

    public boolean Delete(int id) {
        String url = Statics.BASE_URL + "/deletesponsor?id=" + id;

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

    public void addSponsor(sponsor c) {
        String url = Statics.BASE_URL + "/addsponsor?nomS=" + c.getnomS() + "&logoS=" + c.getlogoS();

        req.setUrl(url);
        req.addResponseListener((e) -> {

            String str = new String(req.getResponseData());
            System.out.println("data == " + str);

        });

        NetworkManager.getInstance().addToQueueAndWait(req);
    }

    public boolean modifierSponsor(sponsor event) {

        String url = Statics.BASE_URL + "/updateSponsor/" + event.getId() + "?nomS=" + event.getnomS()  + "&logo=" + event.getlogoS() ;
        req.setUrl(url);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOK = req.getResponseCode() == 200;
                req.removeResponseListener(this);
            }

        });

        NetworkManager.getInstance().addToQueueAndWait(req);
        return resultOK;

    }

}
