package com.example.TablePerConcreteClassExample.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.TablePerConcreteClassExample.interfacesdao.IEmployerDAO;
import com.example.TablePerConcreteClassExample.model.Employer;
import com.example.TablePerConcreteClassExample.model.SalariedEmployer;


@Service
public class EmployerService {
	
	@Autowired
	private IEmployerDAO iEmployerDAO;
	
	public ResponseEntity<?> saveEmployer(int empNo, String eName, double annualSalary){
		
		/*
		 * Observação 1 - Se for Employer employer = new SalariedEmployer() com o construtor feito por voce(com parametros)
		 * ou com o construtor default, e fizer save(employer),
		 * ele salva como type=SalariedEmployer 
		 * 
		 */
		
		/*
		 *Observação 2 - Mesmo se a super classe(nesse caso, employer) for a observação 1 também funciona.
		 *Só lembresse de tirar o DiscriminatorValue,  pois não faz sentido porque não é possivel instanciar.
		 */
		
		/*
		 * Observação 5 - MUITO CUIDADO, esse tipo de strategy, coloca os atributos da subclasse not null.
		 * É possivel alterar fazendo @Column(nullable=true) em cima do atributo desejado.
		 */
		
		/*
		 * Observação 6 - Esse tipo de strategy é para quando tiver uma classe abstrata e não quiser que a classe abstrata
		 * vá para o banco(vire uma tabela no banco).
		 */
		
		/*
		 *Observação 7 (Para essa strategy) - Independente da super classe ser abstrata ou não,
		 *os atributos da super classe vao para a subclasse.
		 *Entretanto se a superclasse não for abstrata, a super classe tambem vai ter uma tabela no banco.
		 *Se a superclasse for abstrata, a super classe não vai ter uma tabela no banco.
		 *Mas em ambos os casos, todos os atributos da super classe vao para a subclasse.  
		 */
		
		/*
		 * Observação 8 (Quando a superclasse não é abstrata) - Quando vc faz Employer employer = new SalariedEmployer(),
		 * é salvo na tabela de SalariedEmployer, mas não na tabela de Employer. Já quando é criado
		 * um objeto do tipo Employer, vai pra tabela de Employer, mas não para tabela de SalariedEmployer,
		 * comprovando que são duas tabelas "separadas".
		 */
		
		/*
		 * Resumo dessa strategy: Só usar quando tiver uma super classe abstrata que não vai ser uma tabela no banco.
		 */
		Employer employer = new SalariedEmployer();
		
		employer.setEmpNo(empNo);
		
		employer.seteName(eName);
				
		iEmployerDAO.save(employer);
		
		return ResponseEntity.ok("Empregado cadastrado com sucesso!");
		
	}
	
	/*
	 * Observação 3 - Traz tambem o objeto do tipo SalariedEmployer, mesmo a referência sendo Employer.
	 */
	
	/*
	 * Observação 4 - É como se lidasse com o objeto inteiro, tanto pra salvar, como para consultar. 
	 */
	public ResponseEntity<Employer> findByEmpNo(int empNo) {
		
		Employer employer = iEmployerDAO.findByEmpNo(empNo);
		return ResponseEntity.ok(employer);
	}
}
