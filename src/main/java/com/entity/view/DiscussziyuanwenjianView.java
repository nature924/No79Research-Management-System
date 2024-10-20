package com.entity.view;

import com.entity.DiscussziyuanwenjianEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 资源文件评论表
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2023-04-25 10:50:41
 */
@TableName("discussziyuanwenjian")
public class DiscussziyuanwenjianView  extends DiscussziyuanwenjianEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public DiscussziyuanwenjianView(){
	}
 
 	public DiscussziyuanwenjianView(DiscussziyuanwenjianEntity discussziyuanwenjianEntity){
 	try {
			BeanUtils.copyProperties(this, discussziyuanwenjianEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
