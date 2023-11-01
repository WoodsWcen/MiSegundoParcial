package com.emergentes.dao;

import com.emergentes.padre.ModeloPadre_biblioteca;
import java.util.List;

public interface BiblioDAO {
    public void update(ModeloPadre_biblioteca biblio) throws Exception;
    public void delete(int id) throws Exception;
    public ModeloPadre_biblioteca getById(int id) throws Exception;
    public List<ModeloPadre_biblioteca> getAll() throws Exception;
}
