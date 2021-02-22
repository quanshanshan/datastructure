package com.opentext.ecd.dctm.test.designpattern.factory;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class XMLBeanConfigParser implements BeanConfigParser {

	@Override
	public List parse(InputStream inputStream) {
		String content = null;
		return parse(content);
	}

	@Override
	public List parse(String configContent) {
		List<BeanDefinition> beans = new ArrayList();
		//TODO
		return beans;
	}

}
