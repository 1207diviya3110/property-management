package com.mycompany.property_management.service.impl;

import com.fasterxml.jackson.databind.annotation.JsonAppend;
import com.mycompany.property_management.convertor.PropertyConvertor;
import com.mycompany.property_management.dto.PropertyDTO;
import com.mycompany.property_management.entity.PropertyEntity;
import com.mycompany.property_management.repository.PropertyRepository;
import com.mycompany.property_management.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PropertyServiceImpl implements PropertyService {

    @Autowired
    private PropertyRepository propertyRepository;

    @Autowired
    private PropertyConvertor propertyConvertor;

    @Override
    public PropertyDTO saveProperty(PropertyDTO propertyDTO) {

       PropertyEntity pe  =  propertyConvertor.convertDTOtoEntity(propertyDTO);
        pe = propertyRepository.save(pe);

        propertyDTO = propertyConvertor.convertEntityToDTO(pe);
        return propertyDTO;
    }

    @Override
    public List<PropertyDTO> getAllProperties() {
        List<PropertyEntity> listOfProps = (List<PropertyEntity>) propertyRepository.findAll();
        List<PropertyDTO> propList = new ArrayList<>();

        for(PropertyEntity pe: listOfProps){
            PropertyDTO propertyDTO = propertyConvertor.convertEntityToDTO(pe);
            propList.add(propertyDTO);
        }
        return propList;
    }

    @Override
    public PropertyDTO updateProperty(PropertyDTO propertyDTO, Long propertyID) {

        Optional<PropertyEntity> optEn =  propertyRepository.findById(propertyID);
        PropertyDTO dto = null;
        if(optEn.isPresent()){

            PropertyEntity pe = optEn.get(); // data from database
            pe.setTitle(propertyDTO.getTitle()); //overwriting the existing data
            pe.setOwnerName(propertyDTO.getOwnerName());
            pe.setDescription(propertyDTO.getDescription());
            pe.setOwnerEmail(propertyDTO.getOwnerEmail());
            pe.setPrice(propertyDTO.getPrice());
            pe.setAddress(propertyDTO.getAddress());
            dto = propertyConvertor.convertEntityToDTO(pe);
            propertyRepository.save(pe); //saving the updated entity
        }
        return dto;
    }

    @Override
    public PropertyDTO updatePropertyDescription(PropertyDTO propertyDTO, Long propertyId) {
        Optional<PropertyEntity> optEn =  propertyRepository.findById(propertyId);
        PropertyDTO dto = null;
        if(optEn.isPresent()){

            PropertyEntity pe = optEn.get(); // data from database
            pe.setDescription(propertyDTO.getDescription());
            dto = propertyConvertor.convertEntityToDTO(pe);
            propertyRepository.save(pe); //saving the updated entity
        }
        return dto;
    }

    @Override
    public PropertyDTO updatePropertyPrice(PropertyDTO propertyDTO, Long propertyId) {
        Optional<PropertyEntity> optEn =  propertyRepository.findById(propertyId);
        PropertyDTO dto = null;
        if(optEn.isPresent()){

            PropertyEntity pe = optEn.get(); // data from database
            pe.setPrice(propertyDTO.getPrice());
            dto = propertyConvertor.convertEntityToDTO(pe);
            propertyRepository.save(pe); //saving the updated entity
        }
        return dto;
    }

    @Override
    public void deleteProperty(Long propertyId) {
        propertyRepository.deleteById(propertyId);
    }
}
