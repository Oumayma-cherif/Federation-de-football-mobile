/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui;

import com.codename1.ui.Button;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BoxLayout;
/**
 *
 * @author cherif
 */
public class HomeForm extends Form {

    Form current;
    /*Garder traçe de la Form en cours pour la passer en paramètres 
    aux interfaces suivantes pour pouvoir y revenir plus tard en utilisant
    la méthode showBack*/
    
    public HomeForm() {
        current = this; //Récupération de l'interface(Form) en cours
        setTitle("Home");
        setLayout(BoxLayout.y());

        add(new Label("Choisissez une option"));
        Button btnAddTask = new Button(" Clubs ");
        Button btnAddTask1 = new Button("joueurs ");

        Button btnAddTask2 = new Button("Sponsors ");
    
            

        btnAddTask.addActionListener(e -> new Listclub(current).show());

        btnAddTask1.addActionListener(e -> new Listjoueur(current).show());
        btnAddTask2.addActionListener(e -> new Listsponsor(current).show());


        //btnAddTask1.addActionListener(e -> new Stat().createPieChartForm().show());
       
        addAll(btnAddTask,btnAddTask1,btnAddTask2);

    }

}
