package pl.java.scalatech.repository.spring_hib;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate5.HibernateTemplate;

import pl.java.scalatech.domain.Item;

public class ItemSpringHib {
    @Autowired
    private HibernateTemplate hibTemp;

    private SessionFactory sessionFactory;

    public List<Item> getItems() throws DataAccessException {
        return (List<Item>) hibTemp.find("FROM Item",List.class);
    }

    /*public Item getItemById(Long itemId) throws DataAccessException {
        return (Item) sessionFactory.getCurrentSession()
        .load(Item.class, itemId);
        }*/

    public Item getItemById(Long itemId) throws DataAccessException {
        return hibTemp.load(Item.class, itemId);
    }

    public void saveCategory(Item item) throws DataAccessException {
        hibTemp.saveOrUpdate(item);
    }

    public List<Item> getItemByPart(Long partId)
            throws DataAccessException {
            return (List<Item>) hibTemp.findByNamedParam(
            "select part from Item item " +
            "join item.parts part " +
            "where item.id = :itemId ",
            "itemId", partId
            );
}
}
