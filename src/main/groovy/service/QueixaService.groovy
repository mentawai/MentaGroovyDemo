package service;

import java.util.List;
  
public class QueixaService {
	
	// Injetado via AutoWiring
	def queixaDao;
	
	
	def salvar(queixa){
		queixaDao.salvar(queixa);
	}

	def atualizar(queixa){
		queixaDao.atualizar(queixa);
	}
	
	def excluir(queixa){
		queixaDao.excluir(queixa);
	}
	
	def carregar(id){
		queixaDao.carregar(id)
	}
	
	def List listarTodos(){
		queixaDao.listarTodos();
	}
}
