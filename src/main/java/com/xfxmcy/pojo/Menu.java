package com.xfxmcy.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.xfxmcy.util.Role;

/**
 * @author CY
 * @Date   05-06	
 * @description  the entity for  menu 递归表
 * @version 0.0.1-SNAPSHOT
 */
@Entity
public class Menu implements Serializable {
	private static final long serialVersionUID = 1l;
	public Menu() {
		// TODO Auto-generated constructor stub
	}
	private String id;
	private String text;
	private String url;
	private String ciconcls;
	private Role role;
	private Menu  menu;
	private Set<Menu>  menus;
	private BigDecimal seq;
	
	public Menu(String id, String text, String url, String ciconcls, Role role,
			Menu menu, BigDecimal seq) {
		super();
		this.id = id;
		this.text = text;
		this.url = url;
		this.ciconcls = ciconcls;
		this.role = role;
		this.menu = menu;
		this.seq = seq;
	}
	@Enumerated(EnumType.STRING)
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	@ManyToOne
	@JoinColumn(name = "pid",nullable = true)
	public Menu getMenu() {
		return menu;
	}
	public void setMenu(Menu menu) {
		this.menu = menu;
	}
	@OneToMany(fetch = FetchType.LAZY , mappedBy="menu")
	public Set<Menu> getMenus() {
		return menus;
	}
	public void setMenus(Set<Menu> menus) {
		this.menus = menus;
	}
	@Column(length = 30)
	public String getCiconcls() {
		return ciconcls;
	}
	public void setCiconcls(String ciconcls) {
		this.ciconcls = ciconcls;
	}
	

	@Id
	@Column(length = 10)
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	@Column(length = 25)
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	@Column(length = 45)
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	} 
	public BigDecimal getSeq() {
		return seq;
	}
	public void setSeq(BigDecimal seq) {
		this.seq = seq;
	}
	
}
