package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
/*de "strInstructionsIT":
"<receita em italiano "

até "strInstructionsZH-HANS"
*/

public class arquivoController implements IArquivosController {

	public arquivoController() {
		super();
	}

	@Override
	public void carregaReceita() throws IOException {

		String so = os();

		if (so.contains("Windows")) {
			String caminho = "C:" + File.separator + "TEMP" + File.separator + "marg.json";
			listaReceitas(caminho);
		}
		if (so.contains("Linux")) {
			String caminho = File.separator + "tmp";
			listaReceitas(caminho);
		}

	}

	private String os() {
		String so = System.getProperty("os.name");
		return so;
	}

	private void listaReceitas(String caminho) throws IOException {

		File arquivo = new File(caminho);

		BufferedReader br = new BufferedReader(new FileReader(arquivo));

		String linha = br.readLine();
		verificaLinha(linha);
		

		br.close();
	}

	private void verificaLinha(String linha) {

		String[] vetLinha = linha.split("strInstructionsIT");

		for (String frase : vetLinha) {
			if (frase.contains("strInstructionsZH-HANS")) {
				String[] receita = frase.split("strInstructionsZH-HANS");
				String textoLimpo = receita[0].replaceAll("[:,\"]", "") // Substitui ":" e aspas po nada(remove)
						.replace("\\r\\n", "\n") // Substitui \r\n por quebra de linha
						.trim(); // Remove espaços em excesso no início e fim

				// Imprime o texto ajustado
				System.out.printf("%s %n", textoLimpo);
				System.out.println("_______________________________________________________________________________");
			}
		}

	}
}
//}
