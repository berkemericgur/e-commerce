package com.bmg.ecommercedemo.business.mappers;

import org.modelmapper.ModelMapper;

public interface ModelMapperService {
       ModelMapper forResponse();
       ModelMapper forRequest();
}
