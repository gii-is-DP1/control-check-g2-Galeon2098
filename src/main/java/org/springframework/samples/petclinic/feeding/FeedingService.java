package org.springframework.samples.petclinic.feeding;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FeedingService {
	
	@Autowired
	FeedingRepository feedingRepository;
	
    public List<Feeding> getAll(){
    	List<Feeding> lista = feedingRepository.findAll();
        return lista;
    }

    public List<FeedingType> getAllFeedingTypes(){
    	//List<FeedingType> tipos = feedingRepository.findAllFeedingTypes();
        return null;
    }

    public FeedingType getFeedingType(String typeName) {
    	FeedingType nombre = feedingRepository.findFeedingTypeByName(typeName);
        return nombre;
    }
    
    @Transactional(rollbackFor = UnfeasibleFeedingException.class)
    public Feeding save(Feeding p) throws UnfeasibleFeedingException {
    	if (p.getPet().getType() != p.getFeedingType().getPetType()) {
    		throw new UnfeasibleFeedingException();
    	} else {
        return feedingRepository.save(p);
    	}
    }

}
