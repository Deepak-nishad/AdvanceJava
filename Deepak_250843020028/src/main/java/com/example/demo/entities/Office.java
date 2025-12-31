package com.example.demo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name="offices")
public class Office {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer officecode;
	String city;
	String phone;
	String addressline1;
	String addressline2;
	String state;
	String country;
	String postalcode;
	String territory;
	

}


