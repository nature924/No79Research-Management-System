package com.entity.model;

import com.entity.DuiwuxinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 队伍信息
 * 接收传参的实体类  
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
 * 取自ModelAndView 的model名称
 * @author 
 * @email 
 * @date 2023-04-25 10:50:40
 */
public class DuiwuxinxiModel  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 成立日期
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date chengliriqi;
		
	/**
	 * 队伍账号
	 */
	
	private String duiwuzhanghao;
		
	/**
	 * 组长姓名
	 */
	
	private String zuzhangxingming;
		
	/**
	 * 封面
	 */
	
	private String fengmian;
		
	/**
	 * 联系电话
	 */
	
	private String lianxidianhua;
		
	/**
	 * 获得荣誉
	 */
	
	private String huoderongyu;
		
	/**
	 * 队伍介绍
	 */
	
	private String duiwujieshao;
		
	/**
	 * 最近点击时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date clicktime;
		
	/**
	 * 点击次数
	 */
	
	private Integer clicknum;
				
	
	/**
	 * 设置：成立日期
	 */
	 
	public void setChengliriqi(Date chengliriqi) {
		this.chengliriqi = chengliriqi;
	}
	
	/**
	 * 获取：成立日期
	 */
	public Date getChengliriqi() {
		return chengliriqi;
	}
				
	
	/**
	 * 设置：队伍账号
	 */
	 
	public void setDuiwuzhanghao(String duiwuzhanghao) {
		this.duiwuzhanghao = duiwuzhanghao;
	}
	
	/**
	 * 获取：队伍账号
	 */
	public String getDuiwuzhanghao() {
		return duiwuzhanghao;
	}
				
	
	/**
	 * 设置：组长姓名
	 */
	 
	public void setZuzhangxingming(String zuzhangxingming) {
		this.zuzhangxingming = zuzhangxingming;
	}
	
	/**
	 * 获取：组长姓名
	 */
	public String getZuzhangxingming() {
		return zuzhangxingming;
	}
				
	
	/**
	 * 设置：封面
	 */
	 
	public void setFengmian(String fengmian) {
		this.fengmian = fengmian;
	}
	
	/**
	 * 获取：封面
	 */
	public String getFengmian() {
		return fengmian;
	}
				
	
	/**
	 * 设置：联系电话
	 */
	 
	public void setLianxidianhua(String lianxidianhua) {
		this.lianxidianhua = lianxidianhua;
	}
	
	/**
	 * 获取：联系电话
	 */
	public String getLianxidianhua() {
		return lianxidianhua;
	}
				
	
	/**
	 * 设置：获得荣誉
	 */
	 
	public void setHuoderongyu(String huoderongyu) {
		this.huoderongyu = huoderongyu;
	}
	
	/**
	 * 获取：获得荣誉
	 */
	public String getHuoderongyu() {
		return huoderongyu;
	}
				
	
	/**
	 * 设置：队伍介绍
	 */
	 
	public void setDuiwujieshao(String duiwujieshao) {
		this.duiwujieshao = duiwujieshao;
	}
	
	/**
	 * 获取：队伍介绍
	 */
	public String getDuiwujieshao() {
		return duiwujieshao;
	}
				
	
	/**
	 * 设置：最近点击时间
	 */
	 
	public void setClicktime(Date clicktime) {
		this.clicktime = clicktime;
	}
	
	/**
	 * 获取：最近点击时间
	 */
	public Date getClicktime() {
		return clicktime;
	}
				
	
	/**
	 * 设置：点击次数
	 */
	 
	public void setClicknum(Integer clicknum) {
		this.clicknum = clicknum;
	}
	
	/**
	 * 获取：点击次数
	 */
	public Integer getClicknum() {
		return clicknum;
	}
			
}
