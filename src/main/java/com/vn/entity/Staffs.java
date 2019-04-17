package com.vn.entity;
// Generated Nov 21, 2018 9:37:06 PM by Hibernate Tools 4.3.5.Final

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * Staffs generated by hbm2java
 */
@Entity
@Table(name = "Staffs", uniqueConstraints = @UniqueConstraint(columnNames = "CodeId"))
public class Staffs {

	private int id;
	private Departs departs;

	private String codeId;

	private String name;
	private boolean gender;

	private String photo;

	private String email;

	private byte level;

	private Set<Records> recordses = new HashSet<Records>(0);

	public Staffs() {
	}

	public Staffs(String codeId, String name, boolean gender, String email, byte level) {
		this.codeId = codeId;
		this.name = name;
		this.gender = gender;

		this.email = email;

		this.level = level;
	}

	public Staffs(Departs departs, String codeId, String name, boolean gender, String photo, String email, byte level,
			Set<Records> recordses) {
		this.departs = departs;
		this.codeId = codeId;
		this.name = name;
		this.gender = gender;

		this.photo = photo;
		this.email = email;

		this.level = level;

		this.recordses = recordses;
	}

	public Staffs(Departs departs, String codeId, String name, boolean gender, String photo, String email, byte level) {
		this.departs = departs;
		this.codeId = codeId;
		this.name = name;
		this.gender = gender;

		this.photo = photo;
		this.email = email;

		this.level = level;

	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "Id", unique = true, nullable = false)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "DepartId")
	public Departs getDeparts() {
		return this.departs;
	}

	public void setDeparts(Departs departs) {
		this.departs = departs;
	}

	@Column(name = "CodeId", unique = true, nullable = false)
	public String getCodeId() {
		return this.codeId;
	}

	public void setCodeId(String codeId) {
		this.codeId = codeId;
	}

	@Column(name = "Name", nullable = false)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "Gender", nullable = false)
	public boolean getGender() {
		return this.gender;
	}

	public void setGender(boolean gender) {
		this.gender = gender;
	}

	@Column(name = "Photo")
	public String getPhoto() {
		return this.photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	@Column(name = "Email", nullable = false)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "Level", nullable = false)
	public byte getLevel() {
		return this.level;
	}

	public void setLevel(byte level) {
		this.level = level;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "staffs")
	public Set<Records> getRecordses() {
		return this.recordses;
	}

	public void setRecordses(Set<Records> recordses) {
		this.recordses = recordses;
	}

}