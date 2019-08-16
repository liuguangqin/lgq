package com.lgq.action;

import com.lgq.service.IItemService;
import com.lgq.service.ITravelService;
import com.lgq.vo.*;
import net.sf.json.JSONObject;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.*;

@Component
@RequestMapping("/*")
public class TravelAction {
    @Resource(name="travelServiceImpl")
    private ITravelService travelService;
    @Resource(name = "itemServiceImpl")
    private IItemService iItemService;
    @InitBinder
    public void iniiBinder(WebDataBinder binder) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        format.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(format, false));
    }
    @RequestMapping("/travelInsertPre")
    public ModelAndView insertTravelPre(Type vo){
        ModelAndView mav=new ModelAndView();
        mav.addObject("items",this.iItemService.list());
        mav.addObject("types",this.travelService.findAllType(vo));
        mav.setViewName("/travel-create.jsp");
        return mav;
    }
    @RequestMapping("/travelInsert")
    public ModelAndView insertTravel(Travel vo,TravelCost tc){
        ModelAndView mav=new ModelAndView();
        vo.setSubdate(new Date());
        vo.setAudit(9);
       // vo.setSeid(this.getEid());
        this.travelService.insert(vo);
        vo.setTotal(this.travelService.getSum(vo.getTid()));
        tc.setTid(vo.getTid());
        this.travelService.insertTravelCost(tc);

        mav.setViewName("/travelList.action");
        return mav;
    }
    @RequestMapping("/insertTravelCost")
    @ResponseBody
    public boolean insertTravelCost( @RequestBody TravelCost vo){
       return  this.travelService.insertTravelCost(vo);
    }
@RequestMapping("/travelList")
    public ModelAndView list(Long tid){
        ModelAndView mav=new ModelAndView();
        List<Travel> list=this.travelService.list();
        List<TravelCost> list2=this.travelService.findAll();
        List<Travel> list1=new ArrayList<Travel>() ;
        Iterator<Travel> iter=list.iterator();
        while(iter.hasNext()){
         Travel vo=iter.next();
        vo.setTotal(this.travelService.getSum(vo.getTid()));
        list1.add(vo);
    }
        mav.addObject("allCost",list2);
        mav.addObject("allTravels",list1);
        mav.setViewName("/travel-list.jsp");
        return mav;
    }
    @RequestMapping("/travelEditPre")
    public ModelAndView updatePre(Long tid,Type vo){
        ModelAndView mav=new ModelAndView();
        Travel travel =this.travelService.findByTid(tid);
        mav.addObject("vo",travel);
        mav.addObject("items",this.iItemService.list());
        mav.addObject("types",this.travelService.findAllType(vo));
        mav.setViewName("/travel-edit.jsp");
        return mav;
    }
    @RequestMapping("/travelEdit")
    public ModelAndView update(Travel vo,TravelCost tc){
        ModelAndView mav=new ModelAndView();
       this.travelService.update(vo);
       this.travelService.updateTravelCost(tc);
       mav.addObject(vo);
        mav.setViewName("/travelList.action");
        return mav;
    }
    @RequestMapping("/travelFindByTid")
    public ModelAndView findByTid(Long tid){
        ModelAndView mav=new ModelAndView();
       this.travelService.findByTid(tid);
        mav.setViewName("/travel-list.jsp");
        return mav;
    }
    @ResponseBody
    @RequestMapping("/travelDelete")
    public boolean  delete(@RequestBody Travel vo){
       return this.travelService.delete(vo);
    }
    @RequestMapping("/travelemp")
    public ModelAndView addEmp(TravelEmp vo){
        Map<String,Object> map=this.travelService.addTravelEmp(vo);
        JSONObject jsoNobject=new JSONObject();
        jsoNobject.putAll(map);
        return null;
    }

    @RequestMapping("/travelfindByAudit")
    public ModelAndView findByAudit(Travel vo){
        ModelAndView mav=new ModelAndView();
        List<Travel> list=this.travelService.findByAudit(vo);
        mav.addObject("allTravels",list);
        mav.setViewName("/travel-list.jsp");
        return mav;
    }
    @RequestMapping("/travelCostList")
    public ModelAndView travelCostlist(Type vo){
        ModelAndView mav=new ModelAndView();
        List<TravelCost> list=this.travelService.findAll();
        mav.addObject("list",list);
        mav.addObject("types",this.travelService.findAllType(vo));
        mav.setViewName("/total-list.jsp");
        return mav;
    }
    @ResponseBody
    @RequestMapping("/travelCostDelete")
    public boolean  delete(@RequestBody TravelCost vo){
        return this.travelService.deleteTravelCost(vo);
    }
    @RequestMapping("/doUpdateAudit")
    public ModelAndView doUpdateAudit(Travel vo){
        ModelAndView mav=new ModelAndView();
        vo.setAuddate(new Date());
        vo.setAudit(2);
        this.travelService.doupdateAudit(vo);
        mav.setViewName("/travelList.action");
        return mav;
    }
    @RequestMapping("/doUpdateAudit1")
    public ModelAndView doUpdateAudit1(Travel vo){
        ModelAndView mav=new ModelAndView();
        //通过
        vo.setAuddate(new Date());
        vo.setAudit(1);
        this.travelService.doupdateAudit(vo);
        System.out.println(vo.getAudit());
        mav.setViewName("/travelList.action");
        return mav;
    }
}
