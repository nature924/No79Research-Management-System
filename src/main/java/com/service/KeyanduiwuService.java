package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.KeyanduiwuEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.KeyanduiwuVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.KeyanduiwuView;


/**
 * 科研队伍
 *
 * @author 
 * @email 
 * @date 2023-04-25 10:50:40
 */
public interface KeyanduiwuService extends IService<KeyanduiwuEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<KeyanduiwuVO> selectListVO(Wrapper<KeyanduiwuEntity> wrapper);
   	
   	KeyanduiwuVO selectVO(@Param("ew") Wrapper<KeyanduiwuEntity> wrapper);
   	
   	List<KeyanduiwuView> selectListView(Wrapper<KeyanduiwuEntity> wrapper);
   	
   	KeyanduiwuView selectView(@Param("ew") Wrapper<KeyanduiwuEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<KeyanduiwuEntity> wrapper);
   	

    List<Map<String, Object>> selectValue(Map<String, Object> params,Wrapper<KeyanduiwuEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params,Wrapper<KeyanduiwuEntity> wrapper);

    List<Map<String, Object>> selectGroup(Map<String, Object> params,Wrapper<KeyanduiwuEntity> wrapper);



}

