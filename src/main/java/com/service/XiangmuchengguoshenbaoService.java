package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.XiangmuchengguoshenbaoEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.XiangmuchengguoshenbaoVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.XiangmuchengguoshenbaoView;


/**
 * 项目成果申报
 *
 * @author 
 * @email 
 * @date 2023-04-25 10:50:40
 */
public interface XiangmuchengguoshenbaoService extends IService<XiangmuchengguoshenbaoEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<XiangmuchengguoshenbaoVO> selectListVO(Wrapper<XiangmuchengguoshenbaoEntity> wrapper);
   	
   	XiangmuchengguoshenbaoVO selectVO(@Param("ew") Wrapper<XiangmuchengguoshenbaoEntity> wrapper);
   	
   	List<XiangmuchengguoshenbaoView> selectListView(Wrapper<XiangmuchengguoshenbaoEntity> wrapper);
   	
   	XiangmuchengguoshenbaoView selectView(@Param("ew") Wrapper<XiangmuchengguoshenbaoEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<XiangmuchengguoshenbaoEntity> wrapper);
   	

}

