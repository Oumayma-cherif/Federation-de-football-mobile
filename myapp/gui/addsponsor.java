package com.mycompany.myapp.gui;

import com.codename1.components.SpanLabel;
import static com.codename1.push.PushContent.setTitle;
import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.mycompany.myapp.entities.sponsor;
import com.mycompany.myapp.services.servicesponsor;
import java.util.ArrayList;
import com.codename1.io.Log;
import com.codename1.io.NetworkManager;
import com.codename1.io.rest.Rest;
import com.codename1.ui.Display;
import com.codename1.ui.Font;
import com.codename1.ui.FontImage;
import com.codename1.ui.TextField;
import com.mycompany.myapp.utils.Statics;
import rest.file.uploader.tn.FileUploader;

/**
 *
 * @author cherif
 */
public class addsponsor extends Form {

    Form previous;
    private String fileNameInServer = "";

    public addsponsor(Form previous) {
        
        setTitle("Add a new sponsor");
        setLayout(BoxLayout.y());

        TextField NomS = new TextField("", "nomS");
        TextField logoS = new TextField("", "logoS");
        Button btnValider = new Button("Add sponsor");

          Font materialFontAjout = FontImage.getMaterialDesignFont();
        int size = Display.getInstance().convertToPixels(5, true);
        materialFontAjout = materialFontAjout.derive(size, Font.STYLE_PLAIN);
        Button Delete = new Button("Supprimer");
        Delete.setIcon(FontImage.create("\uea4c", Delete.getUnselectedStyle(), materialFontAjout));
        //MyApplication
        
        
          Button imgBtn = new Button("parcourir");
        //addStringValue("", imgBtn);

        imgBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                try {
                    FileUploader fu = new FileUploader(Statics.URL_UPLOAD);

                    //Upload
                    Display.getInstance().openGallery(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent v) {
                            if (v == null || v.getSource() == null) {
                                System.out.println("choisir image fail !");
                                return;
                            }

                            String filePath = ((String) v.getSource()).substring(7);
                            System.out.println(filePath);

                            try {
                                fileNameInServer = fu.upload(filePath);

                            } catch (Exception ex) {
                                ex.printStackTrace();
                            }

                        }
                    }, Display.GALLERY_IMAGE);

                } catch (Exception ex) {
                    ex.printStackTrace();
                }

            }
        });
        
       }
        
       /*
        
    btnValider.addActionListener((e) -> {
            //serviceclub c = new serviceclub();
            club r = new club(Nomc.getText().toString(), fileNameInServer, descr.getText(), President.getText().toString());
            System.out.println("data evenement ==" + r);
            serviceclub.getInstance().addTournoi(r);

        });
        addAll(Nomc, imgBtn, descr, President, btnValider);

        getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e -> new Listclub(this).show());

    }

    private void addStringValue(String s, Component v) {
        add(BorderLayout.west(new Label(s, "PaddedLabel"))
                .add(BorderLayout.CENTER, v));
    }
}

        addAll(NomS, logoS, btnValider);
        getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e -> previous.showBack());

    }
}
*/

