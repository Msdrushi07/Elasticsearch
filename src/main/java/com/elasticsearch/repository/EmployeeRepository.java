package com.elasticsearch.repository;

import java.util.List;

import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.elasticsearch.enity.Employee;


@Repository
public interface EmployeeRepository extends ElasticsearchRepository<Employee,String> {

	List<Employee>  findByDesignation(String designation);
	
	// Fuzzy search by name
    @Query("{\"match\": {\"name\": {\"query\": \"?0\", \"fuzziness\": \"AUTO\"}}}")
    List<Employee> fuzzySearchByName(String name);

    // Fuzzy search by skills
    @Query("{\"match\": {\"skills\": {\"query\": \"?0\", \"fuzziness\": \"AUTO\"}}}")
    List<Employee> fuzzySearchBySkill(String skill);

    // Autocomplete by name
    @Query("{\"prefix\": {\"name\": \"?0\"}}")
    List<Employee> autocompleteByName(String name);

    // Autocomplete by skill
 //   @Query("{\"prefix\": {\"skills\": \"?0\"}}")  // this will match prefix (spring) but will not match spring bo
    @Query("{\"match_phrase_prefix\": {\"skills\": \"?0\"}}") //this will match
    List<Employee> autocompleteBySkill(String skill);
 
 //  By Default (Standard Analyzer):

//Lowercases all input during indexing and search.
//Tokenizes on whitespace and punctuation.
//
//So:
//
//"spring boot" becomes two tokens: ["spring", "boot"]
//"spring Bo" becomes: ["spring", "bo"] → bo ≠ boot   
}
