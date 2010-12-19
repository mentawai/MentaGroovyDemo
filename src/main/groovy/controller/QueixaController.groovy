package controller;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

import model.Queixa

import org.hsqldb.util.DatabaseManager;
import org.hsqldb.util.DatabaseManagerSwing;
import org.mentawai.groovy.GroovyAction
import org.mentawai.rule.DateRule
import org.mentawai.validation.Validatable
import org.mentawai.validation.Validator

/**
 * Classe para manutenção de Queixas (Controller seria a mesma coisa que Action) 
 * @author Ricardo JL Rufino
 */
class QueixaController extends GroovyAction implements Validatable{
	
	// Injetado via ioc
	def queixaDao;
	def queixaService;
	
	// TODO: setando dependencias manualmente pois ainda nao tem suporte
	// nativo ao AutoWiring do mentawai, só o IoC
	// esse método é chamado automaticamente pelo IoC do mentawai.
	def setQueixaService(queixaService) {
		queixaService.queixaDao = input("queixaDao");
		this.queixaService = queixaService;
		
		if(queixaService.queixaDao.hasProperty("session"))
			queixaService.queixaDao.session = input("session");
	}
	
	public void prepareValidator(Validator val, String action) {
		if(action.equals("salvar")){
			val.requiredFields("Campo obrigatório !", "pessoa", "data", "resumo");
			val.add("data", DateRule.getInstance(), "Data Inválida");
		}else if("editar".equals(action) || "excluir".equals(action)){
			if(input("id") == null) addError("Parâmetros Inválidos !!");
		}
	}
	 
	void cadastro(){
		println " -- Executando Cadastro --"; 
		out "lista", queixaService.listarTodos();
	} 
	
	void salvar(){
		println " -- Executando Salvar  --";   
		def queixa = input.getObject(Queixa) // Preenche automaticamente com os dados do formulário
		queixaService.salvar queixa
	}
	
	void excluir(){
		println " -- Executando Excluir  XXX --";
		def queixa = queixaService.carregar(input.getLong("id"));
		queixaService.excluir queixa;  
	}
	
	void editar(){
		println " -- Executando Editar   --";
		def queixa = queixaService.carregar(input.getLong("id"));
		out queixa
	}
}