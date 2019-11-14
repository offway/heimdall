package cn.offway.heimdall.utils;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class XmlUtils {

	/**
	 * xml文件配置转换为对象
	 * 
	 * @param xmlPath
	 *            xml文件路径
	 * @param load
	 *            java对象.Class
	 * @return java对象
	 * @throws JAXBException
	 * @throws IOException
	 */
	public static Object xmlToBean(String xmlPath, Class<?> load) throws JAXBException, IOException {
		JAXBContext context = JAXBContext.newInstance(load);
		Unmarshaller unmarshaller = context.createUnmarshaller();
		Object object = unmarshaller.unmarshal(new File(xmlPath));
		return object;
	}

	/**
	 * java对象转换为xml文件
	 * 
	 * @param xmlPath
	 *            xml文件路径
	 * @param load
	 *            java对象.Class
	 * @return xml文件的String
	 * @throws JAXBException
	 */
	public static String beanToXml(Object obj, Class<?> load) throws JAXBException {
		JAXBContext context = JAXBContext.newInstance(load);
		Marshaller marshaller = context.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		marshaller.setProperty(Marshaller.JAXB_ENCODING, "utf-8");
		StringWriter writer = new StringWriter();
		marshaller.marshal(obj, writer);
		return writer.toString();
	}
}
