package com.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.JiaruduiwuEntity;
import com.entity.view.JiaruduiwuView;

import com.service.JiaruduiwuService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 加入队伍
 * 后端接口
 * @author 
 * @email 
 * @date 2023-04-25 10:50:40
 */
@RestController
@RequestMapping("/jiaruduiwu")
public class JiaruduiwuController {
    @Autowired
    private JiaruduiwuService jiaruduiwuService;


    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,JiaruduiwuEntity jiaruduiwu,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			jiaruduiwu.setZhanghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("keyanduiwu")) {
			jiaruduiwu.setDuiwuzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<JiaruduiwuEntity> ew = new EntityWrapper<JiaruduiwuEntity>();

		PageUtils page = jiaruduiwuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jiaruduiwu), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,JiaruduiwuEntity jiaruduiwu, 
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			jiaruduiwu.setZhanghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("keyanduiwu")) {
			jiaruduiwu.setDuiwuzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<JiaruduiwuEntity> ew = new EntityWrapper<JiaruduiwuEntity>();

		PageUtils page = jiaruduiwuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jiaruduiwu), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( JiaruduiwuEntity jiaruduiwu){
       	EntityWrapper<JiaruduiwuEntity> ew = new EntityWrapper<JiaruduiwuEntity>();
      	ew.allEq(MPUtil.allEQMapPre( jiaruduiwu, "jiaruduiwu")); 
        return R.ok().put("data", jiaruduiwuService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(JiaruduiwuEntity jiaruduiwu){
        EntityWrapper< JiaruduiwuEntity> ew = new EntityWrapper< JiaruduiwuEntity>();
 		ew.allEq(MPUtil.allEQMapPre( jiaruduiwu, "jiaruduiwu")); 
		JiaruduiwuView jiaruduiwuView =  jiaruduiwuService.selectView(ew);
		return R.ok("查询加入队伍成功").put("data", jiaruduiwuView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        JiaruduiwuEntity jiaruduiwu = jiaruduiwuService.selectById(id);
        return R.ok().put("data", jiaruduiwu);
    }

    /**
     * 前端详情
     */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        JiaruduiwuEntity jiaruduiwu = jiaruduiwuService.selectById(id);
        return R.ok().put("data", jiaruduiwu);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody JiaruduiwuEntity jiaruduiwu, HttpServletRequest request){
    	jiaruduiwu.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(jiaruduiwu);
        jiaruduiwuService.insert(jiaruduiwu);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody JiaruduiwuEntity jiaruduiwu, HttpServletRequest request){
    	jiaruduiwu.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(jiaruduiwu);
    	jiaruduiwu.setUserid((Long)request.getSession().getAttribute("userId"));
        jiaruduiwuService.insert(jiaruduiwu);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody JiaruduiwuEntity jiaruduiwu, HttpServletRequest request){
        //ValidatorUtils.validateEntity(jiaruduiwu);
        jiaruduiwuService.updateById(jiaruduiwu);//全部更新
        return R.ok();
    }


    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        jiaruduiwuService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	









}
