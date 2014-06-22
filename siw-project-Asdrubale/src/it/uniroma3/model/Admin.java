package it.uniroma3.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;


@Entity
@NamedQueries({ 
    @NamedQuery(name="findAllAdmin", query="select a from Admin a"),
    @NamedQuery(name="findByUsername", query="select a from Admin a where a.username = :paramUsername") 
             })
public class Admin {
	
	@Id 
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	
	@Column(nullable = false, unique = true)
    private String username;
	
    @Column(nullable = false)
    private String password;
    
    public Admin() { }
    
	public Admin(String username, String password) {
		
		this.username = username;
		this.password = password;
		
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public int hashCode() {
		return this.username.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		Admin admin = (Admin) obj;
		return this.username.equals(admin.getUsername());
	}  
	
}


