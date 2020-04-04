package algorithmsandconstructs.s2019xxx;

import algorithmsandconstructs.FeedFactoryInterface;
import algorithmsandconstructs.FeedInterface;
import algorithmsandconstructs.FeedItem;

import java.io.BufferedReader;
import java.io.IOException;

public class FeedFactory implements FeedFactoryInterface {

    public FeedFactory(){ }

    @Override
    public FeedInterface createFeed(BufferedReader in) throws IOException {
        Feed feeds = new Feed();

        String line, title, content;

        while ((line = in.readLine()) != null) {
            title = line;
            content = in.readLine();
            feeds.addItem( new FeedItem(title, content) );
        }
        return feeds;
    }
}
