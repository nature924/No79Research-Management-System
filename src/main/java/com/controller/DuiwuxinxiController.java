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

import com.entity.DuiwuxinxiEntity;
import com.entity.view.DuiwuxinxiView;

import com.service.DuiwuxinxiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import java.io.IOException;
import com.service.StoreupService;
import com.entity.StoreupEntity;

/**
 * 队伍信息
 * 后端接口
 * @author 
 * @email 
 * @date 2023-04-25 10:50:40
 */
@RestController
@RequestMapping("/duiwuxinxi")
public class DuiwuxinxiController {
    @Autowired
    private DuiwuxinxiService duiwuxinxiService;

    @Autowired
    private StoreupService storeupService;

    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,DuiwuxinxiEntity duiwuxinxi,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("keyanduiwu")) {
			duiwuxinxi.setDuiwuzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<DuiwuxinxiEntity> ew = new EntityWrapper<DuiwuxinxiEntity>();

		PageUtils page = duiwuxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, duiwuxinxi), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,DuiwuxinxiEntity duiwuxinxi, 
		HttpServletRequest request){
        EntityWrapper<DuiwuxinxiEntity> ew = new EntityWrapper<DuiwuxinxiEntity>();

		PageUtils page = duiwuxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, duiwuxinxi), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( DuiwuxinxiEntity duiwuxinxi){
       	EntityWrapper<DuiwuxinxiEntity> ew = new EntityWrapper<DuiwuxinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( duiwuxinxi, "duiwuxinxi")); 
        return R.ok().put("data", duiwuxinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(DuiwuxinxiEntity duiwuxinxi){
        EntityWrapper< DuiwuxinxiEntity> ew = new EntityWrapper< DuiwuxinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( duiwuxinxi, "duiwuxinxi")); 
		DuiwuxinxiView duiwuxinxiView =  duiwuxinxiService.selectView(ew);
		return R.ok("查询队伍信息成功").put("data", duiwuxinxiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        DuiwuxinxiEntity duiwuxinxi = duiwuxinxiService.selectById(id);
		duiwuxinxi.setClicknum(duiwuxinxi.getClicknum()+1);
		duiwuxinxi.setClicktime(new Date());
		duiwuxinxiService.updateById(duiwuxinxi);
        return R.ok().put("data", duiwuxinxi);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        DuiwuxinxiEntity duiwuxinxi = duiwuxinxiService.selectById(id);
		duiwuxinxi.setClicknum(duiwuxinxi.getClicknum()+1);
		duiwuxinxi.setClicktime(new Date());
		duiwuxinxiService.updateById(duiwuxinxi);
        return R.ok().put("data", duiwuxinxi);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody DuiwuxinxiEntity duiwuxinxi, HttpServletRequest request){
    	duiwuxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(duiwuxinxi);
        duiwuxinxiService.insert(duiwuxinxi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody DuiwuxinxiEntity duiwuxinxi, HttpServletRequest request){
    	duiwuxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(duiwuxinxi);
        duiwuxinxiService.insert(duiwuxinxi);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody DuiwuxinxiEntity duiwuxinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(duiwuxinxi);
        duiwuxinxiService.updateById(duiwuxinxi);//全部更新
        return R.ok();
    }


    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        duiwuxinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	
	/**
     * 前端智能排序
     */
	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params,DuiwuxinxiEntity duiwuxinxi, HttpServletRequest request,String pre){
        EntityWrapper<DuiwuxinxiEntity> ew = new EntityWrapper<DuiwuxinxiEntity>();
        Map<String, Object> newMap = new HashMap<String, Object>();
        Map<String, Object> param = new HashMap<String, Object>();
		Iterator<Map.Entry<String, Object>> it = param.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, Object> entry = it.next();
			String key = entry.getKey();
			String newKey = entry.getKey();
			if (pre.endsWith(".")) {
				newMap.put(pre + newKey, entry.getValue());
			} else if (StringUtils.isEmpty(pre)) {
				newMap.put(newKey, entry.getValue());
			} else {
				newMap.put(pre + "." + newKey, entry.getValue());
			}
		}
		params.put("sort", "clicknum");
        params.put("order", "desc");
		PageUtils page = duiwuxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, duiwuxinxi), params), params));
        return R.ok().put("data", page);
    }









}
