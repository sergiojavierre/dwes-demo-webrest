package com.cpifppiramide.webrest.rest;

import com.cpifppiramide.webrest.dao.DAOFactory;
import com.cpifppiramide.webrest.entidades.Director;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DirectoresRestController {
    @GetMapping("/api/directores")
    public List<Director> lista(){
        return DAOFactory.getInstance().getDaoDirectores().lista();
    }
}
