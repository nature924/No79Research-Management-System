package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DuiwuxinxiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DuiwuxinxiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DuiwuxinxiView;


/**
 * 队伍信息
 *
 * @author 
 * @email 
 * @date 2023-04-25 10:50:40
 */
public interface DuiwuxinxiService extends IService<DuiwuxinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DuiwuxinxiVO> selectListVO(Wrapper<DuiwuxinxiEntity> wrapper);
   	
   	DuiwuxinxiVO selectVO(@Param("ew") Wrapper<DuiwuxinxiEntity> wrapper);
   	
   	List<DuiwuxinxiView> selectListView(Wrapper<DuiwuxinxiEntity> wrapper);
   	
   	DuiwuxinxiView selectView(@Param("ew") Wrapper<DuiwuxinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DuiwuxinxiEntity> wrapper);
   	

}

