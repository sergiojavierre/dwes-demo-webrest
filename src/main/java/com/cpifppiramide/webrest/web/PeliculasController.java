package com.cpifppiramide.webrest.web;

import com.cpifppiramide.webrest.dao.DAOFactory;
import com.cpifppiramide.webrest.entidades.Director;
import com.cpifppiramide.webrest.entidades.Genero;
import com.cpifppiramide.webrest.entidades.Pelicula;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
        List<Genero> generos = DAOFactory.getInstance().getDaoGeneros().lista();
        model.addAttribute("peliculas", peliculas);
        model.addAttribute("directores", directores);
        model.addAttribute("generos", generos);
        return "index";
    }

    @GetMapping("/nueva")
    public String nueva(Model model){
        List<Director> directores = DAOFactory.getInstance().getDaoDirectores().lista();
        List<Genero> generos = DAOFactory.getInstance().getDaoGeneros().lista();
        model.addAttribute("directores", directores);
        model.addAttribute("generos", generos);
        return "nueva";
    }

    @PostMapping("/guarda")
    public String guarda(
            //si preferís coger las propiedades de los objetos por separado y después montarlo, esta es una opción
            @RequestParam(name = "titulo") String titulo,
            @RequestParam(name = "año") Integer año,
            @RequestParam(name = "director") String director,
            @RequestParam(name = "genero") String genero
            ){
        Pelicula pelicula = new Pelicula();
        pelicula
                .titulo(titulo)
                .año(año)
                .director(new Director(director))
                .genero(new Genero(genero));
        DAOFactory.getInstance().getDaoPeliculas().inserta(pelicula);
        return "redirect:/";
    }

}
