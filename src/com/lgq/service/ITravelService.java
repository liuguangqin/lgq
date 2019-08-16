package com.lgq.service;

import com.lgq.vo.Travel;
import com.lgq.vo.TravelCost;
import com.lgq.vo.TravelEmp;
import com.lgq.vo.Type;

import java.util.List;
import java.util.Map;

public interface ITravelService {
    public boolean insert(Travel vo);
    public List<Travel> list();
    public boolean update(Travel vo);
    public Travel findByTid(Long tid);
    public Map<String,Object> updatePre();
    public boolean delete(Travel vo);

    /**
     * 进行出差待选人员的配置
     * @param vo 出差编号，待选雇员编号
     * @return 返回结果包含以下信息
     * 1.key=status、value=是否增加成功（true、false）
     * 2.key=emp、value=新增雇员信息
     * 3.key=dept、value=雇员所在的部门
     * 4.key=level、value=雇员的级别
     */
    public Map<String,Object> addTravelEmp(TravelEmp vo);
    public List<Travel> findByAudit(Travel vo);
    public  List<Type> findAllType(Type vo);
    public boolean insertTravelCost(TravelCost vo);
    public List<TravelCost> findAll();
    public boolean updateTravelCost(TravelCost vo);
    public boolean deleteTravelCost(TravelCost vo);
    public TravelCost findByTid1(Long tid);
    public Double getSum(Long tid);
    public boolean doupdateAudit(Travel vo);

    /**
     * 调度更新
     * @return
     */
    public boolean editAuditTask();
}
