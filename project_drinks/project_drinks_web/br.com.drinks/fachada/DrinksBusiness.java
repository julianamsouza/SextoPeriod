package fachada;

import dados.DAOFactory;
import model.Cliente;

public class DrinksBusiness implements IFachada{
	
	private static DrinksBusiness instancia;
	
	public static DrinksBusiness getInstancia(){
		if(instancia == null){
			instancia = new DrinksBusiness();
		}
		return instancia;
	}
	
	public void inserirCliente(Cliente entidade){
		DAOFactory.getClienteDAO().inserir(entidade);
	}

}
