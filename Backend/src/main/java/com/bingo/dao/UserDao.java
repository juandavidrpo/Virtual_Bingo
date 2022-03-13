package com.bingo.dao;


import com.bingo.domain.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


public interface UserDao extends CrudRepository<User, Long> {

    @Modifying
    @Query("update User usu set usu.deleted = '1' where usu.idGame = :idGame and usu.name = :name")
    public void updateLoser(@Param(value = "idGame") Long idGame,
                            @Param(value = "name") String name
    );

}
