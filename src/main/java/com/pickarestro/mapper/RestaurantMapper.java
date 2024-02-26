package com.pickarestro.mapper;

import com.pickarestro.dao.RestaurantEntity;
import com.pickarestro.dto.RestaurantDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RestaurantMapper {
    RestaurantDto map(RestaurantEntity entity);

    List<RestaurantDto> map(List<RestaurantEntity> entities);

    @Mapping(target = "id", ignore = true)
    RestaurantEntity mapForCreate(RestaurantDto restaurantDto);
}
