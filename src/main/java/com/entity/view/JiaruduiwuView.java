package com.entity.view;

import com.entity.JiaruduiwuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 加入队伍
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2023-04-25 10:50:40
 */
@TableName("jiaruduiwu")
public class JiaruduiwuView  extends JiaruduiwuEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public JiaruduiwuView(){
	}
 
 	public JiaruduiwuView(JiaruduiwuEntity jiaruduiwuEntity){
 	try {
			BeanUtils.copyProperties(this, jiaruduiwuEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
