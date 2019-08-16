package com.lgq.dao;

import com.lgq.vo.Travel;
import com.lgq.vo.TravelCost;
import com.lgq.vo.TravelEmp;
import com.lgq.vo.Type;

import java.util.Date;
import java.util.List;

public interface ITravelDao {
    /**
     * 增加出差申请
     * @param vo
     * @return 返回true、false
     */
    public boolean insert(Travel vo);

    /**
     * 查询所有出差申请
     * @return
     */
    public List<Travel> list();

    /**
     * 更新申请:当申请audit为0或9时
     * @param vo
     * @return true、false
     */
    public boolean update(Travel vo);

    /**
     * 通过tid查出所有列表信息
     * @param tid
     * @return 所查出的数据
     */
    public Travel findByTid(Long tid);

    /**
     * 删除申请：audit为9或2
     * @param vo
     * @return true、false
     */
    public boolean delete(Travel vo);

    /**
     * 进行travelemp表的处理
     * @param vo 包含有差旅编号，待选出差编号；
     * @return 追加成功返回true
     */
    public boolean doCreateTravelEmp(TravelEmp vo);

    /**
     * 分类查询 audit为1、0、2、9、时的数据
     * @param vo
     * @return
     */
    public List<Travel> findByAudit1(Travel vo);
    public List<Travel> findByAudit0(Travel vo);
    public List<Travel> findByAudit2(Travel vo);
    public List<Travel> findByAudit9(Travel vo);

    /**
     * 查询所有type数据，用于反馈页面进行申请或修改出差列表时使用
     * @param vo
     * @return
     */
    public  List<Type> findAllType(Type vo);

    /**
     * 增加出差所需的花费、花费需要存贮在两个表、一个是travelCost
     *             另一个是调用getSum将sum存在travel的total列中
     * @param vo
     * @return
     */
    public boolean insertTravelCost(TravelCost vo);

    /**
     * 删除所申请的花费
     * @param vo
     * @return
     */
    public boolean deleteTravelCost(TravelCost vo);

    /**
     * 列出所有花费项目
     * @return
     */
    public List<TravelCost> findAll();

    /**
     * 修改花费项目
     * @param vo
     * @return
     */
    public boolean updateTravelCost(TravelCost vo);

    /**
     * 通过tid查询出所申请的花费项目
     * @param tid
     * @return
     */
    public TravelCost findByTid1(Long tid);

    /**
     * 将travelCost中每个人的花费项计算之后填入travel的total列中
     * @param tid
     * @return
     */
    public Double  getSum(Long tid);

    /**
     * 审核操作
     * @param vo tid 、audit
     * @return true false
     */
    public boolean doUpdateAudit(Travel vo);

    /**
     *根据指定时间更新差旅状态
     * @param CurrentDate 当前日期
     * @return
     */
    public boolean doUpdateAuditTask(Date CurrentDate);
}
