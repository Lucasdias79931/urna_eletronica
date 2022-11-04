/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package votacao;


import bancoVotos.eleitor;
import telas.depFe;
import telas.Presidente;
import telas.Governadores;
import telas.depEstadual;
import telas.Senador;
import bancoVotos.telaRelatorio;
import javax.swing.JOptionPane;

/**
 *
 * @author Fabricio
 */
public class votar {
     public static void main(String[] args) {
        eleitor Eleitor = new eleitor();
        
        telaRelatorio relatorio = new telaRelatorio();
        
        
        boolean existencia=false;//verifica a existência do Eleitor
        String nomeEleitor="";  //Nome do eleitor
        String tituloEleitor=""; //Titulo de Eleitor
        boolean sit=false; //Verifica se o Eleitor já votou
        
        
     
          
           
        
        boolean iniciar=true;
       
        while(iniciar==true){
            
         
            boolean tela=true;
              
            Senador votacao = new Senador();
            depFe deputadoFe =new depFe();
            depEstadual depEstadual = new depEstadual();
            Governadores governadores = new Governadores();
            Presidente presidente = new Presidente();
        
            nomeEleitor=JOptionPane.showInputDialog(null,"Nome do Eleitor","",1);
            tituloEleitor=JOptionPane.showInputDialog(null,"titulo de Eleitor","",1);
        
            existencia=Eleitor.verifica(nomeEleitor, tituloEleitor);
            
          

            if(existencia==false){
               JOptionPane.showMessageDialog(null,"Eleitor Inexistente","",1);
             }else{
            
                   sit=Eleitor.situacao(nomeEleitor,tituloEleitor);
            
                    if(sit==false){
                      /*Confirma se o eleitor realizou a votação 
                        e portanto não poderar repetir a votação
                        futuramente
                        */ 
                      Eleitor.validarVotacao(nomeEleitor);
                      
                      /*voto para senador*/
                        while(tela==true){
                            votacao.setVisible(true);
                            if(votacao.getconcluir()==1){ 
                                tela=false;
                                relatorio.votos("senador", votacao.getsenador(), votacao.getqVotos(), votacao.getqNulo(), votacao.getBranco());
                              
                            }
                            
                        }
                        
                   
                   // voto para Deputado Federal
                        while(tela==false){
                            deputadoFe.setVisible(true);
                            if(deputadoFe.getconcluir()==1){
                                tela=true;
                            }
                        }
                    
                   // voto para Deputado Estadual
                        tela=false;
                        while(tela==false){
                            depEstadual.setVisible(true);
                            if(depEstadual.getconcluir()==1){
                                tela=true;
                            }
                        }
                  
                    //voto para Governador
                        tela=false;
                        while(tela==false){
                            governadores.setVisible(true);
                            if(governadores.getconcluir()==1){
                            tela=true;
                            }
                        }
                    
                   // voto para Presidente
                        tela=false;
                        while(tela==false){
                            presidente.setVisible(true);
                            if(presidente.getconcluir()==1){
                                tela=true;
                               
                            }
                        } 
                     
                    }else{
                        JOptionPane.showMessageDialog(null,"Eleitor já Efetuo a Votação","",1);
                    }
        
            }
        if(Eleitor.verificaSituacoes()==true){
            iniciar=false;
        }
    }
     int rela=JOptionPane.showConfirmDialog(null,"YES para ver relatório","Mesário",1);
    if(rela==0){
        relatorio.exibir();
        relatorio.setVisible(true);
    }
    }
}
