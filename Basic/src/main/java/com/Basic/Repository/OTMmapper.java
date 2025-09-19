package com.Basic.Repository;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.Basic.Model.OTMitem;
import com.Basic.Model.OTMitemDTO;
import com.Basic.Model.OTMorder;
import com.Basic.Model.OTMorderDTO;

@Mapper(componentModel = "spring")
public interface OTMmapper {

    OTMmapper INSTANCE = Mappers.getMapper(OTMmapper.class);

    OTMorderDTO toDto(OTMorder user);

    OTMorder toEntity(OTMorderDTO dto);

    @Mapping(source = "itemid", target = "iid")
    @Mapping(source = "itemcode", target = "icode")
    @Mapping(source = "itemname", target = "iname")
    @Mapping(source = "itemprice", target = "iprice")
    @Mapping(source = "itemtype", target = "itype")
    OTMitemDTO toDto(OTMitem item);

    @Mapping(source = "iid", target = "itemid")
    @Mapping(source = "icode", target = "itemcode")
    @Mapping(source = "iname", target = "itemname")
    @Mapping(source = "iprice", target = "itemprice")
    @Mapping(source = "itype", target = "itemtype")
    OTMitem toEntity(OTMitemDTO itemDto);
}
