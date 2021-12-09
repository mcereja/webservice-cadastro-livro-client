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
		
		int contaLivro=1;
		LivrosServiceClient cliente = 
				new LivrosServiceClient("http://localhost:8080", "algaworks", "s3nh4");
		
		do {
			Livro livro = new Livro();
			livro.setNome(contaLivro + " Nome Livro " + contaLivro);
			livro.setEditora(contaLivro + "Editora Livro " + contaLivro);
			
			SimpleDateFormat publicacao = new SimpleDateFormat("dd/MM/yyyy");
			livro.setDataPublicacao( publicacao.parse("01/10/2021") );
			
			livro.setResumo(contaLivro + " Resumo Livro " + contaLivro);
			
			String localizacao = cliente.salvar(livro);
			
			System.out.println("URI do livro salvo: " + localizacao);
			
			contaLivro++;
		} while ( contaLivro <= 3 );
		
	}
	
}
