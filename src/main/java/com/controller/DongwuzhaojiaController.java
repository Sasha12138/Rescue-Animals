package com.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.DongwuzhaojiaEntity;
import com.entity.view.DongwuzhaojiaView;

import com.service.DongwuzhaojiaService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;

/**
 * 动物找家
 * 后端接口
 * @author 
 * @email 
 * @date 2023-06-24 08:54:46
 */
@RestController
@RequestMapping("/dongwuzhaojia")
public class DongwuzhaojiaController {
    @Autowired
    private DongwuzhaojiaService dongwuzhaojiaService;




    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,DongwuzhaojiaEntity dongwuzhaojia, 
		HttpServletRequest request){

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			dongwuzhaojia.setYonghuzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<DongwuzhaojiaEntity> ew = new EntityWrapper<DongwuzhaojiaEntity>();


		PageUtils page = dongwuzhaojiaService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, dongwuzhaojia), params), params));
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,DongwuzhaojiaEntity dongwuzhaojia, 
		HttpServletRequest request){
        EntityWrapper<DongwuzhaojiaEntity> ew = new EntityWrapper<DongwuzhaojiaEntity>();

		PageUtils page = dongwuzhaojiaService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, dongwuzhaojia), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( DongwuzhaojiaEntity dongwuzhaojia){
       	EntityWrapper<DongwuzhaojiaEntity> ew = new EntityWrapper<DongwuzhaojiaEntity>();
      	ew.allEq(MPUtil.allEQMapPre( dongwuzhaojia, "dongwuzhaojia")); 
        return R.ok().put("data", dongwuzhaojiaService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(DongwuzhaojiaEntity dongwuzhaojia){
        EntityWrapper< DongwuzhaojiaEntity> ew = new EntityWrapper< DongwuzhaojiaEntity>();
 		ew.allEq(MPUtil.allEQMapPre( dongwuzhaojia, "dongwuzhaojia")); 
		DongwuzhaojiaView dongwuzhaojiaView =  dongwuzhaojiaService.selectView(ew);
		return R.ok("查询动物找家成功").put("data", dongwuzhaojiaView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        DongwuzhaojiaEntity dongwuzhaojia = dongwuzhaojiaService.selectById(id);
        return R.ok().put("data", dongwuzhaojia);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        DongwuzhaojiaEntity dongwuzhaojia = dongwuzhaojiaService.selectById(id);
        return R.ok().put("data", dongwuzhaojia);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody DongwuzhaojiaEntity dongwuzhaojia, HttpServletRequest request){
    	dongwuzhaojia.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(dongwuzhaojia);

        dongwuzhaojiaService.insert(dongwuzhaojia);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody DongwuzhaojiaEntity dongwuzhaojia, HttpServletRequest request){
    	dongwuzhaojia.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(dongwuzhaojia);

        dongwuzhaojiaService.insert(dongwuzhaojia);
        return R.ok();
    }


    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody DongwuzhaojiaEntity dongwuzhaojia, HttpServletRequest request){
        //ValidatorUtils.validateEntity(dongwuzhaojia);
        dongwuzhaojiaService.updateById(dongwuzhaojia);//全部更新
        return R.ok();
    }

    /**
     * 审核
     */
    @RequestMapping("/shBatch")
    @Transactional
    public R update(@RequestBody Long[] ids, @RequestParam String sfsh, @RequestParam String shhf){
        List<DongwuzhaojiaEntity> list = new ArrayList<DongwuzhaojiaEntity>();
        for(Long id : ids) {
            DongwuzhaojiaEntity dongwuzhaojia = dongwuzhaojiaService.selectById(id);
            dongwuzhaojia.setSfsh(sfsh);
            dongwuzhaojia.setShhf(shhf);
            list.add(dongwuzhaojia);
        }
        dongwuzhaojiaService.updateBatchById(list);
        return R.ok();
    }
    
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        dongwuzhaojiaService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	









}
