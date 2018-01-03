package service;

import java.net.URL;
import java.util.Scanner;

import javafx.concurrent.Service;
import javafx.concurrent.Task;

public class URLService extends Service<String>{

	private String urlStr;

	
	
	@Override
	protected Task<String> createTask() {
		Task<String> task = new Task<String>() {

			@Override
			protected String call() throws Exception {
				URL url = new URL(urlStr);
				StringBuilder sb = new StringBuilder();
				Scanner sc = new Scanner(url.openStream());
				while (sc.hasNextLine()) {
					String line = sc.nextLine();
					sb.append(line+System.getProperty("line.separator"));
					//updateProgress(workDone, max);
				}
				sc.close();
				
			
				return sb.toString();  // value -> valueProperty()
			}
		};
		
		return task;
	}

	public String getUrlStr() {
		return urlStr;
	}

	public void setUrlStr(String urlStr) {
		this.urlStr = urlStr;
	}

	

}
