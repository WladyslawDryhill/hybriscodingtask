package de.hybris.training.facades.populators;

import de.hybris.platform.commercefacades.product.data.ProductData;
import de.hybris.platform.converters.Populator;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.servicelayer.dto.converter.ConversionException;
import de.hybris.platform.variants.model.VariantProductModel;

import java.util.NoSuchElementException;

public class ProductWarrantyMonthPopulator implements Populator<ProductModel, ProductData> {
    @Override
    public void populate(final ProductModel source, final ProductData target) throws ConversionException {
        final ProductModel baseProduct = getBaseProduct(source);

        Integer warrantyMonth = baseProduct.getWarrantyMonth();
        if(warrantyMonth != null) {
            target.setWarrantyMonth(warrantyMonth);
        } else {
            try {
                warrantyMonth = baseProduct.getSupercategories().stream().filter(category ->
                        category.getWarrantyMonth() != null).findFirst().get().getWarrantyMonth();
                target.setWarrantyMonth(warrantyMonth);
            } catch (NoSuchElementException ex) {
                System.out.println("Unknown warranty for item " + baseProduct.getName());
            }
        }
    }

    protected ProductModel getBaseProduct(final ProductModel productModel)
    {
        ProductModel currentProduct = productModel;
        while (currentProduct instanceof VariantProductModel)
        {
            final VariantProductModel variant = (VariantProductModel) currentProduct;
            currentProduct = variant.getBaseProduct();
        }
        return currentProduct;
    }
}
