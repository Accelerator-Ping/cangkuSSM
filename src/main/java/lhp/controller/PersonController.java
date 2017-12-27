package lhp.controller;

import lhp.pojo.Person;
import lhp.service.C_PService;
import lhp.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class PersonController {

    @Autowired
    private PersonService personService;

    @Autowired
    private C_PService c_pService;


    @RequestMapping(value = "/login_check")
    public String loginCheck(Model model, Person person, HttpServletRequest request) throws  Exception{
        person=personService.queryByPerson(person);
        if(person==null){
            return "test";
        }else if(person.getIdentity().equals("老板")){
            request.getSession().setAttribute("username",person.getName());
            request.getSession().setAttribute("identity",person.getIdentity());
            return "bossLogin";
        }else if(person.getIdentity().equals("管理员")){
            request.getSession().setAttribute("username",person.getName());
            request.getSession().setAttribute("identity",person.getIdentity());
            return "redirect:/gmLogin";
        }

        return "loginFail";
    }

    @RequestMapping(value = "/updatePassword1")
    public String updatePassword1(Model model,String password,String newPassword,HttpSession session){
        Person person = new Person();
        person.setName((String) session.getAttribute("username"));
        person.setIdentity((String) session.getAttribute("identity"));
        person.setPassword(password);

        if(personService.queryByPerson(person)==null){
            return "loginFail";
        }

        person.setPassword(newPassword);
        personService.updatePassword(person);

        return "login";
    }

    @RequestMapping(value = "/findPersonAll")
    public String findPersonAll(Model model){
        List<Person> personList=personService.queryPersonAll();
        model.addAttribute("personListLong",personList.size());
        model.addAttribute("personList",personList);
        return "readPersonAll";
    }

    @RequestMapping(value = "/deletePerson/{personName}")
    public String deletePerson(Model model, HttpSession session, @PathVariable String personName){
        c_pService.deletePerson(personName);
        personService.deletePerson(personName);

        return "redirect:/findPersonAll";
    }

    @RequestMapping(value = "/turningPerson")
    public String turning(){//跳转到添加新管理员页面
        return  "insertPerson";
    }


    @RequestMapping(value = "/insertPerson1")
    public String insertPerson1(Model model,Person person){
            person.setIdentity("管理员");
            personService.insertPerson(person);
            return "redirect:/findPersonAll";
    }

}
