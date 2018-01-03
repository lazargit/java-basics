package service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javafx.concurrent.Service;
import javafx.concurrent.Task;

public class ExtractURLService extends Service<List<String>> {

	private String sourceCode;

	@Override
	protected Task<List<String>> createTask() {

		Task<List<String>> task = new Task<List<String>>() {

			@Override
			protected List<String> call() throws Exception {
				return extractUrls(sourceCode);
			}
		};

		return task;
	}

	private List<String> extractUrls(String value) {
		List<String> result = new ArrayList<String>();
		String urlPattern = "((https?|http):((//)|(\\\\))+[\\w\\d:#@%/;$()~_?\\+-=\\\\\\.&]*)";
		Pattern p = Pattern.compile(urlPattern, Pattern.CASE_INSENSITIVE);
		Matcher m = p.matcher(value);
		while (m.find()) {
			if (m.group().matches(".*[^.js][^.css][^.ico]$")) {
				result.add(m.group());
			}

			// result.add(m.group());//z.B. http:domain.de
		}
		return result;
	}

	public String getSourceCode() {
		return sourceCode;
	}

	public void setSourceCode(String sourceCode) {
		this.sourceCode = sourceCode;
	}

}
