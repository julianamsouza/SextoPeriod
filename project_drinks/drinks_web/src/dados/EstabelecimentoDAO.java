package dados;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.security.auth.login.LoginException;

import basicas.Estabelecimento;
import dados.genericos.DaoGenerico;

public class EstabelecimentoDAO extends DaoGenerico<Estabelecimento> implements IDaoEstabelecimento {

	public EstabelecimentoDAO(EntityManagerFactory emf) {
		super(emf);
		// TODO Auto-generated constructor stub
	}

	public Estabelecimento efetuarLogin(String eMail, String senha)
			throws LoginException {

		try {
			TypedQuery<Estabelecimento> query = ((EntityManager) getEntityManagerFactory()).createNamedQuery(
					"efetuarLogin", Estabelecimento.class);
			query.setParameter("eMail", eMail);
			query.setParameter("senha", senha);
			return query.getSingleResult();

		} catch (NoResultException noe) {
			System.out.println("Login/Senha Inválidos!");
			throw new LoginException();

		} catch (Exception e) {
			throw new LoginException();
		}

	}	

}