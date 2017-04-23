package org.itst.service.impl;

import java.util.List;

import org.itst.dao.GroundMapper;
import org.itst.domain.Ground;
import org.itst.service.GroundService;
import org.itst.utils.MyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class GroundServiceImpl implements GroundService{
	@Autowired
	private GroundMapper mapper;
	public void addGround(Ground ground) {
		mapper.addGround(ground);
	}

	public void deleteGroundById(String id) {
		mapper.deleteGroundById(id);
	}

	public List<Ground> getAllGrounds() {
		return mapper.getAllGrounds();
	}

	public Ground getGroundById(String id) {
		return mapper.getGroundById(id);
	}

	public String getGroundJsonByKeyWord(String key, int pageSize, int pageNow) {
		List<Ground> list = mapper.getGroundByKeyWord(key, pageSize*(pageNow-1), pageSize * pageNow);
		String res = "";
		for(Ground g : list) {
			res += "{\"id\":\"" + g.getId()
					+ "\",\"name\":\"" + g.getGroundName()
					+ "\",\"status\":\""+ (g.getStatus()==1?"闲置":"使用中")
					+ "\",\"usingUnit\":\""+ (g.getUsingUnit()==null?"暂无":g.getUsingUnit())
					+ "\",\"addTime\":\"" + MyUtils.dateToString(g.getAddTime())
					+ "\"},";
		}
		if (!res.equals("")) {
			res = res.substring(0, res.length() - 1);
		}
		return "{\"total\":" + mapper.getKeySearchCount(key) + ",\"rows\":[" + res + "]}";
	}

	public Ground getGroundByName(String name) {
		return mapper.getGroundByName(name);
	}

	public String getGroundJsonByPage(int pageSize, int pageNow) {
		List<Ground> list = mapper.getGroundByPage(pageSize*(pageNow-1), pageSize * pageNow);
		String res = "";
		for(Ground g : list) {
			res += "{\"id\":\"" + g.getId()
					+ "\",\"name\":\"" + g.getGroundName()
					+ "\",\"status\":\""+ (g.getStatus()==1?"闲置":"使用中")
					+ "\",\"usingUnit\":\""+ (g.getUsingUnit()==null?"暂无":g.getUsingUnit())
					+ "\",\"addTime\":\"" + MyUtils.dateToString(g.getAddTime())
					+ "\"},";
		}
		if (!res.equals("")) {
			res = res.substring(0, res.length() - 1);
		}
		return "{\"total\":" + mapper.getGroundCount() + ",\"rows\":[" + res + "]}";
	}

	public void updateGroundStatus(Ground g) {
		mapper.updateGroundStatus(g);
	}

}
