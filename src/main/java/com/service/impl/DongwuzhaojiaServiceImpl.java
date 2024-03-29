package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.DongwuzhaojiaDao;
import com.entity.DongwuzhaojiaEntity;
import com.service.DongwuzhaojiaService;
import com.entity.vo.DongwuzhaojiaVO;
import com.entity.view.DongwuzhaojiaView;

@Service("dongwuzhaojiaService")
public class DongwuzhaojiaServiceImpl extends ServiceImpl<DongwuzhaojiaDao, DongwuzhaojiaEntity> implements DongwuzhaojiaService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DongwuzhaojiaEntity> page = this.selectPage(
                new Query<DongwuzhaojiaEntity>(params).getPage(),
                new EntityWrapper<DongwuzhaojiaEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DongwuzhaojiaEntity> wrapper) {
		  Page<DongwuzhaojiaView> page =new Query<DongwuzhaojiaView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<DongwuzhaojiaVO> selectListVO(Wrapper<DongwuzhaojiaEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DongwuzhaojiaVO selectVO(Wrapper<DongwuzhaojiaEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DongwuzhaojiaView> selectListView(Wrapper<DongwuzhaojiaEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DongwuzhaojiaView selectView(Wrapper<DongwuzhaojiaEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
