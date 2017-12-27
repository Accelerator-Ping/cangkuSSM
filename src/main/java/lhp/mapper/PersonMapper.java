package lhp.mapper;

import lhp.pojo.Person;

import java.util.List;


public interface PersonMapper {
    public void insertPerson(Person p);
    //账号、密码、身份查询
    public Person queryByPerson(Person p);
    public List<Person> queryPersonAll();
    public void deletePerson(String name);
    public void updatePassword(Person person);
}