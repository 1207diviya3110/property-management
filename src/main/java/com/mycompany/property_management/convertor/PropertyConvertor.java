package com.mycompany.property_management.convertor;


import com.mycompany.property_management.dto.PropertyDTO;
import com.mycompany.property_management.entity.PropertyEntity;
import org.springframework.stereotype.Component;

@Component
public class PropertyConvertor {

    public PropertyEntity convertDTOtoEntity(PropertyDTO propertyDTO){
        PropertyEntity pe = new PropertyEntity();
        pe.setTitle(propertyDTO.getTitle());
        pe.setOwnerName(propertyDTO.getOwnerName());
        pe.setDescription(propertyDTO.getDescription());
        pe.setOwnerEmail(propertyDTO.getOwnerEmail());
        pe.setPrice(propertyDTO.getPrice());
        pe.setAddress(propertyDTO.getAddress());

        return pe;
    }

    public PropertyDTO convertEntityToDTO(PropertyEntity pe){
        PropertyDTO pDTO = new PropertyDTO();
        pDTO.setId(pe.getId());
        pDTO.setTitle(pe.getTitle());
        pDTO.setOwnerName(pe.getOwnerName());
        pDTO.setDescription(pe.getDescription());
        pDTO.setOwnerEmail(pe.getOwnerEmail());
        pDTO.setPrice(pe.getPrice());
        pDTO.setAddress(pe.getAddress());

        return pDTO;
    }
}
