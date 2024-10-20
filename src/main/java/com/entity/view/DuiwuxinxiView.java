package com.entity.view;

import com.entity.DuiwuxinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 队伍信息
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2023-04-25 10:50:40
 */
@TableName("duiwuxinxi")
public class DuiwuxinxiView  extends DuiwuxinxiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public DuiwuxinxiView(){
	}
 
 	public DuiwuxinxiView(DuiwuxinxiEntity duiwuxinxiEntity){
 	try {
			BeanUtils.copyProperties(this, duiwuxinxiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
