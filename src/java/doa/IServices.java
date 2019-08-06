/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doa;

import entities.Services;
import java.util.List;

/**
 *
 * @author khk
 */
public interface IServices {
    public int add(Services service);
    public int delete(int idS);
    public int update(Services serveur);
    public Services get(int idS);
    public List<Services> liste();
    public List<Services> servicesByServeur(int idServ);
}
