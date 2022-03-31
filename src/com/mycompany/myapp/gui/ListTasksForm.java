/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui;


import com.codename1.components.SpanLabel;
import com.codename1.ui.FontImage;


import com.codename1.ui.Form;
import com.mycompany.myapp.entities.Tournoi;


import com.mycompany.myapp.services.ServiceTournoi;
import java.util.ArrayList;



/**
 *
 * @author bhk
 */
public class ListTasksForm extends Form {


   

    public ListTasksForm(Form previous) {
        setTitle("List Tournois");
  SpanLabel sp = new SpanLabel();
         ArrayList<Tournoi> list;
        list = new ArrayList<>();
        list = ServiceTournoi.getInstance().getAll();
         for ( Tournoi ev : list) {
             SpanLabel sp0 = new SpanLabel("id: " + "  " + ev.getId());
              SpanLabel spl = new SpanLabel("Tournoi name: " + "  " + ev.getNomt());
                SpanLabel sp5 = new SpanLabel("date debut: " + "  " + ev.getDated());
                 SpanLabel sp8 = new SpanLabel("date fin: " + "  " + ev.getDatef());
                   SpanLabel sp7 = new SpanLabel("type: " + "  " + ev.getTypet());
                     SpanLabel sp9 = new SpanLabel("nombre: " + "  " + ev.getNbrc());
                  SpanLabel sp6 = new SpanLabel("logo: " + "  " + ev.getLogo());
                       
          addAll(sp0,spl,sp5,sp8,sp7,sp9,sp6);
         }
         getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e -> previous.showBack());
        }

}
