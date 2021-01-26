
public class Pessoa {

	private String nome;
	private String sobrenome;
	private String signo;
	private String cpf;
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSobrenome() {
		return sobrenome;
	}
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	public String getSigno() {
		return signo;
	}
	public void setSigno(String signo) {
		this.signo = signo;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	
	//verificar se o json leu certinho
	public String toString() {
		return "Pessoa{"+"nome=" + nome +", sobrenome" + sobrenome +", signo=" +  signo +", cpf=" + cpf +'}';
	}
	
}
