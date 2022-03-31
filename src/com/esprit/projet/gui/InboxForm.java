/*
 * Copyright (c) 2016, Codename One
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated 
 * documentation files (the "Software"), to deal in the Software without restriction, including without limitation 
 * the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, 
 * and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions 
 * of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, 
 * INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A 
 * PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT 
 * HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF 
 * CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE 
 * OR THE USE OR OTHER DEALINGS IN THE SOFTWARE. 
 */
package com.esprit.projet.gui;

import com.esprit.projet.entities.User_2;
import com.esprit.projet.services.UserService_2;
import com.codename1.components.FloatingActionButton;
import com.codename1.ui.Button;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.FontImage;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.URLImage;
import com.codename1.ui.animations.CommonTransitions;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.geom.Rectangle;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.layouts.LayeredLayout;
import com.codename1.ui.plaf.RoundBorder;
import com.codename1.ui.plaf.Style;
import java.util.ArrayList;
import java.util.List;

/**
 * GUI builder created Form
 *
 * @author shai
 */
public class InboxForm extends BaseForm {

    public InboxForm() {
        this(com.codename1.ui.util.Resources.getGlobalResources());
    }

    @Override
    protected boolean isCurrentInbox() {
        return true;
    }
    
    
    
    public InboxForm(com.codename1.ui.util.Resources resourceObjectInstance) {
        this.resourceObjectInstance = resourceObjectInstance;
        initGuiBuilderComponents(resourceObjectInstance);
        getToolbar().setTitleComponent(
                FlowLayout.encloseCenterMiddle(
                        new Label("Inbox", "Title")
                )
        );
        
        installSidemenu(resourceObjectInstance);
        EncodedImage enc=EncodedImage.createFromImage(resourceObjectInstance.getImage("toolbar-profile-pic.png"), false);
        Image uelIm = URLImage.createCachedImage("profile-picture",
                UserService_2.getProfilePictureUrl(User_2.getAuthenticatedUser()), 
                enc,
                URLImage.FLAG_RESIZE_SCALE_TO_FILL);
        getToolbar().addCommandToRightBar("", uelIm, e -> {});
        
        
    }
    
//-- DON'T EDIT BELOW THIS LINE!!!
    
    private com.codename1.ui.util.Resources resourceObjectInstance;
    private Container messagesContainer = new Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
    
    public void createThreadComponent(User_2 user) {
        Button threadButton = new com.codename1.ui.Button();
        Label gui_Label_6 = new com.codename1.ui.Label();
        messagesContainer.addComponent(threadButton);
        threadButton.setUIID("Padding2");
        threadButton.setName("Label_4");
        EncodedImage enc=EncodedImage.createFromImage(resourceObjectInstance.getImage("toolbar-profile-pic.png"), false);
        Image userImage = URLImage.createCachedImage("profile-picture",
                UserService_2.getProfilePictureUrl(user), 
                enc,
                URLImage.FLAG_RESIZE_SCALE_TO_FILL);
        threadButton.setIcon(userImage);
        threadButton.setText(user.getUsername());
//        threadButton.addActionListener((e) -> {
//            ThreadForm tf = new ThreadForm(this.resourceObjectInstance);
//            tf.setOtherUser(user);
//            tf.show();
//        });

        messagesContainer.addComponent(gui_Label_6);
        gui_Label_6.setShowEvenIfBlank(true);
    }
    

// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
         
        setLayout(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
        setTitle("InboxForm");
        setName("InboxForm");
        
                
        addComponent(messagesContainer);

        System.out.println("hello");
        //ArrayList<User> allConnectedUsers = ThreadService.getAllConnectedUsers();
        ArrayList<User_2> allConnectedUsers = UserService_2.getAllUsers();
        for(User_2 user: allConnectedUsers) {
            createThreadComponent(user);
        }   
               
    }// </editor-fold>

//-- DON'T EDIT ABOVE THIS LINE!!!
}
