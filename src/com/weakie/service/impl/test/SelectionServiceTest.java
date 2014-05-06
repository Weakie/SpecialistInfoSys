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
 * @author weakie E-mail:weakielin@gmail.com 2014��4��29������5:59:27
 */
public class SelectionServiceTest implements SelectionService {

	@Override
	public ReadOnlyMap<Integer, String> getOrgType() {
		Map<Integer, String> orgTypeMap = new HashMap<Integer, String>();
		orgTypeMap.put(1, "����");
		orgTypeMap.put(2, "��ѧ");
		orgTypeMap.put(3, "�о���");
		orgTypeMap.put(4, "��ҵ");
		orgTypeMap.put(5, "����");
		return new ReadOnlyMap<Integer, String>(orgTypeMap);
	}

	@Override
	public ReadOnlyMap<Integer, String> getProvince(boolean isAbroad) {
		Map<Integer, String> provinceMap = new HashMap<Integer, String>();
		if (!isAbroad) {
			provinceMap.put(1, "�㽭");
			provinceMap.put(2, "����");
			provinceMap.put(3, "�Ϻ�");
			provinceMap.put(4, "����");
			provinceMap.put(5, "����");
		} else {
			provinceMap.put(6, "�ձ�");
			provinceMap.put(7, "����");
			provinceMap.put(8, "Ӣ��");
			provinceMap.put(9, "�¹�");
			provinceMap.put(10, "����");
		}
		return new ReadOnlyMap<Integer, String>(provinceMap);
	}

	@Override
	public ReadOnlyMap<Integer, String> getCity(int provinceId) {
		Map<Integer, String> cityMap = new HashMap<Integer, String>();
		switch (provinceId) {
		case 1:
			cityMap.put(1, "����");
			cityMap.put(2, "����");
			cityMap.put(3, "����");
			break;
		case 2:
			cityMap.put(4, "����1");
			cityMap.put(5, "����2");
			cityMap.put(6, "����3");
			break;
		case 3:
			cityMap.put(7, "�Ϻ�1");
			cityMap.put(8, "�Ϻ�2");
			cityMap.put(9, "�Ϻ�3");
			break;
		case 4:
			cityMap.put(10, "����1");
			cityMap.put(11, "����2");
			cityMap.put(12, "����3");
			break;
		case 5:
			cityMap.put(13, "����1");
			cityMap.put(14, "����2");
			cityMap.put(15, "����3");
			break;
		case 6:
			cityMap.put(16, "�ձ�1");
			cityMap.put(17, "�ձ�2");
			cityMap.put(18, "�ձ�3");
			break;
		case 7:
			cityMap.put(19, "����1");
			cityMap.put(20, "����2");
			cityMap.put(21, "����3");
			break;
		case 8:
			cityMap.put(22, "Ӣ��1");
			cityMap.put(23, "Ӣ��2");
			cityMap.put(24, "Ӣ��3");
			break;
		case 9:
			cityMap.put(25, "�¹�1");
			cityMap.put(26, "�¹�2");
			cityMap.put(27, "�¹�3");
			break;
		case 10:
			cityMap.put(28, "����1");
			cityMap.put(29, "����2");
			cityMap.put(30, "����3");
			break;
		default:
			cityMap.put(31, "��1");
			cityMap.put(32, "��2");
			cityMap.put(33, "��3");
		}

		return new ReadOnlyMap<Integer, String>(cityMap);
	}

	@Override
	public ReadOnlyMap<Integer, String> getQualification() {
		Map<Integer, String> qualificationMap = new HashMap<Integer, String>();
		qualificationMap.put(1, "ע��滮ʦ");
		qualificationMap.put(2, "����ʦ");
		qualificationMap.put(3, "һ������ʦ");
		qualificationMap.put(4, "����");
		return new ReadOnlyMap<Integer, String>(qualificationMap);
	}

	@Override
	public ReadOnlyMap<Integer, String> getTitle() {
		Map<Integer, String> titleMap = new HashMap<Integer, String>();
		titleMap.put(1, "�м�");
		titleMap.put(2, "�߼�");
		return new ReadOnlyMap<Integer, String>(titleMap);
	}

