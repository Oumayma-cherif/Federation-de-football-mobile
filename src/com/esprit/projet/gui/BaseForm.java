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
import com.esprit.projet.services.BaseService;
import com.esprit.projet.services.UserService_2;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.URLImage;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.util.Resources;

/**
 * Utility methods common to forms e.g. for binding the side menu
 *
 * @author Shai Almog
 */
public class BaseForm extends Form {    
    public void installSidemenu(Resources res) {
        Image selection = res.getImage("selection-in-sidemenu.png");
        
        Image inboxImage = null;
        if(isCurrentInbox()) inboxImage = selection;

        Image trendingImage = null;
        if(isCurrentTrending()) trendingImage = selection;
        
        Image calendarImage = null;
        if(isCurrentCalendar()) calendarImage = selection;
        
        Image statsImage = null;
        if(isCurrentStats()) statsImage = selection;
        
        Button inboxButton = new Button("Inbox", inboxImage);
        inboxButton.setUIID("SideCommand");
        inboxButton.getAllStyles().setPaddingBottom(0);
        Container inbox = FlowLayout.encloseMiddle(inboxButton, 
                new Label("", "SideCommandNumber"));
        inbox.setLeadComponent(inboxButton);
        inbox.setUIID("SideCommand");
        inboxButton.addActionListener(e -> new InboxForm().show());
        getToolbar().addComponentToSideMenu(inbox);
        
//        getToolbar().addCommandToSideMenu("Reclamations", statsImage, e -> new ReclamationsForm(res).show());
    //    getToolbar().addCommandToSideMenu("Offers", trendingImage, e -> new OffersForm(res).show());
  //      getToolbar().addCommandToSideMenu("Forum", trendingImage, e -> new InboxoForm(res).show());
        
        // spacer
        getToolbar().addComponentToSideMenu(new Label(" ", "SideCommand"));
        String profileString = User_2.getAuthenticatedUser().getProfilePictureUrl();
        EncodedImage enc=EncodedImage.createFromImage(res.getImage("profile_image.png"), false);
        Image uelIm = URLImage.createCachedImage("profile-picture",
                UserService_2.getProfilePictureUrl(User_2.getAuthenticatedUser()), 
                enc,
                URLImage.FLAG_RESIZE_SCALE_TO_FILL);
        getToolbar().addComponentToSideMenu(new Label(uelIm, "Container"));
        String userUsername = User_2.getAuthenticatedUser().getUsername();
        String userEmail = User_2.getAuthenticatedUser().getEmail();
        System.out.print(profileString);
        getToolbar().addComponentToSideMenu(new Label(userUsername, "SideCommandNoPad"));
        getToolbar().addComponentToSideMenu(new Label(userEmail, "SideCommandSmall"));
    }

        
    protected boolean isCurrentInbox() {
        return false;
    }
    
    protected boolean isCurrentTrending() {
        return false;
    }

    protected boolean isCurrentCalendar() {
        return false;
    }

    protected boolean isCurrentStats() {
        return false;
    }
}
