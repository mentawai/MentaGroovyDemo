package dao.list
import model.Queixa;

public class QueixaDaoList  {
	private static long lastID = 0;
	private static List data = [];
	
	def salvar(bean){
		if(bean != null && bean.id > 0)
			atualizar(bean);
		else{
			def mc= [compare:{a,b -> a.id == b.id? 0: a.id < b.id ? -1: 1}] as Comparator
			def last = data.max(mc);
			bean.id = (last !=null ? last.id + 1 : 1 ) // incrementar id.
			data.add(bean);
		}	 
	}

	def atualizar(bean){
		data[data.findIndexOf{ it.id in bean.id }] = bean
	}
	
	def excluir(bean){ 
		data.remove( data.findIndexOf{ it.id in bean.id } )
	}
	
	def carregar(id){
		return data.find{ it.id == id }
	}
	
	def List listarTodos(){
		return data
	}
}
