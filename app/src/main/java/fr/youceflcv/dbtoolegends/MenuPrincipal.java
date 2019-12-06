package fr.youceflcv.dbtoolegends;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Vector;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import android.content.Context;
import android.content.res.XmlResourceParser;
import android.util.Log;


public class MenuPrincipal extends AppCompatActivity {

    private Vector<Perso> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);

        //Partie récup données etc
        XmlResourceParser xpp = getApplicationContext().getResources().getXml(R.xml.characters);

        // début analyse
        try {

            Perso current_character = null;
            String text= null;
            String path = "";
            list = new Vector<>();

            xpp.next();
            int eventType = xpp.getEventType();
            while (eventType != XmlPullParser.END_DOCUMENT) { // Tant qu'on a pas atteint la fin du doc
                if(eventType == XmlPullParser.START_TAG) {
                    path = path + "." + xpp.getName();
                    if ("character".equals(xpp.getName())) {// début d'une nouvelle image
                        current_character = new Perso();
                    }
                } else  if(eventType == XmlPullParser.END_TAG) {

                    if (".set.character.name".equals(path)) {// début d'une nouvelle image
                        current_character.setName(text);
                    } else if ("character".equals(xpp.getName())) {// début d'une nouvelle image
                        list.add(current_character);
                    }

                    path = path.substring(0,path.lastIndexOf('.'));

                } else if(eventType == XmlPullParser.TEXT) {
                    text = xpp.getText(); // On met le text de coté pour la fin de la balise.
                }

                xpp.next();
                eventType = xpp.getEventType();

            }

        } catch (XmlPullParserException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        for(Perso perso : list){
            Log.d("xml",perso.getName());
        }

    }
}

