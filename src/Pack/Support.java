package Pack;

import org.testng.annotations.Test;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Support {
	
	@Test
	public String test(String sentence) {

	       Pattern pattern = Pattern.compile("[0-9]+");
	       Matcher matcher = pattern.matcher(sentence);

	       if (matcher.find()) {
	           return matcher.group();
	       } else {
	           return null;
	       }
	   }

}
