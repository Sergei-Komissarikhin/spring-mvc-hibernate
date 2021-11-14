package web.dao;


import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addUser(User user) {
        System.out.println("Сохранение юзера из ДАО");
        entityManager.persist(user);
    }
    @Override
    public List<User> getAllUsers(){
        System.out.println("Получение всех юзеров");
        return entityManager.createQuery("SELECT u FROM User u", User.class).getResultList();
    }

    @Override
    public User getUserById(Long id){
        return entityManager.find(User.class,id);
    }

    @Override
    public void updateUser(User user){
        entityManager.merge(user);
    }

}
