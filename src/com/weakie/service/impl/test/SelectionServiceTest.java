/**
 * 
 */
package com.weakie.service.impl.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.weakie.service.SelectionService;
import com.weakie.util.ReadOnlyMap;

/**
 * @author weakie E-mail:weakielin@gmail.com 2014年4月29日下午5:59:27
 */
public class SelectionServiceTest implements SelectionService {

	@Override
	public ReadOnlyMap<Integer, String> getOrgType() {
		Map<Integer, String> orgTypeMap = new HashMap<Integer, String>();
		orgTypeMap.put(1, "政府");
		orgTypeMap.put(2, "大学");
		orgTypeMap.put(3, "研究所");
		orgTypeMap.put(4, "企业");
		orgTypeMap.put(5, "其他");
		return new ReadOnlyMap<Integer, String>(orgTypeMap);
	}

	@Override
	public ReadOnlyMap<Integer, String> getProvince(boolean isAbroad) {
		Map<Integer, String> provinceMap = new HashMap<Integer, String>();
		if (!isAbroad) {
			provinceMap.put(1, "浙江");
			provinceMap.put(2, "北京");
			provinceMap.put(3, "上海");
			provinceMap.put(4, "广州");
			provinceMap.put(5, "江苏");
		} else {
			provinceMap.put(6, "日本");
			provinceMap.put(7, "美国");
			provinceMap.put(8, "英国");
			provinceMap.put(9, "德国");
			provinceMap.put(10, "法国");
		}
		return new ReadOnlyMap<Integer, String>(provinceMap);
	}

	@Override
	public ReadOnlyMap<Integer, String> getCity(int provinceId) {
		Map<Integer, String> cityMap = new HashMap<Integer, String>();
		switch (provinceId) {
		case 1:
			cityMap.put(1, "杭州");
			cityMap.put(2, "温州");
			cityMap.put(3, "宁波");
			break;
		case 2:
			cityMap.put(4, "北京1");
			cityMap.put(5, "北京2");
			cityMap.put(6, "北京3");
			break;
		case 3:
			cityMap.put(7, "上海1");
			cityMap.put(8, "上海2");
			cityMap.put(9, "上海3");
			break;
		case 4:
			cityMap.put(10, "广州1");
			cityMap.put(11, "广州2");
			cityMap.put(12, "广州3");
			break;
		case 5:
			cityMap.put(13, "江苏1");
			cityMap.put(14, "江苏2");
			cityMap.put(15, "江苏3");
			break;
		case 6:
			cityMap.put(16, "日本1");
			cityMap.put(17, "日本2");
			cityMap.put(18, "日本3");
			break;
		case 7:
			cityMap.put(19, "美国1");
			cityMap.put(20, "美国2");
			cityMap.put(21, "美国3");
			break;
		case 8:
			cityMap.put(22, "英国1");
			cityMap.put(23, "英国2");
			cityMap.put(24, "英国3");
			break;
		case 9:
			cityMap.put(25, "德国1");
			cityMap.put(26, "德国2");
			cityMap.put(27, "德国3");
			break;
		case 10:
			cityMap.put(28, "法国1");
			cityMap.put(29, "法国2");
			cityMap.put(30, "法国3");
			break;
		default:
			cityMap.put(31, "上1");
			cityMap.put(32, "上2");
			cityMap.put(33, "上3");
		}

		return new ReadOnlyMap<Integer, String>(cityMap);
	}

	@Override
	public ReadOnlyMap<Integer, String> getQualification() {
		Map<Integer, String> qualificationMap = new HashMap<Integer, String>();
		qualificationMap.put(1, "注册规划师");
		qualificationMap.put(2, "建造师");
		qualificationMap.put(3, "一级建筑师");
		qualificationMap.put(4, "其他");
		return new ReadOnlyMap<Integer, String>(qualificationMap);
	}

	@Override
	public ReadOnlyMap<Integer, String> getTitle() {
		Map<Integer, String> titleMap = new HashMap<Integer, String>();
		titleMap.put(1, "中级");
		titleMap.put(2, "高级");
		return new ReadOnlyMap<Integer, String>(titleMap);
	}

	@Override
	public ReadOnlyMap<Integer, String> getMajorClass() {
		Map<Integer, String> majorClassMap = new HashMap<Integer, String>();
		majorClassMap.put(1, "建筑");
		majorClassMap.put(2, "规划");
		majorClassMap.put(3, "景观");
		majorClassMap.put(4, "其他");
		return new ReadOnlyMap<Integer, String>(majorClassMap);
	}

