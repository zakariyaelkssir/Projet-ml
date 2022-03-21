package jscicalc.expression;

import java.io.File;

import jscicalc.graph.Model;

public class test {
	

	public void MaakToernooi(String text, List<Player> startPlayer, TournamentType type) {
		
		
		boolean addSlash = directory.endsWith("/");
		addSlash = directory.endsWith("\\");
		File dir = new File(directory);
		if(!dir.exists()) {
			dir.mkdir();
		}
		
		text = text.replaceAll("/","_").replaceAll("\\\\","_");
		File nieuwToernooiFile = new File(directory + addSlash ? "/" : "") +text);
		
		if(!nieuwToernooiFile.exists()) {
			try {
			nieuwToernooiFile.createNewFile();
			log("Created new file :" + nieuwToernooiFile.getAbsolutePath());
			torenooiFile = nieuwToernooiFile;
			} catch(IOException ex) {
				Logger.getLogger(Model.class.getName().log(Level.SEVERE,null,ex));
				
			}
			initToernooi();
			tournament.setTournamentType(type);
			for(Player player : startPlayer) {
				addPlayer(player);
			}
			saveToernoii();
			
		}else {
			toernooiFile = nieuwToernooiFile;
		}
		
		
	}
	
}
