package com.xiaobai.information.model.dto.base;

import com.xiaobai.information.utils.BeanUtils;
import com.xiaobai.information.utils.ReflectionUtils;

import java.lang.reflect.ParameterizedType;
import java.util.Objects;

/**
 * Converter interface for input DTO.
 *
 * @author johnniang
 */
public interface InputConverter<DOMAIN> {

    default DOMAIN convertTo(){
        ParameterizedType currentType = getParameterizedType();
        Class<DOMAIN> domainClass = (Class<DOMAIN>) currentType.getActualTypeArguments()[0];
        Objects.requireNonNull(currentType, "Cannot fetch actual type because parameterized type is null");
        return BeanUtils.transformFrom(this, domainClass);
    }

    default ParameterizedType getParameterizedType(){
        return ReflectionUtils.getParameterizedType(InputConverter.class,this.getClass());
    }
}

