package br.com.imaster7.socialbooks.app;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import br.com.imaster7.socialbooks.client.LivrosServiceClient;
import br.com.imaster7.socialbooks.domain.Livro;

/*
 * Cap. 4.2 Cliente consumo em java - No cap. 4.3 cria-se o LivrosServiceClient
 */
public class AppInsereLivro {

	public static void main(String[] args) throws ParseException {
		
		LivrosServiceClient cliente = new LivrosServiceClient("http://localhost:8080", "algaworks", "s3nh4");
		
		Livro livro = new Livro();
		livro.setNome("Git passo-a-passo");
		livro.setEditora("AlgaWorks");
		
		SimpleDateFormat publicacao = new SimpleDateFormat("dd/MM/yyyy");
		livro.setDataPublicacao( publicacao.parse("01/01/2016") );
		
		livro.setResumo("este livro aborda tecnicas de desenvolvimento de APIs.");
		
		String localizacao = cliente.salvar(livro);
		
		System.out.println("URI do livro salvo: " + localizacao);
		
	}
	
}
