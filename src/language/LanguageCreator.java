package language;

import random_generator.RandomNumberGenerator;
import user.User;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LanguageCreator {

	public static List<Language> createLanguages(String fileName) throws IOException{
		List<Language> languages = new ArrayList<>();
		BufferedReader br = new BufferedReader(new FileReader(fileName));
		String line;
		while ((line = br.readLine()) != null) {
			String[] fields = line.split(";");
			String langName = fields[0];
//			U,Q,R,S,L,W
//			1,1,1,1,1,1
//			1,2,1,1,1,1
//			2,1,1,1,1,1
//			2,2,2,2,2,2
			for (String field : fields){
//			
			}
		}
		br.close();
		return users;
	}
}
