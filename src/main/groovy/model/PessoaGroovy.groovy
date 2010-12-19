package model;

import java.io.Serializable

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

      
@Entity
public class PessoaGroovy implements Serializable{
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	Long id;
	
	String nome;
	
	public String toString() {
		"Pessoa[nome=$nome]";
	}
}