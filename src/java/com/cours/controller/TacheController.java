/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cours.controller;

import com.cours.entities.Client;
import com.cours.entities.Tache;
import com.cours.sessions.ClientFacade;
import com.cours.sessions.TacheFacade;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import javax.validation.constraints.NotNull;

/**
 *
 * @author gassama
 */
@Named(value = "tacheController")
@SessionScoped
public class TacheController implements Serializable {

    @EJB
    private ClientFacade clientFacade;

    @EJB
    private TacheFacade tacheFacade;
    private Tache current;
    private List<String> lines;
    private List<String[] > data;

    @NotNull(message = "Veuillez décrire Le Projet")
    private String description;

    private String path;
    @NotNull(message = "Merci de sélectionner un fichier à envoyer")
    private Part file;
    @NotNull(message = "Merci de Mettre la date de Fin")
    private String datefin;
    @NotNull(message = "Merci de Notifier le temps estimé")
    private String tempest;
    @NotNull(message = "Merci de notifier le nb de fouleur")
    private String nbfouleur;
    @NotNull(message = "Merci de notifier le prix")
    private String prix;

    private String email;
    private DataModel<Tache> model;

    public List<Tache> getTachelistes() {
        return tacheFacade.FindAllUserTaches("encours");
    }

    public List<Tache> getTachelistesPasse() {
        return tacheFacade.FindAllUserTaches("fini");
    }

    public List<Tache> getTachelistesEncours() {
        return tacheFacade.FindAllTachesEncours();
    }

    /**
     * Creates a new instance of TacheController
     */
    public TacheController() {
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getDatefin() {
        return datefin;
    }

    public void setDatefin(String datefin) {
        this.datefin = datefin;
    }

    public Part getFile() {
        return file;
    }

    public void setFile(Part file) {
        this.file = file;
    }

    public String getTempest() {
        return tempest;
    }

    public void setTempest(String tempest) {
        this.tempest = tempest;
    }

    public String getNbfouleur() {
        return nbfouleur;
    }

    public void setNbfouleur(String nbfouleur) {
        this.nbfouleur = nbfouleur;
    }

    public String getPrix() {
        return prix;
    }

    public void setPrix(String prix) {
        this.prix = prix;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public static String generate(int length) {
        String chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuffer pass = new StringBuffer();
        for (int x = 0; x < length; x++) {
            int i = (int) Math.floor(Math.random() * (chars.length() - 1));
            pass.append(chars.charAt(i));
        }
        return pass.toString();
    }

    public String validerjob() {

        HttpSession session = SessionBean.getSession();
        email = session.getAttribute("email").toString();

        path = generate(5);
        path = path + ".csv";
        String p = FacesContext.getCurrentInstance().getExternalContext().getRealPath("resources/csv");
        p = p.substring(0, p.indexOf("build"));
        p = p + "web/resources/csv/";

        try {
            InputStream in = file.getInputStream();
            byte[] data = new byte[in.available()];
            in.read(data);
            FileOutputStream out = new FileOutputStream(new File(p + path));
            out.write(data);
            in.close();
            out.close();
        } catch (Exception e) {
        }
        SimpleDateFormat formatter = null;
        Date fdate = null;
        try {

            formatter = new SimpleDateFormat("dd-MM-yyyy");
            fdate = (Date) formatter.parse(datefin);

        } catch (ParseException e) {
            e.printStackTrace();
        }
        Tache tache = new Tache(Integer.SIZE, description, path, Integer.parseInt(prix), new java.util.Date(), fdate, Integer.parseInt(nbfouleur), "encours");

        Client c = new Client();
        c = clientFacade.FindByEmail(email);
        tache.setIdclient(c);
        tacheFacade.ajouter(tache);

        FacesContext.getCurrentInstance().addMessage(
                null,
                new FacesMessage("Job Validé avec succés "));
        return "Acceuil_client";
    }

    public String prepareView(Tache tache) {
        current = tache;
        return "VoirTache";
    }

    public Tache getCurrent() {
        return current;
    }

    public void setCurrent(Tache current) {
        this.current = current;
    }
    
    public List<String> readFile() throws FileNotFoundException, IOException {

        List<String> result = new ArrayList<String>();
        String p = FacesContext.getCurrentInstance().getExternalContext().getRealPath("resources/csv");
        p = p.substring(0, p.indexOf("build"));
        p = p + "web/resources/csv/";
        FileReader fr = new FileReader(new File(p+""+path));
        BufferedReader br = new BufferedReader(fr);

        for (String line = br.readLine(); line != null; line = br.readLine()) {
            result.add(line);
        }

        br.close();
        fr.close();

        return result;
    }

    public List<Image> getAr() throws IOException {
      lines = readFile();
      List<Image> lis=new ArrayList<>();
        data = new ArrayList<String[] >(lines.size());
        String sep = ";";
        for (String line : lines) {
            String[] oneData = line.split(sep);
            Image im = new Image(oneData[0], oneData[1]);
            lis.add(im);
            data.add(oneData);
        }
        return lis;
    }
    
    public String effectuerTache(Tache tache){
        path = tache.getPath();
        return "Effectuer_Tache";
    }

    public String Valider(){
        return "Acceuil_Fouleur";
    }
}
