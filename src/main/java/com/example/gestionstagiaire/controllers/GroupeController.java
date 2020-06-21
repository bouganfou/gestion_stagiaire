package com.example.gestionstagiaire.controllers;

import com.example.gestionstagiaire.dao.GroupeRepository;
import com.example.gestionstagiaire.dao.ModuleFormateurGroupeRepository;
import com.example.gestionstagiaire.dao.ModuleRepository;
import com.example.gestionstagiaire.dao.SeanceRepository;
import com.example.gestionstagiaire.entities.Groupe;
import com.example.gestionstagiaire.entities.Module;
import com.example.gestionstagiaire.entities.ModuleFormateurGroupe;
import com.example.gestionstagiaire.entities.Seance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class GroupeController {
    @Autowired
    private GroupeRepository groupeRepository;
    @Autowired
    private ModuleFormateurGroupeRepository formateurGroupeRepository;
    @Autowired
    private ModuleRepository moduleRepository;

    @Autowired
    private SeanceRepository seanceRepository;

    @GetMapping(value = "/groupes")
    public String index(Model model,
                        @RequestParam(name="page",defaultValue="0") int p,
                        @RequestParam(name="size",defaultValue="5") int s) {
        Pageable pageable=PageRequest.of(p,s);
        Page<Groupe> groupes=groupeRepository.findAll( pageable);
        model.addAttribute("listGroupes",groupes.getContent());
        int[] pages=new int[groupes.getTotalPages()];
        model.addAttribute("pages",pages );
        model.addAttribute("pageCourante",p );
        return "groupes";
    }

    @GetMapping(value = "/modulesGroupe/{code}")
    public String getModuleGroupe(Model model, @PathVariable Long code) {
        Groupe groupe=groupeRepository.findByCodeGrp(code);
        List<ModuleFormateurGroupe> modules=formateurGroupeRepository.findByGroupe(groupe);
        model.addAttribute("modules",modules);

        return "modules";
    }

    @GetMapping(value = "/seances/{id}")
    public String getSeances(Model model, @PathVariable Long id) {
        List<Seance> seances;
        if (id != null ) {
            Module module = moduleRepository.findByIdModule(id);
             seances = seanceRepository.findByModule(module);
        }
        else{
            seances=seanceRepository.findAll();
        }
        for (Seance s:seances
             ) {
            System.out.println(s.getDateRealisation());
            System.out.println(s.getModule().getMasseHoraire());
        }
        model.addAttribute("seances",seances);

        return "seances";
    }
    @GetMapping(value = "/seances")
    public String getSeancesAll(Model model) {
        List<Seance> seances=seanceRepository.findAll();
        model.addAttribute("seances",seances);
        return "seances";
    }
    @GetMapping(value = "/editModule/{id}")
    public String getModule(Model model, @PathVariable Long id) {
        String classColor;
        Module module=moduleRepository.findByIdModule(id);
        model.addAttribute("module",module);

        return "editModule";
    }

    @GetMapping(value = "/")
    public String test() {
        return "groupes";
    }

    @GetMapping(value = "*")
    public String pageFefault() {
        return "404";
    }
}
