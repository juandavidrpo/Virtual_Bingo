package com.bingo.service;

import com.bingo.domain.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface IUserService {

    public List<User> list();

    public User save(User user);

    public User update(Long id, User user);

    public void delete(User user);

    public Optional<User> findUser(User user);

    //public void updateLoser(Long id, User user);
}
