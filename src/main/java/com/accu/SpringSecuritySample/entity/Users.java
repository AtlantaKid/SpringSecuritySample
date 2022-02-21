package com.accu.SpringSecuritySample.entity;

import java.io.Serializable;
import java.time.ZonedDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

/**
 * @author Anoosh Atari
 * 
 *
 */
@Entity(name = "Users")
@Table(name = "users")
@JacksonXmlRootElement(localName = "users")
public class Users implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2L;

	@Id
	// @GeneratedValue(strategy = GenerationType.AUTO)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JacksonXmlProperty(isAttribute = true)
	@Column(name = "id", updatable = false, nullable = false, unique = true)
	private long id;

	@JacksonXmlProperty
	@Column(name = "firstname", length = 64, nullable = false)
	private String firstname;

	@JacksonXmlProperty
	@Column(name = "lastname", length = 64, nullable = false)
	private String lastname;

	@JacksonXmlProperty
	@Column(name = "username", length = 255, nullable = false, unique = true)
	private String username;

	@JacksonXmlProperty
	@Column(name = "password", length = 255, nullable = false)
	private String password;

	@JacksonXmlProperty
	@Column(name = "enabled")
	private boolean enabled = true;

	@JacksonXmlProperty
	@CreationTimestamp
	@Column(name = "created", insertable = true, updatable = false)
	private ZonedDateTime created;

	@JacksonXmlProperty
	@UpdateTimestamp
	@Column(name = "updated", insertable = true, updatable = false)
	private ZonedDateTime updated;

	@JacksonXmlProperty
	@Column(name = "who", length = 100, nullable = true)
	private String who;

	@JacksonXmlProperty
	@Column(name = "comment", length = 2048, nullable = true)
	private String comment;

	public Users() {

	}

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the firstname
	 */
	public String getFirstname() {
		return firstname;
	}

	/**
	 * @param firstname the firstname to set
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	/**
	 * @return the lastname
	 */
	public String getLastname() {
		return lastname;
	}

	/**
	 * @param lastname the lastname to set
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the enabled
	 */
	public boolean isEnabled() {
		return enabled;
	}

	/**
	 * @param enabled the enabled to set
	 */
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	/**
	 * @return the created
	 */
	public ZonedDateTime getCreated() {
		return created;
	}

	/**
	 * @param created the created to set
	 */
	public void setCreated(ZonedDateTime created) {
		this.created = created;
	}

	/**
	 * @return the updated
	 */
	public ZonedDateTime getUpdated() {
		return updated;
	}

	/**
	 * @param updated the updated to set
	 */
	public void setUpdated(ZonedDateTime updated) {
		this.updated = updated;
	}

	/**
	 * @return the who
	 */
	public String getWho() {
		return who;
	}

	/**
	 * @param who the who to set
	 */
	public void setWho(String who) {
		this.who = who;
	}

	/**
	 * @return the comment
	 */
	public String getComment() {
		return comment;
	}

	/**
	 * @param comment the comment to set
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Users [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", username=" + username
				+ ", password=" + password + ", enabled=" + enabled + ", created=" + created + ", updated=" + updated + ", who="
				+ who + ", comment=" + comment + "]";
	}

	/**
	 * @param firstname
	 * @param lastname
	 * @param username
	 * @param password
	 * @param who
	 * @param comment
	 */
	public Users(String firstname, String lastname, String username, String password, String who, String comment) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.username = username;
		this.password = password;
		this.who = who;
		this.comment = comment;
	}

	/**
	 * @param id
	 * @param firstname
	 * @param lastname
	 * @param username
	 * @param password
	 * @param enabled
	 * @param created
	 * @param updated
	 * @param who
	 * @param comment
	 */
	public Users(long id, String firstname, String lastname, String username, String password, boolean enabled,
			ZonedDateTime created, ZonedDateTime updated, String who, String comment) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.username = username;
		this.password = password;
		this.enabled = enabled;
		this.created = created;
		this.updated = updated;
		this.who = who;
		this.comment = comment;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((comment == null) ? 0 : comment.hashCode());
		result = prime * result + ((created == null) ? 0 : created.hashCode());
		result = prime * result + (enabled ? 1231 : 1237);
		result = prime * result + ((firstname == null) ? 0 : firstname.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((lastname == null) ? 0 : lastname.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((updated == null) ? 0 : updated.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		result = prime * result + ((who == null) ? 0 : who.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Users other = (Users) obj;
		if (comment == null) {
			if (other.comment != null)
				return false;
		} else if (!comment.equals(other.comment))
			return false;
		if (created == null) {
			if (other.created != null)
				return false;
		} else if (!created.equals(other.created))
			return false;
		if (enabled != other.enabled)
			return false;
		if (firstname == null) {
			if (other.firstname != null)
				return false;
		} else if (!firstname.equals(other.firstname))
			return false;
		if (id != other.id)
			return false;
		if (lastname == null) {
			if (other.lastname != null)
				return false;
		} else if (!lastname.equals(other.lastname))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (updated == null) {
			if (other.updated != null)
				return false;
		} else if (!updated.equals(other.updated))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		if (who == null) {
			if (other.who != null)
				return false;
		} else if (!who.equals(other.who))
			return false;
		return true;
	}

}
