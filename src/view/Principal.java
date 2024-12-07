package view;

import java.io.IOException;

import controller.IArquivosController;
import controller.arquivoController;

/*de "strInstructionsIT":
"<receita em italiano "

até "strInstructionsZH-HANS"
*/

public class Principal {

	public static void main(String[] args) {

		IArquivosController arqCont=new arquivoController();
		
		try {
			arqCont.carregaReceita();
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
		
	}

}
