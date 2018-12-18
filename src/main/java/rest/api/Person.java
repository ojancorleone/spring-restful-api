package rest.api;


public class Person {

    private int     id;
    private int     key;
    private int     idCard;
    private String  fullName;
    private String  birthDate;
    private String  email;
    private String  address;


    public Person(int id, int idCard, String fullName, String birthDate, String email, String address){

        this.id         = id;
        this.key        = id;
        this.fullName   = fullName;
        this.birthDate  = birthDate;
        this.idCard     = idCard;
        this.email      = email;
        this.address    = address;

    }

    public int getId() {
        return id;
    }
    public int getKey() {
        return key;
    }

    public String getFullName() {
        return fullName;
    }

    public String getEmail() {
        return email;
    }

    public String getBirthDate(){
        return birthDate;
    }

    public int getIdCard() {
        return idCard;
    }

    public String getAddress() {
        return address;
    }


}
