package de.hybris.training.core.provider;

import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.solrfacetsearch.config.IndexConfig;
import de.hybris.platform.solrfacetsearch.config.IndexedProperty;
import de.hybris.platform.solrfacetsearch.provider.FieldValue;
import de.hybris.platform.solrfacetsearch.provider.FieldValueProvider;

import java.util.ArrayList;
import java.util.Collection;
import java.util.NoSuchElementException;

public class WarrantyFieldValueProvider implements FieldValueProvider {

    public Collection<FieldValue> getFieldValues(IndexConfig config, IndexedProperty property, Object model) {
        ProductModel productModel = (ProductModel) model;
        final Collection<FieldValue> fieldValues = new ArrayList<>();

        Integer warrantyMonth = productModel.getWarrantyMonth();
        if(warrantyMonth != null) {
            fieldValues.add(new FieldValue(property.getName(), warrantyMonth));
        } else {
            try {
                warrantyMonth = productModel.getSupercategories().stream().filter(category ->
                        category.getWarrantyMonth() != null).findFirst().get().getWarrantyMonth();
                fieldValues.add(new FieldValue(property.getName(), warrantyMonth));
            } catch (NoSuchElementException ex) {
                //Do nothing
            }
        }
        return fieldValues;
    }
}
