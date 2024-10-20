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

import com.entity.DiscussziyuanwenjianEntity;
import com.entity.view.DiscussziyuanwenjianView;

import com.service.DiscussziyuanwenjianService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 资源文件评论表
 * 后端接口
 * @author 
 * @email 
 * @date 2023-04-25 10:50:41
 */
@RestController
@RequestMapping("/discussziyuanwenjian")
public class DiscussziyuanwenjianController {
    @Autowired
    private DiscussziyuanwenjianService discussziyuanwenjianService;


    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,DiscussziyuanwenjianEntity discussziyuanwenjian,
		HttpServletRequest request){
        EntityWrapper<DiscussziyuanwenjianEntity> ew = new EntityWrapper<DiscussziyuanwenjianEntity>();

		PageUtils page = discussziyuanwenjianService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussziyuanwenjian), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,DiscussziyuanwenjianEntity discussziyuanwenjian, 
		HttpServletRequest request){
        EntityWrapper<DiscussziyuanwenjianEntity> ew = new EntityWrapper<DiscussziyuanwenjianEntity>();

		PageUtils page = discussziyuanwenjianService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussziyuanwenjian), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( DiscussziyuanwenjianEntity discussziyuanwenjian){
       	EntityWrapper<DiscussziyuanwenjianEntity> ew = new EntityWrapper<DiscussziyuanwenjianEntity>();
      	ew.allEq(MPUtil.allEQMapPre( discussziyuanwenjian, "discussziyuanwenjian")); 
        return R.ok().put("data", discussziyuanwenjianService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(DiscussziyuanwenjianEntity discussziyuanwenjian){
        EntityWrapper< DiscussziyuanwenjianEntity> ew = new EntityWrapper< DiscussziyuanwenjianEntity>();
 		ew.allEq(MPUtil.allEQMapPre( discussziyuanwenjian, "discussziyuanwenjian")); 
		DiscussziyuanwenjianView discussziyuanwenjianView =  discussziyuanwenjianService.selectView(ew);
		return R.ok("查询资源文件评论表成功").put("data", discussziyuanwenjianView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        DiscussziyuanwenjianEntity discussziyuanwenjian = discussziyuanwenjianService.selectById(id);
        return R.ok().put("data", discussziyuanwenjian);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        DiscussziyuanwenjianEntity discussziyuanwenjian = discussziyuanwenjianService.selectById(id);
        return R.ok().put("data", discussziyuanwenjian);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody DiscussziyuanwenjianEntity discussziyuanwenjian, HttpServletRequest request){
    	discussziyuanwenjian.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(discussziyuanwenjian);
        discussziyuanwenjianService.insert(discussziyuanwenjian);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody DiscussziyuanwenjianEntity discussziyuanwenjian, HttpServletRequest request){
    	discussziyuanwenjian.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(discussziyuanwenjian);
        discussziyuanwenjianService.insert(discussziyuanwenjian);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody DiscussziyuanwenjianEntity discussziyuanwenjian, HttpServletRequest request){
        //ValidatorUtils.validateEntity(discussziyuanwenjian);
        discussziyuanwenjianService.updateById(discussziyuanwenjian);//全部更新
        return R.ok();
    }


    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        discussziyuanwenjianService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	









}
