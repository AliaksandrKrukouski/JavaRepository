package by.krukouski.text.textparserchain;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import by.krukouski.text.textcomposite.TextComponentInterface;
import by.krukouski.text.textcomposite.TextComposite;
import by.krukouski.text.textconstant.BeginEnd;
import by.krukouski.text.textconstant.TextType;

public class LexemeToPunctuationParser implements TextParserInterface {
	private static Logger logger = LogManager.getLogger(LexemeToPunctuationParser.class.getName());
	private TextComposite punctComposite = new TextComposite(TextType.PUNCTUATION);
	
	@Override
	public TextComponentInterface parse(String lexeme) {		
		return parse(lexeme, BeginEnd.END);
	}
	
	public TextComponentInterface parse(String lexeme, BeginEnd beginEnd) {
		String regexpPunct = (beginEnd == BeginEnd.BEGIN ? "^\\p{Punct}+" : "\\p{Punct}+$");
		
		Pattern patternPunct = Pattern.compile(regexpPunct);
		Matcher matcherPunct = patternPunct.matcher(lexeme);
		String punct; 
		
		while(matcherPunct.find()) {
			punct = matcherPunct.group();
            logger.info("Punctuation: " + punct);
			 
			punctComposite.addComponent(new WordPunctToSymbolParser().parse(punct)); 
		}
		
		return punctComposite;
	}
}
