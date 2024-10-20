package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;


/**
 * 科研成果
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2023-04-25 10:50:40
 */
@TableName("keyanchengguo")
public class KeyanchengguoEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public KeyanchengguoEntity() {
		
	}
	
	public KeyanchengguoEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 主键id
	 */
	@TableId
	private Long id;
	/**
	 * 成果名称
	 */
					
	private String chengguomingcheng;
	
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
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
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
	
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;

	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 设置：成果名称
	 */
	public void setChengguomingcheng(String chengguomingcheng) {
		this.chengguomingcheng = chengguomingcheng;
	}
	/**
	 * 获取：成果名称
	 */
	public String getChengguomingcheng() {
		return chengguomingcheng;
	}
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
