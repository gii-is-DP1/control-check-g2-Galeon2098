package org.springframework.samples.petclinic.feeding;

import java.util.List;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeedingRepository extends CrudRepository<Feeding, Integer>{
    
	List<Feeding> findAll();
    
    @Query("SELECT f FROM FeedingType f")
    List<FeedingType> findAllFeedingTypes();
    
    @Query("SELECT f FROM FeedingType f WHERE f.name=:name")
    FeedingType findFeedingTypeByName (String name);
    
   
    Optional<Feeding> findById(int id);
    
    Feeding save(Feeding p);
}
