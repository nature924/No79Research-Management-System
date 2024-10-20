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
 * 项目成果申报
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2023-04-25 10:50:40
 */
@TableName("xiangmuchengguoshenbao")
public class XiangmuchengguoshenbaoEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public XiangmuchengguoshenbaoEntity() {
		
	}
	
	public XiangmuchengguoshenbaoEntity(T t) {
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
	 * 申报名称
	 */
					
	private String shenbaomingcheng;
	
	/**
	 * 队伍名称
	 */
					
	private String duiwumingcheng;
	
	/**
	 * 类型
	 */
					
	private String leixing;
	
	/**
	 * 申报资料
	 */
					
	private String shenbaoziliao;
	
	/**
	 * 上传日期
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
	@DateTimeFormat 		
	private Date shangchuanriqi;
	
	/**
	 * 申请内容
	 */
					
	private String shenqingneirong;
	
	/**
	 * 队伍账号
	 */
					
	private String duiwuzhanghao;
	
	/**
	 * 组长姓名
	 */
					
	private String zuzhangxingming;
	
	/**
	 * 是否审核
	 */
					
	private String sfsh;
	
	/**
	 * 审核回复
	 */
					
	private String shhf;
	
	
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
	 * 设置：申报名称
	 */
	public void setShenbaomingcheng(String shenbaomingcheng) {
		this.shenbaomingcheng = shenbaomingcheng;
	}
	/**
	 * 获取：申报名称
	 */
	public String getShenbaomingcheng() {
		return shenbaomingcheng;
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
	 * 设置：类型
	 */
	public void setLeixing(String leixing) {
		this.leixing = leixing;
	}
	/**
	 * 获取：类型
	 */
	public String getLeixing() {
		return leixing;
	}
	/**
	 * 设置：申报资料
	 */
	public void setShenbaoziliao(String shenbaoziliao) {
		this.shenbaoziliao = shenbaoziliao;
	}
	/**
	 * 获取：申报资料
	 */
	public String getShenbaoziliao() {
		return shenbaoziliao;
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
	 * 设置：申请内容
	 */
	public void setShenqingneirong(String shenqingneirong) {
		this.shenqingneirong = shenqingneirong;
	}
	/**
	 * 获取：申请内容
	 */
	public String getShenqingneirong() {
		return shenqingneirong;
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
	 * 设置：是否审核
	 */
	public void setSfsh(String sfsh) {
		this.sfsh = sfsh;
	}
	/**
	 * 获取：是否审核
	 */
	public String getSfsh() {
		return sfsh;
	}
	/**
	 * 设置：审核回复
	 */
	public void setShhf(String shhf) {
		this.shhf = shhf;
	}
	/**
	 * 获取：审核回复
	 */
	public String getShhf() {
		return shhf;
	}

}
