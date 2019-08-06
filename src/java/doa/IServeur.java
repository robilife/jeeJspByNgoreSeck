/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doa;

import entities.Serveur;
import java.util.List;

/**
 *
 * @author khk
 */
public interface IServeur {
    
    public int add(Serveur serveur);
    public int delete(int idServ);
    public int update(Serveur serveur);
    public Serveur get(int idServ);
    public List<Serveur> liste();
    
}
