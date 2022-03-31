/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui;

import com.codename1.io.Log;
import com.codename1.io.rest.Rest;
import com.codename1.l10n.SimpleDateFormat;
import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;

import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.mycompany.myapp.entities.Tournoi;
import com.mycompany.myapp.services.ServiceTournoi;
import java.util.Date;
/**
 *
 * @author oumayma
 */
public class AjoutTournoi extends Form {

    public AjoutTournoi(Form previous) {
    
    
     setTitle("Add a new tournoi");
        setLayout(BoxLayout.y());
        
        TextField tfName = new TextField("","name");
        TextField tfdated= new TextField("", "date: yy-mm-dd");
         TextField tfdatef= new TextField("", "date: yy-mm-dd");
          TextField type= new TextField("", "type");
         TextField nbrc= new TextField("", "nombre");
         TextField logo= new TextField("", "logo");
        Button btnValider = new Button("Add tournoi");
        
        btnValider.addActionListener(( e)-> {
            {  
                try {
                if ((tfName.getText().length()==0)||(tfdated.getText().length()==0)||(tfdatef.getText().length()==0)||(type.getText().length()==0)||(nbrc.getText().length()==0)||(logo.getText().length()==0))
                    Dialog.show("Alert", "Please fill all the fields", new Command("OK"));
                else
                {
                 
                        SimpleDateFormat format= new SimpleDateFormat("yyyy-MM-dd");
                        Tournoi t = new Tournoi( tfName.getText().toString(),tfdated.getText(),tfdatef.getText(),type.getText().toString(),Integer.parseInt(nbrc.getText()),logo.getText().toString());
                    if( ServiceTournoi.getInstance().addTournoi(t))
                    {
                           Dialog.show("Success","Connection accepted",new Command("OK"));
                        
                    }else{
                         Dialog.show("ERROR", "connn refuse", new Command("OK"));
                    }  
                    
                }
                } catch (NumberFormatException x) {
                        Dialog.show("ERROR", "Status must be a number", new Command("OK"));
                    }
                    
                
            }
        });
        
        
        addAll(tfName,tfdated,tfdatef,type,nbrc,logo,btnValider);
        getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e-> previous.showBack());
                
    }
}
    
               
