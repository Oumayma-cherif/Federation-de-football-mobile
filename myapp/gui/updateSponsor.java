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
import com.mycompany.myapp.entities.sponsor;
import com.mycompany.myapp.services.servicesponsor;

/**
 *
 * @author oumaymacherif
 */
public class updateSponsor extends Form {

    Form previous;

    public updateSponsor(sponsor ev) {
        super("Newsfeed", BoxLayout.y());

        setTitle("Modifier Votre sponsor");

        TextField nomS = new TextField(ev.getnomS(), "nomc", 20, TextField.ANY);
        nomS.setUIID("TextFieldBlack");

        TextField Image = new TextField(ev.getlogoS(), "logo ", 20, TextField.ANY);
        Image.setUIID("TextFieldBlack");

       
        Button btnModifier = new Button("Modifier");
        btnModifier.setUIID("Button");

        //OnClick Button
        btnModifier.addPointerPressedListener(l -> {

          /*  ev.setnomS(Description.getText());
            ev.setDescr(Nom.getText());
            ev.setLogo(Image.getText());
            ev.setPresident(Image.getText());

            //Appel a la methode UPDATE
            if (servicesponsor.getInstance().modifierClub(ev)) {
                //If True
                // new Listclub(res).show();

            }*/
        });

        Label l2 = new Label("");
        Label l3 = new Label("");
        Label l4 = new Label("");
        Label l5 = new Label("");

        Label l1 = new Label();

        Container content = BoxLayout.encloseY(
                l1, l2,
             
                new FloatingHint(Image),
                new FloatingHint(nomS),
                btnModifier
             
        );

        add(content);
        show();

    }

}
