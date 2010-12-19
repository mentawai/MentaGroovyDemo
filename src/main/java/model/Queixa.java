package model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Entity
public class Queixa {
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	private String pessoa;
	
	private String resumo;
	
	private Date data;
	
	public void setPessoa(String pessoa) {
		this.pessoa = pessoa;
	}
	
	public String getPessoa() {
		return pessoa;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getResumo() {
		return resumo;
	}

	public void setResumo(String resumo) {
		this.resumo = resumo;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}
	
	
	@Override
	public String toString() {
		return "{id="+id+", pessoa="+pessoa+", data="+data+"}";
	}
	
}
