/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doa;

import entities.Serveur;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author khk
 */
public class ServeurImpl implements IServeur{

    private Db db;
    private ResultSet rs;
    private int ok;
    
    @Override
    public int add(Serveur serveur) {
        ok = 0;
        String sql = "INSERT INTO serveur VALUES(NULL,?,?)";
        try {
            db = new Db();
            db.initPrepar(sql);
            db.getPstm().setString(1, serveur.getNomServ());
            db.getPstm().setString(2, serveur.getAdripServ());
            ok = db.executeMaj();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ok;
    }

    @Override
    public int delete(int idServ) {
        ok = 0;
        String sql = "DELETE FROM serveur where IdServ = ?";
        try {
            db = new Db();
            db.initPrepar(sql);
            db.getPstm().setInt(1, idServ);
            ok = db.executeMaj();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ok;
    }

    @Override
    public int update(Serveur serveur) {
        ok = 0;
        String sql = "UPDATE serveur SET nomServ = ?, adripServ = ? WHERE idServ = ?";
        try {
            db = new Db();
            db.initPrepar(sql);
            db.getPstm().setString(1, serveur.getNomServ());
            db.getPstm().setString(2, serveur.getAdripServ());
            db.getPstm().setInt(3, serveur.getIdServ());
            ok = db.executeMaj();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ok;
    }

    @Override
    public Serveur get(int idServ) {
        Serveur serveur = null;
        String sql = "SELECT * FROM serveur WHERE idSERv = ?";
        try {
            db = new Db();
            db.initPrepar(sql);
            db.getPstm().setInt(1, idServ);
            rs = db.executeSelect();
            while (rs.next()) {
                serveur = new Serveur();
                serveur.setIdServ(rs.getInt(1));
                serveur.setNomServ(rs.getString(2));
                serveur.setAdripServ(rs.getString(3));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return serveur;
    }

    @Override
    public List<Serveur> liste() {
        List<Serveur> listes = new ArrayList<Serveur>();
        String sql = "SELECT * FROM serveur";
        try {
            db = new Db();
            db.initPrepar(sql);
            rs = db.executeSelect();
            while (rs.next()) {
                Serveur serveur = new Serveur();
                serveur.setIdServ(rs.getInt(1));
                serveur.setNomServ(rs.getString(2));
                serveur.setAdripServ(rs.getString(3));
                listes.add(serveur);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listes;
    }
    
}
