package aa.com.resource.model;

import java.io.Serializable;

import java.text.SimpleDateFormat;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * 
 * @author zengzhuo
 * 
 *         用户模型
 * 
 *         窗口 > 首选项 > Java > 代码生成 > 代码和注释
 */
@Entity
@Table(name = "demo_user")
public class User implements Serializable

{

	private static final long serialVersionUID = -4360427971861239742L;
	@Id
	@GenericGenerator(name = "generator", strategy = "uuid")
	@GeneratedValue(generator = "generator")
	@Column(name = "id", unique = true, nullable = false)
	private int id;
	private String name;
	private String cardID;
	private Date birth;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCardID() {
		return cardID;
	}

	public void setCardID(String cardID) {
		this.cardID = cardID;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	@Override
	public String toString() {
		return "[ name =" + name + ", birth = "
				+ new SimpleDateFormat("yyyy-MM-dd").format(birth)
				+ ", carID = " + cardID + ", id = " + id + " ]";
	}

}