package com.entity.view;

import com.entity.ZiyuanwenjianEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 资源文件
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2023-04-25 10:50:40
 */
@TableName("ziyuanwenjian")
public class ZiyuanwenjianView  extends ZiyuanwenjianEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public ZiyuanwenjianView(){
	}
 
 	public ZiyuanwenjianView(ZiyuanwenjianEntity ziyuanwenjianEntity){
 	try {
			BeanUtils.copyProperties(this, ziyuanwenjianEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
