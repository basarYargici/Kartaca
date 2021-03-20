package RESTAPI.Entity.Concrete;

import RESTAPI.Entity.Abstract.IEntity;

import javax.persistence.*;

/**
 * @author İbrahim Başar YARGICI
 * @date 20.03.2021
 */

@Entity
@Table(name = "city")
public class City implements IEntity {
    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "countrycode")
    private String countryCode;

    @Column(name = "population")
    private int population;

    @Column(name = "district")
    private String district;

    public City(String name, String countryCode, String district, int population) {
        this.name = name;
        this.countryCode = countryCode;
        this.district = district;
        this.population = population;
    }

    public City() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

}
