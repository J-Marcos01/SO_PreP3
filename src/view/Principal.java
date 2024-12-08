package view;

import java.io.FileNotFoundException;
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
        } catch (FileNotFoundException e) {
            System.err.println("Erro: O arquivo necessário não foi encontrado.");
            System.err.println("Detalhes: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Erro de I/O ao tentar carregar a receita.");
            System.err.println("Detalhes: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Erro inesperado.");
            System.err.println("Detalhes: " + e.getMessage());
        }

}
}