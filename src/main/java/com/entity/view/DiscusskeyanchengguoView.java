package com.entity.view;

import com.entity.DiscusskeyanchengguoEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 科研成果评论表
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2023-04-25 10:50:41
 */
@TableName("discusskeyanchengguo")
public class DiscusskeyanchengguoView  extends DiscusskeyanchengguoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public DiscusskeyanchengguoView(){
	}
 
 	public DiscusskeyanchengguoView(DiscusskeyanchengguoEntity discusskeyanchengguoEntity){
 	try {
			BeanUtils.copyProperties(this, discusskeyanchengguoEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
