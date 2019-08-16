package com.lgq.service.impl;

import com.lgq.dao.IEmpDao;
import com.lgq.dao.ILevelDao;
import com.lgq.service.ILevelService;
import com.lgq.vo.DeptRole;
import com.lgq.vo.Emp;
import com.lgq.vo.Level;
import com.lgq.vo.RoleAction;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class LevelServiceImpl implements ILevelService {
    @Resource(name = "levelDaoImpl")
    private ILevelDao levelDao;
    @Resource(name="empDaoImpl")
    private IEmpDao iEmpDao;
    @Override
    public List<Level> list() {
        return this.levelDao.findAllLevel();
    }


    @Override
    public Map<String,Object> findById(Long eid) {
       Emp vo=this.iEmpDao.findByEid(eid);
       List<DeptRole> rids=this.levelDao.findById(vo);
       List<RoleAction>  actids=this.levelDao.findByRid(vo);
        Map<String,Object> map=new HashMap<>();
        map.put("rids",rids);
        map.put("actids",actids);
        return map;
     }
}
