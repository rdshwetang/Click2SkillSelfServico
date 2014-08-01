/* 
 * @author Shwetang R.D 
 * Visual Sistemas Electronicos Ltda.
 * Belo Horizonte-Brazil -2014
 */
package com.dribblelogics.sqlitedb;

public class UserDataManager {
	
	int _id;
    String _name;
    String _sex;
    String _dob;
    String _cep;
    String _endereco;
    String _bairro;
    String _cidade;
    String _estado;
    String _telefone;
    String _celular;
    String _bloqueado;
    String _ativo;
    String _senha;
    String _email;
    String _documentoSecundario;
    String _documentoPrincipal;
    
 // Empty constructor
    public UserDataManager() {
		// TODO Auto-generated constructor stub
	}
         
    // constructor
    public UserDataManager(int id, String name, String sex, String dob, String cep, String endereco, String bairro, String cidade, String estado, String telefone, String celular, String bloqueado, String ativo, String senha, String email,String documentoSecundario, String documentoPrincipal){
        this._id = id;
        this._name = name;
        this._sex = sex;
        this._dob = dob;
        this._cep = cep;
        this._endereco = endereco;
        this._bairro = bairro;
        this._cidade = cidade;
        this._estado = estado;
        this._telefone = telefone;
        this._celular = celular;
        this._bloqueado = bloqueado;
        this._ativo = ativo;
        this._senha = senha;
        this._email = email;
        this._documentoSecundario = documentoSecundario;
        this._documentoPrincipal = documentoPrincipal;
    }
     
    // constructor
    public UserDataManager(String name, String _city_id){
        this._name = name;
    }
    
    public UserDataManager(String name, String sex, String dob, String cep, String endereco, String bairro, String cidade, String estado, String telefone, String celular, String bloqueado, String ativo, String senha, String email,String documentoSecundario, String documentoPrincipal){
        this._name = name;
        this._sex = sex;
        this._dob = dob;
        this._cep = cep;
        this._endereco = endereco;
        this._bairro = bairro;
        this._cidade = cidade;
        this._estado = estado;
        this._telefone = telefone;
        this._celular = celular;
        this._bloqueado = bloqueado;
        this._ativo = ativo;
        this._senha = senha;
        this._email = email;
        this._documentoSecundario = documentoSecundario;
        this._documentoPrincipal = documentoPrincipal;
    }
    
    public int getID(){
        return this._id;
    }
     
    public void setID(int id){
        this._id = id;
    }
     
    public String getName(){
        return this._name;
    }
     
    public void setName(String name){
        this._name = name;
    }
     
    public String getCidade(){
        return this._cidade;
    }
     
    public void setCidade(String city_id){
        this._cidade = city_id;
    }
    
    public String getSex(){
        return this._sex;
    }
     
    public void setSex(String name){
        this._sex = name;
    }
    
    public String getDob(){
        return this._dob;
    }
     
    // setting name
    public void setDob(String name) {
        this._dob = name;
    }
    
    
    public String getCep(){
        return this._cep;
    }
     
    public void setCep(String name){
        this._cep = name;
    }
    
    public String getEndereco(){
        return this._endereco;
    }
     
    // setting name
    public void setEndereco(String name){
        this._endereco = name;
    }
    public String getBairro(){
        return this._bairro;
    }
     
    // setting name
    public void setBairro(String name){
        this._bairro = name;
    }
    public String getEstado(){
        return this._estado;
    }
     
    // setting name
    public void setEstadoe(String name){
        this._estado = name;
    }
    public String getTelefone(){
        return this._telefone;
    }
     
    // setting name
    public void setTelefone(String name){
        this._telefone = name;
    }
    public String getCelular(){
        return this._celular;
    }
     
    // setting name
    public void setCelular(String name){
        this._celular = name;
    }
    
    //--
    
    public String getBoleqado(){
        return this._bloqueado;
    }
     
    // setting name
    public void setBoleqado(String name){
        this._bloqueado = name;
    }
    public String getAtivo(){
        return this._ativo;
    }
     
    // setting name
    public void setAtivo(String name){
        this._ativo = name;
    }
    
    public String getSenha(){
        return this._senha;
    }
     
    // setting name
    public void setSenha(String name){
        this._senha = name;
    }
    public String getEmail(){
        return this._email;
    }
     
    // setting name
    public void setEmail(String name){
        this._email = name;
    }
    public String getDocumentoSecundario(){
        return this._documentoSecundario;
    }
     
    // setting name
    public void setDocumentoSecundario(String name){
        this._documentoSecundario = name;
    }
    public String getDocumentoPrincipal(){
        return this._documentoPrincipal;
    }
     
    // setting name
    public void setDocumentoPrincipal(String name){
        this._documentoPrincipal = name;
    }
}