	@Override
	public ReadOnlyMap<Integer, String> getMajor(int majorClassId) {
		Map<Integer, String> majorMap = new HashMap<Integer, String>();
		switch (majorClassId) {
		case 1:
			majorMap.put(1, "公共建筑");
			majorMap.put(2, "别墅");
			majorMap.put(3, "住宅");
			majorMap.put(4, "工业建筑");
			majorMap.put(5, "其他");
			break;
		case 2:
			majorMap.put(6, "规划1");
			majorMap.put(7, "规划2");
			majorMap.put(8, "规划3");
			majorMap.put(9, "规划4");
			majorMap.put(10, "规划5");
			break;
		case 3:
			majorMap.put(11, "景观1");
			majorMap.put(12, "景观2");
			majorMap.put(13, "景观3");
			majorMap.put(14, "景观4");
			majorMap.put(15, "景观5");
			break;
		case 4:
			majorMap.put(16, "其他1");
			majorMap.put(17, "其他2");
			majorMap.put(18, "其他3");
			majorMap.put(19, "其他4");
			majorMap.put(20, "其他5");
			break;
		}

		return new ReadOnlyMap<Integer, String>(majorMap);
	}

	@Override
	public Integer getMajorClassIdByMajorId(Integer majorId) {

		return (majorId + 4) / 5;
	}

	@Override
	public ReadOnlyMap<Integer, Integer> getCityProvinceMap(List<Integer> cityList) {
		Map<Integer, Integer> cityProMap = new HashMap<Integer, Integer>();
		for (int i : cityList) {
			cityProMap.put(i, (i + 2) / 3);
		}
		return new ReadOnlyMap<Integer, Integer>(cityProMap);
	}

	@Override
	public ReadOnlyMap<Integer, Boolean> getProvinceAbroadMap(List<Integer> provinceList) {
		Map<Integer, Boolean> abroadProMap = new HashMap<Integer, Boolean>();
		for (int i : provinceList) {
			if (i > 5) {
				abroadProMap.put(i, true);
			} else {
				abroadProMap.put(i, false);
			}
		}
		return new ReadOnlyMap<Integer, Boolean>(abroadProMap);
	}

	@Override
	public ReadOnlyMap<Integer, String> getCityNameMap(List<Integer> cityList) {
		Map<Integer, String> cityMap = new HashMap<Integer, String>();
		cityMap.put(1, "杭州");
		cityMap.put(2, "温州");
		cityMap.put(3, "宁波");
		cityMap.put(4, "北京1");
		cityMap.put(5, "北京2");
		cityMap.put(6, "北京3");
		cityMap.put(7, "上海1");
		cityMap.put(8, "上海2");
		cityMap.put(9, "上海3");
		cityMap.put(10, "广州1");
		cityMap.put(11, "广州2");
		cityMap.put(12, "广州3");
		cityMap.put(13, "江苏1");
		cityMap.put(14, "江苏2");
		cityMap.put(15, "江苏3");
		cityMap.put(16, "日本1");
		cityMap.put(17, "日本2");
		cityMap.put(18, "日本3");
		cityMap.put(19, "美国1");
		cityMap.put(20, "美国2");
		cityMap.put(21, "美国3");
		cityMap.put(22, "英国1");
		cityMap.put(23, "英国2");
		cityMap.put(24, "英国3");
		cityMap.put(25, "德国1");
		cityMap.put(26, "德国2");
		cityMap.put(27, "德国3");
		cityMap.put(28, "法国1");
		cityMap.put(29, "法国2");
		cityMap.put(30, "法国3");
		cityMap.put(31, "上1");
		cityMap.put(32, "上2");
		cityMap.put(33, "上3");

		Map<Integer, String> cityMap2 = new HashMap<Integer, String>();
		for (int i : cityList) {
			cityMap2.put(i, cityMap.get(i));
		}
		return new ReadOnlyMap<Integer, String>(cityMap2);
	}

	@Override
	public ReadOnlyMap<Integer, String> getProvNameMap(List<Integer> cityList) {
		Map<Integer, String> provinceMap = new HashMap<Integer, String>();
		provinceMap.put(1, "浙江");
		provinceMap.put(2, "北京");
		provinceMap.put(3, "上海");
		provinceMap.put(4, "广州");
		provinceMap.put(5, "江苏");
		provinceMap.put(6, "日本");
		provinceMap.put(7, "美国");
		provinceMap.put(8, "英国");
		provinceMap.put(9, "德国");
		provinceMap.put(10, "法国");

		Map<Integer, String> cityMap = new HashMap<Integer, String>();
		for (int i : cityList) {
			cityMap.put((i+2)/3, provinceMap.get((i+2)/3));
		}
		return new ReadOnlyMap<Integer, String>(cityMap);
	}

}
