package com.cpifppiramide.webrest.rest;

import com.cpifppiramide.webrest.dao.DAOFactory;
import com.cpifppiramide.webrest.entidades.Genero;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GenerosRestController {
    @GetMapping("/api/generos")
    public List<Genero> lista(){
        return DAOFactory.getInstance().getDaoGeneros().lista();
    }
}
