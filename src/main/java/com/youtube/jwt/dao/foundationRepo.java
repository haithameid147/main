package com.youtube.jwt.dao;

import java.util.List;
//import java.util.Map;

//import javax.persistence.EntityGraph;
//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import javax.persistence.EntityTransaction;
//import javax.persistence.FlushModeType;
//import javax.persistence.LockModeType;
//import javax.persistence.Query;
//import javax.persistence.StoredProcedureQuery;
//import javax.persistence.TypedQuery;
//import javax.persistence.criteria.CriteriaBuilder;
//import javax.persistence.criteria.CriteriaDelete;
//import javax.persistence.criteria.CriteriaQuery;
//import javax.persistence.criteria.CriteriaUpdate;
//import javax.persistence.criteria.Predicate;
//import javax.persistence.criteria.Root;
//import javax.persistence.metamodel.Metamodel;
//
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.youtube.jwt.entity.Foundation;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;


@Repository
@Transactional
public interface foundationRepo extends JpaRepository<Foundation, Integer>{


	//         public  List<Area> findByCityId(int cityId);
     public List<Foundation> findByServiceId(int servicesId);
//     public default List<Foundation>  findAllByServiceIdAndCityId(int servicesId,int cityId){
//    	// Foundation f = new Foundation();
//    	  CriteriaBuilder cb= entityManager.getCriteriaBuilder();
//    	  CriteriaQuery cq = cb.createQuery();
//    	 Root<Foundation> f = cq.from(Foundation.class);
//    	 Predicate servicesIdPredicate =cb.equal(f.get("servicesId"), servicesId);
//    	 Predicate cityIdPredicate =cb.equal(f.get("cityId"), cityId);
//    	 cq.where(servicesIdPredicate,cityIdPredicate);
//    	 TypedQuery<Foundation> query = entityManager.createQuery(cq);
//
//    	 
//    	 return query.getResultList();
//     };
 	 long countByUserUserName(String name);
     public List<Foundation> findByUserUserName(String appUserId);
     public List<Foundation> findByCityId(int cityId);
     public List<Foundation> findBynameArContaining(String name);
     @Modifying
    // @Transactional
     @org.springframework.data.jpa.repository.Query
        ("update Foundation f set f.active = ?1 where f.id = ?2")
     void setActiveForFoundation1(boolean active, int id);

//     @Modifying
//     @Transactional
//     @org.springframework.data.jpa.repository.Query
//        ("update Foundation f set f.count_of_call = ?2 where f.id = ?1")
//     void setCountCallForFoundation(int id,Integer numberOfCall);
//     
     
     @Modifying
     @Query(value = "update Foundation  set count_of_call = ? where id = ?", 
       nativeQuery = true)
     void setCountCallForFoundation(Integer count_of_call, int id);
}
