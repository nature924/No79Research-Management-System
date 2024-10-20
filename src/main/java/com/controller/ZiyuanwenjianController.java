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

import com.entity.ZiyuanwenjianEntity;
import com.entity.view.ZiyuanwenjianView;

import com.service.ZiyuanwenjianService;
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
 * 资源文件
 * 后端接口
 * @author 
 * @email 
 * @date 2023-04-25 10:50:40
 */
@RestController
@RequestMapping("/ziyuanwenjian")
public class ZiyuanwenjianController {
    @Autowired
    private ZiyuanwenjianService ziyuanwenjianService;

    @Autowired
    private StoreupService storeupService;

    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ZiyuanwenjianEntity ziyuanwenjian,
		HttpServletRequest request){
    	if(!request.getSession().getAttribute("role").toString().equals("管理员")) {
    		ziyuanwenjian.setUserid((Long)request.getSession().getAttribute("userId"));
    	}
        EntityWrapper<ZiyuanwenjianEntity> ew = new EntityWrapper<ZiyuanwenjianEntity>();

		PageUtils page = ziyuanwenjianService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, ziyuanwenjian), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ZiyuanwenjianEntity ziyuanwenjian, 
		HttpServletRequest request){
        EntityWrapper<ZiyuanwenjianEntity> ew = new EntityWrapper<ZiyuanwenjianEntity>();

		PageUtils page = ziyuanwenjianService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, ziyuanwenjian), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ZiyuanwenjianEntity ziyuanwenjian){
       	EntityWrapper<ZiyuanwenjianEntity> ew = new EntityWrapper<ZiyuanwenjianEntity>();
      	ew.allEq(MPUtil.allEQMapPre( ziyuanwenjian, "ziyuanwenjian")); 
        return R.ok().put("data", ziyuanwenjianService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ZiyuanwenjianEntity ziyuanwenjian){
        EntityWrapper< ZiyuanwenjianEntity> ew = new EntityWrapper< ZiyuanwenjianEntity>();
 		ew.allEq(MPUtil.allEQMapPre( ziyuanwenjian, "ziyuanwenjian")); 
		ZiyuanwenjianView ziyuanwenjianView =  ziyuanwenjianService.selectView(ew);
		return R.ok("查询资源文件成功").put("data", ziyuanwenjianView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ZiyuanwenjianEntity ziyuanwenjian = ziyuanwenjianService.selectById(id);
		ziyuanwenjian.setClicknum(ziyuanwenjian.getClicknum()+1);
		ziyuanwenjian.setClicktime(new Date());
		ziyuanwenjianService.updateById(ziyuanwenjian);
        return R.ok().put("data", ziyuanwenjian);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ZiyuanwenjianEntity ziyuanwenjian = ziyuanwenjianService.selectById(id);
		ziyuanwenjian.setClicknum(ziyuanwenjian.getClicknum()+1);
		ziyuanwenjian.setClicktime(new Date());
		ziyuanwenjianService.updateById(ziyuanwenjian);
        return R.ok().put("data", ziyuanwenjian);
    }
    


    /**
     * 赞或踩
     */
    @RequestMapping("/thumbsup/{id}")
    public R vote(@PathVariable("id") String id,String type){
        ZiyuanwenjianEntity ziyuanwenjian = ziyuanwenjianService.selectById(id);
        if(type.equals("1")) {
        	ziyuanwenjian.setThumbsupnum(ziyuanwenjian.getThumbsupnum()+1);
        } else {
        	ziyuanwenjian.setCrazilynum(ziyuanwenjian.getCrazilynum()+1);
        }
        ziyuanwenjianService.updateById(ziyuanwenjian);
        return R.ok("投票成功");
    }

    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ZiyuanwenjianEntity ziyuanwenjian, HttpServletRequest request){
    	ziyuanwenjian.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(ziyuanwenjian);
    	ziyuanwenjian.setUserid((Long)request.getSession().getAttribute("userId"));
        ziyuanwenjianService.insert(ziyuanwenjian);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ZiyuanwenjianEntity ziyuanwenjian, HttpServletRequest request){
    	ziyuanwenjian.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(ziyuanwenjian);
        ziyuanwenjianService.insert(ziyuanwenjian);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ZiyuanwenjianEntity ziyuanwenjian, HttpServletRequest request){
        //ValidatorUtils.validateEntity(ziyuanwenjian);
        ziyuanwenjianService.updateById(ziyuanwenjian);//全部更新
        return R.ok();
    }


    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        ziyuanwenjianService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	
	/**
     * 前端智能排序
     */
	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params,ZiyuanwenjianEntity ziyuanwenjian, HttpServletRequest request,String pre){
        EntityWrapper<ZiyuanwenjianEntity> ew = new EntityWrapper<ZiyuanwenjianEntity>();
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
		PageUtils page = ziyuanwenjianService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, ziyuanwenjian), params), params));
        return R.ok().put("data", page);
    }









}
