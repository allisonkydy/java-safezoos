package com.lambdaschool.zoos.repository;

import com.lambdaschool.zoos.model.Animal;
import com.lambdaschool.zoos.view.AnimalsZooCount;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AnimalRepository extends CrudRepository<Animal, Long>
{
    Animal findByAnimaltype(String type);

    @Query(value = "SELECT a.animalid, a.animaltype, count(z.animalid) as zoocount FROM animal a LEFT JOIN zooanimals z on a.animalid = z.animalid GROUP BY a.animalid",
           nativeQuery = true)
    List<AnimalsZooCount> findAnimalsZooCount();
}
