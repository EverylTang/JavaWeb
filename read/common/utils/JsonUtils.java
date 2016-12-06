package com.pengzhen.bcm.common.utils;

import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Component;

/**
 * @memo 说明：json工具类
 */
@Component("jsonUtils")
public class JsonUtils {
	private static ObjectMapper objectMapper = new ObjectMapper();

	@SuppressWarnings("rawtypes")
	public static JSONObject mapToJson(Map map) {
		JSONObject jsonObject = JSONObject.fromObject(map);
		return jsonObject;
	}

	/**
	 * ObjectתJson
	 * 
	 * @param obj
	 * @return JSONObject
	 */
	public static JSONObject ObjectToJson(Object obj) {
		JSONObject jsonObject = JSONObject.fromObject(obj);
		return jsonObject;
	}

	/**
	 * JsonתMap
	 * 
	 * @param jsonStr
	 * @return Map
	 * @throws IOException
	 * @throws JsonMappingException
	 * @throws JsonParseException
	 */
	@SuppressWarnings("rawtypes")
	public static Map jsonToMap(String jsonStr) throws JsonParseException,
			JsonMappingException, IOException {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.readValue(jsonStr, Map.class);
	}

	public static JSONArray ObjectToJsonArray(Object objs) {
		JSONArray jsonArray = JSONArray.fromObject(objs);
		return jsonArray;
	}

	/**
	 * 读取json数据转成MAP
	 * 
	 * @author liujx
	 * @see jackson
	 * @param jsonData
	 * @return
	 * @version 2015-02-25
	 */
	@SuppressWarnings("unchecked")
	public static Map<String, Object> readJson2Map(String jsonData) {
		Map<String, Object> maps = null;
		try {
			maps = objectMapper.readValue(jsonData, Map.class);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return maps;
	}

	/**
	 * 将实体转成json数据
	 * 
	 * @author liujx
	 * @see jackson
	 * @param obj
	 * @return
	 * @version 2015-02-25
	 */
	public static String writeEntityJSON(Object obj) {
		String jsonResult = "";
		try {
			jsonResult = objectMapper.writeValueAsString(obj);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return jsonResult;
	}

	/**
	 * @param object
	 *            任意对象
	 * @return java.lang.String
	 */
	public static String objectToJson(Object object) {
		StringBuilder json = new StringBuilder();
		if (object == null) {
			json.append("\"\"");
		} else if (object instanceof String || object instanceof Integer) {
			json.append("\"").append(object.toString()).append("\"");
		} else {
			json.append(beanToJson(object));
		}
		return json.toString();
	}

	/**
	 * 功能描述:传入任意一个 javabean 对象生成一个指定规格的字符串
	 * 
	 * @param bean
	 *            bean对象
	 * @return String
	 */
	public static String beanToJson(Object bean) {
		StringBuilder json = new StringBuilder();
		json.append("{");
		PropertyDescriptor[] props = null;
		try {
			props = Introspector.getBeanInfo(bean.getClass(), Object.class)
					.getPropertyDescriptors();
		} catch (IntrospectionException e) {
			e.printStackTrace();
		}
		if (props != null) {
			for (int i = 0; i < props.length; i++) {
				try {
					String name = objectToJson(props[i].getName());
					String value = objectToJson(props[i].getReadMethod()
							.invoke(bean));
					json.append(name);
					json.append(":");
					json.append(value);
					json.append(",");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			json.setCharAt(json.length() - 1, '}');
		} else {
			json.append("}");
		}
		return json.toString();
	}

	/**
	 * 功能描述:通过传入一个列表对象,调用指定方法将列表中的数据生成一个JSON规格指定字符串
	 * 
	 * @param list
	 *            列表对象
	 * @return java.lang.String
	 */
	public static String listToJson(List<?> list) {
		StringBuilder json = new StringBuilder();
		json.append("[");
		if (list != null && list.size() > 0) {
			for (Object obj : list) {
				json.append(objectToJson(obj));
				json.append(",");
			}
			json.setCharAt(json.length() - 1, ']');
		} else {
			json.append("]");
		}
		return json.toString();
	}
}
