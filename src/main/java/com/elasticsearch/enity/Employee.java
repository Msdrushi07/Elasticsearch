package com.elasticsearch.enity;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName = "employees")
public class Employee {
	
	@Id
	private String id;
    private String name;
    private String email;
    private String designation;
    private int yearsOfExperience;
    private List<String> skills;

}
