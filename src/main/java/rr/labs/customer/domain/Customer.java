package rr.labs.customer.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.data.cassandra.core.cql.Ordering;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;

/**
 * Classe que representa um cliente
 * 
 * @author regis
 *
 */
public class Customer {

	@PrimaryKeyColumn(name = "id", ordering = Ordering.DESCENDING, ordinal = 0, type = PrimaryKeyType.PARTITIONED)
	private UUID id;

	@Column(value = "email")
	private String email;

	@Column(value = "birthdate")
	private LocalDate birthdate;

	@Column(value = "name")
	private String name;

	@Column(value = "created")
	private LocalDateTime created;

	@Column(value = "modified")
	private LocalDateTime modified;

	/**
	 * @return the id
	 */
	public UUID getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(UUID id) {
		this.id = id;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the birthdate
	 */
	public LocalDate getBirthdate() {
		return birthdate;
	}

	/**
	 * @param birthdate the birthdate to set
	 */
	public void setBirthdate(LocalDate birthdate) {
		this.birthdate = birthdate;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the created
	 */
	public LocalDateTime getCreated() {
		return created;
	}

	/**
	 * @param created the created to set
	 */
	public void setCreated(LocalDateTime created) {
		this.created = created;
	}

	/**
	 * @return the modified
	 */
	public LocalDateTime getModified() {
		return modified;
	}

	/**
	 * @param modified the modified to set
	 */
	public void setModified(LocalDateTime modified) {
		this.modified = modified;
	}

	public Customer() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 */
	public Customer(final String id) {
		this.id = UUID.fromString(id);
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", email=" + email + ", birthdate=" + birthdate + ", name=" + name + ", created="
				+ created + ", modified=" + modified + "]";
	}

}
