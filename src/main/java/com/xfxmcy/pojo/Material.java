package com.xfxmcy.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
/**
 * @author CY
 * @Date   14-08
 * @description  base Material
 * @version 0.0.1-SNAPSHOT
 */
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Material implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String mid;			    //id
	private String mdescription;	//说明	
	private String mtitle;			//标题
	private Material material;		//父资源
	private Set<Material> materials;//子资源
	private Date persistDate;		//添加时间
	@Temporal(TemporalType.DATE)
	public Date getPersistDate() {
		return persistDate;
	}
	public void setPersistDate(Date persistDate) {
		this.persistDate = persistDate;
	}
	@OneToMany(mappedBy="material" , fetch = FetchType.LAZY)
	public Set<Material> getMaterials() {
		return materials;
	}
	public void setMaterials(Set<Material> materials) {
		this.materials = materials;
	}
	@Id
	@Column(length = 40)
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	@Column(length = 255)
	public String getMdescription() {
		return mdescription;
	}
	public void setMdescription(String mdescription) {
		this.mdescription = mdescription;
	}
	@Column(length = 105)
	public String getMtitle() {
		return mtitle;
	}
	public void setMtitle(String mtitle) {
		this.mtitle = mtitle;
	}
	@ManyToOne(optional = true,cascade = CascadeType.REMOVE)
	@JoinColumn(nullable = true ,name = "mpid")
	public Material getMaterial() {
		return material;
	}
	public void setMaterial(Material material) {
		this.material = material;
	}
	
	public Material() {
		// TODO Auto-generated constructor stub
	}
	public Material(String mid, String mdescription, String mtitle) {
		super();
		this.mid = mid;
		this.mdescription = mdescription;
		this.mtitle = mtitle;
	}
	
}
