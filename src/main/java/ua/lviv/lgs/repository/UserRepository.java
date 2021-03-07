package ua.lviv.lgs.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ua.lviv.lgs.domain.User;

import javax.annotation.PostConstruct;

@Repository
public interface UserRepository extends CrudRepository<User,Long> {
    @PostConstruct
    default void init(){
        User user = new User();
        user.setUserId(3l);
        user.setUserName("Marik");
        user.setPassword("11111");
        user.setEmail("kk@gmail.com");
        user.setEnabled(1);


    }

    User findByUserName(String userName);

}
