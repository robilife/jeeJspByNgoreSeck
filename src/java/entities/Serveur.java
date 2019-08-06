/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author khk
 */
public class Serveur {
    private int idServ;
    private String nomServ;
    private String adripServ;

    public Serveur() {
    }

    public Serveur(int idServ, String nomServ, String adripServ) {
        this.idServ = idServ;
        this.nomServ = nomServ;
        this.adripServ = adripServ;
    }

    public int getIdServ() {
        return idServ;
    }

    public void setIdServ(int idServ) {
        this.idServ = idServ;
    }

    public String getNomServ() {
        return nomServ;
    }

    public void setNomServ(String nomServ) {
        this.nomServ = nomServ;
    }

    public String getAdripServ() {
        return adripServ;
    }

    public void setAdripServ(String adripServ) {
        this.adripServ = adripServ;
    }
    
    
}
