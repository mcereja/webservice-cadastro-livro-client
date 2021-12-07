package br.com.imaster7.socialbooks.app;

import java.text.ParseException;

import br.com.imaster7.socialbooks.client.LivrosServiceClient;
import br.com.imaster7.socialbooks.domain.Livro;

public class AppConsultaLivroEspecifico {

public static void main(String[] args) throws ParseException {
		
		LivrosServiceClient cliente = new LivrosServiceClient("http://localhost:8080", "algaworks", "s3nh4");
		
		//obs. como arg do metodo buscar, se passa o retorno da var localização do AppInsereLivro
		//   nesse caso passei fixo
		Livro livroBuscado = cliente.buscar("http://localhost:8080/livros/3");
		
		System.out.println("Livro buscado: " + livroBuscado.getNome());
		
	}

}
