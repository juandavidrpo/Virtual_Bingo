package com.bingo.service;

import com.bingo.dao.UserDao;
import com.bingo.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService {

    @Autowired // para inyectar UserDao
    private UserDao userDao;

    @Override
    @Transactional(readOnly = true)
    public List<User> list() {
        return (List<User>) userDao.findAll();
    }

    @Override
    @Transactional
    public User save(User user) {
        return userDao.save(user);
    }

    @Override
    @Transactional
    public User update(Long id, User user) {
        user.setId(id);
        return userDao.save(user);
    }

    @Override
    @Transactional
    public void delete(User user) {
        userDao.delete(user);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<User> findUser(User user) {
        return userDao.findById(user.getId());
    }

/*    @Override
    @Transactional
    public void updateLoser(Long id, User user) {
        userDao.updateLoser(id, user.getName());
    }*/
}
