package lhp.service.Impl;

import lhp.mapper.PersonMapper;
import lhp.pojo.Person;
import lhp.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonMapper personMapper;

    public void insertPerson(Person p) {
        personMapper.insertPerson(p);
    }

    public Person queryByPerson(Person p) {
        return personMapper.queryByPerson(p);
    }

    public List<Person> queryPersonAll() {
        return personMapper.queryPersonAll();
    }

    public void deletePerson(String name) {
        personMapper.deletePerson(name);
    }

    public void updatePassword(Person person) {
        personMapper.updatePassword(person);
    }
}
