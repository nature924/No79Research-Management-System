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

import com.entity.KeyanchengguoEntity;
import com.entity.view.KeyanchengguoView;

import com.service.KeyanchengguoService;
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
 * 科研成果
 * 后端接口
 * @author 
 * @email 
 * @date 2023-04-25 10:50:40
 */
@RestController
@RequestMapping("/keyanchengguo")
public class KeyanchengguoController {
    @Autowired
    private KeyanchengguoService keyanchengguoService;

    @Autowired
    private StoreupService storeupService;

    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,KeyanchengguoEntity keyanchengguo,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("keyanduiwu")) {
			keyanchengguo.setDuiwuzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<KeyanchengguoEntity> ew = new EntityWrapper<KeyanchengguoEntity>();

		PageUtils page = keyanchengguoService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, keyanchengguo), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,KeyanchengguoEntity keyanchengguo, 
		HttpServletRequest request){
        EntityWrapper<KeyanchengguoEntity> ew = new EntityWrapper<KeyanchengguoEntity>();

		PageUtils page = keyanchengguoService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, keyanchengguo), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( KeyanchengguoEntity keyanchengguo){
       	EntityWrapper<KeyanchengguoEntity> ew = new EntityWrapper<KeyanchengguoEntity>();
      	ew.allEq(MPUtil.allEQMapPre( keyanchengguo, "keyanchengguo")); 
        return R.ok().put("data", keyanchengguoService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(KeyanchengguoEntity keyanchengguo){
        EntityWrapper< KeyanchengguoEntity> ew = new EntityWrapper< KeyanchengguoEntity>();
 		ew.allEq(MPUtil.allEQMapPre( keyanchengguo, "keyanchengguo")); 
		KeyanchengguoView keyanchengguoView =  keyanchengguoService.selectView(ew);
		return R.ok("查询科研成果成功").put("data", keyanchengguoView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        KeyanchengguoEntity keyanchengguo = keyanchengguoService.selectById(id);
		keyanchengguo.setClicknum(keyanchengguo.getClicknum()+1);
		keyanchengguo.setClicktime(new Date());
		keyanchengguoService.updateById(keyanchengguo);
        return R.ok().put("data", keyanchengguo);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        KeyanchengguoEntity keyanchengguo = keyanchengguoService.selectById(id);
		keyanchengguo.setClicknum(keyanchengguo.getClicknum()+1);
		keyanchengguo.setClicktime(new Date());
		keyanchengguoService.updateById(keyanchengguo);
        return R.ok().put("data", keyanchengguo);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody KeyanchengguoEntity keyanchengguo, HttpServletRequest request){
    	keyanchengguo.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(keyanchengguo);
        keyanchengguoService.insert(keyanchengguo);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
	@IgnoreAuth
    @RequestMapping("/add")
    public R add(@RequestBody KeyanchengguoEntity keyanchengguo, HttpServletRequest request){
    	keyanchengguo.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(keyanchengguo);
        keyanchengguoService.insert(keyanchengguo);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody KeyanchengguoEntity keyanchengguo, HttpServletRequest request){
        //ValidatorUtils.validateEntity(keyanchengguo);
        keyanchengguoService.updateById(keyanchengguo);//全部更新
        return R.ok();
    }


    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        keyanchengguoService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	
	/**
     * 前端智能排序
     */
	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params,KeyanchengguoEntity keyanchengguo, HttpServletRequest request,String pre){
        EntityWrapper<KeyanchengguoEntity> ew = new EntityWrapper<KeyanchengguoEntity>();
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
		PageUtils page = keyanchengguoService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, keyanchengguo), params), params));
        return R.ok().put("data", page);
    }






    /**
     * （按值统计）
     */
    @RequestMapping("/value/{xColumnName}/{yColumnName}")
    public R value(@PathVariable("yColumnName") String yColumnName, @PathVariable("xColumnName") String xColumnName,HttpServletRequest request) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("xColumn", xColumnName);
        params.put("yColumn", yColumnName);
        EntityWrapper<KeyanchengguoEntity> ew = new EntityWrapper<KeyanchengguoEntity>();
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("keyanduiwu")) {
            ew.eq("duiwuzhanghao", (String)request.getSession().getAttribute("username"));
		}
        List<Map<String, Object>> result = keyanchengguoService.selectValue(params, ew);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for(Map<String, Object> m : result) {
            for(String k : m.keySet()) {
                if(m.get(k) instanceof Date) {
                    m.put(k, sdf.format((Date)m.get(k)));
                }
            }
        }
        return R.ok().put("data", result);
    }

    /**
     * （按值统计(多)）
     */
    @RequestMapping("/valueMul/{xColumnName}")
    public R valueMul(@PathVariable("xColumnName") String xColumnName,@RequestParam String yColumnNameMul, HttpServletRequest request) {
        String[] yColumnNames = yColumnNameMul.split(",");
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("xColumn", xColumnName);
        List<List<Map<String, Object>>> result2 = new ArrayList<List<Map<String,Object>>>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        EntityWrapper<KeyanchengguoEntity> ew = new EntityWrapper<KeyanchengguoEntity>();
        String tableName = request.getSession().getAttribute("tableName").toString();
        if(tableName.equals("keyanduiwu")) {
            ew.eq("duiwuzhanghao", (String)request.getSession().getAttribute("username"));
        }
        for(int i=0;i<yColumnNames.length;i++) {
            params.put("yColumn", yColumnNames[i]);
            List<Map<String, Object>> result = keyanchengguoService.selectValue(params, ew);
            for(Map<String, Object> m : result) {
                for(String k : m.keySet()) {
                    if(m.get(k) instanceof Date) {
                        m.put(k, sdf.format((Date)m.get(k)));
                    }
                }
            }
            result2.add(result);
        }
        return R.ok().put("data", result2);
    }

    /**
     * （按值统计）时间统计类型
     */
    @RequestMapping("/value/{xColumnName}/{yColumnName}/{timeStatType}")
    public R valueDay(@PathVariable("yColumnName") String yColumnName, @PathVariable("xColumnName") String xColumnName, @PathVariable("timeStatType") String timeStatType,HttpServletRequest request) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("xColumn", xColumnName);
        params.put("yColumn", yColumnName);
        params.put("timeStatType", timeStatType);
        EntityWrapper<KeyanchengguoEntity> ew = new EntityWrapper<KeyanchengguoEntity>();
        String tableName = request.getSession().getAttribute("tableName").toString();
        if(tableName.equals("keyanduiwu")) {
            ew.eq("duiwuzhanghao", (String)request.getSession().getAttribute("username"));
        }
        List<Map<String, Object>> result = keyanchengguoService.selectTimeStatValue(params, ew);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for(Map<String, Object> m : result) {
            for(String k : m.keySet()) {
                if(m.get(k) instanceof Date) {
                    m.put(k, sdf.format((Date)m.get(k)));
                }
            }
        }
        return R.ok().put("data", result);
    }

    /**
     * （按值统计）时间统计类型(多)
     */
    @RequestMapping("/valueMul/{xColumnName}/{timeStatType}")
    public R valueMulDay(@PathVariable("xColumnName") String xColumnName, @PathVariable("timeStatType") String timeStatType,@RequestParam String yColumnNameMul,HttpServletRequest request) {
        String[] yColumnNames = yColumnNameMul.split(",");
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("xColumn", xColumnName);
        params.put("timeStatType", timeStatType);
        List<List<Map<String, Object>>> result2 = new ArrayList<List<Map<String,Object>>>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        EntityWrapper<KeyanchengguoEntity> ew = new EntityWrapper<KeyanchengguoEntity>();
        String tableName = request.getSession().getAttribute("tableName").toString();
        if(tableName.equals("keyanduiwu")) {
            ew.eq("duiwuzhanghao", (String)request.getSession().getAttribute("username"));
        }
        for(int i=0;i<yColumnNames.length;i++) {
            params.put("yColumn", yColumnNames[i]);
            List<Map<String, Object>> result = keyanchengguoService.selectTimeStatValue(params, ew);
            for(Map<String, Object> m : result) {
                for(String k : m.keySet()) {
                    if(m.get(k) instanceof Date) {
                        m.put(k, sdf.format((Date)m.get(k)));
                    }
                }
            }
            result2.add(result);
        }
        return R.ok().put("data", result2);
    }

    /**
     * 分组统计
     */
    @RequestMapping("/group/{columnName}")
    public R group(@PathVariable("columnName") String columnName,HttpServletRequest request) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("column", columnName);
        EntityWrapper<KeyanchengguoEntity> ew = new EntityWrapper<KeyanchengguoEntity>();
        String tableName = request.getSession().getAttribute("tableName").toString();
        if(tableName.equals("keyanduiwu")) {
            ew.eq("duiwuzhanghao", (String)request.getSession().getAttribute("username"));
        }
        List<Map<String, Object>> result = keyanchengguoService.selectGroup(params, ew);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for(Map<String, Object> m : result) {
            for(String k : m.keySet()) {
                if(m.get(k) instanceof Date) {
                    m.put(k, sdf.format((Date)m.get(k)));
                }
            }
        }
        return R.ok().put("data", result);
    }






}
