package de.hybris.training.facades.populators;

import de.hybris.platform.commercefacades.product.data.ProductData;
import de.hybris.platform.commerceservices.search.resultdata.SearchResultValueData;
import de.hybris.platform.converters.Populator;
import de.hybris.platform.servicelayer.dto.converter.ConversionException;
import org.springframework.util.Assert;

public class SearchResultApparelProductWarrantyMonthPopulator implements Populator<SearchResultValueData, ProductData>
{
    @Override
    public void populate(final SearchResultValueData source, final ProductData target) throws ConversionException
    {
        Assert.notNull(source, "Parameter source must not be null.");
        Assert.notNull(target, "Parameter target must not be null.");
        final Integer warrantyMonth = (Integer) source.getValues().get("warrantyMonth");
        target.setWarrantyMonth(warrantyMonth == null ? null : warrantyMonth.intValue());
    }
}