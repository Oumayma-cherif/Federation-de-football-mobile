/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.myapp.gui;

import com.codename1.components.FloatingHint;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.Resources;
import com.mycompany.myapp.entities.joueur;
import com.mycompany.myapp.services.servicejoueur;

/**
 *
 * @author oumaymacherif
 */
public class updateJoueur extends Form {

    Form previous;

    public updateJoueur(joueur ev) {
        super("Newsfeed", BoxLayout.y());

        setTitle("Modifier Votre joueur");

        TextField Description = new TextField(ev.getNom(), "nomc", 20, TextField.ANY);
        Description.setUIID("TextFieldBlack");

        TextField Image = new TextField(ev.getposte(), "descr", 20, TextField.ANY);
        Image.setUIID("TextFieldBlack");

        

        Button btnModifier = new Button("Modifier");
        btnModifier.setUIID("Button");

        //OnClick Button
        btnModifier.addPointerPressedListener(l -> {

            ev.setNom(Description.getText());
            ev.setposte(Image.getText());
           

            //Appel a la methode UPDATE
            if (servicejoueur.getInstance().modifierJoueur(ev)) {
                //If True
                // new Listclub(res).show();

            }
        });

        Label l2 = new Label("");
        Label l3 = new Label("");
        Label l4 = new Label("");
        Label l5 = new Label("");

        Label l1 = new Label();

        Container content = BoxLayout.encloseY(
                l1, l2,
             
                
                new FloatingHint(Description),
                new FloatingHint(Image),
                btnModifier
             
        );

        add(content);
        show();

    }

}
