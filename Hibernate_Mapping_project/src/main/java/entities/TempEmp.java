package entities;

//import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Table(name="tempEmp")
@Entity
@PrimaryKeyJoinColumn(name="eid")
public class TempEmp extends Emp {
//	@Column
	float extrapay;
//	@Column
	float taxes;
	public TempEmp() {
		super();
	}
	
	

	public TempEmp(int id, String ename, float extrapay, float taxes) {
		super(id, ename);
		this.extrapay = extrapay;
		this.taxes = taxes;
	}



	public float getExtrapay() {
		return extrapay;
	}
	public void setExtrapay(float extrapay) {
		this.extrapay = extrapay;
	}
	public float getTaxes() {
		return taxes;
	}
	public void setTaxes(float taxes) {
		this.taxes = taxes;
	}
	
	

}
