package com.ibm.test.first_project.utils;

import com.ibm.test.first_project.data.dtos.bike.BikeGetResDTO;
import com.ibm.test.first_project.data.dtos.bike.BikeUpdateResDTO;
import com.ibm.test.first_project.data.dtos.sales_order.SalesOrderPostResDTO;
import com.ibm.test.first_project.data.models.Bike;
import com.ibm.test.first_project.data.models.OrderItem;
import com.ibm.test.first_project.data.models.SalesOrder;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CustomModelMapper extends ModelMapper {
    public CustomModelMapper() {
        customMapping();
    }

    public <S, T> List<T> mapList(List<S> source, Class<T> targetClass) {
        return source
                .stream()
                .map(elem -> this.map(elem, targetClass))
                .collect(Collectors.toList());
    }

    private void customMapping() {
        this.typeMap(Bike.class, BikeGetResDTO.class).addMappings(mapper -> {
            mapper.map(src -> src.getBrand().getName(),
                    BikeGetResDTO::setBrand);
            mapper.map(src -> src.getColor().getName(),
                    BikeGetResDTO::setColor);
        });

        this.typeMap(Bike.class, BikeUpdateResDTO.class).addMappings(mapper -> {
            mapper.map(src -> src.getBrand().getName(),
                    BikeUpdateResDTO::setBrand);
            mapper.map(src -> src.getColor().getName(),
                    BikeUpdateResDTO::setColor);
        });
    }
}
