package weibo4j.examples.timeline;

import java.util.ArrayList;
import java.util.List;

import weibo4j.Timeline;
import weibo4j.examples.oauth2.Log;
import weibo4j.model.Status;
import weibo4j.model.StatusWapper;
import weibo4j.model.WeiboException;

public class GetUserTimeline {

	public static void main(String[] args) {
		String access_token ="2.00bLmXEC0jj7ewd4b95c8a5f8hYh4E";
		Timeline tm = new Timeline();
		tm.client.setToken(access_token);
		try {
			StatusWapper status = tm.getUserTimeline();
			for(Status s : status.getStatuses()){
				Log.logInfo(s.toString());
				List<String>  pic_urls=new ArrayList<String>();
				pic_urls=s.getPic_urls();
				System.out.println("size:"+  pic_urls.size());
				for(int i=0;i<pic_urls.size();i++){
					System.out.println(pic_urls.get(i));
					
					
				}
			}
			System.out.println(status.getNextCursor());
			System.out.println(status.getPreviousCursor());
			System.out.println(status.getTotalNumber());
			System.out.println(status.getHasvisible());
		} catch (WeiboException e) {
			e.printStackTrace();
		}
	}

}