	@Override
	public ReadOnlyMap<Integer, String> getMajorClass() {
		Map<Integer, String> majorClassMap = new HashMap<Integer, String>();
		majorClassMap.put(1, "����");
		majorClassMap.put(2, "�滮");
		majorClassMap.put(3, "����");
		majorClassMap.put(4, "����");
		return new ReadOnlyMap<Integer, String>(majorClassMap);
	}

	@Override
	public ReadOnlyMap<Integer, String> getMajor(int majorClassId) {
		Map<Integer, String> majorMap = new HashMap<Integer, String>();
		switch (majorClassId) {
		case 1:
			majorMap.put(1, "��������");
			majorMap.put(2, "����");
			majorMap.put(3, "סլ");
			majorMap.put(4, "��ҵ����");
			majorMap.put(5, "����");
			break;
		case 2:
			majorMap.put(6, "�滮1");
			majorMap.put(7, "�滮2");
			majorMap.put(8, "�滮3");
			majorMap.put(9, "�滮4");
			majorMap.put(10, "�滮5");
			break;
		case 3:
			majorMap.put(11, "����1");
			majorMap.put(12, "����2");
			majorMap.put(13, "����3");
			majorMap.put(14, "����4");
			majorMap.put(15, "����5");
			break;
		case 4:
			majorMap.put(16, "����1");
			majorMap.put(17, "����2");
			majorMap.put(18, "����3");
			majorMap.put(19, "����4");
			majorMap.put(20, "����5");
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
		cityMap.put(1, "����");
		cityMap.put(2, "����");
		cityMap.put(3, "����");
		cityMap.put(4, "����1");
		cityMap.put(5, "����2");
		cityMap.put(6, "����3");
		cityMap.put(7, "�Ϻ�1");
		cityMap.put(8, "�Ϻ�2");
		cityMap.put(9, "�Ϻ�3");
		cityMap.put(10, "����1");
		cityMap.put(11, "����2");
		cityMap.put(12, "����3");
		cityMap.put(13, "����1");
		cityMap.put(14, "����2");
		cityMap.put(15, "����3");
		cityMap.put(16, "�ձ�1");
		cityMap.put(17, "�ձ�2");
		cityMap.put(18, "�ձ�3");
		cityMap.put(19, "����1");
		cityMap.put(20, "����2");
		cityMap.put(21, "����3");
		cityMap.put(22, "Ӣ��1");
		cityMap.put(23, "Ӣ��2");
		cityMap.put(24, "Ӣ��3");
		cityMap.put(25, "�¹�1");
		cityMap.put(26, "�¹�2");
		cityMap.put(27, "�¹�3");
		cityMap.put(28, "����1");
		cityMap.put(29, "����2");
		cityMap.put(30, "����3");
		cityMap.put(31, "��1");
		cityMap.put(32, "��2");
		cityMap.put(33, "��3");

		Map<Integer, String> cityMap2 = new HashMap<Integer, String>();
		for (int i : cityList) {
			cityMap2.put(i, cityMap.get(i));
		}
		return new ReadOnlyMap<Integer, String>(cityMap2);
	}

	@Override
	public ReadOnlyMap<Integer, String> getProvNameMap(List<Integer> cityList) {
		Map<Integer, String> provinceMap = new HashMap<Integer, String>();
		provinceMap.put(1, "�㽭");
		provinceMap.put(2, "����");
		provinceMap.put(3, "�Ϻ�");
		provinceMap.put(4, "����");
		provinceMap.put(5, "����");
		provinceMap.put(6, "�ձ�");
		provinceMap.put(7, "����");
		provinceMap.put(8, "Ӣ��");
		provinceMap.put(9, "�¹�");
		provinceMap.put(10, "����");

		Map<Integer, String> cityMap = new HashMap<Integer, String>();
		for (int i : cityList) {
			cityMap.put((i+2)/3, provinceMap.get((i+2)/3));
		}
		return new ReadOnlyMap<Integer, String>(cityMap);
	}

}
