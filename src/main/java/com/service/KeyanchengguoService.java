package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.KeyanchengguoEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.KeyanchengguoVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.KeyanchengguoView;


/**
 * 科研成果
 *
 * @author 
 * @email 
 * @date 2023-04-25 10:50:40
 */
public interface KeyanchengguoService extends IService<KeyanchengguoEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<KeyanchengguoVO> selectListVO(Wrapper<KeyanchengguoEntity> wrapper);
   	
   	KeyanchengguoVO selectVO(@Param("ew") Wrapper<KeyanchengguoEntity> wrapper);
   	
   	List<KeyanchengguoView> selectListView(Wrapper<KeyanchengguoEntity> wrapper);
   	
   	KeyanchengguoView selectView(@Param("ew") Wrapper<KeyanchengguoEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<KeyanchengguoEntity> wrapper);
   	

    List<Map<String, Object>> selectValue(Map<String, Object> params,Wrapper<KeyanchengguoEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params,Wrapper<KeyanchengguoEntity> wrapper);

    List<Map<String, Object>> selectGroup(Map<String, Object> params,Wrapper<KeyanchengguoEntity> wrapper);



}

