package wot.repository;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import wot.entity.Cat;
import wot.entity.CatColor;

import java.util.List;
@Repository
public interface CatRepository extends JpaRepository<Cat, Integer> {
  List<Cat> findAll(Sort sort);

    List<Cat> findAll();

    @Transactional
    @Modifying
    @Query(value = "insert into cats (name, color, tail_length, whiskers_length) values (:name, 'black', :tail_length, :whiskers_length)",
            nativeQuery = true)
    void saveBlack(@Param("name") String name,
                   @Param("tail_length") Integer tail_length,
                   @Param("whiskers_length") Integer whiskers_length);


    @Transactional
    @Modifying
    @Query(value = "insert into cats (name, color, tail_length, whiskers_length) values (:name, 'white', :tail_length, :whiskers_length)",
            nativeQuery = true)
    void saveWhite(@Param("name") String name,
                   @Param("tail_length") Integer tail_length,
                   @Param("whiskers_length") Integer whiskers_length);

    @Transactional
    @Modifying
    @Query(value = "insert into cats (name, color, tail_length, whiskers_length) values (:name, 'black & white', :tail_length, :whiskers_length)",
            nativeQuery = true)
    void saveBlackAndWhite(@Param("name") String name,
                           @Param("tail_length") Integer tail_length,
                           @Param("whiskers_length") Integer whiskers_length);

    @Transactional
    @Modifying
    @Query(value = "insert into cats (name, color, tail_length, whiskers_length) values (:name, 'red', :tail_length, :whiskers_length)",
            nativeQuery = true)
    void saveRed(@Param("name") String name,
                 @Param("tail_length") Integer tail_length,
                 @Param("whiskers_length") Integer whiskers_length);

    @Transactional
    @Modifying
    @Query(value = "insert into cats (name, color, tail_length, whiskers_length) values (:name, 'red & white', :tail_length, :whiskers_length)",
            nativeQuery = true)
    void saveRedAndWhite(@Param("name") String name,
                         @Param("tail_length") Integer tail_length,
                         @Param("whiskers_length") Integer whiskers_length);

    @Transactional
    @Modifying
    @Query(value = "insert into cats (name, color, tail_length, whiskers_length) values (:name, 'red & black & white', :tail_length, :whiskers_length)",
            nativeQuery = true)
    void saveRedAndBlackAndWhite(@Param("name") String name,
                                 @Param("tail_length") Integer tail_length,
                                 @Param("whiskers_length") Integer whiskers_length);

}



//
//    Cat save(Cat cat);
// }
