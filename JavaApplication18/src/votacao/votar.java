/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package votacao;

import mesario.mesarioPrincipal;
import mesario.inserirDados;
import mesario.mesarioSec;
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
        
        
        Senador senado = new Senador();
        depFe deputadoFe =new depFe();
        depEstadual depEstadual = new depEstadual();
        Governadores governadores = new Governadores();
        Presidente presidente = new Presidente();
        
        telaRelatorio relatorio = new telaRelatorio();
        mesarioPrincipal mesario = new mesarioPrincipal();
        mesarioSec mesaSec = new mesarioSec();
        
        boolean existencia=false;//verifica a existência do Eleitor
        String nomeEleitor="";  //Nome do eleitor
        String tituloEleitor=""; //Titulo de Eleitor
        boolean sit=false; //Verifica se o Eleitor já votou
        
        
     
          
           
        
        boolean iniciar=true;
       
        while(iniciar==true){
            
         
            boolean tela=true;
              
            while(tela=true){
                mesario.setVisible(true);
                
                if(mesario.getSair()==true){
                    iniciar=false;
                    break;
                }
                
                if(mesario.getVotar()==true){
                   break;
                }
                
                
            }
           
            tela=true;
            
             while(tela==true&&mesario.getSair()==false){
                nomeEleitor=JOptionPane.showInputDialog(null,"Nome do Eleitor","",1);
                tituloEleitor=JOptionPane.showInputDialog(null,"titulo de Eleitor","",1);
        
                existencia=Eleitor.verifica(nomeEleitor, tituloEleitor);
                tela=false;
            }
            
          

            if(existencia==false&&tela==false){
               JOptionPane.showMessageDialog(null,"Eleitor Inexistente","",1);
             }else if(tela==false){
            
                   sit=Eleitor.situacao(nomeEleitor,tituloEleitor);
            
                    if(sit==false){
                      /*Confirma se o eleitor realizou a votação 
                        e portanto não poderar repetir a votação
                        futuramente
                        */ 
                      Eleitor.validarVotacao(nomeEleitor);
                      
                      /*voto para senador*/
                        while(tela==true){
                            senado.setVisible(true);
                            if(senado.getconcluir()==1){ 
                                tela=false;
                              
                            }
                            
                        }
                        senado.inicializar2(); //reseta alguns atributos da tela
                        
                   
                   // voto para Deputado Federal
                        while(tela==false){
                            deputadoFe.setVisible(true);
                            if(deputadoFe.getconcluir()==1){
                                tela=true;
                            }
                        }
                        deputadoFe.inicializar2(); //reseta alguns atributos da tela
                    
                   // voto para Deputado Estadual
                        tela=false;
                        while(tela==false){
                            depEstadual.setVisible(true);
                            if(depEstadual.getconcluir()==1){
                                tela=true;
                            }
                        }
                        depEstadual.inicializar2(); //reseta alguns atributos da tela
                     
                    //voto para Governador
                        tela=false;
                        while(tela==false){
                            governadores.setVisible(true);
                            if(governadores.getconcluir()==1){
                            tela=true;
                            }
                        }
                        governadores.inicializar2(); //reseta alguns atributos da tela
                    
                   // voto para Presidente
                        tela=false;
                        while(tela==false){
                            presidente.setVisible(true);
                            if(presidente.getconcluir()==1){
                                tela=true;
                               
                            }
                        } 
                        presidente.inicializar2(); //reseta alguns atributos da tela
                        
                        mesario.reset();
                     
                     
                    }else{
                        JOptionPane.showMessageDialog(null,"Eleitor já Efetuo a Votação","",1);
                    }
        
            }
        
    }
    
    
    relatorio.votos("senador", senado.getsenador(), senado.getqVotos(), senado.getqNulo(), senado.getBranco());
    relatorio.votos("presidente",presidente.getpresidente(),presidente.getqVotos(),presidente.getqNulo(),presidente.getBranco());
    relatorio.votos("deputadoFe", deputadoFe.getDeputadoFe(), deputadoFe.getqVotos(), deputadoFe.getqNulo(), deputadoFe.getBranco());
    relatorio.votos("deputadoEs",depEstadual.getDeputadoEs(),depEstadual.getqVotos(),depEstadual.getqNulo(),depEstadual.getBranco());
    relatorio.votos("governador", governadores.getGovernador(), governadores.getqVotos(), governadores.getqNulo(), governadores.getBranco());

    boolean mesaSecundaria=true;
    
    while(mesaSecundaria=true){
        relatorio.exibir();
        mesaSec.setVisible(true);
        
        if(mesaSec.getRelatorio()==true){
           mesaSec.reset();
           boolean rela=true;
           while(rela==true){
               relatorio.setVisible(true);
               if(relatorio.getSair()==true){
                   rela=false;
                   
               }
           }
        }
        
    }
   
    
    }
}
