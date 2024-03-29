package com.entity.view;

import com.entity.DongwuzhaojiaEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 动物找家
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2023-06-24 08:54:46
 */
@TableName("dongwuzhaojia")
public class DongwuzhaojiaView  extends DongwuzhaojiaEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public DongwuzhaojiaView(){
	}
 
 	public DongwuzhaojiaView(DongwuzhaojiaEntity dongwuzhaojiaEntity){
 	try {
			BeanUtils.copyProperties(this, dongwuzhaojiaEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
