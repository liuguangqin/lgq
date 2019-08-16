package com.lgq.action;

import com.lgq.service.IDeptService;
import com.lgq.service.ILevelService;
import com.lgq.vo.Dept;
import com.lgq.vo.Emp;
import com.lgq.vo.Level;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/*")
public class DeptAction {
    @Resource(name="deptServiceImpl")
    private IDeptService deptService;
    @Resource(name="levelServiceImpl")
    private ILevelService levelService;


    @RequestMapping("list")
    public  ModelAndView list(){
    ModelAndView mav=new ModelAndView();
        Map<String,Object> map=this.deptService.findDeptList();//取出数据
        Map<String,String> map1=new HashMap<String, String>();
        List<Emp> emp=(List)map.get("emps");
        List<Dept> dept=(List)map.get("depts");
        Iterator<Emp> iter=emp.iterator();
        while(iter.hasNext()){
           Emp vo= iter.next();
           map1.put(vo.getEid().toString(),vo.getEname());
        }
        mav.addObject("emps",map1);
        mav.addObject("depts",dept);
        mav.setViewName("/table-font-list.jsp");
        return mav;
   }
   @RequestMapping("/update")
   @ResponseBody
   public boolean updateDname(@RequestBody Dept vo){
        return this.deptService.updateDname(vo);
   }

    @RequestMapping("deptslist")
    public  ModelAndView deptslist() {
        ModelAndView mav = new ModelAndView();
        List<Dept> dept = this.deptService.listAll();//取出数据
        List<Level> level=this.levelService.list();
        mav.addObject("levels",level);
        mav.addObject("depts", dept);
        mav.setViewName("/emp-add.jsp");
        return mav;
    }
}
