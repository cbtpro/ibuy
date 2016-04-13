package com.ibuy.www.services;

import com.ibuy.www.domain.IGoodImages;
import com.ibuy.www.domain.IImages;

public interface IImagesServices {
    IImages save(IImages image);
    IGoodImages save(IGoodImages goodImages);
    void delete(IImages image);
    void update(IImages image);
    IImages findByUuid(String uuid);
}
