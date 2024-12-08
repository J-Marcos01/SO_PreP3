package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class arquivoController implements IArquivosController {

	public arquivoController() {
		super();
	}

	@Override
	public void carregaReceita() throws IOException {

		String so = os();

		if (so.contains("Windows")) {
			String caminho = "C:" + File.separator + "TEMP" + File.separator + "marg.json";
			carregaReceitas(caminho);
		}

		if (so.contains("Linux")) {
			String caminho = File.separator + "tmp" + File.separator + "marg.json";
			carregaReceitas(caminho);
		}
	}

	private String os() {
		String so = System.getProperty("os.name");
		return so;
	}

	private void carregaReceitas(String caminho) throws IOException {

		File arquivo = new File(caminho);

		if (!arquivo.exists() || !arquivo.isFile()) {
			throw new FileNotFoundException("Arquivo não encontrado: " + caminho);
		}

		BufferedReader br = new BufferedReader(new FileReader(arquivo));

		String linha = br.readLine();

		while (linha != null) {
			carregaReceitasIt(linha);
			linha = br.readLine();
		}
		br.close();
	}

	private void carregaReceitasIt(String linha) throws IOException {

		String[] vetLinha = linha.split("strInstructionsIT");

		for (String frase : vetLinha) {
		
			
			if (frase.contains("strInstructionsZH-HANS")) {
			
				
				String[] receita = frase.split("strInstructionsZH-HANS");
				String receitaLimpa = receita[0].replaceAll("[:,\"]", "") // Substitui ":" e aspas po nada(remove)
						.replace("\\r\\n", "\n") // Substitui \r\n por quebra de linha
						.trim(); // Remove espaços em excesso no início e fim

       //				 Imprime o texto ajustado
				System.out.println(receitaLimpa);

				System.out.println("_______________________________________________________________________________________________________");
			}
		}

	}
}

