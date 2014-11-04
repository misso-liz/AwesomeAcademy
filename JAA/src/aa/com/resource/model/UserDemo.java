package aa.com.resource.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * UserDemo entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "user_demo")
public class UserDemo implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GenericGenerator(name = "generator", strategy = "uuid")
	@GeneratedValue(generator = "generator")
	@Column(name = "id", unique = true, nullable = false)
	
	private String id;
	private String name;
	private String cardid;
	private Date birth;

	// Constructors

	/** default constructor */
	public UserDemo() {
	}

	/** minimal constructor */
	public UserDemo(String id) {
		this.id = id;
	}

	/** full constructor */
	public UserDemo(String id, String name, String cardid, Date birth) {
		this.id = id;
		this.name = name;
		this.cardid = cardid;
		this.birth = birth;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCardid() {
		return this.cardid;
	}

	public void setCardid(String cardid) {
		this.cardid = cardid;
	}

	public Date getBirth() {
		return this.birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

}