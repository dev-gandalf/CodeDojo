package com.groupone.shazar.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.groupone.shazar.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
	
	List<Product> findByKeywordContainsIgnoreCase(String keyword);
	List<Product> findByTitleContainsIgnoreCase(String title);
	@Override
	List<Product> findAll();
	

	// DONE
	@Query("select p from Product p where (p.startDate <=?2 and p.endDate >= ?3) and (p.title LIKE %?1% or p.description LIKE %?1%)")
	List<Product> findByTextAndDate(String searchTerm, Date startDate, Date endDate);
	
	// DONE
	@Query("select p from Product p where p.title LIKE %?1% or p.description LIKE %?1%")
	List<Product> findByTitleOnly(String searchTerm);
	
	// DONE
	@Query("select p from Product p where p.title LIKE %?1% and p.pricePerDay <=?2")
	List<Product> findByTextAndPrice(String searchTerm, double pricePerDay);
	
	// DONE
	@Query("select p from Product p where (p.startDate <=?2 and p.endDate >= ?3) and (p.title LIKE ?1) and (p.pricePerDay <= ?4)")
	List<Product> findByTextAndDateAndPrice(String searchTerm, Date startDate, Date endDate, double pricePerDay);
		
	// TODO
	@Query("select p from Product p where (p.title LIKE %?1% or p.description LIKE %?1%) and p.keyword LIKE %?2%")
	List<Product> findByTextAndCategory(String searchTerm, String category);
	
	// TODO
	@Query("select p from Product p where p.keyword LIKE %?1%")
	List<Product> findByCategory(String category);
	
	// TODO
	@Query("select p from Product p where p.title LIKE %?1% and p.pricePerDay <=?2 and p.keyword LIKE %?3%")
	List<Product> findByTextAndPriceAndCategory(String searchTerm, double pricePerDay, String category);
	
	// TODO
	@Query("select p from Product p where (p.startDate <=?2 and p.endDate >= ?3) and (p. title LIKE %?1% or p.description LIKE %?1%) and p.keyword LIKE %?4%")
	List<Product> findByTextAndDateAndCategory(String searchTerm, Date startDate, Date endDate, String category);
	
	// Using @Query
	@Query("select p from Product p where (p.startDate <=?2 and p.endDate >= ?3) and (p.title LIKE %?1%)")
	List<Product> findByAll(String searchTerm, Date startDate, Date endDate, String maxPricePerDay);

	@Query("select p from Product p where p.startDate <=?1 and p.endDate >= ?2")
	List<Product> findByDate(Date startDate, Date endDate);
	
	@Query("select p from Product p where p.startDate <= ?1")
	List<Product> findAfterDate(Date startDate);	
}
