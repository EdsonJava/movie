package br.com.santos.movie.adapter.infra;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReadFileUtils {

	public static List<List<String>> readFileCsv(String fileName) {
		
		BufferedReader br = null;
		String line = "";
		String csvSeparator = ";";
		
		List<List<String>> list = new ArrayList<List<String>>();
		
		try {
			br = new BufferedReader(new FileReader(fileName));
			while ((line = br.readLine()) != null) {
				String[] columns = line.split(csvSeparator);
				list.add(Arrays.asList(columns));
			}
			
		} catch (IOException e) {
			throw new RuntimeException(e);
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
		}

		return list;
	
	}
}
