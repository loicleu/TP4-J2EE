/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bowling;

/**
 *
 * @author pedago
 */
public class MultiPlayersGame implements MultiPlayerGame {
        String[] player;
        SinglePlayerGame[] jeu;
        int numjoueur;
	public String startNewGame(String[] playerName){
            if (playerName == null || playerName.length<1){
                throw new UnsupportedOperationException("Il n'y a pas assez de joueur ");
            }
            player = playerName;
            jeu = new SinglePlayerGame[player.length];
            for(int i=0;i<player.length;i++){
                jeu[i]= new SinglePlayerGame();}
                
            
        return "Prochain tir : joueur"+ player[0]+", tour n° 1, boule n° 1";}
	
	public String lancer(int nombreDeQuillesAbattues){
            if(jeu == null){
                throw new UnsupportedOperationException("Le jeu n'a pas commencé");
            }
        jeu[numjoueur].lancer(nombreDeQuillesAbattues);
        
        if(jeu[numjoueur].hasCompletedFrame()){
            if(numjoueur<player.length-1){
                numjoueur+=1;}
            else {
                numjoueur=0;}
        return "Prochain tir : joueur "+ player[numjoueur]+", tour n°"+jeu[numjoueur].getFrameNumber()+", boule n° 1";}
        else{  
        return "Prochain tir : joueur "+ player[numjoueur]+", tour n°"+jeu[numjoueur].getFrameNumber()+", boule n°"+jeu[numjoueur].getNextBallNumber();}}
        
	
	public int scoreFor(String playerName){
        return jeu[search(playerName)].score();}
	

        
        public int search(String playerName){
            int i =0;
            if (player[i]!=playerName ){
                if(i>player.length-1){
                    throw new UnsupportedOperationException("Le joueur n'a pas été trouvé");
                }
                else{
                i++;}}
            return i;}
        }
        



        


