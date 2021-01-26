package programajSon;

import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONObject;

public class Main {

	public static void main(String[] args) {
		
		FileWriter writeFile = null;
		JSONObject objetoJson = new JSONObject();
		
		objetoJson.put("nome", "Jackson");
		objetoJson.put("sobrenome", "Santos");
		objetoJson.put("cpf", "123.456.789-10");
		objetoJson.put("signo", "Cancer");
		
		try {
			//escreve dentro do arquivo e fecha
			writeFile = new FileWriter("dados_importante.json");
			writeFile.write(objetoJson.toJSONString());
			writeFile.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(objetoJson.toJSONString());
		
	}
}
