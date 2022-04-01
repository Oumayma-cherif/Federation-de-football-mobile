package com.mycompany.myapp.gui;

import com.codename1.components.ImageViewer;
import com.codename1.components.SpanLabel;
import static com.codename1.push.PushContent.setTitle;
import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.URLImage;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.mycompany.myapp.entities.sponsor;
import com.mycompany.myapp.services.servicesponsor;
import java.util.ArrayList;
import com.mycompany.myapp.utils.Statics;

/**
 *
 * @author oumaymacherif
 */
public class Listsponsor extends Form {

    public Listsponsor(Form previous) {

        setTitle("Liste des sponsor");

        servicesponsor es = new servicesponsor();
        ArrayList<sponsor> list = es.getAllsponsor();

        Button ajoutsponsor = new Button("Ajouter");

        ajoutsponsor.addPointerPressedListener(l -> {
            new addsponsor().show();
        });

        Container chercherContianer = new Container();
        chercherContianer.setLayout(BoxLayout.y());
        chercherContianer.addAll(ajoutsponsor);
        this.add(chercherContianer);

        for (sponsor r : list) {
            Container c3 = new Container(BoxLayout.y());
            String url = Statics.BASE_URL + "/" + "uploads/" + r.getlogoS();

            SpanLabel cat = new SpanLabel("Nom du sponsor  :" + r.getnomS());
            SpanLabel cat1 = new SpanLabel("logo   :" + r.getlogoS());
            Image placeholder = Image.createImage(200, 200);
            EncodedImage enc = EncodedImage.createFromImage(placeholder, false);
            URLImage urlim = URLImage.createToStorage(enc, r.getlogoS(), url + "/" + r.getlogoS());
            ImageViewer imgV = new ImageViewer();
            imgV.setImage(urlim);
            c3.add(cat);
            c3.add(cat1);

            Button Delete = new Button("Delete");
            c3.add(Delete);
            Button Modifier = new Button("Modifier");
            Modifier.addPointerPressedListener(l -> {
                new updateSponsor(r).show();
            });
            c3.add(Modifier);
            Delete.getAllStyles().setBgColor(0xF36B08);
            Delete.addActionListener(e -> {
                Dialog alert = new Dialog("Attention");
                SpanLabel message = new SpanLabel("Etes-vous sur de vouloir supprimer ce club ?\nCette action est irréversible!");
                alert.add(message);
                Button ok = new Button("Confirmer");
                Button cancel = new Button(new Command("Annuler"));
                //User clicks on ok to delete account
                ok.addActionListener(new ActionListener() {

                    public void actionPerformed(ActionEvent evt) {
                        es.Delete(r.getId());

                        alert.dispose();
                        refreshTheme();
                    }

                }
                );

                alert.add(cancel);
                alert.add(ok);
                alert.showDialog();

                new Listsponsor(previous).show();
            });
            ajoutsponsor.addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent evt) {

                    refreshTheme();
                }

            });

            System.out.println("dd sponsor");

            addAll (c3);

            getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK,
                    e -> previous.showBack()); // Revenir vers l'interface précédente

        }

    }

}


