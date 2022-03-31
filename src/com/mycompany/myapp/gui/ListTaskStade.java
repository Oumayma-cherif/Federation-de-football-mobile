/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui;

import com.codename1.components.ImageViewer;
import com.codename1.components.SpanLabel;
import com.codename1.components.ToastBar;
import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.URLImage;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.Resources;
import com.mycompany.myapp.entities.Stade;
import com.mycompany.myapp.services.ServiceStade;
import java.util.ArrayList;
 
/**
 *
 * @author Ahmed.A.Hsouna
 */
public class ListTaskStade extends Form{
    
    Form current;
    Resources res;
       String url = "http://localhost/Federation-de-football/public/uploads";
    
        public ListTaskStade(Form previous) {
        
        
     /*   setTitle("List Stade");
         setLayout(BoxLayout.y());
        SpanLabel sp = new SpanLabel();
        /*ArrayList<Arbitre> list;
        list = new ArrayList<>();
        list = ServiceArbitre.getInstance().getAll(); */
    /*    ServiceStade es = new ServiceStade();
                ArrayList<Stade> list = es.getAll() ;
        for (Stade ev : list) {
            
             Container c3 = new Container(BoxLayout.y());
             
            SpanLabel sp0 = new SpanLabel("id: " + "  " + ev.getId());
            SpanLabel spl = new SpanLabel("Stade name: " + "  " + ev.getNoms());
            SpanLabel sp7 = new SpanLabel("nombre de capacité: " + "  " + ev.getNbrP());
            SpanLabel sp9 = new SpanLabel("Lieu: " + "  " + ev.getLieu());
            SpanLabel sp10 = new SpanLabel("Etat: " + "  " + ev.getEtat());
           // SpanLabel sp6 = new SpanLabel("image: " + "  " + ev.getPhoto());

           Image placeholder = Image.createImage(500,500);
            EncodedImage enc = EncodedImage.createFromImage(placeholder, false);
            URLImage urlim = URLImage.createToStorage(enc, ev.getPhoto(), url + "/" +ev.getPhoto());
            ImageViewer imgV = new ImageViewer();
            imgV.setImage(urlim);
            
            
            
        //    addAll(sp0, spl, sp7, sp9, sp10, sp6);
                        c3.add(sp0);
                        c3.add(spl);
                        c3.add(sp7);
                        c3.add(sp9);
                        c3.add(sp10);
                        c3.add(imgV);
                           Button Delete =new Button("Delete");
         c3.add(Delete);
            Delete.getAllStyles().setBgColor(0xF36B08);
            Delete.addActionListener(e -> {
               Dialog alert = new Dialog("Attention");
                SpanLabel message = new SpanLabel("Etes-vous sur de vouloir supprimer cet événement?\nCette action est irréversible!");
                alert.add(message);
                Button ok = new Button("Confirmer");
                Button cancel = new Button(new Command("Annuler"));
                //User clicks on ok to delete account
                ok.addActionListener(new ActionListener() {
                  
                    public void actionPerformed(ActionEvent evt) {
                       es.Delete((int) ev.getId());
                     alert.dispose();
                         ToastBar.Status status = ToastBar.getInstance().createStatus();
                    status.setShowProgressIndicator(true);
//   status.setIcon(res.getImage("").scaledSmallerRatio(Display.getInstance().getDisplayWidth()/10, Display.getInstance().getDisplayWidth()/15));
                              status.setMessage("STADE SUPPRIME AVEC SUCCES");
                                                  status.setExpires(10000);   
                      status.show();
                  
                     
                    
                    
              
                      
                        refreshTheme();
                    }
                    
                }
                
                
                );

                alert.add(cancel);
                alert.add(ok);
                alert.showDialog();
                
                //new ListArticle(previous).show();
              
                
             
            });
            
   
             Button modifier =new Button("Modifier");
         c3.add(modifier);
            modifier.getAllStyles().setBgColor(0xF36B08);
            modifier.addPointerPressedListener((ActionEvent l)->{
               new ModifierStade(ev).show();
            });
                       
                        
           System.out.println("");
              
  add(c3);
        } */
    
     setTitle("List Stade");
      Container c1 = new Container(BoxLayout.y());
        
         ArrayList<Stade> list;
        list = new ArrayList<>();
        //ArrayList<Tournoi>    k = new ArrayList<>();
        list = ServiceStade.getInstance().getAll();

        // k = ServiceTournoi.getInstance().getAll();
        for (Stade ev : list) {
           
            
             Container club1_c = new Container(BoxLayout.y());
            Container clubm = new Container(BoxLayout.x());
             Image placeholder = Image.createImage(500,500);
            EncodedImage enc = EncodedImage.createFromImage(placeholder, false);
            URLImage urlim = URLImage.createToStorage(enc, ev.getPhoto(), url + "/" +ev.getPhoto());
            ImageViewer imgV = new ImageViewer();
            imgV.setImage(urlim);
            
            SpanLabel sp13 = new SpanLabel("   ");
            SpanLabel spl = new SpanLabel("Stade name: " + "  " + ev.getNoms());
            SpanLabel sp7 = new SpanLabel("nombre de capacité: " + "  " + ev.getNbrP());
            SpanLabel sp9 = new SpanLabel("Lieu: " + "  " + ev.getLieu());
            SpanLabel sp10 = new SpanLabel("Etat: " + "  " + ev.getEtat());
            SpanLabel sp1l = new SpanLabel("   ");
                
                
                
              clubm.add(imgV);
             
              club1_c.add(sp13).add(spl).add(sp7).add(sp9).add(sp10).add(sp1l);
           clubm.add(club1_c);
              
               
            /*  Button btnView = new Button();
              btnView.addActionListener(e-> {
                  new HomeForm().show();
              });
                SpanLabel sp12 = new SpanLabel("   "); 
              club1_c.setLeadComponent(btnView); */
             c1.add(clubm);
        }
        this.add(c1);
        getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e -> new HomeForm().show());
    }
    
}
