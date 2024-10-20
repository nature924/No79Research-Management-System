package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DuiwushenqingEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DuiwushenqingVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DuiwushenqingView;


/**
 * 队伍申请
 *
 * @author 
 * @email 
 * @date 2023-04-25 10:50:40
 */
public interface DuiwushenqingService extends IService<DuiwushenqingEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DuiwushenqingVO> selectListVO(Wrapper<DuiwushenqingEntity> wrapper);
   	
   	DuiwushenqingVO selectVO(@Param("ew") Wrapper<DuiwushenqingEntity> wrapper);
   	
   	List<DuiwushenqingView> selectListView(Wrapper<DuiwushenqingEntity> wrapper);
   	
   	DuiwushenqingView selectView(@Param("ew") Wrapper<DuiwushenqingEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DuiwushenqingEntity> wrapper);
   	

}

