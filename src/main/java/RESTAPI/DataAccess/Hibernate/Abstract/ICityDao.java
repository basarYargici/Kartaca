package RESTAPI.DataAccess.Hibernate.Abstract;

import RESTAPI.Entity.Concrete.City;

import java.util.List;

/**
 * @author İbrahim Başar YARGICI
 * @date 20.03.2021
 */
public interface ICityDao {
    List<City> getAll();

    City getById(int id);

    void add(City city);

    void update(City city);

    void delete(City city);
}
