package executavel;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import exception.ExecaoProcessarNota;

public class Main {
	public static void main(String[] args) throws ExecaoProcessarNota {
	
		try {
			File f = new File("c://file.txt");
			Scanner s = new Scanner(f);
		}catch(FileNotFoundException e) {
			throw new ExecaoProcessarNota("excecao ao processar nota");
			
		}
		
		
	}
}
