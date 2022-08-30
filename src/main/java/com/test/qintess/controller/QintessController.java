package com.test.qintess.controller;


import com.test.qintess.dto.personList;
import com.test.qintess.dto.personListResult;
import com.test.qintess.service.QintessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

@Controller
public class QintessController {

    @Autowired
    QintessService qintessService;

    public List<personListResult> getSortedAge(){
        List<personList> list = getList();
        return qintessService.getSortedAge(list);
    }

    public List<personListResult> getSortedAgeName(){
        List<personList> list = getList();
        return qintessService.getSortedAgeandName(list);
    }

    public List<personList> getList(){
        List<personList> nationalTeam = new ArrayList<>();
        nationalTeam.add(new personList(37, "Claudio Bravo"));
        nationalTeam.add(new personList(36, "Jean Beausejour"));
        nationalTeam.add(new personList(34, "Gonzalo Jara"));
        nationalTeam.add(new personList(33, "Gary Medel"));
        nationalTeam.add(new personList(32, "Mauricio Isla"));
        nationalTeam.add(new personList(31, "Charles Aránguiz"));
        nationalTeam.add(new personList(33, "Arturo Vidal"));
        nationalTeam.add(new personList(34, "Matias Fernandez"));
        nationalTeam.add(new personList(36, "Jorge Valdivia"));
        nationalTeam.add(new personList(31, "Alexis Sánchez"));
        nationalTeam.add(new personList(30, "Eduardo Vargas"));
        return nationalTeam;
    }

}
