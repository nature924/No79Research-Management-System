package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.JiaruduiwuEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.JiaruduiwuVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.JiaruduiwuView;


/**
 * 加入队伍
 *
 * @author 
 * @email 
 * @date 2023-04-25 10:50:40
 */
public interface JiaruduiwuService extends IService<JiaruduiwuEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<JiaruduiwuVO> selectListVO(Wrapper<JiaruduiwuEntity> wrapper);
   	
   	JiaruduiwuVO selectVO(@Param("ew") Wrapper<JiaruduiwuEntity> wrapper);
   	
   	List<JiaruduiwuView> selectListView(Wrapper<JiaruduiwuEntity> wrapper);
   	
   	JiaruduiwuView selectView(@Param("ew") Wrapper<JiaruduiwuEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<JiaruduiwuEntity> wrapper);
   	

}

