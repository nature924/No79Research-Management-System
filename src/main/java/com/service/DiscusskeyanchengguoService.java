package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DiscusskeyanchengguoEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DiscusskeyanchengguoVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DiscusskeyanchengguoView;


/**
 * 科研成果评论表
 *
 * @author 
 * @email 
 * @date 2023-04-25 10:50:41
 */
public interface DiscusskeyanchengguoService extends IService<DiscusskeyanchengguoEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscusskeyanchengguoVO> selectListVO(Wrapper<DiscusskeyanchengguoEntity> wrapper);
   	
   	DiscusskeyanchengguoVO selectVO(@Param("ew") Wrapper<DiscusskeyanchengguoEntity> wrapper);
   	
   	List<DiscusskeyanchengguoView> selectListView(Wrapper<DiscusskeyanchengguoEntity> wrapper);
   	
   	DiscusskeyanchengguoView selectView(@Param("ew") Wrapper<DiscusskeyanchengguoEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscusskeyanchengguoEntity> wrapper);
   	

}

