package com.example.pictochat;

import java.io.Serializable;

public class Member implements Serializable {
    private String Nom;
    private String Prenom;
    private String Ville;
    private Integer Departement;

    public Member() {
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String nom) {
        Nom = nom;
    }

    public String getPrenom() {
        return Prenom;
    }

    public void setPrenom(String prenom) {
        Prenom = prenom;
    }

    public String getVille() {
        return Ville;
    }

    public void setVille(String ville) {
        Ville = ville;
    }

    public Integer getDepartement() {
        return Departement;
    }

    public void setDepartement(Integer departement) {
        Departement = departement;
    }
}