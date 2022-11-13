/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bancoVotos;

import javax.swing.JOptionPane;

/**
 *
 * @author Fabricio
 */
public class eleitor {
    private String[] nomeEleitor = new String[5];
    private String[] tituloEleitor = new String[5];
    private boolean[] situacao = new boolean[5];

    public eleitor(){
        
        
        tituloEleitor[0]="123456789101";
        tituloEleitor[1]="516846513215";
        tituloEleitor[2]="651521681312";
        tituloEleitor[3]="465121516151";
        tituloEleitor[4]="651841965155";
        
        for(int i=0;i<5;i++){
            situacao[i]=false;
        }
       
      
    }
    
    public boolean verifica(String titulo){
       boolean test=false;
        for(int i=0;i<5;i++){
            if(titulo.equals(tituloEleitor[i])){
                
                test=true;
            }
        }
        return test;
    }
    
    public void validarVotacao(String titulo){
        for(int i=0;i<5;i++){
            if(titulo.equals(tituloEleitor[i])){
                situacao[i]=true;
            }
        }
    }
    //verificar se o eleitor já votou
    public boolean situacao(String titulo){
       
        boolean test=false;
        
        for(int i=0;i<5;i++){
            if(titulo.equals(tituloEleitor[i])){
                test=situacao[i];
            }
        }
        return test;
    }
    
    /*
    public boolean verificaSituacoes(){
        int w=0;
        boolean j=false;
        for(int i=0;i<situacao.length;i++){
            if(situacao[i]==true){
                w++;
            }
        }
        
        if(w==situacao.length){
            j=true;
        }
        
        return j;
    }
*/
}
