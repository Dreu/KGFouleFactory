/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cours.controller;

/**
 *
 * @author gassama
 */
public class Image {
    
    private String path;
    private String ville;

    public Image() {
    }

    public Image(String path, String ville) {
        this.path = path;
        this.ville = ville;
    }
    

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }
    
}
