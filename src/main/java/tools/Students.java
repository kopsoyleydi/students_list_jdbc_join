package tools;

public class Students {
    private Long id;
    private String user;
    private String surname;
    private String birthdate;
    private Cities city;

    public Students(Long id, String user, String surname, String birthdate, Cities city) {
        this.id = id;
        this.user = user;
        this.surname = surname;
        this.birthdate = birthdate;
        this.city = city;
    }

    public Students() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public Cities getCity() {
        return city;
    }

    public void setCity(Cities city) {
        this.city = city;
    }
}
