
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import algorithmsandconstructs.FeedFactoryInterface;
import algorithmsandconstructs.FeedInterface;
import algorithmsandconstructs.FeedItem;
// Modify this to match your package
import algorithmsandconstructs.s2019xxx.FeedFactory;

public class FeedReader {
	
	public static void main(String[] args) throws IOException {

		// This will produce an error until you create your own class
		// FeedFactory and fix the import at line 7 
		FeedFactoryInterface factory = new FeedFactory();

		String file = "test.rss";
		BufferedReader in = new BufferedReader(new FileReader(file));

		FeedInterface feed = factory.createFeed(in);

		System.out.println("=== News items ===");

		for(String title : feed.listTitles()) {
			System.out.println(title);
		}

		/* descomente as tres linhas abaixo para testar os metodos implementados.
		 eu nao sei se e para mandar esses metodos para o professor pois na documentacao
		 diz que so devemos escrever as classes Feed.java e FeedFactory.java, como esse arquivo e a classe FeedReader
		 provida por ele, nao sei se pode escrever aqui. De qual quer forma criei esses metodos aqui para testar
		 se todas as implementacoes estavam funcionando. Voce decide remove eles ou nao antes de submeter o projeto.
		 caso decida manter esses metodos de teste, recomento trocar os nomes das variaveis ou ate mesmo alterar
		 a lguma parte da logica para poder diferenciar dos demais, lembrando sempe de testar novamente para saber
		 se os resuldatos continuam os mesmos. Se nao for enviar esses metodos, preferindo manter essa classe exatamente
		 a mesma que o professor proveu, basta apagar as tres linhas a seguir e o proximos 3 methodos privados.
		 */
		searchFeedByTitle(feed, "breaking news");
		searchFeedByKeyword(feed, "less");
		showTotalNews(feed);

	}

	private static void searchFeedByTitle(FeedInterface feedslist, String title){
		FeedItem result = feedslist.getItem(title);
		System.out.println("\nSearching: "+ title);
		if(result != null){
			System.out.println("1 record found:");
			System.out.println("Title: "+result.getTitle());
			System.out.println("Content: "+result.getContent());
		} else {
			System.out.println("Not Found.\n");
		}
	}

	private static void searchFeedByKeyword(FeedInterface feedslist, String keyword){

		List<FeedItem> feedItems = (List<FeedItem>) feedslist.findItems(keyword);
		System.out.println("\nSearching feeds. Keyword: "+keyword);
		if(!feedItems.isEmpty()){
			System.out.println(feedItems.size()+" record(s) found: ");
			for (int i = 0; i < feedItems.size(); i++) {
				System.out.println("Title: "+feedItems.get(i).getTitle());
				System.out.println("Content: "+feedItems.get(i).getContent());
			}
		} else {
			System.out.println("0");
		}
	}

	private static void showTotalNews(FeedInterface feeds){
		System.out.println("\nTotal of feeds: "+feeds.numItems());
	}
}
