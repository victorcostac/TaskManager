/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Domain;

import java.time.LocalDate;
import java.util.Objects;

/**
 *
 * @author Usuario
 */
public class User {
    private Long id;
    private String name;
    private String ssn;
    private LocalDate birthDate;
    private String zip;
    private String address;
    private String city;
    //criar os campos que estão  faltando
    private static Long idCount = 1L;

    public User(String name, String ssn, LocalDate birthDate, String zip, String address, String city) {
        this.id = countId(User.idCount);
        this.name = name;
        this.ssn = ssn;
        this.birthDate = birthDate;
        this.zip = zip;
        this.address = address;
        this.city = city;
    }

    private static Long countId(Long idCount){
        return idCount++;
    }
    
    public Long getId() {
        return id;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final User other = (User) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.ssn, other.ssn)) {
            return false;
        }
        if (!Objects.equals(this.zip, other.zip)) {
            return false;
        }
        if (!Objects.equals(this.address, other.address)) {
            return false;
        }
        if (!Objects.equals(this.city, other.city)) {
            return false;
        }
        return Objects.equals(this.birthDate, other.birthDate);
    }

    @Override
    public String toString() {
        return getName();
    }
    
    public static class UserBuilder{
        private String name;
        private String ssn;
        private LocalDate birthDate;
        private String zip;
        private String address;
        private String city;
        
        public static UserBuilder builder() {
            return new UserBuilder();
        }

        public UserBuilder name(String name) {
            this.name = name;
            return this;
        }
    
        public UserBuilder ssn(String ssn) {
            this.ssn = ssn;
            return this;
        }
        
        public UserBuilder birthDate(LocalDate birthDate) {
            this.birthDate = birthDate;
            return this;
        }
        
        public UserBuilder zip(String zip) {
            this.zip = zip;
            return this;
        }
        
        public UserBuilder address(String address) {
            this.address = address;
            return this;
        }
        
        public UserBuilder city(String city) {
            this.city = city;
            return this;
        }
        
        public User build() {
            return new User(this.name,this.ssn,this.birthDate,this.zip,this.address,this.city);
        }
    }
     
}
