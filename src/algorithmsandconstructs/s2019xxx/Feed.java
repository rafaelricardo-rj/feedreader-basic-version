package algorithmsandconstructs.s2019xxx;

import algorithmsandconstructs.FeedInterface;
import algorithmsandconstructs.FeedItem;

import java.util.*;

public class Feed implements FeedInterface {

    private List<FeedItem> feeds = new ArrayList<FeedItem>();

    public Feed(){ }

    @Override
    public void addItem(FeedItem item) {

        this.feeds.add(item);
    }

    @Override
    public Collection<String> listTitles() {
        List<String> titles = new ArrayList<String>();
        for (int i = 0; i < this.feeds.size(); i++) {
            titles.add(this.feeds.get(i).getTitle());
        }
        return titles;
    }

    @Override
    public FeedItem getItem(String title) {

        for (int i = 0; i < this.feeds.size(); i++) {
            if(this.feeds.get(i).getTitle().toLowerCase().equals(title.toLowerCase())){
                return this.feeds.get(i);
            }
        }
        return null;
    }

    @Override
    public int numItems() {

        return this.feeds.size();
    }

    @Override
    public Collection<FeedItem> findItems(String keyword) {
        List<FeedItem> resultFilter = new ArrayList<FeedItem>();
        for (int i = 0; i < this.feeds.size(); i++) {
            if(this.feeds.get(i).getTitle().contains(keyword) || this.feeds.get(i).getContent().contains(keyword)){
                resultFilter.add(this.feeds.get(i));
            }
        }
        return resultFilter;
    }

}
