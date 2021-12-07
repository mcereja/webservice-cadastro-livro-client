package br.com.imaster7.socialbooks.client;

import java.net.URI;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;

import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import br.com.imaster7.socialbooks.domain.Livro;

/*
 * Cap. 4.4 - Criou vars URI_BASE, URN_BASE e passou usar obj Base64 do java.utils
 */
public class LivrosServiceClient {

	private RestTemplate restTemplate;
	
	private String URI_BASE;
	private String URN_BASE = "/livros";
	private String credencial;
	
	public LivrosServiceClient(String url, String usuario, String senha) {
		restTemplate = new RestTemplate();
		
		URI_BASE = url.concat(URN_BASE);
		
		String credencialAux = usuario + ":" + senha;
		
		credencial = "Basic " + Base64.getEncoder()
				.encodeToString(credencialAux.getBytes());
	}
	
	public List<Livro> listar() {
		// o Authorization passa a senha base64 "Basic YWxnYXdvcmtzOnMzbmg0" extraida do postman
		//   a obtencao dessa senha criptografada esta nos cap. 4.1 e 3.2
		RequestEntity<Void> request = RequestEntity
				.get(URI.create(URI_BASE))
				.header("Authorization", credencial).build();
		
		ResponseEntity<Livro[]> response = restTemplate.exchange(request, Livro[].class);
		
		return Arrays.asList(response.getBody());
	}
	
	public String salvar(Livro livro) {
		RequestEntity<Livro> request = RequestEntity
				.post(URI.create(URI_BASE))
				.header("Authorization", credencial)
				.body(livro);
		
		ResponseEntity<Void> response = restTemplate.exchange(request, Void.class);
		
		return response.getHeaders().getLocation().toString();
	}
	
	public Livro buscar(String uri) {
		RequestEntity<Void> request = RequestEntity
				.get(URI.create(uri))
				.header("Authorization", credencial)
				.build();
		
		ResponseEntity<Livro> response = restTemplate.exchange(request, Livro.class);
		
		return response.getBody();
	}
	
}
