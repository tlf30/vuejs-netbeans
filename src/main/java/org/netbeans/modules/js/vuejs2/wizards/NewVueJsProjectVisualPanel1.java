package org.netbeans.modules.js.vuejs2.wizards;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import javax.swing.JPanel;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openide.util.Exceptions;

public final class NewVueJsProjectVisualPanel1 extends JPanel {

    private ArrayList<Template> templates = new ArrayList<>();
    /**
     * Creates new form NewVueJsProjectVisualPanel1
     */
    public NewVueJsProjectVisualPanel1() {
        initComponents();
        
        try {
            Document document = Jsoup.parse(new URL("https://github.com/vuejs-templates"), 50);
            Elements templateNodes = document.select("/div[@id='org-repositories']/*/li");
            for (Element template : templateNodes) {
                Elements nameNode = template.select("/div[1]/h3/a");
                Elements descriptionNode = template.select("/div[2]/p");
                
                this.templates.add(new Template(nameNode.text(), nameNode.attr("href"), descriptionNode.text()));
            }
        } catch (MalformedURLException ex) {
            Exceptions.printStackTrace(ex);
        } catch (IOException ex) {
            Exceptions.printStackTrace(ex);
        }
    }

    @Override
    public String getName() {
        return "Step #1";
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

    class Template {
        public String name;
        public String description;
        public String url;

        public Template(String name, String description, String url) {
            this.name = name;
            this.description = description;
            this.url = url;
        }
        
    }
}