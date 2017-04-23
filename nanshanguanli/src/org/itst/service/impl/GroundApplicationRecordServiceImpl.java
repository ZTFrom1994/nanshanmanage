package org.itst.service.impl;

import java.sql.SQLException;
import java.util.List;

import org.itst.dao.GroundApplicationRecordMapper;
import org.itst.domain.GroundApplicationRecord;
import org.itst.service.GroundApplicationRecordService;
import org.itst.utils.MyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class GroundApplicationRecordServiceImpl implements GroundApplicationRecordService{

	@Autowired
	private GroundApplicationRecordMapper mapper;
	public void addRecord(GroundApplicationRecord record) {
		mapper.addRecord(record);
	}

	public GroundApplicationRecord getRecordById(int id) {
		return mapper.getRecordById(id);
	}

	public String getRecordsJsonByPage(int pageSize, int pageNow) {
		List<GroundApplicationRecord> list = mapper.getRecordsByPage(pageSize*(pageNow - 1), pageNow*pageSize);
		String res = "";
			for(GroundApplicationRecord g : list) {
				res += "{\"id\":\"" + g.getId()
						+ "\",\"groundName\":\"" + g.getGround().getGroundName()
						+ "\",\"usingUnit\":\"" + g.getUsingUnit()
						+ "\",\"startTime\":\""+ MyUtils.dateToString(g.getStartTime())
						+ "\",\"endTime\":\""+ MyUtils.dateToString(g.getEndTime())
						+ "\",\"petitioner\":\""+ g.getPetitioner()
						+ "\",\"contact\":\"" + g.getContact()
						+ "\",\"usingFor\":\""+ g.getUsingFor()
						+ "\",\"operator\":\""+ g.getOperator().getUsername()
						+ "\",\"operateTime\":\""+ MyUtils.dateToString(g.getOperateTime())
						+ "\"},";
			}
			if (!res.equals("")) {
				res = res.substring(0, res.length() - 1);
			}
		return "{\"total\":" + mapper.getRecordCount() + ",\"rows\":[" + res + "]}";
	}

	public String getRecordsJsonBykeyWord(String key, int pageSize, int pageNow) {
		List<GroundApplicationRecord> list = mapper.getRecordsBykeyWord(key,pageSize*(pageNow - 1), pageNow*pageSize);
		String res = "";
			for(GroundApplicationRecord g : list) {
				res += "{\"id\":\"" + g.getId()
						+ "\",\"groundName\":\"" + g.getGround().getGroundName()
						+ "\",\"usingUnit\":\"" + g.getUsingUnit()
						+ "\",\"startTime\":\""+ MyUtils.dateToString(g.getStartTime())
						+ "\",\"endTime\":\""+ MyUtils.dateToString(g.getEndTime())
						+ "\",\"petitioner\":\""+ g.getPetitioner()
						+ "\",\"contact\":\"" + g.getContact()
						+ "\",\"usingFor\":\""+ g.getUsingFor()
						+ "\",\"operator\":\""+ g.getOperator().getUsername()
						+ "\",\"operateTime\":\""+ MyUtils.dateToString(g.getOperateTime())
						+ "\"},";
			}
			if (!res.equals("")) {
				res = res.substring(0, res.length() - 1);
			}
		return "{\"total\":" + mapper.getKeySearchCount(key) + ",\"rows\":[" + res + "]}";
	}

}
