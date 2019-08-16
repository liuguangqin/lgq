package com.lgq.dao.impl;

import com.lgq.dao.ITravelDao;
import com.lgq.vo.Travel;
import com.lgq.vo.TravelCost;
import com.lgq.vo.TravelEmp;
import com.lgq.vo.Type;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Component
public class TravelDaoImpl implements ITravelDao {
    @Resource
    private SqlSessionFactory sessionFactory;
    @Override
    public boolean insert(Travel vo) {
        return this.sessionFactory.openSession().insert("com.lgq.vo.mapping.travel.insertTravel",vo)>0;
    }

    @Override
    public List<Travel> list() {
        return this.sessionFactory.openSession().selectList("com.lgq.vo.mapping.travel.findAll");
    }

    @Override
    public boolean update(Travel vo) {
        return this.sessionFactory.openSession().update("com.lgq.vo.mapping.travel.updateTravel",vo)>0;
    }

    @Override
    public Travel findByTid(Long tid) {
        return this.sessionFactory.openSession().selectOne("com.lgq.vo.mapping.travel.findByID",tid);
    }

    @Override
    public boolean delete(Travel vo) {
        return this.sessionFactory.openSession().delete("com.lgq.vo.mapping.travel.deleteTravel",vo)>0;
    }

    @Override
    public boolean doCreateTravelEmp(TravelEmp vo) {
        return this.sessionFactory.openSession().insert("com.lgq.vo.mapping.travel.doCreateTravelEmp",vo)>0;
    }

    @Override
    public List<Travel> findByAudit1(Travel vo) {
        return this.sessionFactory.openSession().selectList("com.lgq.vo.mapping.travel.findByAudit1",vo);
    }

    @Override
    public List<Travel> findByAudit0(Travel vo) {
        return this.sessionFactory.openSession().selectList("com.lgq.vo.mapping.travel.findByAudit0",vo);
    }

    @Override
    public List<Travel> findByAudit2(Travel vo) {
        return this.sessionFactory.openSession().selectList("com.lgq.vo.mapping.travel.findByAudit2",vo);
    }

    @Override
    public List<Travel> findByAudit9(Travel vo) {
        return this.sessionFactory.openSession().selectList("com.lgq.vo.mapping.travel.findByAudit9",vo);
    }

    @Override
    public List<Type> findAllType(Type vo) {
        return this.sessionFactory.openSession().selectList("com.lgq.vo.mapping.type.findAllType",vo);
    }

    @Override
    public boolean insertTravelCost(TravelCost vo) {
        return this.sessionFactory.openSession().insert("com.lgq.vo.mapping.travelCost.insertTravelCost",vo)>0;
    }

    @Override
    public boolean deleteTravelCost(TravelCost vo) {
        return this.sessionFactory.openSession().delete("com.lgq.vo.mapping.travelCost.delete",vo)>0;
    }

    @Override
    public List<TravelCost> findAll() {
        return this.sessionFactory.openSession().selectList("com.lgq.vo.mapping.travelCost.findAll");
    }

    @Override
    public boolean updateTravelCost(TravelCost vo) {
        return this.sessionFactory.openSession().update("com.lgq.vo.mapping.travelCost.updateTravelCost",vo)>0;
    }

    @Override
    public TravelCost findByTid1(Long tid) {
        return this.sessionFactory.openSession().selectOne("com.lgq.vo.mapping.travelCost.findByTid",tid);
    }

    @Override
    public Double getSum(Long tid) {
        return this.sessionFactory.openSession().selectOne("com.lgq.vo.mapping.travelCost.sum",tid);
    }

    @Override
    public boolean doUpdateAudit(Travel vo) {
        return this.sessionFactory.openSession().update("com.lgq.vo.mapping.travel.doUpdateAudit",vo)>0;
    }

    @Override
    public boolean doUpdateAuditTask(Date CurrentDate) {
        return this.sessionFactory.openSession().update("com.lgq.vo.mapping.travel.doUpdateAuditTask",CurrentDate)>0;
    }


}
