package rest.api;

import java.util.ArrayList;
import java.util.List;

public class PersonHandling {

    private List<Person> persons;

    private static PersonHandling instance = null;

    public  static PersonHandling getInstance(){

        if(instance == null){
            instance = new PersonHandling();
        }
        return instance;
    }

    public PersonHandling(){

        persons   = new ArrayList<>();

        persons.add(new Person(1, 223456, "Fauzan Hilmy Abyan", "1995-05-26 00:00:00", "fauzanhilmyabyan@gmail.com", "Jakarta, Indonesia"));
        persons.add(new Person(2, 223973, "Andrean Hirata", "1992-07-21 00:00:00", "andreanhirata@gmail.com", "Bayuwangi, Indonesia"));
        persons.add(new Person(3, 221342, "Jayden Blue", "1987-11-09 00:00:00", "jayden.blue@gmail.com", "Manchester, England"));
        persons.add(new Person(4, 212332, "Aurora Indira", "2000-10-16 00:00:00", "indiraurora@gmail.com", "Osaka, Japan"));
        persons.add(new Person(5, 223456, "Fauzan Hilmy Abyan", "1995-05-26 00:00:00", "fauzanhilmyabyan@gmail.com", "Jakarta, Indonesia"));
        persons.add(new Person(6, 223973, "Andrean Hirata", "1992-07-21 00:00:00", "andreanhirata@gmail.com", "Bayuwangi, Indonesia"));
        persons.add(new Person(7, 221342, "Jayden Blue", "1987-11-09 00:00:00", "jayden.blue@gmail.com", "Manchester, England"));
        persons.add(new Person(8, 212332, "Aurora Indira", "2000-10-16 00:00:00", "indiraurora@gmail.com", "Osaka, Japan"));
        persons.add(new Person(9, 223456, "Fauzan Hilmy Abyan", "1995-05-26 00:00:00", "fauzanhilmyabyan@gmail.com", "Jakarta, Indonesia"));
        persons.add(new Person(10, 223973, "Andrean Hirata", "1992-07-21 00:00:00", "andreanhirata@gmail.com", "Bayuwangi, Indonesia"));
        persons.add(new Person(11, 221342, "Jayden Blue", "1987-11-09 00:00:00", "jayden.blue@gmail.com", "Manchester, England"));
        persons.add(new Person(12, 212332, "Aurora Indira", "2000-10-16 00:00:00", "indiraurora@gmail.com", "Osaka, Japan"));


    }

    public  List<Person> fetchPerson(){
        return persons;
    }

    public List<Person>  getById(int id){
        List<Person>  listFoundPerson = new ArrayList<>();
        for (Person b : persons){
            if(b.getId() == id){
                listFoundPerson.add(b);
            }
        }
        return listFoundPerson;
    }


    public List<Person> getByName(String searchParam){

        List<Person>  listFoundPerson = new ArrayList<>();

        for(Person b : persons){
            if(b.getFullName().toLowerCase().contains(searchParam.toLowerCase())){
                listFoundPerson.add(b);
            }
        }

        return listFoundPerson;


    }


    public Person createPerson(int id, int idCard, String fullName, String birthDate, String email, String address){

        Person newPerson = new Person(id, idCard, fullName, birthDate, email, address);

        persons.add(newPerson);

        return newPerson;

    }

    public Person updatePerson(int id, int idCard, String fullName, String birthDate, String email, String address){

        Person editPerson   = new Person(id, idCard, fullName, birthDate, email, address);

        for (Person b : persons){

            if(b.getId() == id){
                int blogIndex = persons.indexOf(b);
                persons.set(blogIndex, editPerson);

                return editPerson;
            }
        }

        return null;
    }


    public Boolean deletePerson(int id){

        int personIndex = -1;

        for (Person b : persons){
            if(b.getId() == id){
                personIndex = persons.indexOf(b);
            }
        }
        if(personIndex > -1){
              persons.remove(personIndex);
        }

        return true;
    }

}
