package com.bingo.dao;


import com.bingo.domain.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 * Representa la interfaz del dao usuario.
 * @version 1.0.0 2022-03-13
 * @author Juan David Rojas Restrepo.
 * @since 1.0.0
 */
public interface UserDao extends CrudRepository<User, Long> {

    @Modifying
    @Query("update User usu set usu.deleted = '1' where usu.idGame = :idGame and usu.name = :name")
    public void updateLoser(@Param(value = "idGame") Long idGame,
                            @Param(value = "name") String name
    );

}
