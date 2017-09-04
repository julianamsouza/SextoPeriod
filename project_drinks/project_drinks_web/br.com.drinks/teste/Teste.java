package teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dados.DAOFactory;
import model.Cliente;
import model.Estabelecimento;

public class Teste {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = null;
		EntityManager em = null;
		
		
		
		//INSERT INTO (codigo, razaoSocial, nomeFantasia, eMail, senha, cnpj, Endereco, latiutude, logitude )
		Estabelecimento estabelecimento = new Estabelecimento(
				null, "SuperAdmin", "Admin", "admin@admin.com.br", "admin321", "19291136000126", null, "", "");
		
		
		Cliente cliente = new Cliente(null, "Silvio","engenheirocedrim@gmail.com", "81999898989", "123456789");
		
			try {
				emf = Persistence.createEntityManagerFactory("drinks");
				em = emf.createEntityManager();
				
//				daoEstabelecimento = new DaoEstabelecimento(em);
				DAOFactory.getClienteDAO().inserir(cliente);				
				
			} catch (Exception e) {
				e.printStackTrace();
			} 
			
			if (em != null){
				em.close();
			} 
			if (emf != null){
				emf.close();
		}		
		
	}

}
