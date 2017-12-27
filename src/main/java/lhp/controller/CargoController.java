package lhp.controller;

import lhp.pojo.C_P;
import lhp.pojo.Cargo;
import lhp.service.C_PService;
import lhp.service.CargoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class CargoController {

    @Autowired
    private CargoService cargoService;

    @Autowired
    private C_PService c_pService;



    @RequestMapping(value = "/gmLogin")
    public String readCargo(Model model){//管理员登录 获得所有货物信息

        List<Cargo> cargoList = cargoService.queryAll();
        model.addAttribute("cargoList",cargoList);
        return "readCargoAll";
    }


    @RequestMapping(value = "/deleteCargo/{cargoName}")
    public String deleteCargo(Model model, @PathVariable String cargoName,HttpSession session){//删除货物
        C_P cp = new C_P();
        cp.setUserName((String) session.getAttribute("username"));
        cp.setCargoName(cargoName);
        cp.setOperation("删除");

        Cargo cargo =new Cargo();
        cargo.setName(cargoName);

        c_pService.insertCp(cp);
        cargoService.deleteCargo(cargo);

        return "redirect:/gmLogin";
    }

    @RequestMapping(value = "/turing/{name}")
    public String turing(Model model,@PathVariable String name){
        /**
         * 因为web_inf下面的被保护 不能直接访问
         * 所以不能对于web-inf下面的jsp之间进行跳转
         * 通过这个jsp实现
         */
        model.addAttribute("name",name);
        return  "upDateCargo";
    }

    @RequestMapping(value = "/upDateCargo1")
    public String upDateCargo1(Model model,HttpSession session,String type,Integer num){
        Cargo cargo = new Cargo();
        cargo.setName((String) session.getAttribute("cargoname"));
        cargo.setNum(num);
        cargo.setType(type);

        C_P cp = new C_P();
        cp.setUserName((String) session.getAttribute("userName"));
        cp.setOperation("数量修改为");
        cp.setCargoName(cargo.getName());
        cp.setNumber(num);

        c_pService.insertCp(cp);
        cargoService.updateCargo(cargo);

        return "redirect:/gmLogin";
    }

    @RequestMapping(value = "/turning2")
    public String turing2(Model model){
        /**
         * 因为web_inf下面的被保护 不能直接访问
         * 所以不能对于web-inf下面的jsp之间进行跳转
         * 通过这个jsp实现
         */
        return  "insertCargo";
    }

    @RequestMapping(value = "/findByName")
    public String findByName(Model model,HttpSession session){//
        List<C_P> cpList = c_pService.queryByName((String) session.getAttribute("username"));
        model.addAttribute("cpList",cpList);
        return  "readCpByName";
    }

    @RequestMapping(value = "/turning4")
    public String turing4(Model model){
        /**
         * 因为web_inf下面的被保护 不能直接访问
         * 所以不能对于web-inf下面的jsp之间进行跳转
         * 通过这个jsp实现
         */
        return  "updatePassword";
    }

    @RequestMapping(value = "/insertCargo1")
    public String insertCargo1(Model model,Cargo cargo,HttpSession session){
        C_P cp = new C_P();
        cp.setUserName((String) session.getAttribute("userName"));
        cp.setOperation("新增加商品");
        cp.setCargoName(cargo.getName());
        cp.setNumber(cargo.getNum());

        c_pService.insertCp(cp);
        cargoService.insertCargo(cargo);
        return "redirect:/gmLogin";
    }



}
