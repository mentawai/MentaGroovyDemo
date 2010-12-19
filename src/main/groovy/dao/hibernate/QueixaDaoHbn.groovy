package dao.hibernate;

import model.Queixa;

import org.hibernate.Session


public class QueixaDaoHbn  {
	
	private Session session;
	
	def setSession(Session session) {
		this.session = session;
	}
	
	def salvar(queixa){
		session.saveOrUpdate(queixa);
	}

	def atualizar(queixa){
		session.update(queixa);
	}
	
	def excluir(queixa){
		session.delete(queixa);
	}
	
	def carregar(id){
		session.get(Queixa, id)
	}
	
	def List listarTodos(){
		session.createCriteria(Queixa).list();
	}
}
