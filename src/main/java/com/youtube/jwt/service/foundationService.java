package com.youtube.jwt.service;

import com.youtube.jwt.controller.customRepo;
//import static com.youtube.jwt.dao.foundationRepo.entityManager;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.youtube.jwt.entity.Foundation;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

@Service
public class foundationService implements customRepo {

    @Autowired
    com.youtube.jwt.dao.foundationRepo foundationRepo;
    @PersistenceContext
    private EntityManager entityManager;

    public List<Foundation> getAllfoundationByserviceID(int servicesId) {
        return foundationRepo.findByServiceId(servicesId);
    }

    public List<Foundation> getFoundationOfServiceId(int servicesId) {
        return foundationRepo.findByServiceId(servicesId);
    }

//    public List<Foundation> getAlllfoundationBySearch(int servicesId, int cityId) {
//        return foundationRepo.findAllByServiceIdAndCityId(servicesId, cityId);
//    }

    public List<Foundation> getFoundationOfCityId(int cityId) {
        return foundationRepo.findByCityId(cityId);
    }

    public List<Foundation> getFoundationOfAppUserName(String appUserID) {
        //	return foundationRepo.findByUserUserName(appUserID);
        return foundationRepo.findByUserUserName(appUserID);
    }

    public List<Foundation> getFoundationByNameContaining(String name) {
        return foundationRepo.findBynameArContaining(name);
    }

    public List<Foundation> all() {
        System.out.print(foundationRepo.findAll());
        return foundationRepo.findAll();
    }

    public Foundation findFoundationById(int idd) {

        return foundationRepo.findById(idd).orElse(null);
        //    return areaRepo.findById(idd);

    }

    public int findserviceIdByFoundationById(int idd) {
        int id;
        Foundation f = new Foundation();
        f = foundationRepo.findById(idd).orElse(null);
        id = f.getService().getId();
        return id;
        //	return foundationRepo.findById(idd).orElse(null);
        //    return areaRepo.findById(idd);

    }

    public int findCityIdByFoundationById(int idd) {
        int id;
        Foundation f = new Foundation();
        f = foundationRepo.findById(idd).orElse(null);
        id = f.getCity().getId();
        return id;
        //	return foundationRepo.findById(idd).orElse(null);
        //    return areaRepo.findById(idd);

    }

    public void addFoundation(Foundation newFoundation) {

        foundationRepo.save(newFoundation);

    }
     
    public void ubdateFoundation(Foundation newFoundation) {
        foundationRepo.save(newFoundation);
    }
       public void ubdateFoundationActive(boolean active, int id) {
        foundationRepo.setActiveForFoundation1(active,id);
    }
       public void ubdateFoundationCallCount(int numberOfCall,int id) {
           foundationRepo.setCountCallForFoundation(numberOfCall,id);
       }
    public void deleteFoundation(int id) {
        foundationRepo.deleteById(id);
    }

//    public List<Foundation> getAllfoundationBySearch(int servicesId, int cityId) {
//        // TODO Auto-generated method stub
//
//        return foundationRepo.findAllByServiceIdAndCityId(servicesId, cityId);
//    }

    @Override
    public List<Foundation> findAllByServiceIdAndCityId(int servicesId, int cityId,String name,int pageNumber) {
        Pageable page = PageRequest.of(0,2);
//        int pageNumber =pageRequest.getPageNumber();
//        int pageSize = pageRequest.getCount();
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();

        // CriteriaQuery cq = cb.createQuery();
        CriteriaQuery<Foundation> cq = cb.createQuery(Foundation.class);
        Root<Foundation> f = cq.from(Foundation.class);
        List<Predicate> predicates = new ArrayList<Predicate>();
        if (servicesId != 0) {
            predicates.add(cb.equal(f.get("service"), servicesId));
        }
        if (cityId != 0) {
            predicates.add(cb.equal(f.get("city"), cityId));
        }
        if (!name.equals("no")){
        predicates.add(cb.like(f.<String>get("nameAr"), "%"+name+"%"));  //"%"+reference+"%"
       // criteria.add(cb.like(emp.<String>get("name"), p));

        
        }
        cq.where(predicates.toArray(new Predicate[]{}));
    //  System.out.println("the predicates is : "+predicates.toArray(new Predicate[]{}));
        TypedQuery<Foundation> query = entityManager.createQuery(cq);
//      System.out.println("the query is : "+query.toString());
//      System.out.println("query reslt list" + query.getResultList());
    //  int pageNumber = 2;
        int pageSize = 25;
        query.setFirstResult((pageNumber-1) * pageSize); 
        query.setMaxResults(pageSize);
        return query.getResultList();
        
    }
    public long userCount(String name) {
    	
    	return foundationRepo.countByUserUserName(name);
    }

}
