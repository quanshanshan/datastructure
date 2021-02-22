package com.opentext.ecd.dctm.test.designpattern.factory;

import java.util.HashMap;
import java.util.Map;

import com.opentext.ecd.dctm.test.animal.Animal;
import com.opentext.ecd.dctm.test.animal.Cat;
import com.opentext.ecd.dctm.test.animal.Dog;

/**
 * 
public class RuleConfigParserFactory {
  private static final Map<String, RuleConfigParser> cachedParsers = new HashMap<>();

  static {
    cachedParsers.put("json", new JsonRuleConfigParser());
    cachedParsers.put("xml", new XmlRuleConfigParser());
    cachedParsers.put("yaml", new YamlRuleConfigParser());
    cachedParsers.put("properties", new PropertiesRuleConfigParser());
  }

  public static IRuleConfigParser createParser(String configFormat) {
    if (configFormat == null || configFormat.isEmpty()) {
      return null;//返回null还是IllegalArgumentException全凭你自己说了算
    }
    IRuleConfigParser parser = cachedParsers.get(configFormat.toLowerCase());
    return parser;
  }
}
 * @author squan
 *
 */
public class ConfigFactory {
	
	private static final Map<String, Animal> animals = new HashMap<String, Animal>();
	
	static {		
		animals.put("dog", new Dog("dog"));
		animals.put("cat", new Cat("cat"));
		
	}
	
	public static Animal getAnimal(String name) {
		Animal animal = animals.get(name);
		return animal;
		
	}

}
