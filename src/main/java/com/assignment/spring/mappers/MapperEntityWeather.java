package com.assignment.spring.mappers;

import com.assignment.spring.entities.EntityWeather;
import com.assignment.spring.models.external.openweatherapi.WeatherResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface MapperEntityWeather {

    @Mappings({
            @Mapping(source = "name", target = "city"),
            @Mapping(source = "sys.country", target = "country"),
            @Mapping(source = "main.temp", target = "temperature")
    })
    public EntityWeather mapFromWeatherResponse(WeatherResponse response);
}
