package br.com.imaster7.socialbooks.app;

import java.text.ParseException;
import java.util.List;

import br.com.imaster7.socialbooks.client.LivrosServiceClient;
import br.com.imaster7.socialbooks.domain.Livro;

public class AppConsultaLivro {

public static void main(String[] args) throws ParseException {
		
		LivrosServiceClient cliente = new LivrosServiceClient("http://localhost:8080", "algaworks", "s3nh4");
		
		List<Livro> listaLivros = cliente.listar();
		
		for(Livro livro : listaLivros) {
			System.out.println("Livro: " + livro.getId() + " - " +  livro.getNome());
		}
		
	}

}
