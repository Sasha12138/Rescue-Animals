package com.entity.view;

import com.entity.DongwubaikeEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 动物百科
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2023-06-24 08:54:46
 */
@TableName("dongwubaike")
public class DongwubaikeView  extends DongwubaikeEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public DongwubaikeView(){
	}
 
 	public DongwubaikeView(DongwubaikeEntity dongwubaikeEntity){
 	try {
			BeanUtils.copyProperties(this, dongwubaikeEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
