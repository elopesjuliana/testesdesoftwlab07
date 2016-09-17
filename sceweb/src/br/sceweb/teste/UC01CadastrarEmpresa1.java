package br.sceweb.teste;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.sceweb.modelo.Empresa;
import br.sceweb.modelo.EmpresaDAO;

public class UC01CadastrarEmpresa1 {

	static Empresa empresa;
	static EmpresaDAO empresaDAO;
	
	//estabelece as pre condições de teste
	//@Before //o que eu preciso ter antes de eu testar
	@BeforeClass //executa o que é comum pata tds os testes
	public static void setUpBeforeClass() throws Exception {
		empresaDAO = new EmpresaDAO();
		empresa = new Empresa();
		empresa.setNomeDaEmpresa("empresa x");
		empresa.setCnpj("89424232000180");
		empresa.setNomeFantasia("empresa x");
		empresa.setEndereco("rua taquari");
		empresa.setTelefone("2222");
	}
	
	@Before // antes de qualquer teste
	public void excluiCNPJ(){
		empresaDAO.exclui("89424232000180");
	}

	@AfterClass //como deve ficar o ambiente depois de eu testar
	public static void tearDownAfterClass() throws Exception {
		
		
	}
/*Verificar comportamento do sistema na inclusão de uma empresa com sucesso */
	@Test
	public void CT01UC01FBCadastrarEmpresa_com_sucesso() {
		assertEquals(1, empresaDAO.adiciona(empresa));
	}
	
	/*Verificar comportamento do sistema na inclusão de uma empresa com cnpj inválido */
	@Test (expected=RuntimeException.class)
	public void CT01UC01FBCadastrarEmpresa_com_cnpj_invalido() {
		empresaDAO.adiciona(empresa);
		//empresaDAO.adiciona(empresa);
	}

}
