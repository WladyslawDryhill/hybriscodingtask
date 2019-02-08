package de.hybris.training.core.interceptor;

import de.hybris.platform.servicelayer.interceptor.InterceptorContext;
import de.hybris.platform.servicelayer.interceptor.PrepareInterceptor;
import de.hybris.training.core.exception.NegativeWarrantyMonthException;
import de.hybris.training.core.model.ApparelProductModel;

public class ApparelProductWarrantyPrepareInterceptor implements PrepareInterceptor {
    public void onPrepare(Object model, InterceptorContext ctx) {
        if (model instanceof ApparelProductModel) {
            ApparelProductModel productModel = (ApparelProductModel) model;
            if (productModel.getWarrantyMonth() != null && productModel.getWarrantyMonth() < 0) {
                throw new NegativeWarrantyMonthException();
            }
        }
    }
}
