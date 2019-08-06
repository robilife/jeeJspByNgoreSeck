/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doa;

import entities.Serveur;
import entities.Services;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author khk
 */
public class ServicesImpl implements IServices{

    private Db db;
    private ResultSet rs;
    private int ok;
    
    @Override
    public int add(Services service) {
        ok = 0;
        String sql = "INSERT INTO service VALUES(NULL,?,?,?,?)";
        try {
            db = new Db();
            db.initPrepar(sql);
            db.getPstm().setString(1, service.getNomS());
            db.getPstm().setInt(2, service.getPortS());
            db.getPstm().setString(3, service.getEtatS());
            db.getPstm().setInt(4, service.getServeur().getIdServ());
            ok = db.executeMaj();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ok;
    }

    @Override
    public int delete(int idS) {
        ok = 0;
        String sql = "DELETE FROM service WHERE idS = ?";
        try {
            db = new Db();
            db.initPrepar(sql);
            db.getPstm().setInt(1, idS);
            ok = db.executeMaj();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ok;
    }

    @Override
    public int update(Services service) {
        ok = 0;
        String sql = "UPDATE service set nomS = ?, portS = ?, etatS = ?, idServ = ? WHERE idS = ?";
        try {
            db = new Db();
            db.initPrepar(sql);
            db.getPstm().setString(1, service.getNomS());
            db.getPstm().setInt(2, service.getPortS());
            db.getPstm().setString(3, service.getEtatS());
            db.getPstm().setInt(4, service.getServeur().getIdServ());
            db.getPstm().setInt(4, service.getIdS());
            ok = db.executeMaj();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ok;
    }

    @Override
    public Services get(int idS) {
        Services service = null;
        String sql = "SELECT * FROM service WHERE idServ = ?";
        try {
            db = new Db();
            db.initPrepar(sql);
            db.getPstm().setInt(1, idS);
            rs = db.executeSelect();
            while (rs.next()) {
                service = new Services();
                service.setIdS(rs.getInt(1));
                service.setNomS(rs.getString(2));
                service.setPortS(rs.getInt(3));
                service.setEtatS(rs.getString(4));
                service.setServeur(new ServeurImpl().get(rs.getInt(5)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return service;
    }

    @Override
    public List<Services> liste() {
        List<Services> listes = new ArrayList<Services>();
        String sql = "SELECT * FROM service";
        try {
            db = new Db();
            db.initPrepar(sql);
            rs = db.executeSelect();
            System.out.println("dans la fonction liste");
            while (rs.next()) {
                Services service = new Services();
                service.setIdS(rs.getInt(1));
                service.setNomS(rs.getString(2));
                service.setPortS(rs.getInt(3));
                service.setEtatS(rs.getString(4));
                service.setServeur(new ServeurImpl().get(rs.getInt(5)));
                listes.add(service);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listes;
    }

    @Override
    public List<Services> servicesByServeur(int idServ) {
        List<Services> listes = new ArrayList<Services>();
        String sql = "SELECT * FROM service WHERE idServ = ?";
        try {
            db.initPrepar(sql);
            rs = db.executeSelect();
            db.getPstm().setInt(1, idServ);
            rs = db.executeSelect();
            while (rs.next()) {
                Services service = new Services();
                service.setIdS(rs.getInt(1));
                service.setNomS(rs.getString(2));
                service.setPortS(rs.getInt(3));
                service.setEtatS(rs.getString(4));
                service.setServeur(new ServeurImpl().get(rs.getInt(5)));
                listes.add(service);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listes;
    }
    
}
