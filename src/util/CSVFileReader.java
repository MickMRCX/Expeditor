package util;

	import java.io.FileReader;
import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.apache.commons.csv.CSVFormat;
	import org.apache.commons.csv.CSVParser;
	import org.apache.commons.csv.CSVRecord;

import dal.IArticleDAL;
import dal.impl.ArticleDAL;
import dal.impl.DALFactory;
import model.Article;
import model.Commande;
import model.Etats;

public class CSVFileReader {
	
	private static final String COMMANDE_DATE = "Date de Commande";
	private static final String COMMANDE_NUMERO = "Numéro de commande";
	private static final String COMMANDE_CLIENT = "Nom client";
	private static final String COMMANDE_ADRESSE = "Adresse";
	private static final String COMMANDE_ARTICLES = "Articles commandés";
	
	private static final String [] FILE_HEADER_MAPPING = {COMMANDE_DATE, COMMANDE_NUMERO, COMMANDE_CLIENT, COMMANDE_ADRESSE, COMMANDE_ARTICLES};
	
	public static void readCsvFile(String fileName){
		CSVFormat csvFileFormat = CSVFormat.DEFAULT.withHeader(FILE_HEADER_MAPPING);
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy kk:mm:ss");
		List commandes = new ArrayList();
		CSVParser csvFileParser = null;
		FileReader fileReader = null;
		
		try{
			
			
			fileReader = new FileReader(fileName);
			
			csvFileParser  = new CSVParser(fileReader,csvFileFormat);
			
			List csvRecords = csvFileParser.getRecords();
			
			for(int inc = 1; inc < csvRecords.size(); inc++){
				CSVRecord record = (CSVRecord) csvRecords.get(inc);
				
				Date date = (Date) df.parse(record.get(COMMANDE_DATE));
				String numero = record.get(COMMANDE_NUMERO);
				String client = record.get(COMMANDE_CLIENT);
				String adresse = record.get(COMMANDE_ADRESSE);
				String articles = record.get(COMMANDE_ARTICLES);
				
				SuperParser2000 commande = new SuperParser2000(date, numero, client, adresse, articles);
				commandes.add(commande);
			}
		}catch(Exception e){
			System.out.println("Erreur in CsvFileReader.");
			e.printStackTrace();
		}finally{
			try{ 
				fileReader.close();
				csvFileParser.close();
			}catch(IOException e){
				System.out.println("Erreur lors de la fermeture de fileReader/csvFileParser.");
				e.printStackTrace();
			}
		}
		
		List<Article> articlesList = new ArrayList<Article>();
		IArticleDAL articleDAL = DALFactory.getArticleDAL();
		
		for(int inc = 0; inc < commandes.size(); inc++){
			SuperParser2000 cmd = (SuperParser2000) commandes.get(inc);
			String articles = cmd.getArticles();
			
			String[] arts = articles.split(";");
			
			for(int incb = 0; incb < arts.length; incb++){
				String[] art = arts[incb].split(" ");;
				
				String articleName = art[0].trim();
				int articleQte = Integer.parseInt(art[1].replace("(", " ").replace(")", " ").trim());
				
				articleDAL.getOneByLibelle(articleName);
			}
			
			Commande commande = new Commande(cmd.getDate(), cmd.getNom(), cmd.getAdresse(), Etats.AFFECTABLE, )
			
		}
		
	}
}
