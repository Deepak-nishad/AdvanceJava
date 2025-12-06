package entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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
@Table(name="contacts")
public class Contact {
	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	
	int cid;
	@Column
	String uid;
	@Column
	String password;
	@Column
	String fname;
	@Column
	String lname;
	@Column
	String email;
	@Column
	String contactno;
//	@Column
//	Date bdate;

}
