package modelos;


public class Usuario {
 
 private String login;
 private String senha; 
 
 public Usuario( String senha, String login){
 this.senha = senha;
 this.login = login;
 }
 
 public String getLogin() {
 return login;
 }
 public String getSenha(){
 return senha;
 }
 public void setLogin(String login) {
 this.login = login;	 
 }
 public void setSenha(String senha){
 this.senha = senha;
 }
 }