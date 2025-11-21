package com.cpifppiramide.webrest.web;

import com.cpifppiramide.webrest.dao.DAOFactory;
import com.cpifppiramide.webrest.entidades.Director;
import com.cpifppiramide.webrest.entidades.Genero;
import com.cpifppiramide.webrest.entidades.Pelicula;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class PeliculasController {

    @GetMapping("/")
    String lista(Model model,
                 //parámetros en URL opcionales
                 @RequestParam(required = false) String titulo,
                 @RequestParam(required = false) Integer año,
                 @RequestParam(required = false) String director,
                 @RequestParam(required = false) String genero
                 ){
        Director directorObj = null;
        if(director != null){
            directorObj = new Director(director);
        }
        Genero generoObj = null;
        if(genero != null){
            generoObj = new Genero(genero);
        }
        List<Pelicula> peliculas = DAOFactory.getInstance().getDaoPeliculas().lista(titulo, año, directorObj, generoObj);
        List<Director> directores = DAOFactory.getInstance().getDaoDirectores().lista();
        model.addAttribute("peliculas", peliculas);
        model.addAttribute("directores", directores);
        return "index";
    }

}
