package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ZiyuanwenjianEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ZiyuanwenjianVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ZiyuanwenjianView;


/**
 * 资源文件
 *
 * @author 
 * @email 
 * @date 2023-04-25 10:50:40
 */
public interface ZiyuanwenjianService extends IService<ZiyuanwenjianEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ZiyuanwenjianVO> selectListVO(Wrapper<ZiyuanwenjianEntity> wrapper);
   	
   	ZiyuanwenjianVO selectVO(@Param("ew") Wrapper<ZiyuanwenjianEntity> wrapper);
   	
   	List<ZiyuanwenjianView> selectListView(Wrapper<ZiyuanwenjianEntity> wrapper);
   	
   	ZiyuanwenjianView selectView(@Param("ew") Wrapper<ZiyuanwenjianEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ZiyuanwenjianEntity> wrapper);
   	

}

