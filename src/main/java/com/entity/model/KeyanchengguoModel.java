package com.entity.model;

import com.entity.KeyanchengguoEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 科研成果
 * 接收传参的实体类  
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
 * 取自ModelAndView 的model名称
 * @author 
 * @email 
 * @date 2023-04-25 10:50:40
 */
public class KeyanchengguoModel  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 队伍名称
	 */
	
	private String duiwumingcheng;
		
	/**
	 * 成果类型
	 */
	
	private String chengguoleixing;
		
	/**
	 * 成果附件
	 */
	
	private String chengguofujian;
		
	/**
	 * 封面
	 */
	
	private String fengmian;
		
	/**
	 * 上传日期
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date shangchuanriqi;
		
	/**
	 * 成果内容
	 */
	
	private String chengguoneirong;
		
	/**
	 * 队伍账号
	 */
	
	private String duiwuzhanghao;
		
	/**
	 * 组长姓名
	 */
	
	private String zuzhangxingming;
		
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
	 * 设置：队伍名称
	 */
	 
	public void setDuiwumingcheng(String duiwumingcheng) {
		this.duiwumingcheng = duiwumingcheng;
	}
	
	/**
	 * 获取：队伍名称
	 */
	public String getDuiwumingcheng() {
		return duiwumingcheng;
	}
				
	
	/**
	 * 设置：成果类型
	 */
	 
	public void setChengguoleixing(String chengguoleixing) {
		this.chengguoleixing = chengguoleixing;
	}
	
	/**
	 * 获取：成果类型
	 */
	public String getChengguoleixing() {
		return chengguoleixing;
	}
				
	
	/**
	 * 设置：成果附件
	 */
	 
	public void setChengguofujian(String chengguofujian) {
		this.chengguofujian = chengguofujian;
	}
	
	/**
	 * 获取：成果附件
	 */
	public String getChengguofujian() {
		return chengguofujian;
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
	 * 设置：上传日期
	 */
	 
	public void setShangchuanriqi(Date shangchuanriqi) {
		this.shangchuanriqi = shangchuanriqi;
	}
	
	/**
	 * 获取：上传日期
	 */
	public Date getShangchuanriqi() {
		return shangchuanriqi;
	}
				
	
	/**
	 * 设置：成果内容
	 */
	 
	public void setChengguoneirong(String chengguoneirong) {
		this.chengguoneirong = chengguoneirong;
	}
	
	/**
	 * 获取：成果内容
	 */
	public String getChengguoneirong() {
		return chengguoneirong;
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
