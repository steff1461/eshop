package be.technobel.eshop.service;

import java.util.List;

public interface BaseService<TDTO, TFORM, TID> {

    List<TDTO> findAll();

    TDTO findOne(TID id);

    boolean save(TFORM form);

    boolean delete(TID id);

    TDTO update(TFORM form, TID id);


}
