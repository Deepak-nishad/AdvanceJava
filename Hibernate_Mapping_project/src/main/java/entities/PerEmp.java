package entities;

//import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Table(name="peremp")
@Entity
@PrimaryKeyJoinColumn(name="eid")
public class PerEmp  extends Emp{
//	@Column
	float allownce;
//	@Column
	float bonus;
//	@Column
	float deduction;
	
	public PerEmp() {
		super();
		
	}

	

	public PerEmp(int id, String ename, float allownce, float bonus, float deduction) {
		super(id, ename);
		this.allownce = allownce;
		this.bonus = bonus;
		this.deduction = deduction;
	}



	public float getAllownce() {
		return allownce;
	}

	public void setAllownce(float allownce) {
		this.allownce = allownce;
	}

	public float getBonus() {
		return bonus;
	}

	public void setBonus(float bonus) {
		this.bonus = bonus;
	}

	public float getDeduction() {
		return deduction;
	}

	public void setDeduction(float deduction) {
		this.deduction = deduction;
	}
	
	
	
	

}
