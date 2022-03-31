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
import com.codename1.ui.util.Resources;
/**
 *
 * @author bhk
 */
public class HomeForm extends Form{
Form current;
   Resources res ;
    public HomeForm() {
     
           current=this; //Back 
        setTitle("Home");
        setLayout(BoxLayout.y());
        
        add(new Label("Choose an option"));
        Button btnAddTask = new Button("Add Arbitre");
        Button btnListTasks = new Button("List Arbitre front");
        Button btnListTasks20 = new Button("List Arbitre back");
        Button btnListTasks1 = new Button("Add Stade");
        Button btnListTasks2 = new Button("List Stade front");
        Button btnListTasks21 = new Button("List Stade back");
        Button btnListTasks3 = new Button("Statistique");
        Button btnListTasks4 = new Button("My Position");
         Button btnListTasks5 = new Button("List Game front");
         Button btnListTasks22 = new Button("List Game back");
         Button btnListTasks6 = new Button("Add Game");
        
        
        btnAddTask.addActionListener(e-> new AjoutArbitre(current).show());
        btnListTasks.addActionListener(e-> new ListTaskArbitre(current).show());
        btnListTasks20.addActionListener(e-> new ListTaskArbitreF(current).show());
        btnListTasks1.addActionListener(e-> new AjoutStade(current).show());
        btnListTasks2.addActionListener(e-> new ListTaskStade(current).show());
        btnListTasks21.addActionListener(e-> new ListTaskStadeF(current).show());
        btnListTasks3.addActionListener(e-> new StatistiquePieForm().createPieChartForm().show());
        btnListTasks4.addActionListener(e-> new MapForm());
        btnListTasks5.addActionListener(e-> new ListTaskGame(current).show());
         btnListTasks22.addActionListener(e-> new ListTaskGameF(current).show());
         btnListTasks6.addActionListener(e-> new AjoutGame(current).show());
       
        addAll(btnAddTask,btnListTasks,btnListTasks1,btnListTasks2,btnListTasks3,btnListTasks4,btnListTasks5,btnListTasks6,btnListTasks20,btnListTasks21,btnListTasks22);
        
        
    }
    
    
}
