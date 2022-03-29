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

//    public boolean addCat(Evenement t) {
//            String url = Statics.BASE_URL + "/addjs/new?type="+ t.getType();
//        req.setUrl(url);// Insertion de l'URL de notre demande de connexion
//        req.addResponseListener(new ActionListener<NetworkEvent>() {
//            @Override
//            public void actionPerformed(NetworkEvent evt) {
//                resultOK = req.getResponseCode() == 200; //Code HTTP 200 OK
//                req.removeResponseListener(this); //Supprimer cet actionListener
//                /* une fois que nous avons terminé de l'utiliser.
//                La ConnectionRequest req est unique pour tous les appels de 
//                n'importe quelle méthode du Service task, donc si on ne supprime
//                pas l'ActionListener il sera enregistré et donc éxécuté même si 
//                la réponse reçue correspond à une autre URL(get par exemple)*/
//                
//            }
//        });
//        NetworkManager.getInstance().addToQueueAndWait(req);
//        return resultOK;
//    }
    public ArrayList<sponsor> parseCat(String jsonText) {
        try {
            sponsor = new ArrayList<>();
            JSONParser j = new JSONParser();// Instanciation d'un objet JSONParser permettant le parsing du résultat json

            /*
                On doit convertir notre réponse texte en CharArray à fin de
            permettre au JSONParser de la lire et la manipuler d'ou vient 
            l'utilité de new CharArrayReader(json.toCharArray())
            
            La méthode parse json retourne une MAP<String,Object> ou String est 
            la clé principale de notre résultat.
            Dans notre cas la clé principale n'est pas définie cela ne veux pas
            dire qu'elle est manquante mais plutôt gardée à la valeur par defaut
            qui est root.
            En fait c'est la clé de l'objet qui englobe la totalité des objets 
                    c'est la clé définissant le tableau de tâches.
             */
            Map<String, Object> sponsorListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));

            /* Ici on récupère l'objet contenant notre liste dans une liste 
            d'objets json List<MAP<String,Object>> ou chaque Map est une tâche.               
            
            Le format Json impose que l'objet soit définit sous forme
            de clé valeur avec la valeur elle même peut être un objet Json.
            Pour cela on utilise la structure Map comme elle est la structure la
            plus adéquate en Java pour stocker des couples Key/Value.
            
            Pour le cas d'un tableau (Json Array) contenant plusieurs objets
            sa valeur est une liste d'objets Json, donc une liste de Map
             */
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
        /*
            A ce niveau on a pu récupérer une liste des tâches à partir
        de la base de données à travers un service web
        
         */
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
 public void ajoutsponsor (sponsor r) {
        ConnectionRequest con = new ConnectionRequest();
        String url = Statics.BASE_URL + "/addsponsor?nomS=" + r.getnomS() + "&logoS=" + r.getlogoS() ;

        System.out.println("tt");

        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());
            System.out.println(str);
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
    }
 
 
 


}
