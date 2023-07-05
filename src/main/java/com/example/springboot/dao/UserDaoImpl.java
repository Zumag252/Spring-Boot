package web.dao;

import org.springframework.stereotype.Repository;
import web.models.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.constraints.Null;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("from User", User.class).getResultList();
    }

    @Override
    public void createUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public User userById(long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void deleteUser(long id) {
        User user = userById(id);
        if (user == null) {
            throw new NullPointerException("Пользователь с таким id не найден");
        }
        entityManager.remove(user);
    }

    @Override
    public void updateUser(long id, User updatedUser) {
        User user = userById(id);
        user.setName(updatedUser.getName());
        user.setEmail(updatedUser.getEmail());
    }
}
