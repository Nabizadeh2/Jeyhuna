package az.atl.customer.mapper;

import az.atl.customer.dao.EntityCustomer;
import az.atl.customer.mode.CustomerDto;
import az.atl.customer.mode.CustomerRequest;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;
import org.springframework.stereotype.Component;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CustomerMapper {

   EntityCustomer toEntity(CustomerRequest studentDto) ;

   CustomerDto toDto( EntityCustomer entityCustomert) ;


   //Object toDto(Object o);
}
