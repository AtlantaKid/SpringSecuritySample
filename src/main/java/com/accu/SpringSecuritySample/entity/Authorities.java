package com.accu.SpringSecuritySample.entity;

import java.io.Serializable;
import java.time.ZonedDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

/**
 * @author Anoosh Atari
 * 
 */
@Entity(name = "Authorities")
@Table(name = "authorities")
@JacksonXmlRootElement(localName = "authorities")
public class Authorities implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3L;

	@Id
	// @GeneratedValue(strategy = GenerationType.AUTO)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JacksonXmlProperty(isAttribute = true)
	@Column(name = "id", updatable = false, nullable = false, unique = true)
	private long id;

	@JacksonXmlProperty
	@Column(name = "authority", length = 255, nullable = true)
	private String authority;

	@JacksonXmlProperty
	@Column(name = "username", length = 255, insertable = false, updatable = false)
	private String username;

	@ManyToOne
	@JoinColumn(name = "username", referencedColumnName = "username")
	private Users users;

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

	public Authorities() {

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
	 * @return the authority
	 */
	public String getAuthority() {
		return authority;
	}

	/**
	 * @param authority the authority to set
	 */
	public void setAuthority(String authority) {
		this.authority = authority;
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
	 * @return the users
	 */
	public Users getUsers() {
		return users;
	}

	/**
	 * @param users the users to set
	 */
	public void setUsers(Users users) {
		this.users = users;
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
	 * @param id
	 * @param authority
	 * @param username
	 * @param users
	 * @param created
	 * @param updated
	 * @param who
	 * @param comment
	 */
	public Authorities(long id, String authority, String username, Users users, ZonedDateTime created,
			ZonedDateTime updated, String who, String comment) {
		super();
		this.id = id;
		this.authority = authority;
		this.username = username;
		this.users = users;
		this.created = created;
		this.updated = updated;
		this.who = who;
		this.comment = comment;
	}

	@Override
	public String toString() {
		return "Authorities [id=" + id + ", authority=" + authority + ", username=" + username + ", users=" + users
				+ ", created=" + created + ", updated=" + updated + ", who=" + who + ", comment=" + comment + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((authority == null) ? 0 : authority.hashCode());
		result = prime * result + ((comment == null) ? 0 : comment.hashCode());
		result = prime * result + ((created == null) ? 0 : created.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((updated == null) ? 0 : updated.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		result = prime * result + ((users == null) ? 0 : users.hashCode());
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
		Authorities other = (Authorities) obj;
		if (authority == null) {
			if (other.authority != null)
				return false;
		} else if (!authority.equals(other.authority))
			return false;
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
		if (id != other.id)
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
		if (users == null) {
			if (other.users != null)
				return false;
		} else if (!users.equals(other.users))
			return false;
		if (who == null) {
			if (other.who != null)
				return false;
		} else if (!who.equals(other.who))
			return false;
		return true;
	}

}
