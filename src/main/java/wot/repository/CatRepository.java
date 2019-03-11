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
  @Query(value = "insert into cats (name, color, tail_length, whiskers_length) values (:name, (SELECT CAST (:color AS cat_color)), :tail_length, :whiskers_length)",
          nativeQuery = true)
  void save(@Param("name") String name,
            @Param("color") String color,
            @Param("tail_length") Integer tail_length,
            @Param("whiskers_length") Integer whiskers_length);
}
