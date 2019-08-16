package com.lgq.service.impl;

import com.lgq.dao.*;
import com.lgq.service.ITravelService;
import com.lgq.vo.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TravelServiceImpl implements ITravelService {
    @Resource(name = "travelDaoImpl")
    private ITravelDao travelDao;
    @Resource(name = "itemDaoImpl")
    private IItemDao iItemDao;
    @Resource(name = "deptDaoImpl")
    private IDeptDao deptDao;
    @Resource(name = "levelDaoImpl")
    private ILevelDao levelDao;
    @Resource(name = "empDaoImpl")
    private IEmpDao empDao;

    @Override
    public boolean insert(Travel vo) {
        return this.travelDao.insert(vo);
    }

    @Override
    public List<Travel> list() {
        return this.travelDao.list();
    }
    @Override
    public Map<String, Object> updatePre() {
        Map<String,Object> map=new HashMap<String, Object>() ;
        map.put("allItems",this.iItemDao.findAll());
        return map;
    }

    @Override
    public boolean delete(Travel vo) {
        return this.travelDao.delete(vo);
    }

    @Override
    public Map<String, Object> addTravelEmp(TravelEmp vo) {
        Map<String,Object> map=new HashMap<String,Object>();
        boolean status=this.travelDao.doCreateTravelEmp(vo);//保存出差雇员安排信息
        if(status){
           Emp emp=this.empDao.findByEid(vo.getEid());
            map.put("emp",emp);
            map.put("dept",this.deptDao.findByDid(emp.getDid()));
            map.put("level",this.levelDao.findByLid(emp.getLid()));

        }
        map.put("status",status);
        return map;
    }

    @Override
    public List<Travel> findByAudit(Travel vo) {
        int i=vo.getAudit();
        System.out.println(i);
        if(i==9){
            return this.travelDao.findByAudit9(vo);
        }else if(i==1){
            return this.travelDao.findByAudit1(vo);
        }else if(i==0){
            return this.travelDao.findByAudit0(vo);
        }else{
            return this.travelDao.findByAudit2(vo);
        }

    }

    @Override
    public List<Type> findAllType(Type vo) {
        return this.travelDao.findAllType(vo);
    }

    @Override
    public boolean insertTravelCost(TravelCost vo) {
        return this.travelDao.insertTravelCost(vo);
    }

    @Override
    public List<TravelCost> findAll() {
        return this.travelDao.findAll();
    }

    @Override
    public boolean updateTravelCost(TravelCost vo) {
        return this.travelDao.updateTravelCost(vo);
    }

    @Override
    public boolean deleteTravelCost(TravelCost vo) {
        return this.travelDao.deleteTravelCost(vo);
    }

    @Override
    public TravelCost findByTid1(Long tid) {
        return this.travelDao.findByTid1(tid);
    }

    @Override
    public Double getSum(Long tid) {
        return this.travelDao.getSum(tid);
    }

    @Override
    public boolean doupdateAudit(Travel vo) {
        return this.travelDao.doUpdateAudit(vo);
    }

    @Override
    public boolean editAuditTask() {
        return this.travelDao.doUpdateAuditTask(new Date());
    }

    @Override
    public boolean update(Travel vo) {
        if(vo.getSdate().before(vo.getEdate())){
            vo.setAudit(9);
            return this.travelDao.update(vo);
        }
       return false;
    }

    @Override
    public Travel findByTid(Long tid) {
        return this.travelDao.findByTid(tid);
    }


}
