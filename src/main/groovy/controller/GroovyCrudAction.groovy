package controller;
import org.mentawai.core.BaseAction;

abstract class GroovyCrudAction extends BaseAction{
	def abstract salvar();
	def cadastro() { return SUCCESS }
	def editar() { return SUCCESS }
	def listar() { return SUCCESS }
	def buscar() { return SUCCESS }
}