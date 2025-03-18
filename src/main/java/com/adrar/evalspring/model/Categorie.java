package com.adrar.evalspring.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "categorie")
public class Categorie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "libele", nullable = false, length = 50)
    @NotBlank(message = "Le libele ne doit pas être vide")
    @Size(min = 2, max = 50, message = "Le libele doit contenir entre 2 et 50 caractères")
    private String libele;

    public Categorie() {}

    public Categorie(String libele) {
        this.libele = libele;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLibele() {
        return libele;
    }

    public void setLibele(String libele) {
        this.libele = libele;
    }
}
