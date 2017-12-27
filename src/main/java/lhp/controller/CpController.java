package lhp.controller;

import lhp.pojo.C_P;
import lhp.service.C_PService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class CpController {

    @Autowired
    private C_PService c_pService;

    @RequestMapping(value = "/findCpAll")
    public  String findCpAll(Model model){
        List<C_P> cpAllList=c_pService.queryAll();
        model.addAttribute("cpAllList",cpAllList);
        return "readCpAll";
    }

    @RequestMapping(value = "/deleteCp")
    public String deleteCp(Model model,C_P cp){
        c_pService.deleteCp(cp);
        return "redirect:/findCpAll";
    }
}
