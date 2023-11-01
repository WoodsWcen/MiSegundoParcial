package com.emergentes.dao;

import com.emergentes.conexionBD.ConexionBD_BIBLIOTECA;
import com.emergentes.padre.ModeloPadre_biblioteca;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BibliotecaDAO extends ConexionBD_BIBLIOTECA implements BiblioDAO {

    @Override
    public void update(ModeloPadre_biblioteca biblio) throws Exception {
        this.conectar();
        String sql = "update libros set titulo=?,autor=?,disponible=? where=?";
        PreparedStatement ps = this.conect.prepareStatement(sql);
        ps.setString(1, biblio.getTitulo());
        ps.setString(2, biblio.getAutor());
        ps.setInt(3, biblio.getDisponible());
        ps.setInt(4, biblio.getId());
        ps.executeUpdate();
    }

    @Override
    public void delete(int id) throws Exception {
        this.conectar();
        String sql = "delete from libros where id = ?";
        PreparedStatement ps = this.conect.prepareStatement(sql);
        ps.setInt(1, id);
        ps.executeUpdate();
    }

    @Override
    public ModeloPadre_biblioteca getById(int id) throws Exception {
        ModeloPadre_biblioteca bib = new ModeloPadre_biblioteca();

        return bib;
    }

    @Override
    public List<ModeloPadre_biblioteca> getAll() throws Exception {
        List<ModeloPadre_biblioteca> lista = null;
        this.conectar();
        String sql = "select * from libros";
        PreparedStatement ps = this.conect.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        
        lista = new ArrayList<ModeloPadre_biblioteca>();
        while(rs.next()){
            ModeloPadre_biblioteca bib = new ModeloPadre_biblioteca();
            bib.setId(rs.getInt("id"));
            bib.setTitulo(rs.getString("titulo"));
            bib.setAutor(rs.getString("autor"));
            bib.setDisponible(rs.getInt("disponible"));
            lista.add(bib);
        }
        rs.close();
        return lista;
    }

}
