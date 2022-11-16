/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package votacao;

import mesario.mesarioPrincipal;
import mesario.inserirDados;
import mesario.mesarioSec;
import mesario.eleitorSituacao;

import bancoVotos.eleitor;
import bancoVotos.telaRelatorio;

import telas.depFe;
import telas.Presidente;
import telas.Governadores;
import telas.depEstadual;
import telas.Senador;


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
        eleitorSituacao eleitorSit = new eleitorSituacao();
        mesarioSec mesaSec = new mesarioSec();
        inserirDados dadosEleitor = new inserirDados();
        
        boolean existencia=false;//verifica a existência do Eleitor
        String tituloEleitor=""; //Titulo de Eleitor
        boolean sit=false; //Verifica se o Eleitor já votou
        
        
     
          
           
        
        boolean iniciarPrincipal=true;
        
        
        while(iniciarPrincipal==true){
            
            boolean iniciarSec=false;
            boolean tela=true;
              
            while(tela==true){
                mesario.setVisible(true);
                
                if(mesario.getSair()==true){
                    iniciarPrincipal=false;
                    tela=false;
                }
                
                if(mesario.getVotar()==true){
                   tela=false;
                   iniciarSec=true;
                }
                
                
            }
            mesario.reset();
            tela=true;
            
             while(tela==true&&iniciarSec==true){
                
                while(tela==true){
                    dadosEleitor.setVisible(true);
                    if(dadosEleitor.getFinalizar()==true){
                        tela=false;
                    }
                }
                tituloEleitor=dadosEleitor.getTitulo();
                existencia=Eleitor.verifica(tituloEleitor);
                
            }
             dadosEleitor.resetarTela();
             tela=true;
            
          

            if(existencia==false&&iniciarSec==true){
               eleitorSit.sitEleitor("nao existe");
               while(tela==true){
                   eleitorSit.setVisible(true);
                   if(eleitorSit.getSair()==true){
                       tela=false;
                       
                   }
               }
               eleitorSit.reset();
               tela=false;
             }else if(existencia==true&&iniciarSec==true){
            
                   sit=Eleitor.situacao(tituloEleitor);
            
                    if(sit==false){
                      /*Confirma se o eleitor realizou a votação 
                        e portanto não poderar repetir a votação
                        futuramente
                        */ 
                      Eleitor.validarVotacao(tituloEleitor);
                      
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
                        eleitorSit.sitEleitor("Ja votou");
                        while(tela==true){
                           eleitorSit.setVisible(true);
                            if(eleitorSit.getSair()==true){
                              tela=false;
                             }
                        }
                         eleitorSit.reset();
                         tela=true;
                    }
        
            }
        
    }
    
    
    relatorio.votos("senador", senado.getsenador(), senado.getqVotos(), senado.getBranco(),senado.getqNulo());
    relatorio.votos("presidente",presidente.getpresidente(),presidente.getqVotos(),presidente.getBranco(),presidente.getqNulo());
    relatorio.votos("deputadoFe", deputadoFe.getDeputadoFe(), deputadoFe.getqVotos(), deputadoFe.getBranco(), deputadoFe.getqNulo());
    relatorio.votos("deputadoEs",depEstadual.getDeputadoEs(),depEstadual.getqVotos(),depEstadual.getBranco(),depEstadual.getqNulo());
    relatorio.votos("governador", governadores.getGovernador(), governadores.getqVotos(), governadores.getBranco(), governadores.getqNulo());

    boolean mesaSecundaria=true;
   
    while(mesaSecundaria==true){
        relatorio.exibir(); //Atualiza a tela de relatório
        relatorio.sairReset();
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
