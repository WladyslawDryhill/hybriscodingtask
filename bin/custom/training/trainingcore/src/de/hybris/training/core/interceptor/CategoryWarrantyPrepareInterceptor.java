package de.hybris.training.core.interceptor;

import de.hybris.platform.category.model.CategoryModel;
import de.hybris.platform.servicelayer.interceptor.InterceptorContext;
import de.hybris.platform.servicelayer.interceptor.PrepareInterceptor;
import de.hybris.training.core.exception.NegativeWarrantyMonthException;

public class CategoryWarrantyPrepareInterceptor implements PrepareInterceptor {
    public void onPrepare(Object model, InterceptorContext ctx) {
        if (model instanceof CategoryModel) {
            CategoryModel categoryModel = (CategoryModel) model;
            if (categoryModel.getWarrantyMonth() != null && categoryModel.getWarrantyMonth() < 0) {
                throw new NegativeWarrantyMonthException();
            }
        }
    }
}
