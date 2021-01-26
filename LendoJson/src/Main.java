import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.sql.rowset.CachedRowSet;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Main {

	public static void main(String[] args) throws org.json.simple.parser.ParseException {
		
		JSONObject jsonObject;
		JSONParser parser = new JSONParser();
		
		Pessoa pessoa = new Pessoa();
		
		try {
			
			jsonObject = (JSONObject) parser.parse(new FileReader("D:\\Projeto-java\\programajSon\\dados_importante.json"));
			
			pessoa.setNome((String) jsonObject.get("nome"));
			pessoa.setSobrenome((String) jsonObject.get("sobrenome"));
			pessoa.setSigno((String) jsonObject.get("signo"));
			pessoa.setCpf((String) jsonObject.get("cpf"));
			
			System.out.println("PESSOA RECUEPARAD DO jSON = "  + pessoa.toString());
			
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}catch (org.json.simple.parser.ParseException ex) {
			Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}
