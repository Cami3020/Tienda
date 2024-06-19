/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tienda.Service.impl;

import Tienda.Service.CategoriaService;
import Tienda.dao.CategoriaDao;
import Tienda.domain.Categoria;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaServiceimpl implements CategoriaService {
    
    @Autowired
    private CategoriaDao categoriaDao;
    
    @Override
    public List<Categoria> getCategorias (boolean activo){
        List<Categoria> lista = categoriaDao.findAll();
        
        //filtrar en caso de querer solo activos
        if (activo) {
            lista.removeIf(c -> !c.isActivo());
        
        }
        
        return lista;
    }
    
}
