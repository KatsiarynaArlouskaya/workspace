package com.epam.nb.dao.impl.xml;

import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import com.epam.nb.dao.impl.xml.implDOM.MyDOMParser;
import com.epam.nb.dao.impl.xml.implSAX.SAXParser;
import com.epam.nb.dao.impl.xml.implStAX.StAXParser;

public class ParserFactory {
	private static final ParserFactory parserFactory = new ParserFactory();

	private Map<ParserType, XMLParser> parser = new HashMap<>();
	private ParserType parserType;
	

	public static ParserFactory getInstance() {
		return parserFactory;
	}

	private ParserFactory() {
		ResourceBundle rb = ResourceBundle.getBundle("source");
		String source = rb.getString("xml.parser");
		parserType = ParserType.valueOf(source);
		parser.put(ParserType.SAX, new SAXParser());
		parser.put(ParserType.StAX, new StAXParser());
		parser.put(ParserType.DOM, new MyDOMParser());	
	}

	public XMLParser getParser() {
		return parser.get(parserType);
	}
}
