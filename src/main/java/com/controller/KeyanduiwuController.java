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

import com.entity.KeyanduiwuEntity;
import com.entity.view.KeyanduiwuView;

import com.service.KeyanduiwuService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 科研队伍
 * 后端接口
 * @author 
 * @email 
 * @date 2023-04-25 10:50:40
 */
@RestController
@RequestMapping("/keyanduiwu")
public class KeyanduiwuController {
    @Autowired
    private KeyanduiwuService keyanduiwuService;


    
	@Autowired
	private TokenService tokenService;
	
	/**
	 * 登录
	 */
	@IgnoreAuth
	@RequestMapping(value = "/login")
	public R login(String username, String password, String captcha, HttpServletRequest request) {
		KeyanduiwuEntity u = keyanduiwuService.selectOne(new EntityWrapper<KeyanduiwuEntity>().eq("duiwuzhanghao", username));
		if(u==null || !u.getMima().equals(password)) {
			return R.error("账号或密码不正确");
		}
		
		String token = tokenService.generateToken(u.getId(), username,"keyanduiwu",  "科研队伍" );
		return R.ok().put("token", token);
	}

	
	/**
     * 注册
     */
	@IgnoreAuth
    @RequestMapping("/register")
    public R register(@RequestBody KeyanduiwuEntity keyanduiwu){
    	//ValidatorUtils.validateEntity(keyanduiwu);
    	KeyanduiwuEntity u = keyanduiwuService.selectOne(new EntityWrapper<KeyanduiwuEntity>().eq("duiwuzhanghao", keyanduiwu.getDuiwuzhanghao()));
		if(u!=null) {
			return R.error("注册用户已存在");
		}
		Long uId = new Date().getTime();
		keyanduiwu.setId(uId);
        keyanduiwuService.insert(keyanduiwu);
        return R.ok();
    }

	
	/**
	 * 退出
	 */
	@RequestMapping("/logout")
	public R logout(HttpServletRequest request) {
		request.getSession().invalidate();
		return R.ok("退出成功");
	}
	
	/**
     * 获取用户的session用户信息
     */
    @RequestMapping("/session")
    public R getCurrUser(HttpServletRequest request){
    	Long id = (Long)request.getSession().getAttribute("userId");
        KeyanduiwuEntity u = keyanduiwuService.selectById(id);
        return R.ok().put("data", u);
    }
    
    /**
     * 密码重置
     */
    @IgnoreAuth
	@RequestMapping(value = "/resetPass")
    public R resetPass(String username, HttpServletRequest request){
    	KeyanduiwuEntity u = keyanduiwuService.selectOne(new EntityWrapper<KeyanduiwuEntity>().eq("duiwuzhanghao", username));
    	if(u==null) {
    		return R.error("账号不存在");
    	}
        u.setMima("123456");
        keyanduiwuService.updateById(u);
        return R.ok("密码已重置为：123456");
    }


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,KeyanduiwuEntity keyanduiwu,
		HttpServletRequest request){
        EntityWrapper<KeyanduiwuEntity> ew = new EntityWrapper<KeyanduiwuEntity>();

		PageUtils page = keyanduiwuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, keyanduiwu), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,KeyanduiwuEntity keyanduiwu, 
		HttpServletRequest request){
        EntityWrapper<KeyanduiwuEntity> ew = new EntityWrapper<KeyanduiwuEntity>();

		PageUtils page = keyanduiwuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, keyanduiwu), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( KeyanduiwuEntity keyanduiwu){
       	EntityWrapper<KeyanduiwuEntity> ew = new EntityWrapper<KeyanduiwuEntity>();
      	ew.allEq(MPUtil.allEQMapPre( keyanduiwu, "keyanduiwu")); 
        return R.ok().put("data", keyanduiwuService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(KeyanduiwuEntity keyanduiwu){
        EntityWrapper< KeyanduiwuEntity> ew = new EntityWrapper< KeyanduiwuEntity>();
 		ew.allEq(MPUtil.allEQMapPre( keyanduiwu, "keyanduiwu")); 
		KeyanduiwuView keyanduiwuView =  keyanduiwuService.selectView(ew);
		return R.ok("查询科研队伍成功").put("data", keyanduiwuView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        KeyanduiwuEntity keyanduiwu = keyanduiwuService.selectById(id);
        return R.ok().put("data", keyanduiwu);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        KeyanduiwuEntity keyanduiwu = keyanduiwuService.selectById(id);
        return R.ok().put("data", keyanduiwu);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody KeyanduiwuEntity keyanduiwu, HttpServletRequest request){
    	keyanduiwu.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(keyanduiwu);
    	KeyanduiwuEntity u = keyanduiwuService.selectOne(new EntityWrapper<KeyanduiwuEntity>().eq("duiwuzhanghao", keyanduiwu.getDuiwuzhanghao()));
		if(u!=null) {
			return R.error("用户已存在");
		}
		keyanduiwu.setId(new Date().getTime());
        keyanduiwuService.insert(keyanduiwu);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody KeyanduiwuEntity keyanduiwu, HttpServletRequest request){
    	keyanduiwu.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(keyanduiwu);
    	KeyanduiwuEntity u = keyanduiwuService.selectOne(new EntityWrapper<KeyanduiwuEntity>().eq("duiwuzhanghao", keyanduiwu.getDuiwuzhanghao()));
		if(u!=null) {
			return R.error("用户已存在");
		}
		keyanduiwu.setId(new Date().getTime());
        keyanduiwuService.insert(keyanduiwu);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody KeyanduiwuEntity keyanduiwu, HttpServletRequest request){
        //ValidatorUtils.validateEntity(keyanduiwu);
        keyanduiwuService.updateById(keyanduiwu);//全部更新
        return R.ok();
    }


    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        keyanduiwuService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	






    /**
     * （按值统计）
     */
    @RequestMapping("/value/{xColumnName}/{yColumnName}")
    public R value(@PathVariable("yColumnName") String yColumnName, @PathVariable("xColumnName") String xColumnName,HttpServletRequest request) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("xColumn", xColumnName);
        params.put("yColumn", yColumnName);
        EntityWrapper<KeyanduiwuEntity> ew = new EntityWrapper<KeyanduiwuEntity>();
        List<Map<String, Object>> result = keyanduiwuService.selectValue(params, ew);
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
        EntityWrapper<KeyanduiwuEntity> ew = new EntityWrapper<KeyanduiwuEntity>();
        for(int i=0;i<yColumnNames.length;i++) {
            params.put("yColumn", yColumnNames[i]);
            List<Map<String, Object>> result = keyanduiwuService.selectValue(params, ew);
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
        EntityWrapper<KeyanduiwuEntity> ew = new EntityWrapper<KeyanduiwuEntity>();
        List<Map<String, Object>> result = keyanduiwuService.selectTimeStatValue(params, ew);
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
        EntityWrapper<KeyanduiwuEntity> ew = new EntityWrapper<KeyanduiwuEntity>();
        for(int i=0;i<yColumnNames.length;i++) {
            params.put("yColumn", yColumnNames[i]);
            List<Map<String, Object>> result = keyanduiwuService.selectTimeStatValue(params, ew);
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
        EntityWrapper<KeyanduiwuEntity> ew = new EntityWrapper<KeyanduiwuEntity>();
        List<Map<String, Object>> result = keyanduiwuService.selectGroup(params, ew);
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
