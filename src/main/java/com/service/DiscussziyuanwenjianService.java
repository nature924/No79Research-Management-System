package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DiscussziyuanwenjianEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DiscussziyuanwenjianVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DiscussziyuanwenjianView;


/**
 * 资源文件评论表
 *
 * @author 
 * @email 
 * @date 2023-04-25 10:50:41
 */
public interface DiscussziyuanwenjianService extends IService<DiscussziyuanwenjianEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscussziyuanwenjianVO> selectListVO(Wrapper<DiscussziyuanwenjianEntity> wrapper);
   	
   	DiscussziyuanwenjianVO selectVO(@Param("ew") Wrapper<DiscussziyuanwenjianEntity> wrapper);
   	
   	List<DiscussziyuanwenjianView> selectListView(Wrapper<DiscussziyuanwenjianEntity> wrapper);
   	
   	DiscussziyuanwenjianView selectView(@Param("ew") Wrapper<DiscussziyuanwenjianEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscussziyuanwenjianEntity> wrapper);
   	

}

